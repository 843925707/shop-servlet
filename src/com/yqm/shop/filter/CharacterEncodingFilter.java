package com.yqm.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yqm.shop.util.StringUtil;

@WebFilter(filterName = "CharacterEncodingFilter",value = "/*",initParams = @WebInitParam(name="encoding",value="utf-8"))
public  class CharacterEncodingFilter implements Filter{

private String encoding = "utf-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String temp = filterConfig.getInitParameter("encoding");
		if(!StringUtil.checkNull(temp)){
			encoding = temp;
		}
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resq, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resq;
	
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
