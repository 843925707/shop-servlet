package com.yqm.shop.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqm.shop.biz.ICartInfoBiz;
import com.yqm.shop.biz.impl.CartInfoBizImpl;
import com.yqm.shop.entity.CartInfo;
import com.yqm.shop.entity.MemberInfo;
import com.yqm.shop.util.RequestParamUtil;


@WebServlet("/cart")
public class CartInfoController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5365529159754433220L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		
		if("info".equals(op)){
			info(request, response);
		}else if("update".equals(op)){
			update(request, response);
		}else if("add".equals(op)){
			add(request, response);
		}else if("find".equals(op)){
			find(request, response);
		}else if("findByCnos".equals(op)){
			findByCnos(request, response);
		}
	}

	private void findByCnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		this.send(response, 200, "", cartInfoBiz.findByCnos(cnos));
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500, "", null);
			return;
		}
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200, "", cartInfoBiz.finds(String.valueOf(mf.getMno())));
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CartInfo cf = RequestParamUtil.getParams(CartInfo.class, request);
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		String cno = UUID.randomUUID().toString().replace("-", "");
		cf.setCno(cno);
		System.out.println(cf);
		int result = cartInfoBiz.add(cf);
		if(result > 0){
			this.send(response, 200, cno, null);
		}else{
			this.send(response, 500, "", null);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		int num = Integer.parseInt(request.getParameter("num"));
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		int result = cartInfoBiz.updateNum(cno, num);
		if(result > 0){
			this.send(response, 200, cno, null);
		}else{
			this.send(response, 500, "", null);
		}
		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500, "", null);
			return;
		}
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200, "", cartInfoBiz.findsCart(String.valueOf(mf.getMno())));
		
	}
}
