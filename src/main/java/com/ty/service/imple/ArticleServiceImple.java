package com.ty.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dao.ArticleMapper;
import com.ty.entity.Article;
import com.ty.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@Service
public class ArticleServiceImple implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public PageInfo<Article> selectBypage(Map<String, Object> map) {
        int   pageNum=map.get("pageNum")==null?1:Integer.parseInt(map.get("pageNum")+"");
        int   pageSize=map.get("pageSize")==null?5:Integer.parseInt(map.get("pageSize")+"");
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(articleMapper.selectAll(map));
    }

    @Override
    public List<Article> selectByMap(Map<String, Object> map) {
        return articleMapper.selectAll(map);
    }

    @Override
    @Transactional
    public boolean insert(Article Article) {
        try {
            if(articleMapper.insert(Article)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            if(articleMapper.deleteByPrimaryKey(id)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Article Article) {
        try {
            if(articleMapper.updateByPrimaryKeySelective(Article)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }
}
