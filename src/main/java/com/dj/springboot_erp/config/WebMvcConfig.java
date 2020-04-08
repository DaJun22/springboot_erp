package com.dj.springboot_erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dj.springboot_erp.filter.ParamterFilter;
import com.dj.springboot_erp.interceptor.UriInterceptor;


@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private UriInterceptor uriInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(uriInterceptor).addPathPatterns("/**");
	}

	@Bean
	public FilterRegistrationBean<ParamterFilter> filterRegister() {
		FilterRegistrationBean<ParamterFilter> bean = new FilterRegistrationBean<ParamterFilter>();
		bean.setFilter(new ParamterFilter());
		return bean;
	}
}
