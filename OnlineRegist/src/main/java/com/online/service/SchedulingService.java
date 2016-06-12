package com.online.service;

import java.util.List;

import com.online.model.Scheduling;

public interface SchedulingService {
	
	public void addSheduling(Scheduling record);
	public List selectByDoctorId(Integer doctorId);
	public Scheduling selectByDoctorIdAndDate(String date,Integer doctorId,String time);
	
	public void updateScheduling(Scheduling record);
	
	public List manageSelectByDoctorId(Integer doctorId);
}
