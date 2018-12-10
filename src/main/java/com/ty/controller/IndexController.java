package com.ty.controller;

import com.ty.entity.Article;
import com.ty.entity.BlogMessage;
import com.ty.service.ArticleService;
import com.ty.service.BlogMessageService;
import com.ty.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/4.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    BlogMessageService blogMessageService;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/toindex")
    public String toindex(HttpServletRequest request){
        request.setAttribute("pageInfo",articleService.selectBypage(new HashMap<>()));
        return "index";
    }
    @RequestMapping("/toarticleDetail")
    public String toarticleDetail(int id,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        List<Article> articlelist=articleService.selectByMap(map);
        try {
            Article article=articlelist.get(0);
            article.setCountClick(article.getCountClick()+1);
            request.setAttribute("article",article);
            articleService.update(article);
        }catch (Exception e){
            return "404";
        }
        return "articleDetail";
    }
    @RequestMapping("/tomessage")
    public String tomessage(HttpServletRequest request){
        return "message";
    }
    @RequestMapping("/message")
    public String message(HttpServletRequest request, BlogMessage message){
        boolean boo=blogMessageService.insert(message);
        if(boo){
            return "留言成功";
        }
        return "留言失败";
    }
    @RequestMapping("/tolifelistpic")
    public String tolifelistpic(String pageNum,String pageSize,HttpServletRequest request){
        request.setAttribute("pageInfo",articleService.selectBypage(getmap(pageNum,pageSize,1)));
        return "newslistpic";
    }
    @RequestMapping("/tostudylistpic")
    public String tostudylistpic(String pageNum,String pageSize,HttpServletRequest request){
        request.setAttribute("pageInfo",articleService.selectBypage(getmap(pageNum,pageSize,2)));
        return "newslistpic";
    }
    @RequestMapping("/toskilllistpic")
    public String toskilllistpic(String pageNum,String pageSize,HttpServletRequest request){
        request.setAttribute("pageInfo",articleService.selectBypage(getmap(pageNum,pageSize,3)));
        return "newslistpic";
    }
    Map<String,Object> getmap(String pageNum,String pageSize,int catalogId){
        Map<String,Object> map=new HashMap<>();
        map.put("catalogId",catalogId);
        map.put("pageNum",pageNum);
        pageSize=pageSize==null?3+"":pageSize;
        map.put("pageSize",pageSize);
        return map;
    }
    @RequestMapping("/toabout")
    public String toabout(HttpServletRequest request){
        return "about";
    }
    @RequestMapping("/to404")
    public String to404(HttpServletRequest request){
        return "404";
    }
}
