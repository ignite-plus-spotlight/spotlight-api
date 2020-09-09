package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.CertGenerate;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Exception.InputValidationException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.*;
import spring.spot.trial.dto.AwardsGivenByManagerDTO;
import spring.spot.trial.dto.AwardsHistoryDTO;
import spring.spot.trial.dto.EmpAwardWinnersUnderManagerDTO;
import spring.spot.trial.util.VelToPdf;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

@Service
public class EmployeeAwardsService {
    @Autowired
    EmployeeAwardsTMRepository employeeAwardsTMRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeAwardsMRepository employeeAwardsMRepository;

    @Autowired
    AwardToIndividualRepository awardToIndividualRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ActivityFeedRepository activityFeedRepository;




    //used in "reward" tab to award an individual
    public EmployeeAwardsService(EmployeeAwardsTMRepository employeeAwardsTMRepository) { this.employeeAwardsTMRepository = employeeAwardsTMRepository; }

    public EmployeeAwardsTM createEmployeeAwards(String empId, String manager_id, String award_name, String period_name, String department) throws Exception {
        EmployeeAwardsTM emp = new EmployeeAwardsTM();
        AwardToIndividual awardToIndividual = awardToIndividualRepository.findByAwardName(award_name);
        Employee employee1 = employeeRepository.findByEmpId(manager_id).get(0);
        LocalDateTime now = LocalDateTime.now();
        emp.setAwardedById(manager_id);
        emp.setAwardName(award_name);
        emp.setTimestamp(now);
        emp.setDepartment(department);
        emp.setDescription(awardToIndividual.getDescription());
        emp.setEmpId(empId);
        emp.setEmpPoints(awardToIndividual.getPoints());
        emp.setImgsrc(awardToIndividual.getImgsrc());
        emp.setManagerName(employee1.getFirstName()+" "+employee1.getLastName());
        emp.setPeriodName(period_name);
        EmployeeAwardsTM employeeAwardsTM = employeeAwardsTMRepository.save(emp);
        /************For certificate**************/
        Employee employee = employeeRepository.findByEmpId(employeeAwardsTM.getEmpId()).get(0);
        /*****************************************/
        String id = employeeAwardsTM.getEmpId();
        EmployeeAwardsTM etm = employeeAwardsTMRepository.findByEmpId(id).get(0);
        EmployeeAwardsMD emd = new EmployeeAwardsMD();
        emd.setAwardedById(etm.getAwardedById());
        emd.setAwardName(etm.getAwardName());
        emd.setDepartment(etm.getDepartment());
        emd.setDescription(etm.getDescription());
        emd.setEmpId(etm.getEmpId());
        emd.setEmpPoints(etm.getEmpPoints());
        emd.setImgsrc(etm.getImgsrc());
        emd.setManagerName(etm.getManagerName());
        emd.setPeriodName(etm.getPeriodName());
        emd.setTimestamp(now);
        employeeAwardsMRepository.save(emd);

        UUID uuid= UUID.randomUUID();
        ActivityFeed activityFeed = new ActivityFeed();

        activityFeed.setAwardeeId(emd.getEmpId());
        activityFeed.setAwardName(emd.getAwardName());
        activityFeed.setDescription(emd.getDescription());
        activityFeed.setImgsrc(emd.getImgsrc());
        activityFeed.setPoints(emd.getEmpPoints());
        activityFeed.setTimestamp(emd.getTimestamp());
        activityFeed.setUuid(uuid);

        activityFeed.setAwardeeName(employeeRepository.findByEmpId(emd.getEmpId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(emd.getEmpId()).get(0).getLastName());
        activityFeedRepository.save(activityFeed);


        final String username = "spotlightadm@gmail.com";
        final String password = "spotlight123.";
        String fromEmail = "spotlightadm@gmail.com";
        String toEmail =employeeRepository.findByEmpId(empId).get(0).getEmpEmail();

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
        String htmlData = certGenerate.certGenerate(employee, employeeAwardsTM);
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

        return employeeAwardsTM;
    }


    public List<EmployeeAwardsTM> getAllEmployeeAwards(){
        List<EmployeeAwardsTM> employeesAwards = employeeAwardsTMRepository.findAll();
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Employee Award not found");
        return employeesAwards;
    }

    public List<EmployeeAwardsTM> getEmployeeAwardsById(String id) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsTM> employeesAwards = employeeAwardsTMRepository.findByEmpId(id);
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Employee Award not found for id:"+id);
        return employeesAwards; }

    public EmployeeAwardsTM updateEmployeeAwardsById(String id, EmployeeAwardsTM emp) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsTM> employees = employeeAwardsTMRepository.findByEmpId(id);
        if(employees.isEmpty())
            throw new NotFoundException("Employee Award not found for id: "+id);
        return employeeAwardsTMRepository.save(emp); }

    public List<EmployeeAwardsMD> getEmployeeAwardsMByManagerId(String id) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsMD> employeesAwards = employeeAwardsMRepository.findByAwardedById(id);
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Manager not found for id: "+id);
        return employeesAwards;
    }


    //used in "reward" tab to display the number of awards already won
    public int countAwards(String empId, String periodName)
    {
        int count = 0;
        List<EmployeeAwardsTM> employeeAwardsTMS = employeeAwardsTMRepository.findByEmpIdAndPeriodName(empId, periodName);
        count = employeeAwardsTMS.size();
        return count;
    }

    public AwardsGivenByManagerDTO getWinnersUnderManager(String managerId)
    {
        AwardsGivenByManagerDTO awardsGivenByManagerDTO = new AwardsGivenByManagerDTO();
        awardsGivenByManagerDTO.setEmployee(employeeRepository.findByEmpId(managerId).get(0));
        List<EmpAwardWinnersUnderManagerDTO> empAwardWinnersUnderManagerDTOS = new ArrayList<>();
        List<Team> teams = teamRepository.findByManagerId(managerId);
        for (Team t : teams)     //All teams under manager
        {
            List<String> members = t.getMembers();

            for (String empId : members)     //All members under this team
            {
                EmpAwardWinnersUnderManagerDTO edto = new EmpAwardWinnersUnderManagerDTO();
                Employee employee = employeeRepository.findByEmpId(empId).get(0);
                edto.setEmployee(employee);
                List<EmployeeAwardsTM> etms = employeeAwardsTMRepository.findByEmpId(empId);    //All awards of this member
                if(!etms.isEmpty()) {
                    edto.setEmployeeAwardsTMS(etms);
                    empAwardWinnersUnderManagerDTOS.add(edto);
                }
            }
        }
        awardsGivenByManagerDTO.setEmpAwardWinnersUnderManagerDTOS(empAwardWinnersUnderManagerDTOS);
        return awardsGivenByManagerDTO;
    }


    //head views the history of awards given
    public List<AwardsHistoryDTO> awardsHistory (String givenById)
    {
        List<AwardsHistoryDTO> awardsHistoryDTOS = new ArrayList<>();
        List<EmployeeAwardsMD> employeeAwards = employeeAwardsMRepository.findByAwardedById(givenById);
        for (EmployeeAwardsMD employeeAwardsMD : employeeAwards)
        {
            AwardsHistoryDTO awardsHistoryDTO = new AwardsHistoryDTO();
            awardsHistoryDTO.setAwardedById(employeeAwardsMD.getAwardedById());
            awardsHistoryDTO.setAwardName(employeeAwardsMD.getAwardName());
            awardsHistoryDTO.setDepartment(employeeAwardsMD.getDepartment());
            awardsHistoryDTO.setDescription(employeeAwardsMD.getDescription());
            awardsHistoryDTO.setEmpId(employeeAwardsMD.getEmpId());
            awardsHistoryDTO.setEmployee(employeeRepository.findByEmpId(employeeAwardsMD.getEmpId()).get(0));
            awardsHistoryDTO.setEmpPoints(employeeAwardsMD.getEmpPoints());
            awardsHistoryDTO.setImgsrc(employeeAwardsMD.getImgsrc());
            awardsHistoryDTO.setManagerName(employeeAwardsMD.getManagerName());
            awardsHistoryDTO.setPeriodName(employeeAwardsMD.getPeriodName());
            awardsHistoryDTO.setTimestamp(employeeAwardsMD.getTimestamp());
            awardsHistoryDTOS.add(awardsHistoryDTO);
        }

        return  awardsHistoryDTOS;
    }

}
