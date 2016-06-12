package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.bean.SchedulingResult;
import com.online.dao.SchedulingMapper;
import com.online.model.Scheduling;
import com.online.service.SchedulingService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午3:16:40
 *	TODO
 */
@Service
public class SchedulingServiceImp implements SchedulingService{

	@Resource
	private SchedulingMapper schedulingMapper;
	public void addSheduling(Scheduling record) {
		// TODO Auto-generated method stub
		schedulingMapper.insert(record);
	}
	public List selectByDoctorId(Integer doctorId) {
		// TODO Auto-generated method stub
		List<SchedulingResult> list = schedulingMapper.selectByDoctorId(doctorId);
		for(SchedulingResult res:list){
			String[] str = res.getTime().split(":");
			if(Integer.valueOf(str[0])<12){// 表示上午
				res.setIsMAE(0);
			}else if(Integer.valueOf(str[0])<17){// 1 表示下午
				res.setIsMAE(1);
			}else { // 表示晚上
				res.setIsMAE(2);
			}
		}
		return list;
	}
	public Scheduling selectByDoctorIdAndDate(String date, Integer doctorId,String time) {
		// TODO Auto-generated method stub
		return schedulingMapper.selectByDocterIdAndDate(date, doctorId,time);
	}
	public void updateScheduling(Scheduling record) {
		// TODO Auto-generated method stub
		schedulingMapper.updateByPrimaryKey(record);
	}
	public List manageSelectByDoctorId(Integer doctorId) {
		// TODO Auto-generated method stub
		return schedulingMapper.manageSelectByDoctorId(doctorId);
	}

}
