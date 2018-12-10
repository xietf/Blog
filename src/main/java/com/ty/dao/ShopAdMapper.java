package com.ty.dao;

import com.ty.entity.ShopAd;

import java.util.List;
import java.util.Map;

public interface ShopAdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopAd record);

    int insertSelective(ShopAd record);

    ShopAd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopAd record);

    int updateByPrimaryKeyWithBLOBs(ShopAd record);

    int updateByPrimaryKey(ShopAd record);

    List<ShopAd> selectAll(Map<String, Object> map);
}