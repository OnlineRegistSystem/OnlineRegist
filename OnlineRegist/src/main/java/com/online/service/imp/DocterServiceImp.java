package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.DoctorMapper;
import com.online.model.Doctor;
import com.online.service.DocterService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:32:04
 *	TODO
 */
@Service
public class DocterServiceImp implements DocterService {

	@Resource
	private DoctorMapper doctorDao;
	public void addDocter(Doctor record) {
		// TODO Auto-generated method stub
		doctorDao.insert(record);
	}
	public List selectByKey(String key, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return doctorDao.selectByKey(key, start, offset);
	}
	public List selectByKeyAndPositionId(String key, Integer positionId, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return doctorDao.selectByKeyAndPositionId(key, positionId, start, offset);
	}

}
