package com.online.service;

import com.online.model.ClassCost;

public interface CostService {

	public void addCost(ClassCost record);
	public ClassCost getCost(Integer id);
}
