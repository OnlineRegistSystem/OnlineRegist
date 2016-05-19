package com.online.service;

import java.util.List;

import com.online.model.Doctor;

public interface DocterService {

	public void addDocter(Doctor record);
	public List selectByKey(String key,Integer start,Integer offset);
	public List selectByKeyAndPositionId(String key,Integer positionId,Integer start,Integer offset);
}
