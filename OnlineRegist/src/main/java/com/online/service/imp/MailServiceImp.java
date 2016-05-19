package com.online.service.imp;

import java.util.concurrent.FutureTask;


import org.springframework.stereotype.Service;

import com.online.service.MailService;
import com.online.util.MailUtil;
@Service
public class MailServiceImp implements MailService{

		public void sendVerifyCode(String destination, String code) {
			// TODO Auto-generated method stub
		MailUtil mailUtil = new MailUtil(destination, "您的在线预约系统找回密码验证码是："+code,"在线预约系统找回密码");
		FutureTask<Integer> task = new FutureTask<Integer>(mailUtil);
		new Thread(task,"邮箱验证").start();
	}

}

