package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.online.model.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    //补充
    List selectByPage(@Param("start")Integer start,@Param("offset")Integer offset);
    List selectByKey(@Param("key")String key,@Param("start")Integer start,@Param("offset")Integer offset);
    List selectDiseaseOfHospital(@Param("hospitalId")Integer hospitalId);
}