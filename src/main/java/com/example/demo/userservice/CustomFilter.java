package com.example.demo.userservice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest requestHttp = (HttpServletRequest) request;
		  HttpServletResponse responseHttp = (HttpServletResponse) response;

		  logger.info("CustomFilter Logging Request  {} : {}", requestHttp.getMethod(), requestHttp.getRequestURI());

		  //call next filter in the filter chain
		  chain.doFilter(request, response);

		  logger.info("CustomFilter Logging Response :{}", responseHttp.getContentType());
	}

}
