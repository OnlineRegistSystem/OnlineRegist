package com.online.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Scheduling;
import com.online.service.SchedulingService;
import com.online.util.DateUtil;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午3:19:14
 *	TODO
 */
@Controller 
@RequestMapping("/manage")
public class SchedulingController {

	@Resource
	private SchedulingService schedulingService;
//	@RequestMapping("/addScheduling")
//	@ResponseBody
//	public Object addScheduling(HttpServletRequest request){
//		String doctorId = request.getParameter("doctorId");
//		String date = request.getParameter("date");
//		String number = request.getParameter("number");
//		String state = request.getParameter("state");
//		if(doctorId==null||date==null||number==null||state==null){
//			return Message.getMessage(0, "参数为空！", "");
//		}
//		Scheduling scheduling = new Scheduling();
//		scheduling.setDate(date);
//		scheduling.setDoctorId(Integer.valueOf(doctorId));
//		scheduling.setNumber(number);
//		scheduling.setState(state);
//		
//		schedulingService.addSheduling(scheduling);
//		return Message.getMessage(1, "", "");
//	}
	@RequestMapping("/addScheduling")
	@ResponseBody
	public Object addScheduling(Scheduling record){
		if(record.getDate()==null||record.getDoctorId()==null||record.getNumber()==null||record.getTime()==null){
			return Message.getMessageParmNull();
		}
		if(schedulingService.selectByDoctorIdAndDate(record.getDate(), record.getDoctorId(),record.getTime())!=null){
			return Message.getMessage(null);
		}
		if(record.getState()==null){
			record.setState("1");
		}
		record.setWeek(DateUtil.getWeek( record.getDate(),"-"));
		schedulingService.addSheduling(record);
		return Message.getMessage();
	}
	@RequestMapping("/updateScheduling")
	@ResponseBody
	public Object updateScheduling(Scheduling record){
		if(record.getDate()==null||record.getDoctorId()==null||record.getNumber()==null||record.getId()==null||record.getTime()==null){
			return Message.getMessageParmNull();
		}
		if(schedulingService.selectByDoctorIdAndDate(record.getDate(), record.getDoctorId(),record.getTime())!=null){
			return Message.getMessage(null);
		}
		if(record.getState()==null){
			record.setState("1");
		}
		record.setWeek(DateUtil.getWeek( record.getDate(),"-"));
		schedulingService.updateScheduling(record);
		return Message.getMessage();
	}
}
