package com.online.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Disease;
import com.online.service.DiseaseService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:23:47
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class DiseaseController {

	@Resource
	private DiseaseService diseaseService;
	
	@RequestMapping("addDisease")
	@ResponseBody
	public Object addDisease(HttpServletRequest request){
		String name = request.getParameter("name");
		String departmentId = request.getParameter("departmentId");
		if(name==null||departmentId==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		Disease disease = new Disease();
		disease.setDepartmenId(Integer.valueOf(departmentId));
		disease.setName(name);
		diseaseService.addDisease(disease);
		return Message.getMessage(1, "", "");
	}
	
	
}
