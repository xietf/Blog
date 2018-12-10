package com.ty.dao;

import com.ty.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectAll(Map<String, Object> map);
}