package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.print.Doc;

import org.springframework.stereotype.Service;

import com.online.bean.DoctorResult;
import com.online.dao.DiseaseMapper;
import com.online.dao.DoctorMapper;
import com.online.model.Disease;
import com.online.service.DiseaseService;
import com.online.service.SchedulingService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:21:52
 *	TODO
 */
@Service
public class DiseaseServiceImp implements DiseaseService {

	@Resource
	private DiseaseMapper diseaseDao;
	@Resource
	private SchedulingService schedulingService;
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
	public List getAllDoctorOfDisease(Integer diseaseId,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		if(page==null){
			return diseaseDao.selectDocterOfDisease(diseaseId,null,null);
			
		}
		
		List<DoctorResult> list = diseaseDao.selectDocterOfDisease(diseaseId,(page-1)*pageSize,pageSize);
		for(DoctorResult res:list){
			res.setTimeList(schedulingService.selectByDoctorId(res.getDoctorId()));
		}
		
		return list;
	}

}
