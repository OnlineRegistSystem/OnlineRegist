package com.online.service;

import java.util.List;

import com.online.model.Hospital;

public interface HospitalService {

	public void addHospital(Hospital record);
	public List selectByPositionId(Integer positionId);
	
	public List selectByPage(Integer start,Integer offset);
	
	public List selectByKey(String key,Integer start,Integer offset);
}
