package com.online.bean;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月25日 上午11:36:38
 *	TODO
 */
public class SchedulingResult {
	private String schedulingId;
	private String date;
	private String cost;
	private String state;
	private Integer doctorId;
	private String time;
	private String week;
	private Integer isMAE;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public Integer getIsMAE() {
		return isMAE;
	}
	public void setIsMAE(Integer isMAE) {
		this.isMAE = isMAE;
	}


}
