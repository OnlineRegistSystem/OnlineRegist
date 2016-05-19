package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
		return schedulingMapper.selectByDoctorId(doctorId);
	}
	public Scheduling selectByDoctorIdAndDate(String date, Integer doctorId) {
		// TODO Auto-generated method stub
		return schedulingMapper.selectByDocterIdAndDate(date, doctorId);
	}
	public void updateScheduling(Scheduling record) {
		// TODO Auto-generated method stub
		schedulingMapper.updateByPrimaryKey(record);
	}

}
