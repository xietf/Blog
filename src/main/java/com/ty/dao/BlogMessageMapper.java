package com.ty.dao;

import com.ty.entity.BlogMessage;

import java.util.List;
import java.util.Map;

public interface BlogMessageMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(BlogMessage record);

    int insertSelective(BlogMessage record);

    BlogMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogMessage record);

    int updateByPrimaryKeyWithBLOBs(BlogMessage record);

    int updateByPrimaryKey(BlogMessage record);

    List<BlogMessage> selectAll(Map<String, Object> map);
}