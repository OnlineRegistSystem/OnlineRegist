package com.online.service;

import java.util.List;

import com.online.model.Department;

public interface DepartmentService {
	public void addDepartmrnt(Department record);

	public List selectBypage(Integer start,Integer offset);
	public List selectByKey(String key ,Integer start,Integer offset);
	public List getDiseseOfHospital(Integer hospitalId);
}
