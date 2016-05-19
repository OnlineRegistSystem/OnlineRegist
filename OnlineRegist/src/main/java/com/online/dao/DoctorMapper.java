package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.online.model.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
    //补充
    List selectByKey(@Param("key")String key,@Param("start")Integer start,@Param("offset")Integer offset); 
    List selectByKeyAndPositionId(@Param("key")String key,@Param("positionId") Integer positionId,@Param("start")Integer start,@Param("offset")Integer offset); 
}