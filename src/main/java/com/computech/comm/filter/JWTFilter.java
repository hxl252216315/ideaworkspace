package com.computech.comm.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.util.StringUtils;
import com.computech.comm.jwt.JWTToken;

public class JWTFilter extends BasicHttpAuthenticationFilter {
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (null != getSubject(request, response) 
                && getSubject(request, response).isAuthenticated()) {
            return true;
        }
        return false;
	}
	
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(isJwtSubmission(request)){
            AuthenticationToken token = createToken(request, response);
            try {
                Subject subject = getSubject(request, response);
                subject.login(token);
                return true;
            } catch (AuthenticationException e) {
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
                return false;
            } 
        }else{
			WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED,"认证失败");
			return false;
		}
    }
	
	protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse response) {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		String jwt = request.getHeader("Authorization");
        return new JWTToken(jwt);
    }
	
	
	protected boolean isJwtSubmission(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
        String jwt = request.getHeader("Authorization");
        return (request instanceof HttpServletRequest)
                                && !StringUtils.isEmpty(jwt);
    }

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				httpServletRequest.getHeader("Access-Control-Request-Headers"));
		// 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
		if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			httpServletResponse.setStatus(HttpStatus.OK.value());
			return false;
		}
		return super.preHandle(request, response);
	}
}
