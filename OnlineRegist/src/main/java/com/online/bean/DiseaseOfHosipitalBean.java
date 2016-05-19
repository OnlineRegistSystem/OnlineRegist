package com.online.bean;

import java.util.List;

/**
 * @author chuankun
 *@2016年5月15日 上午10:08:54
 * email:yichuankun@qq.com
 */
public class DiseaseOfHosipitalBean {
	
	private Integer departmentId;
	private String departmentName;
	private List diseaseList;
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List getDiseaseList() {
		return diseaseList;
	}
	public void setDiseaseList(List diseaseList) {
		this.diseaseList = diseaseList;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

}
