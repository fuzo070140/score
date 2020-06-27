package com.score.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSendThred extends Thread {

	private String from;
	private String to;
	private String subject;
	private String content;

	public MailSendThred(String from, String to, String subject, String content) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public static void MailSend(String from, String to, String subject, String content) {

		MailSendThred mst = new MailSendThred(from, to, subject, content);
		mst.start();
	}

	public void run() {
		Properties p = new Properties(); // 정보를 담을 객체

		p.put("mail.smtp.host", "smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.trust", "smtp.naver.com");

		System.out.println(p.toString());

		try {

			Authenticator auth = new SMTPAuthenticatior();
			Session sess = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, "wnstndi1234");
				}
			});
			MimeMessage msg = new MimeMessage(sess); // 메일의 내용을 담을 객체
			msg.setSubject(subject, "UTF-8"); // 제목

			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr); // 보내는 사람

			Address toAddr = new InternetAddress(to);

			msg.addRecipient(Message.RecipientType.TO, toAddr);

			msg.setContent(content, "text/html;charset=UTF-8");

			Transport.send(msg);
		} catch (Exception e) {
			System.out.println("exception error");
			e.printStackTrace();
		}

	}

}
