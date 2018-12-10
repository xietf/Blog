package com.ty.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dao.ShopAdMapper;
import com.ty.entity.ShopAd;
import com.ty.service.ShopAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@Service
public class ShopAdServiceImple implements ShopAdService {
    @Autowired
    ShopAdMapper shopAdMapper;
    @Override
    public PageInfo<ShopAd> selectBypage(Map<String, Object> map) {
        int   pageNum=map.get("pageNum")==null?1:Integer.parseInt(map.get("pageNum")+"");
        int   pageSize=map.get("pageSize")==null?5:Integer.parseInt(map.get("pageSize")+"");
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(shopAdMapper.selectAll(map));
    }

    @Override
    public List<ShopAd> selectByMap(Map<String, Object> map) {
        return shopAdMapper.selectAll(map);
    }

    @Override
    @Transactional
    public boolean insert(ShopAd ShopAd) {
        try {
            if(shopAdMapper.insert(ShopAd)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            if(shopAdMapper.deleteByPrimaryKey(id)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }

    @Override
    @Transactional
    public boolean update(ShopAd ShopAd) {
        try {
            if(shopAdMapper.updateByPrimaryKeySelective(ShopAd)>0){
                return true;
            }
        }catch (Exception e){ }
        return false;
    }
}
