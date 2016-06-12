package com.online.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.ClassCost;
import com.online.service.CostService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午2:46:53
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class CostController {

	@Resource
	private CostService costService;
	
	@RequestMapping("/addCost")
	@ResponseBody
	public Object addClassCost(HttpServletRequest request){
		String name = request.getParameter("name");
		String cost = request.getParameter("cost");
		if(name==null||cost==null){
			return Message.getMessage(0, "参数为空！", "");
		}
		ClassCost record = new ClassCost();
		record.setCost(cost);
		record.setName(name);
		costService.addCost(record);
		
		return Message.getMessage(1, "", "");
	}
	@RequestMapping("/getClassAndCost")
	@ResponseBody
	public Object getClassAndCost(HttpServletRequest request){
		String classCostId = request.getParameter("classCostId");
		if(classCostId==null){
			return Message.getMessage(costService.selectAll());
		}
		ClassCost classCost = costService.getCost(Integer.valueOf(classCostId));
		return Message.getMessage(classCost);
	}
}
