package com.ssafy.ssafit.model.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ssafit.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	private final String HEADER_AUTH = "Authorization";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
		String token = request.getHeader(HEADER_AUTH);
		System.out.println(token);
		if(token != null) {
			jwtUtil.validate(token);
			return true;
		}
		
		throw new Exception("유효하지 않은 접근");
	}
}
