package com.ty.controller;

import com.ty.service.ArticleService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/10.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;
    @RequestMapping("/tologin")
    public String tologin(HttpServletRequest request){
        return "admin/login";
    }
    @RequestMapping("/toindex")
    public String toindex(HttpServletRequest request){
        return "admin/index";
    }
    @RequestMapping("/toueditor")
    public String toueditor(HttpServletRequest request){
        return "admin/ueditor";
    }
    @RequestMapping("/toarticle")
    public String toarticle(String pageNum,String pageSize,HttpServletRequest request){
        Map map=new HashMap();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        articleService.selectByMap(map);
        return "admin/article";
    }


}
