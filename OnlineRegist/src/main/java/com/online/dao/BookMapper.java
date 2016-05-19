package com.online.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.online.model.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    //补充
    List selectByUserId(@Param("userId")Integer userId);
    int selectNumberOfScheduling(@Param("schedulingId") Integer schedulingId);
}