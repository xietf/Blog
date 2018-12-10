package com.ty.controller;

import com.ty.Util.FileUtils;
import com.ty.entity.User;
import com.ty.service.UserService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27.
 */
@RestController
public class LoginController extends BaseController<UserService>{
    @RequestMapping("/login")
    public Map login(String username, String password, HttpSession session, ModelMap modelMap){
        Map<String,Object>map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        Map<String,Object>resultmap=new HashMap<>();
        List<User> list =baseService.selectByMap(map);
        try{
            session.setAttribute("user",list.get(0));
        }catch (Exception e){
            resultmap.put("msg","登录失败！");
            resultmap.put("status","0");
            return resultmap;
        }
        resultmap.put("user",list.get(0));
        resultmap.put("msg","登录成功！");
        resultmap.put("status","1");
        return resultmap;
    }
    @RequestMapping("/clean")
    public String  clean( HttpSession session){
        session.removeAttribute("user");
        return "";
    }

    @RequestMapping("/register")
    public Map register(User user, HttpSession session){
        Map<String,Object>resultmap=new HashMap<>();
        user.setCreateTime(new Date());
        user.setStatus(1);
        Boolean count = false;
        try{
            count=baseService.insert(user);
        }catch (Exception e){}
        if(count){
            resultmap.put("msg","注册成功！");
            resultmap.put("status","1");
        }else{
            resultmap.put("msg","注册失败！");
            resultmap.put("status","0");
        }
        return resultmap;
    }
    @RequestMapping("/toFile")
    public Map<String,Object> toFile(@RequestParam("fileImg") MultipartFile file, HttpSession  session) throws IllegalStateException, IOException {
        //获取上传文件名字
        String filename= file.getOriginalFilename();
        String newFileName=new Date().getTime()+filename.substring(filename.lastIndexOf("."));
        //上传部署后的目录中 getRealPath()
      // String basePath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\upload\\";//user.dir指定了当前项目的路径
        String basePath=session.getServletContext().getRealPath("/static/images/upload/");
        File baseFile=new File(basePath);
        if(!baseFile.exists()) {//判断是否存在
            baseFile.mkdirs(); //创建文件夹
        }
        String savePath=basePath+newFileName;
        System.out.println(savePath);
        //transferTo 写出文件
        file.transferTo(new File(savePath));
        System.out.println("1");
        Map<String,Object> map=new HashMap<>();
        map.put("url",newFileName);
        return map;
    }
    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("/fileUpload")
    public Map fileUpload(@RequestParam("fileImg") MultipartFile file){
        Map<String, Object> map=new HashMap<>();
        // 要上传的目标文件存放路径
        String localPath = "D:/BlogUpload/";
        // 上传成功或者失败的提示
        String msg = "";

        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";
        }
        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        return map;
    }
}
