package com.yqm.shop.controller;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.yqm.shop.util.FileUploadUtil;
import com.yqm.shop.util.StringUtil;

public class InitServlet extends HttpServlet{
	private static final long serialVersionUID = 2492946012409030449L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("uploadPath");
		if(StringUtil.checkNull(path)) {
			path="../pics";
		}
		
		String temp= config.getServletContext().getRealPath("/");
		
		File file=new File(temp,path);
		if(!file.exists()) {
			file.mkdirs();
		}
		FileUploadUtil.PATH=path;
	}
}
