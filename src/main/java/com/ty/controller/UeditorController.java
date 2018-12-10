package com.ty.controller;
        import com.baidu.ueditor.ActionEnter;
        import com.ty.config.DiyActionEnter;
        import org.json.JSONException;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@RestController
@RequestMapping("/ueditor")
public class UeditorController {
    @RequestMapping("/ueditorConfig")
    public void getUEditorConfig(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("application/json");
        String rootPath ="D:\\BlogUpload\\";
        try {
            String exec = new DiyActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}