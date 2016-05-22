package com.online.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.bean.DepartmentResult;
import com.online.bean.DoctorResult;
import com.online.bean.SchedulingResult;
import com.online.model.Hospital;
import com.online.service.DepartmentService;
import com.online.service.DiseaseService;
import com.online.service.DocterService;
import com.online.service.HospitalService;
import com.online.service.SchedulingService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午5:39:43
 *	TODO
 */
@Controller
@RequestMapping("/order")
public class SearchController {

	@Resource
	private HospitalService hospitalService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private DiseaseService diseaseService;
	@Resource
	private DocterService docterService;
	@Resource
	private SchedulingService schedulingService;
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/getHospitalByPositionId")
	@ResponseBody
	public Object getHospitalByPositionId(HttpServletRequest request){
		String positionId= request.getParameter("positionId");
		if(positionId==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		List<Hospital> list = hospitalService.selectByPositionId(Integer.valueOf(positionId));
		return Message.getMessage(list);
	}
	@RequestMapping("/getHospitalByPage")
	@ResponseBody
	public Object getHospitalByPage(HttpServletRequest request){
		String page = request.getParameter("page");
		if(page==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		Integer start = Integer.valueOf(page);
		
		List<Hospital> list ;
		if(start==0){ //返航所有
			list = hospitalService.selectByPage(0, 1000);
		}else {
			String number = request.getParameter("number");
			String isAll = request.getParameter("isAll");
			if(number==null){
				return Message.getMessage(0, "参数为空！", "");
			}
			Integer offset = Integer.valueOf(number);
			start = (start-1)*offset;
			if(isAll==null){
				list = hospitalService.selectByPage(start,offset);
			}else{
				list = hospitalService.selectByPage(start, 10000);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List list2 = hospitalService.selectByPage(0, 10000);
		if(list2!=null){
			map.put("number", list2.size());
		}else{
			map.put("number", 0);
		}
		map.put("hospitals", list);
		if(list.isEmpty()){
			return Message.getMessage(2, "", map);
		}
		return Message.getMessage(map);
	}
	@RequestMapping("/getDepartmentByPage")
	@ResponseBody
	public Object getDepartmentByPage(HttpServletRequest request){
		String page = request.getParameter("page");
		if(page==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		Integer start = Integer.valueOf(page);
		
		List<DepartmentResult> list ;
		if(start==0){ //返回所有
			list = departmentService.selectBypage(0, 10000);
		}else {
			String number = request.getParameter("number");
			String isAll = request.getParameter("isAll");
			if(number==null){
				return Message.getMessage(0, "参数为空！", "");
			}
			Integer offset = Integer.valueOf(number);
			start = (start-1)*offset;
			if(isAll==null){
				list = departmentService.selectBypage(start, offset);
			}else{
				list = departmentService.selectBypage(start, 10000);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List list2 = departmentService.selectBypage(0, 10000);
		if(list2!=null){
			map.put("number", list2.size());
		}else{
			map.put("number", 0);
		}
		map.put("departments", list);
		if(list.isEmpty()){
			return Message.getMessage(2, "", map);
		}
		return Message.getMessage(map);
	}
	@RequestMapping("/searchByType")
	@ResponseBody
	public Object searchByType(HttpServletRequest request){
		String key = request.getParameter("key");
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		if(key==null||type==null||page==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		
		switch (Integer.valueOf(type)) {
		case 1:{//按医院搜索
			Integer start = Integer.valueOf(page);
			List<Hospital> list ;
			if(start==0){ //返航所有
				list = hospitalService.selectByKey(key, 0, 10000);
			}else {
				String number = request.getParameter("number");
				String isAll = request.getParameter("isAll");
				if(number==null){
					return Message.getMessage(0, "参数为空！", "");
				}
				Integer offset = Integer.valueOf(number);
				start = (start-1)*offset;
				if(isAll==null){
					list = hospitalService.selectByKey(key,start, offset);
				}else{
					list = hospitalService.selectByKey(key,start, 10000);
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			List list2 =hospitalService.selectByKey(key, 0, 10000);
			if(list2!=null){
				map.put("number", list2.size());
			}else{
				map.put("number", 0);
			}
			map.put("datas", list);
			if(list.isEmpty()){
				return Message.getMessage(2, "", map);
			}
			return Message.getMessage(map);
			
		}
		
		case 2:{//按科室查找
			Integer start = Integer.valueOf(page);
			List<DepartmentResult> list ;
			if(start==0){ //返航所有
				list = departmentService.selectByKey(key, 0, 10000);
			}else {
				String number = request.getParameter("number");
				String isAll = request.getParameter("isAll");
				if(number==null){
					return Message.getMessage(0, "参数为空！", "");
				}
				Integer offset = Integer.valueOf(number);
				start = (start-1)*offset;
				if(isAll==null){
					list = departmentService.selectByKey(key,start, offset);
				}else{
					list =departmentService.selectByKey(key,start, 10000);
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			List list2 =departmentService.selectByKey(key, 0, 10000);
			if(list2!=null){
				map.put("number", list2.size());
			}else{
				map.put("number", 0);
			}
			map.put("datas", list);
			if(list.isEmpty()){
				return Message.getMessage(2, "", map);
			}
			return Message.getMessage(map);
			 
		}
		case 3:{//按疾病查找
			Integer start = Integer.valueOf(page);
			List<DoctorResult> list ;
			if(start==0){ //返航所有
				list = diseaseService.selectByKey(key, 0, 10000);
			}else {
				String number = request.getParameter("number");
				String isAll = request.getParameter("isAll");
				String positionId = request.getParameter("positionId");
			
				if(number==null){
					return Message.getMessage(0, "参数为空！", "");
				}
				Integer offset = Integer.valueOf(number);
				start = (start-1)*offset;
				if(positionId==null){ //positionId 是否为空
				if(isAll==null){
					list = diseaseService.selectByKey(key,start, offset);
				}else{
					list = diseaseService.selectByKey(key,start, 10000);
				}
			}else{
				if(isAll==null){
					list = diseaseService.selectByKeyAndPositionId(key,Integer.valueOf(positionId),start, offset);
				}else{
					list = diseaseService.selectByKeyAndPositionId(key,Integer.valueOf(positionId),start, 10000);
				}
			}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			List list2 =diseaseService.selectByKey(key, 0, 10000);
			if(list2!=null){
				map.put("number", list2.size());
			}else{
				map.put("number", 0);
			}
			map.put("datas", list);
			if(list.isEmpty()){
				return Message.getMessage(2, "", map);
			}
			return Message.getMessage(map);
		}
		case 4:{//按医生查找
			Integer start = Integer.valueOf(page);
			List<HospitalService> list ;
			if(start==0){ //返航所有
				list = docterService.selectByKey(key, 0, 10000);
			}else {
				String number = request.getParameter("number");
				String isAll = request.getParameter("isAll");
				String positionId =request.getParameter("positionId");
				if(number==null){
					return Message.getMessage(0, "参数为空！", "");
				}
				Integer offset = Integer.valueOf(number);
				start = (start-1)*offset;
				if(positionId==null){
				if(isAll==null){
					list = docterService.selectByKey(key,start, offset);
				}else{
					list = docterService.selectByKey(key,start, 10000);
				}
				}else{
					if(isAll==null){
						list = docterService.selectByKeyAndPositionId(key,Integer.valueOf(positionId),start, offset);
					}else{
						list = docterService.selectByKeyAndPositionId(key,Integer.valueOf(positionId),start, 10000);
					}
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			List list2 =docterService.selectByKey(key, 0, 10000);
			if(list2!=null){
				map.put("number", list2.size());
			}else{
				map.put("number", 0);
			}
			map.put("datas", list);
			if(list.isEmpty()){
				return Message.getMessage(2, "", map);
			}
			return Message.getMessage(map);
		}
		default:
			break;
		}
		return null;
	}
	@RequestMapping("/getScheduling")
	@ResponseBody
	public Object getSchedulingByDocterId(HttpServletRequest request){
		String doctorId = request.getParameter("doctorId");
		if(doctorId==null ){
			return Message.getMessage(0, "参数为空！", "");
		}
		List<SchedulingResult> list = schedulingService.selectByDoctorId(Integer.valueOf(doctorId));
		return Message.getMessage(list);
	}
}
