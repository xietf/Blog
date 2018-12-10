package com.ty.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dao.UserMapper;
import com.ty.entity.User;
import com.ty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@Service
public class UserServiceImple implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageInfo<User> selectBypage(Map<String, Object> map) {
        int   pageNum=map.get("pageNum")==null?1:Integer.parseInt(map.get("pageNum")+"");
        int   pageSize=map.get("pageSize")==null?5:Integer.parseInt(map.get("pageSize")+"");
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(userMapper.selectAll(map));
    }

    @Override
    public List<User> selectByMap(Map<String, Object> map) {
        return userMapper.selectAll(map);
    }

    @Override
    @Transactional
    public boolean insert(User user) {
        try {
            if(userMapper.insertSelective(user)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            if(userMapper.deleteByPrimaryKey(id)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean update(User user) {
        try {
            if(userMapper.updateByPrimaryKeySelective(user)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }
}
