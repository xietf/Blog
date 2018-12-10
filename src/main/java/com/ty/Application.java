package com.ty;


import com.ty.filter.ComFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableTransactionManagement
//dao层mapper文件扫描注解
@MapperScan("com.ty.dao")
//servlet扫描注解
@ServletComponentScan(basePackages="com.ty.servlet")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	@Bean
	public FilterRegistrationBean getFilterBean() {
		FilterRegistrationBean bean=new FilterRegistrationBean(new ComFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
	@Bean
	public FilterRegistrationBean<Filter> getFilter(){
		CharacterEncodingFilter cfilter=new CharacterEncodingFilter();
		cfilter.setEncoding("UTF-8");
		cfilter.setForceEncoding(true);
		FilterRegistrationBean<Filter> rootFilter=new FilterRegistrationBean<>(cfilter);
		rootFilter.addUrlPatterns("/*");
		return rootFilter;
	}
}
