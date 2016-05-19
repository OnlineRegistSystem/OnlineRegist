package com.online.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Hospital;
import com.online.service.HospitalService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月21日 上午10:10:50
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class HospitalController {

	@Resource
	private HospitalService hospitalService;
	@RequestMapping("addHospital")
	@ResponseBody
	public Object addHospital(HttpServletRequest request){
		String name = request.getParameter("name");
		String positionId= request.getParameter("positionId");
		String desc = request.getParameter("desc");
		String hospitalClass = request.getParameter("hospitalClass");
		String phone = request.getParameter("phone");
		String image = request.getParameter("image");
		String address = request.getParameter("address");
		if(name==null||positionId==null||hospitalClass==null){
			return Message.getMessage(0, "参数为空！", "");
		}else if(desc==null){
			desc ="";
		}else if(phone==null){
			phone="";
		}else if(image==null){
			image="";
		}else if(address==null){
			address="广州市";
		}
		Hospital hospital = new Hospital();
		hospital.setHospitalClass(hospitalClass);
		hospital.setHospitalDesc(desc);
		hospital.setImage(image);
		hospital.setName(name);
		hospital.setPositionid(Integer.valueOf(positionId));
		hospital.setHospitalPhone(phone);
		hospital.setHospitalAddress(address);
		
		hospitalService.addHospital(hospital);
		return Message.getMessage(1, "", "");
		
	}
	

}
