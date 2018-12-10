package com.ty.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
public interface BaseService<T>{
    PageInfo<T> selectBypage(Map<String,Object>map);
    List<T> selectByMap(Map<String,Object>map);
    boolean insert(T t);
    boolean delete(int id);
    boolean update(T t);

}
