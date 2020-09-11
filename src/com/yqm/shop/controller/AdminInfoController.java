package com.yqm.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yqm.shop.biz.IAdminInfoBiz;
import com.yqm.shop.biz.impl.AdminInfoBizImpl;
import com.yqm.shop.entity.AdminInfo;
import com.yqm.shop.entity.GoodsType;
import com.yqm.shop.util.RequestParamUtil;
import com.yqm.shop.util.SessionKey;
import com.yqm.shop.util.ObjectUtil;

@WebServlet("/admin")
public class AdminInfoController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3933654788891134284L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if("findAll".equals(op)) {
			findAll(request,response);
		}else if("login".equals(op)){
			login(request,response);
		}else if("info".equals(op)){
			info(request,response);
		}else if("update".equals(op)) {
			update(request,response);
		}else if("pwdUpdate".equals(op)) {
			pwdUpdate(request,response);
		}
	}

	private void pwdUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub	
		
		String aname = request.getParameter("aname");
		String apwd = request.getParameter("apwd");
		String pwd = request.getParameter("pwd");
		String newpwd = request.getParameter("newpwd");
	
		if(!pwd.equals(apwd)){
			this.send(response, 500, "", null);
			return;
		}
		
		IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
		adminInfoBiz.pwdUpdate(aname, newpwd);
		if(adminInfoBiz.pwdUpdate(aname, newpwd) == -1){
			this.send(response, 501, "", null);
			return;
		}
		this.send(response, 200, "", null);
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();
		Object obj = session.getAttribute(SessionKey.CURRENTLOGINADMIN);
		AdminInfo admin=(AdminInfo) obj;
		String ad=admin.getAname();*/
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		this.send(response, adminInfoBiz.findAll());
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		AdminInfo af = RequestParamUtil.getParams(AdminInfo.class, request);
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		this.send(response, adminInfoBiz.update(af));
		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(SessionKey.CURRENTLOGINADMIN);
		this.send(response, obj);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String aname = request.getParameter("aname");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
		AdminInfo af = adminInfoBiz.login(aname, pwd);
		if(af == null){
			this.send(response, 501, "", null);
			return;
		}
		
		session.setAttribute("currentLoginAdmin", af);
		this.send(response, 200, "", null);
	}
	   
}
