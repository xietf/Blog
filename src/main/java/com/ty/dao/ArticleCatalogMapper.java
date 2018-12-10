package com.ty.dao;

import com.ty.entity.ArticleCatalog;

import java.util.List;
import java.util.Map;

public interface ArticleCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCatalog record);

    int insertSelective(ArticleCatalog record);

    ArticleCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleCatalog record);

    int updateByPrimaryKeyWithBLOBs(ArticleCatalog record);

    int updateByPrimaryKey(ArticleCatalog record);

    List<ArticleCatalog> selectAll(Map<String,Object>map);
}