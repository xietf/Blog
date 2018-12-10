package com.ty.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dao.BlogMessageMapper;
import com.ty.entity.BlogMessage;
import com.ty.service.BlogMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@Service
public class BlogMessageServiceImple implements BlogMessageService {
    @Autowired
    BlogMessageMapper blogMessageMapper;
    @Override
    public PageInfo<BlogMessage> selectBypage(Map<String, Object> map) {
        int   pageNum=map.get("pageNum")==null?1:Integer.parseInt(map.get("pageNum")+"");
        int   pageSize=map.get("pageSize")==null?5:Integer.parseInt(map.get("pageSize")+"");
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blogMessageMapper.selectAll(map));
    }

    @Override
    public List<BlogMessage> selectByMap(Map<String, Object> map) {
        return blogMessageMapper.selectAll(map);
    }

    @Override
    @Transactional
    public boolean insert(BlogMessage BlogMessage) {
        try {
            if(blogMessageMapper.insert(BlogMessage)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            if(blogMessageMapper.deleteByPrimaryKey(id)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean update(BlogMessage BlogMessage) {
        try {
            if(blogMessageMapper.updateByPrimaryKeySelective(BlogMessage)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }
}
