package spring.spot.trial.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:/Users/YASHASWINI/Downloads/Email/src/main/resources/Application.properties");
        Properties prop = new Properties();
        prop.load(fis);

        final String username = prop.getProperty("username");
        final String password = prop.getProperty("password");
        String fromEmail = prop.getProperty("fromEmail");
        String toEmail = prop.getProperty("toEmail");


        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject("Received Award");

            Multipart emailContent = new MimeMultipart();

            //textbodypart
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Congratulations");

            //attachment body part
            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile("Test.pdf");

            //attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);

            //attach multipart to message
            message.setContent(emailContent);

            Transport.send(message);
            System.out.println("Message sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

