package com.online.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Department;
import com.online.service.DepartmentService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:09:15
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	@RequestMapping("addDepartment")
	@ResponseBody
	public Object addDepartment(HttpServletRequest request){
		String name = request.getParameter("name");
		String hospitalId = request.getParameter("hospitalId");
		if(name==null||hospitalId==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		Department department = new Department();
		department.setHospitalId(Integer.valueOf(hospitalId));
		department.setName(name);
		
		departmentService.addDepartmrnt(department);
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/getDiseaseOfHospital")
	@ResponseBody
	public Object getDiseaseOfHospital(Integer hospitalId){
		if(hospitalId==null){
			return Message.getMessageParmNull();
		}
		List list = departmentService.getDiseseOfHospital(hospitalId);
		
		return Message.getMessage(list);
	}

}
