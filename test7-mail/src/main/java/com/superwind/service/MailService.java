package com.superwind.service;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by jiangxj on 2018/5/4.
 */
@Service
public class MailService {
    public void sendMessage(String mailListStr,String subject) {
        if (Strings.isNullOrEmpty(mailListStr)) {
            return;
        }
        String[] toList = mailListStr.split(",");
        // 发件人电子邮箱
        String from = "zhangsan@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.163.com";
        String user = "zhangsan@163.com";
        String password = "123";

        // 获取系统属性
        Properties properties = new Properties();

        // 设置邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp"); //协议
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        StringBuilder sb = new StringBuilder("<body><table width='100%'>");
        sb.append("<tr><th>name</th></tr>");
        sb.append("<tr><td>test</td></tr>");
        sb.append("</table></body>");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);
        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            for (String to : toList) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(sb.toString(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            message.setContent(mainPart);

            Transport trans = session.getTransport();
            trans.connect(host, user, password); // 邮件的账号密码
            trans.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
