package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.ClassCostMapper;
import com.online.model.ClassCost;
import com.online.service.CostService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午2:43:48
 *	TODO
 */
@Service
public class CostServiceImp implements CostService{

	@Resource
	private ClassCostMapper classCostDao;
	public void addCost(ClassCost record) {
		// TODO Auto-generated method stub
		classCostDao.insert(record);
	}
	public ClassCost getCost(Integer id) {
		// TODO Auto-generated method stub
		
		return classCostDao.selectByPrimaryKey(id);
	}
	public List selectAll() {
		// TODO Auto-generated method stub
		return classCostDao.selectAll();
	}
	
	
}
