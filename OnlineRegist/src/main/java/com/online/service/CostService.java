package com.online.service;

import java.util.List;

import com.online.model.ClassCost;

public interface CostService {

	public void addCost(ClassCost record);
	public ClassCost getCost(Integer id);
	
	public List selectAll();
}
