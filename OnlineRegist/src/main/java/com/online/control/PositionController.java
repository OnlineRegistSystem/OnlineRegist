package com.online.control;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Position;
import com.online.service.PositionService;
import com.online.util.Message;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午3:42:44
 *	TODO
 */
@Controller
@RequestMapping("/manage")
public class PositionController {

	@Resource
	private PositionService positionService;
	@RequestMapping("/getPosition")
	@ResponseBody
	public Object getPotion(){
		List<Position> list = positionService.getPosition();
		
		return Message.getMessage( list);
	}
}
