package com.online.service.imp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.bean.DiseaseOfHosipitalBean;
import com.online.dao.DepartmentMapper;
import com.online.dao.DiseaseMapper;
import com.online.model.Department;
import com.online.service.DepartmentService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 上午9:07:04
 *	TODO
 */
@Service
public class DepartmentServiceImp implements DepartmentService{

	@Resource
	private DepartmentMapper departmentDao;
	@Resource
	private DiseaseMapper diseaseMapper;
	public void addDepartmrnt(Department record) {
		// TODO Auto-generated method stub
		departmentDao.insert(record);
	}
	public List selectBypage(Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return departmentDao.selectByPage(start, offset);
	}
	public List selectByKey(String key, Integer start, Integer offset) {
		// TODO Auto-generated method stub
		return departmentDao.selectByKey(key, start, offset);
	}
	public List getDiseseOfHospital(Integer hospitalId) {
		// TODO Auto-generated method stub
		List<Department> list1= departmentDao.selectDiseaseOfHospital(hospitalId);
		if(list1 != null){
			List<DiseaseOfHosipitalBean> beanList  = new LinkedList<DiseaseOfHosipitalBean>();
			for(Department re:list1){
				DiseaseOfHosipitalBean be =new DiseaseOfHosipitalBean();
				be.setDepartmentId(re.getId());
				be.setDepartmentName(re.getName());
				be.setDiseaseList(diseaseMapper.selectByDepartmentId(re.getId()));
				beanList.add(be);
			}
			return beanList;
		}
				
		return null;
	}

	
}
