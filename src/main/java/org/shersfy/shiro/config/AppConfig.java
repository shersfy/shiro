package org.shersfy.shiro.config;

import javax.servlet.Filter;

import org.shersfy.shiro.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilter(){
		LoginFilter filter = new LoginFilter();
		FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>();
		
		bean.setOrder(1);
		bean.setFilter(filter);
		bean.setName("loginFilter");
		bean.addUrlPatterns("/*");
		
		addInitParameters(bean);
		return bean;
	}
	
	private void addInitParameters(FilterRegistrationBean<? extends Filter> bean) {
		
	}
}
