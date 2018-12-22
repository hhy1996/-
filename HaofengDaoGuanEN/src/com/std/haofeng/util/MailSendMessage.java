package com.std.haofeng.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSendMessage {

	public final static String MAIL_STMPHOST = "smtp.yeah.net";
	public final static String MAIL_USERID = "xiakebang@yeah.net";
	public final static String MAIL_PASSWORD = "KgdsoYAB3216Hofi";

	public static void sendMsg(String title, String content, String mailAddress) {
		String send_msg = content;
		String smtphost = MAIL_STMPHOST; // 发送邮件服务器
		String user = MAIL_USERID; // 邮件服务器登录用户名
		String password = MAIL_PASSWORD; // 邮件服务器登录密码
		String from = MAIL_USERID; // 发送人邮件地址
		String to = mailAddress; // 接受人邮件地址
		String subject = title; // 邮件标题
		String body = send_msg; // 邮件内容
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", smtphost);
			props.put("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			Session ssn = Session.getInstance(props, null);
			MimeMessage message = new MimeMessage(ssn);
			InternetAddress fromAddress = new InternetAddress(from);
			message.setFrom(fromAddress);
			InternetAddress toAddress = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setText(body);
			Transport transport = ssn.getTransport("smtp");
			transport.connect(smtphost, user, password);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			// transport.send(message);
			transport.close();
		} catch (Exception m) {
			
		}
	}
	
	public static void main(String[] args)
	{
		sendMsg("用户反馈邮件","这是一封用户反馈邮件,自动发送,姓名:a,电话:12345","517614486@qq.com");
	}

}
