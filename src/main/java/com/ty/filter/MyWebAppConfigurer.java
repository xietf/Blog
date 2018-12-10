package com.ty.filter;

import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {



    /** 添加拦截器 **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ComHandler()).addPathPatterns("/**");
                /*.excludePathPatterns("/index")
                .excludePathPatterns("/user");//选择过滤的url请求*/
    }

    //解决跨域问题
    public void addCorsMappings(CorsRegistry registry) {

    }
    //这里配置视图解析器
    public void configureViewResolvers(ViewResolverRegistry registry){

    }
    // 配置内容裁决的一些选项 *
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){

    }
   // 视图跳转控制器 *
   public void addViewControllers(ViewControllerRegistry registry){
       registry.addViewController("/").setViewName("redirect:/index.html");

   };
    // 静态资源处理 *
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/static/images/")
                .addResourceLocations("classpath:/static/images/upload/")
                .addResourceLocations("file:D:/BlogUpload/")
                .addResourceLocations("file:D:/BlogUpload/static/");;
    }
   // 默认静态资源处理器 *
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){

    }

    @Bean
    public FilterRegistrationBean<Filter> getFilter()
    {
        CharacterEncodingFilter cfilter = new CharacterEncodingFilter();
        cfilter.setEncoding("UTF-8");
        cfilter.setForceEncoding(true);
        FilterRegistrationBean rootFilter = new FilterRegistrationBean(cfilter, new ServletRegistrationBean[0]);
        rootFilter.addUrlPatterns(new String[] { "/*" });
        return rootFilter;
    }
}