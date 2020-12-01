package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.CertGenerate;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Repository.*;
import spring.spot.trial.dto.ManagerDTO;
import spring.spot.trial.dto.TeamDTO;
import spring.spot.trial.util.VelToPdf;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class TeamAwardsTMDService {
    @Autowired
    TeamAwardsTMDRepository teamAwardsTMDRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    AwardToTeamRepository awardToTeamRepository;

    @Autowired
    IndividualTeamAwardsRepository individualTeamAwardsRepository;

    @Autowired
    TeamAwardsDirectorRepository teamAwardsDirectorRepository;



    public TeamAwardsTMDService(TeamAwardsTMDRepository teamAwardsTMDRepository) {
        this.teamAwardsTMDRepository = teamAwardsTMDRepository;
    }

    //post into teamawards and individual team awards table
    public TeamAwardsTMD createTeamAwards(String awardName, String awardedById, String periodName, int teamId, String teamName, String headId) throws Exception {
        Date d = new Date();
        TeamAwardsTMD team = new TeamAwardsTMD();
        AwardToTeam awardToTeam = awardToTeamRepository.findByAwardName(awardName);

        String description = awardToTeam.getDescription();
        String imgsrc = awardToTeam.getImgsrc();
        int teamPoints = awardToTeam.getPoints();

        team.setAwardName(awardName);
        team.setDescription(description);
        team.setImgsrc(imgsrc);
        team.setAwardedById(awardedById);
        team.setPeriodName(periodName);
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        team.setTeamPoints(teamPoints);
        team.setTimestamp(d);

        Team t = teamRepository.findByManagerIdAndTeamId(headId,teamId);
        IndividualTeamAwards i = new IndividualTeamAwards();
        i.setEmpId(headId);
        i.setTeamId(teamId);
        Date date1 = new Date();
        i.setTimestamp(date1);
        individualTeamAwardsRepository.save(i);

        TeamAwardsDirector teamAwardsDirector = new TeamAwardsDirector();
        teamAwardsDirector.setAwardedById(awardedById);
        teamAwardsDirector.setTeamId(teamId);
        teamAwardsDirector.setTimestamp(date1);
        teamAwardsDirectorRepository.save(teamAwardsDirector);

        List<String> members = t.getMembers();
        for (String mid: members)
        {
            Date date = new Date();
            IndividualTeamAwards individualTeamAwards = new IndividualTeamAwards();
            individualTeamAwards.setEmpId(mid);
            individualTeamAwards.setTeamId(teamId);
            individualTeamAwards.setTimestamp(date);
            individualTeamAwardsRepository.save(individualTeamAwards);

            Employee employee = employeeRepository.findByEmpId(mid).get(0);

        final String username = "apekshaspot24@gmail.com";
        final String password = "spotlight123.";
        String fromEmail = "apekshaspot24@gmail.com";
        String toEmail =employeeRepository.findByEmpId(mid).get(0).getEmpEmail();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });


        CertGenerate certGenerate = new CertGenerate();
        String htmlData = certGenerate.teamCertGenerate(employee, team);
        String filename= VelToPdf.velocityToPdf(htmlData);

        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Congratulations!");

            Multipart emailContent = new MimeMultipart();

            //Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Target is pleased to acknowledge your contribution towards the company\n");

            //Attachment body part.
            MimeBodyPart pdfAttachment = new MimeBodyPart();

            pdfAttachment.attachFile(filename);

            //Attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);

            //Attach multipart to message
            msg.setContent(emailContent);

            Transport.send(msg);
            System.out.println("Sent message");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }

        return teamAwardsTMDRepository.save(team);
    }

    //get call for team awards history in director's dashboard
    public List<TeamAwardsTMD> teamawardshistory(String id)
    {
        List<TeamAwardsTMD> teamAwardsTMDS = new ArrayList<>();
        for(TeamAwardsDirector teamAwardsDirector : teamAwardsDirectorRepository.findByAwardedById(id))
        {
            int teamId = teamAwardsDirector.getTeamId();
             for (TeamAwardsTMD teamAwardsTMD : teamAwardsTMDRepository.findByTeamId(teamId))
             {
                 teamAwardsTMDS.add(teamAwardsTMD);
             }
        }
        return teamAwardsTMDS;
    }

    public List<TeamAwardsTMD> getAllTeamAwards() {
        return teamAwardsTMDRepository.findAll();
    }

    public List<TeamAwardsTMD> getTeamAwardsById(int id) {
        return teamAwardsTMDRepository.findByTeamId(id);
    }

    public TeamAwardsTMD updateTeamAwardsById(int id, TeamAwardsTMD teamAwardsTMD) {
        return teamAwardsTMDRepository.save(teamAwardsTMD);
    }

    //to display teams under the managers under director (cards)
    public ManagerDTO display(String id)
    {
        List<Employee> employee = employeeRepository.findByEmpId(id);
        List<Team> team = teamRepository.findByManagerId(id);
        List<String> teamMembers =  team.get(0).getMembers();
        ManagerDTO managerDTO = new ManagerDTO();
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for(String memberid : teamMembers) {
            TeamDTO teamDTO = new TeamDTO();
            List<Team> teams = teamRepository.findByManagerId(memberid);
            if (!teamRepository.findByManagerId(memberid).isEmpty()) {
                teamDTO.setTeamId(teams.get(0).getTeamId());
                teamDTO.setTeamName(teams.get(0).getTeamName());
                teamDTO.setHeadId((employeeRepository.findByEmpId(teams.get(0).getManagerId())).get(0).getEmpId());
                teamDTO.setHeadName((employeeRepository.findByEmpId(teams.get(0).getManagerId())).get(0).getFirstName());
                List<String> memberids = teams.get(0).getMembers();
                List<Employee> reportee = new ArrayList<>();
                for (String empId : memberids) {
                    reportee.add(employeeRepository.findByEmpId(empId).get(0));
                }
                teamDTO.setTeamMembers(reportee);
                teamDTOS.add(teamDTO);
            }
            managerDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));
            managerDTO.setTeams(teamDTOS);
        }
        return managerDTO;
    }

    //to display the team awards in the dashboard
    public List<TeamAwardsTMD> displayTeamAwards(String empId)
    {
       List<IndividualTeamAwards> i = individualTeamAwardsRepository.findByEmpId(empId);
       List<TeamAwardsTMD> teamAwardsTMDList = new ArrayList<>();
       for(IndividualTeamAwards individualTeamAwards : i)
       {
            int teamId = individualTeamAwards.getTeamId();
            List<TeamAwardsTMD> teamAwardsTMDS = teamAwardsTMDRepository.findByTeamId(teamId);
            for (TeamAwardsTMD x : teamAwardsTMDS)
            {
                teamAwardsTMDList.add(x);
            }
       }
       return teamAwardsTMDList;
    }

}

