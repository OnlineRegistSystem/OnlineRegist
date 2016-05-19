package com.online.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Doctor;
import com.online.service.DocterService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:33:47
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class DocterController {

	@Resource
	private DocterService docterService;
	
	@RequestMapping("/addDocter")
	@ResponseBody
	public Object addDocter(HttpServletRequest request){
		String name = request.getParameter("name");
		String diseaseId = request.getParameter("diseaseId");
		String doctorDesc = request.getParameter("docterDesc");
		String doctorClass = request.getParameter("docterClass");
		String doctorImage = request.getParameter("docterImage");
		if(name==null||diseaseId==null||doctorClass==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(doctorDesc==null){
			doctorDesc="";
		}else if(doctorImage==null){
			doctorImage="";
		}
		Doctor doctor = new Doctor();
		doctor.setDiseaseId(Integer.valueOf(diseaseId));
		doctor.setDoctorClass(Integer.valueOf(doctorClass));
		doctor.setDoctorDesc(doctorDesc);
		doctor.setDoctorImage(doctorImage);
		doctor.setName(name);
		
		docterService.addDocter(doctor);
		return Message.getMessage(1, "", "");
	}
}
