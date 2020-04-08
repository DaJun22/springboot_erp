package com.dj.springboot_erp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "paramterFilter",urlPatterns = "/**")
public class ParamterFilter implements Filter {

	private final static Logger Log=LoggerFactory.getLogger(ParamterFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Log.debug("过滤器处理");
		HttpServletRequest httprequest =(HttpServletRequest) request;
		HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httprequest) {

			@Override
			public String getParameter(String name) {
				String value = httprequest.getParameter(name);
				if(value != null || value != "") {
					return value.replace("fuck", "***");
				}
				return super.getParameter(name);
			}

			/**
			 * 过滤通过 @RequestParam的获取参数
			 */
			@Override
			public String[] getParameterValues(String name) {
				String[] values = httprequest.getParameterValues(name);
				if(values!=null && values.length>0) {
					values[0] = values[0].replace("fuck", "***");
					return values;
				}
				return super.getParameterValues(name);
			}
		
		};
		chain.doFilter(requestWrapper, response);
	}

}
