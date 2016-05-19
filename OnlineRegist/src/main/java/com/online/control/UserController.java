package com.online.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.User;
import com.online.service.MailService;
import com.online.service.UserService;
import com.online.util.Message;
import com.sun.mail.handlers.message_rfc822;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月18日 下午4:44:36
 *	TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private MailService mailService;
	
	@RequestMapping("/regist")
	@ResponseBody
	public Object regist(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String IDcard = request.getParameter("IDcard");
		if(username==null){
			return Message.getMessage(0, "用户名为空！", "");
		}else if(userService.findUserByName(username)!=null){
			return Message.getMessage(0, "用户名已存在", "");
		}else if(password==null){
			return Message.getMessage(0, "密码为空！"	, "");
		}else if(password.length()<6){
			return Message.getMessage(0, "密码长度小于6位", "");
		}else if(email==null){
			return Message.getMessage(0, "邮箱为空", "");
		}
		if(sex==null||IDcard==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
		 Pattern regex = Pattern.compile(check);    
		 Matcher matcher = regex.matcher(email);    
		 boolean isMatched = matcher.matches();
		 if(!isMatched){
			 return Message.getMessage(0, "邮箱格式错误！", "");
		 }else if(userService.findUserByEmail(email)!=null){
			 return Message.getMessage(0, "邮箱已被注册！", "");
		 }
		 if(phone==null){
			 phone="";
		 }
		 User  user = new User();
		 user.setEmail(email);
		 user.setName(username);
		 user.setPassword(password);
		 user.setPhone(phone);
		 try{
		 user.setIdcard(IDcard);
		 user.setSex(Integer.valueOf(sex));
		 }catch (NumberFormatException e){
			 return Message.getMessage(0, "格式错误！", "");
		 }
		 userService.addUser(user);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/checkEmail")
	@ResponseBody
	public Object checkEmail(HttpServletRequest request){
		String email = request.getParameter("email");
		if(email ==  null){
			return Message.getMessage(0, "邮箱为空！", "");
		}
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
		 Pattern regex = Pattern.compile(check);    
		 Matcher matcher = regex.matcher(email);    
		 boolean isMatched = matcher.matches();
		 if(!isMatched){
			 return Message.getMessage(0, "邮箱格式错误！", "");
		 }
		 if(userService.findUserByEmail(email)!=null){
			 return Message.getMessage(2, "邮箱已被注册！", "");
		 }
		return Message.getMessage(1, "", "");
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null){
			return Message.getMessage(0, "用户名为空！", "");
			
		}else if(password==null){
			return Message.getMessage(0, "密码为空！", 	"");
		}
		User user = userService.findUserByName(username);
		if(user==null){
			return Message.getMessage(0, "用户名不存在！", "");
		}
		if(password.equalsIgnoreCase(user.getPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			return Message.getMessage(1, "", "");
		}else{
			return Message.getMessage(0, "密码错误！", "");
		}
	}
	@RequestMapping("/viewInfo")
	@ResponseBody
	public Object viewInfo(HttpSession session){
		if(session==null){
			return Message.getMessage(0, "登录信息已失效！", "");
		}
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userService.findById(userId);
		if(user != null){
			user.setPassword("******");
			return Message.getMessage(1, "", user);
		}
		return Message.getMessage(0, "登录信息已失效！", "");
	}
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public Object modifyPassword(HttpServletRequest request,HttpSession session){
		if(session==null){
			return Message.getMessage(0, "登录信息已失效！", "");
		}
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId==null){
			return Message.getMessage(0, "登录信息已失效！", "");
		}
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		if(oldPassword==null||newPassword == null){
			return Message.getMessage(0, "密码为空！", "");
		}
		if(newPassword.length()<6){
			return Message.getMessage(0, "新密码长度小于6位！", "");
		}
		User user =  userService.findById(userId);
		if(!user.getPassword().equals(oldPassword)){
			return Message.getMessage(0, "密码错误！", "");
		}
		user.setPassword(newPassword);
		userService.updateUser(user);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/sendVerifyCode")
	@ResponseBody
	public Object sendVerifyCode(HttpServletRequest request){
		String email = request.getParameter("email");
		if(email==null){
			return Message.getMessage(0, "邮箱为空！", "");
		}else if(userService.findUserByEmail(email)==null){
			return Message.getMessage(0, "邮箱未注册！", "");
			
		}
		Integer number = new Integer((int) (Math.random()*100000+1));
		String  code= String.format("%6d", number).replaceAll(" ", "0");
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		session.setAttribute("email", email);
		mailService.sendVerifyCode(email, code);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/checkVerifyCode")
	@ResponseBody
	public Object checkVerifyCode(HttpSession session,HttpServletRequest request){
		if(session ==null){
			return Message.getMessage(0, "请重新发送验证码！", "");
		}
		String code = (String) session.getAttribute("code");
		if(code == null ){
			return Message.getMessage(0, "请重新发送验证码！", "");
		}
		String verifyCode = request.getParameter("code");
		if(!code.equalsIgnoreCase(verifyCode)){
			return Message.getMessage(0, "验证码错误！", "");
		}
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/resetPassword")
	@ResponseBody
	public Object resetPassword(HttpServletRequest request,HttpSession session){
		if(session ==null){
			return Message.getMessage(0, "请重新发送验证码！", "");
		}
		String code = (String) session.getAttribute("code");
		if(code == null ){
			return Message.getMessage(0, "请重新发送验证码！", "");
		}
		String verifyCode = request.getParameter("code");
		if(!code.equalsIgnoreCase(verifyCode)){
			return Message.getMessage(0, "验证码错误！", "");
		}
		String email =(String) session.getAttribute("email");
		String password = request.getParameter("password");
		if(email==null||password==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(password.length()<6){
			return Message.getMessage(0, "密码长度小于6位！", "");
		}
		
		User user  = userService.findUserByEmail(email);
		user.setPassword(password);
		userService.updateUser(user);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/logOut")
	@ResponseBody
	public Object logOut(HttpSession session){
		if(session!=null){
			session.setAttribute("userId", null);
		}
		return Message.getMessage(1, "", "");
	}
}
