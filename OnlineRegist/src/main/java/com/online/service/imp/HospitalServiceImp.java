package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.DepartmentMapper;
import com.online.dao.DiseaseMapper;
import com.online.dao.HospitalMapper;
import com.online.model.Hospital;
import com.online.service.HospitalService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月21日 上午10:08:56
 *	TODO
 */
@Service
public class HospitalServiceImp implements HospitalService{

	@	Resource
	private HospitalMapper hospitalDao;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private DiseaseMapper diseaseMapper;
	public void addHospital(Hospital record) {
		// TODO Auto-generated method stub
		hospitalDao.insert(record);
	}
	public List selectByPositionId(Integer positionId) {
		// TODO Auto-generated method stub
		return hospitalDao.selectByPositionId(positionId);
	}
	public List selectByPage(Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return hospitalDao.selectBypage(start, offset);
	}
	public List selectByKey(String key, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return hospitalDao.selectByKey(key, start, offset);
	}
	public List selectDiseaseOfHospital(Integer hospitalId) {
		// TODO Auto-generated method stub
		 
		return null;
	}
	

}
