package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.online.model.Disease;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Disease record);

    int insertSelective(Disease record);

    Disease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);
    //补充
    List selectByKey(@Param("key")String key,@Param("start")Integer start,@Param("offset")Integer offset); 
    List selectByKeyAndPositionId(@Param("key")String key,@Param("positionId") Integer positionId,@Param("start")Integer start,@Param("offset")Integer offset); 
    List selectByDepartmentId(@Param("departmentId")Integer departmentId);
    List selectDocterOfDisease(@Param("diseaseId")Integer diseaseId);
}