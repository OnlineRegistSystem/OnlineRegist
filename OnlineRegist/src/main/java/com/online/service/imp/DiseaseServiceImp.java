package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.DiseaseMapper;
import com.online.model.Disease;
import com.online.service.DiseaseService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:21:52
 *	TODO
 */
@Service
public class DiseaseServiceImp implements DiseaseService {

	@Resource
	private DiseaseMapper diseaseDao;
	public void addDisease(Disease record) {
		// TODO Auto-generated method stub
		diseaseDao.insert(record);
	}
	public List selectByKey(String key, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return diseaseDao.selectByKey(key, start, offset);
	}
	public List selectByKeyAndPositionId(String key, Integer positionId, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return diseaseDao.selectByKeyAndPositionId(key, positionId, start, offset);
	}
	public List getAllDoctorOfDisease(Integer diseaseId) {
		// TODO Auto-generated method stub
		return diseaseDao.selectDocterOfDisease(diseaseId);
	}

}
