package com.ty.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dao.ArticleCatalogMapper;
import com.ty.entity.ArticleCatalog;
import com.ty.service.ArticleCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@Service
public class ArticleCatalogServiceImple implements ArticleCatalogService {
    @Autowired
    ArticleCatalogMapper articleCatalogMapper;
    @Override
    public PageInfo<ArticleCatalog> selectBypage(Map<String, Object> map) {
        int   pageNum=map.get("pageNum")==null?1:Integer.parseInt(map.get("pageNum")+"");
        int   pageSize=map.get("pageSize")==null?5:Integer.parseInt(map.get("pageSize")+"");
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(articleCatalogMapper.selectAll(map));
    }

    @Override
    public List<ArticleCatalog> selectByMap(Map<String, Object> map) {
        return articleCatalogMapper.selectAll(map);
    }

    @Override
    @Transactional
    public boolean insert(ArticleCatalog ArticleCatalog) {
        try {
            if(articleCatalogMapper.insert(ArticleCatalog)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            if(articleCatalogMapper.deleteByPrimaryKey(id)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean update(ArticleCatalog ArticleCatalog) {
        try {
            if(articleCatalogMapper.updateByPrimaryKeySelective(ArticleCatalog)>0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
