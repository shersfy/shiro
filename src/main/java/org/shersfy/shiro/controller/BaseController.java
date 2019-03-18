package org.shersfy.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shersfy.shiro.commons.beans.Result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	protected static final int SUCESS = ResultCode.SUCESS;
	protected static final int FAIL	  = ResultCode.FAIL;

	private static ThreadLocal<HttpServletRequest> THREAD_LOCAL_REQUEST = new ThreadLocal<>();
	private static ThreadLocal<HttpServletResponse> THREAD_LOCAL_RESPONSE = new ThreadLocal<>();

	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
		THREAD_LOCAL_REQUEST.set(request);
		THREAD_LOCAL_RESPONSE.set(response);
		setBasePath(request, response);
	}

	public HttpServletRequest getRequest() {
		return THREAD_LOCAL_REQUEST.get();
	}

	public HttpServletResponse getResponse() {
		return THREAD_LOCAL_RESPONSE.get();
	}

	public String getRemoteAddr() {
		String remoteAddr = getRequest().getRemoteAddr();
		remoteAddr = "0:0:0:0:0:0:0:1".equals(remoteAddr)?"127.0.0.1":remoteAddr;
		return remoteAddr;
	}
	public String getRemoteHost() {
		String remoteAddr = getRequest().getRemoteHost();
		remoteAddr = "0:0:0:0:0:0:0:1".equals(remoteAddr)?"localhost":remoteAddr;
		return remoteAddr;
	}
	
	protected void setBasePath(HttpServletRequest request, HttpServletResponse res) {
		
		res.setCharacterEncoding("UTF-8");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		res.setHeader("Access-Control-Allow-Headers", "*");
		
		StringBuilder basePath = new StringBuilder(0);
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName());
		if(request.getServerPort() != 80 && request.getServerPort() != 443){
			basePath.append(":").append(request.getServerPort());
		}
		basePath.append(request.getContextPath());
		request.setAttribute("basePath", basePath.toString());
	}
	
}