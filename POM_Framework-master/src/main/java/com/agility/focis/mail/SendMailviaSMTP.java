package com.agility.focis.mail;


import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

public class SendMailviaSMTP {
    private static final String SMTP_SERVER = "10.201.34.252";
    private static final String USERNAME = "Avanamala@agility.com";
    private static final String PASSWORD = "Too@1234";

    private static final String EMAIL_FROM = "Avanamala@agility.com";
    private static final String EMAIL_TO = "Avanamala@agility.com, anji3035@gmail.com, anjivanamala@outlook.com";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";
    public static void main(String[] args) {

        Properties prop = System.getProperties();
        prop.put("com.agility.focis.globalVariables.mail.smtp.auth", "true");
        prop.put("com.agility.focis.globalVariables.mail.smtp.host", "10.201.34.252"); //optional, defined in SMTPTransport
        prop.put("com.agility.focis.globalVariables.mail.smtp.port", "25"); // default port 25
        prop.put("com.agility.focis.globalVariables.mail.smtp.starttls.enable", "true");
        prop.put("com.agility.focis.globalVariables.mail.smtp.startssl.enable", "false");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            msg.setFrom(new InternetAddress(EMAIL_FROM));

            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

            msg.setSubject(EMAIL_SUBJECT);

            // text
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText(EMAIL_TEXT);

            // file
            MimeBodyPart p2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource("D:/xpath.txt");
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName(fds.getName());

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
            mp.addBodyPart(p2);

            msg.setContent(mp);


            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    String[] args = {"class",""};

}