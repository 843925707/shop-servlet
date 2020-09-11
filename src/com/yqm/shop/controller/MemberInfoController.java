package com.yqm.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqm.shop.biz.IAdminInfoBiz;
import com.yqm.shop.biz.IMemberInfoBiz;
import com.yqm.shop.biz.impl.AdminInfoBizImpl;
import com.yqm.shop.biz.impl.MemberInfoBizImpl;
import com.yqm.shop.entity.AdminInfo;
import com.yqm.shop.entity.MemberInfo;
import com.yqm.shop.util.RequestParamUtil;

@WebServlet("/member")
public class MemberInfoController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5365529159754433220L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		
		if("login".equals(op)){
			login(request,response);
		}else if("info".equals(op)){
			info(request, response);
		}else if("findAll".equals(op)) {
			findAll(request,response);
		}else if("update".equals(op)) {
			update(request,response);
		}else if("add".equals(op)) {
			add(request,response);
		}else if("pwdUpdate".equals(op)) {
			pwdUpdate(request,response);
		}
	}

	private void pwdUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String nickname = request.getParameter("nickname");
		String apwd = request.getParameter("apwd");
		String pwd = request.getParameter("pwd");
		String newpwd = request.getParameter("newpwd");
		if(!pwd.equals(apwd)){
			this.send(response, 500, "", null);
			return;
		}
		
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		memberInfoBiz.pwdUpdate(nickname, newpwd);
		if(memberInfoBiz.pwdUpdate(nickname, newpwd) == -1){
			this.send(response, 501, "", null);
			return;
		}
		this.send(response, 200, "", null);
	
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String nickname = request.getParameter("nickname");
		String cpwd = request.getParameter("cpwd");
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		HttpSession session = request.getSession();
		String vcode = String.valueOf(session.getAttribute("validatecode"));
		if(!code.equals(vcode)){
			this.send(response, 500, "", null);
			return;
		}
		if(!pwd.equals(cpwd)){
			this.send(response, 500, "", null);
			return;
		}
		
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		memberInfoBiz.add(nickname, pwd,tel,email);
		if(memberInfoBiz.add(nickname, pwd,tel,email) == -1){
			this.send(response, 501, "", null);
			return;
		}
		this.send(response, 200, "", null);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		MemberInfo mf=RequestParamUtil.getParams(MemberInfo.class, request);
		IMemberInfoBiz memberInfoBiz=new MemberInfoBizImpl();
		this.send(response,memberInfoBiz.update(mf));
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//int page = Integer.parseInt(request.getParameter("page"));
		//int rows = Integer.parseInt(request.getParameter("rows"));
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		this.send(response, memberInfoBiz.findAll());
		System.out.println(memberInfoBiz.findAll());
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500, "", null);   //说明没有登录
			return;
		}
		this.send(response, 200, "", obj);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nickName = request.getParameter("nickName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String vcode = String.valueOf(session.getAttribute("validatecode"));
		if(!code.equals(vcode)){
			this.send(response, 500, "", null); //说明验证码错误
			return;
		}
		
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		MemberInfo memberInfo = memberInfoBiz.login(nickName, pwd);
		if(memberInfo == null){
			this.send(response, 501, "", null);  //说明账号或密码错误
			return;
		}
		
		//存到session
		session.setAttribute("currentLoginMember", memberInfo);
		this.send(response, 200, "", null);
		
	}
}
