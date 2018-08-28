package com.computech.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.computech.interceptor.LoginInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		/*InterceptorRegistration re = registry.addInterceptor(new LoginInterceptor());
        re.addPathPatterns("/**");
        re.excludePathPatterns("/login","/login/getKey");*/
    }
}
