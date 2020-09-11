package com.yqm.shop.listener;

import java.io.File;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yqm.shop.util.FileUploadUtil;
import com.yqm.shop.util.StringUtil;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	
    @Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		String path = application.getInitParameter("uploadPath");
		if(StringUtil.checkNull(path)){
			path = "../pics";
		}
		File file = new File(application.getRealPath(""),path);
		if(!file.exists()){
			file.mkdirs();
		}
		
		FileUploadUtil.PATH = path;
	}
}
