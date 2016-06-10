package com.online.bean;

import java.util.List;

public class DoctorResult {
	
	private Integer doctorId;
	private String hospitalName;
    private String doctorName;
    private String doctorDesc;
    private Integer doctorClass;
    private String doctorImage;
    private List timeList;
    public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDesc() {
		return doctorDesc;
	}
	public void setDoctorDesc(String doctorDesc) {
		this.doctorDesc = doctorDesc;
	}
	public Integer getDoctorClass() {
		return doctorClass;
	}
	public void setDoctorClass(Integer doctorClass) {
		this.doctorClass = doctorClass;
	}
	public String getDoctorImage() {
		return doctorImage;
	}
	public void setDoctorImage(String doctorImage) {
		this.doctorImage = doctorImage;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public List getTimeList() {
		return timeList;
	}
	public void setTimeList(List timeList) {
		this.timeList = timeList;
	}
	private Integer hospitalId;
    
	

}
