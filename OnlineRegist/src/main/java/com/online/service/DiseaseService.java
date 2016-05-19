package com.online.service;

import java.util.List;

import com.online.model.Disease;

public interface DiseaseService {

	public void addDisease(Disease record);
	
	public List selectByKey(String key,Integer start ,Integer offset);
	public List selectByKeyAndPositionId(String key,Integer positionId,Integer start ,Integer offset);
	
	public List getAllDoctorOfDisease(Integer diseaseId);
}
