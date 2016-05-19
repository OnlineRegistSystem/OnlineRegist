package com.online.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月26日 上午10:58:14
 *	TODO
 */
@Controller
@RequestMapping("/redirect")
public class RedireController {
	
	@RequestMapping("/forward")
	public String forward(HttpServletRequest request){
		String pageName = request.getParameter("pageName");
		if(pageName==null){
			return "index";
		}
		return pageName;
	}

}
