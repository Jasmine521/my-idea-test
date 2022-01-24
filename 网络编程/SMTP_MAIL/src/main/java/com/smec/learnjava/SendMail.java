package com.smec.learnjava;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.PropertyPermission;

public class SendMail {
    final String smtpHost;
    final String username;
    final String password;
    final boolean debug;

    public SendMail(String smtpHost, String username, String password, boolean debug) {
        this.smtpHost = smtpHost;
        this.username = username;
        this.password = password;
        this.debug = debug;
    }

    public static void main(String[] args) throws Exception {
        final String smtp = "smtp.qq.com";
        final String username = "1779605057@qq.com";
        final String password = "ctmsqhrekiyidfjj";
        final String from = username;
        final String to = "jiuboyan@nuaa.edu.cn";
        SendMail sender = new SendMail(smtp, username, password, true);
        Session session = sender.createSSLSession();
        Message message = createTexMessage(session, from, to, "JavaMail邮件", "Hello" +
                ", 这是一封来自javamail的邮件！");
        Transport.send(message);
    }

    Session createTLSSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", this.smtpHost); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
            }
        });
        session.setDebug(this.debug); // 显示调试信息
        return session;
    }

    Session createSSLSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        //启动SSL
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        Session session = Session.getInstance(props, new Authenticator() {
            //用户名+口令认证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
            }
        });
        session.setDebug(this.debug);
        return session;
    }

    static Message createTexMessage(Session session, String from, String to, String subject, String body)
            throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject, "UTF-8");
        message.setText(body, StandardCharsets.UTF_8.name());
        return message;
    }
}
