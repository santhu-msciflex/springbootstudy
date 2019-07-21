package com.example.demo.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[ LogInterceptor.preHandle() ]");
		String x = request.getMethod();
		logger.info(x + " intercepted");
		logger.info("Request info, {}", request);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[ LogInterceptor.postHandle() ]");
		int x = response.getStatus();
		logger.info(x + " response status code");
		logger.info("Response info, {}", response);
	}
	
	

}
