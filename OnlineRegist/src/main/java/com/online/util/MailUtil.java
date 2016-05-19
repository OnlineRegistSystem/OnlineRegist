package com.online.util;

import java.util.Properties;
import java.util.concurrent.Callable;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil implements Callable<Integer>{
	
	private String destination;
	private String messageInfo;
	private String title;

	public MailUtil(String destination,String message,String title) {
		// TODO Auto-generated constructor stub
		this.destination = destination;
		this.messageInfo = message;
		this.title = title;
	}
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>发送邮件！");
		sendVerify(destination, messageInfo);
		System.out.println("<<<<<<<<<<<<发送成功！");
		return 1;
	}
	private void sendVerify(String destination, String code) throws MessagingException {
		// TODO Auto-generated method stub
		// 配置发送邮件的环境属性
	    final Properties props = new Properties();
	    /*
	     * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
	     * mail.user / mail.from
	     */
	    // 表示SMTP发送邮件，需要进行身份验证
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.host", "smtp.163.com");
	    // 发件人的账号
	    props.put("mail.user", "18825077991@163.com");
	    // 访问SMTP服务时需要提供的密码
	    props.put("mail.password", "test123456");

	    // 构建授权信息，用于进行SMTP进行身份验证
	    Authenticator authenticator = new Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            // 用户名、密码
	            String userName = props.getProperty("mail.user");
	            String password = props.getProperty("mail.password");
	            return new PasswordAuthentication(userName, password);
	        }
	    };
	    // 使用环境属性和授权信息，创建邮件会话
	    Session mailSession = Session.getInstance(props, authenticator);
	    // 创建邮件消息
	    MimeMessage message = new MimeMessage(mailSession);
	    // 设置发件人
	    InternetAddress form = new InternetAddress(
	            props.getProperty("mail.user"));
	    message.setFrom(form);

	    // 设置收件人
	    InternetAddress to = new InternetAddress(destination);
	    message.setRecipient(RecipientType.TO, to);


	    // 设置邮件标题
	    message.setSubject("在线预约系统找回密码");

	    // 设置邮件的内容体
	    message.setContent(messageInfo, "text/html;charset=UTF-8");

	    // 发送邮件
	    Transport.send(message);
	}

}
