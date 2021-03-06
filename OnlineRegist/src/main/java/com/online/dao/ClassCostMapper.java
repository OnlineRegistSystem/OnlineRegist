package com.online.dao;

import java.util.List;

import com.online.model.ClassCost;

public interface ClassCostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassCost record);

    int insertSelective(ClassCost record);

    ClassCost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassCost record);

    int updateByPrimaryKey(ClassCost record);
    
    //补充
    List selectAll();
}