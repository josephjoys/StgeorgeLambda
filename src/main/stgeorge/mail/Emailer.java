package stgeorge.mail;

import stgeorge.util.StringUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.InvalidParameterException;
import java.util.Properties;

public class Emailer {

    private String from = System.getenv("fromemailaddress");
    private String password = System.getenv("fromemailpassword");

    public void send(String to, String subject, String content) {

        if (StringUtils.isEmpty(from) && StringUtils.isEmpty(password)) {
            throw new InvalidParameterException("From address and Password required");
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.smtp.port", "587");


        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            for (String s : to.split(",")) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
            }
            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(content);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}