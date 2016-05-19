package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.online.model.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
    //补充
    List selectByPositionId(Integer positionId);
    List selectBypage(@Param("start")Integer start,@Param("offset")Integer offset);
    List selectByKey(@Param("key")String key,@Param("start")Integer start,@Param("offset")Integer offset);
   
}