package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.online.model.Scheduling;

public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);
    
  //补充
    List selectByDoctorId(@Param("doctorId")Integer doctorId);
    
    Scheduling selectByDocterIdAndDate(@Param("date")String date,@Param("doctorId")Integer doctorId,@Param("time")String time);

    List manageSelectByDoctorId(@Param("doctorId")Integer doctorId);
}