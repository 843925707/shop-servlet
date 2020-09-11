package com.yqm.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yqm.shop.biz.IGoodsTypeBiz;
import com.yqm.shop.biz.impl.GoodsTypeBizImpl;
import com.yqm.shop.entity.GoodsType;
import com.yqm.shop.util.RequestParamUtil;

@WebServlet("/type")
public class GoodsTypeController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6705111358932684212L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if("findAll".equals(op)){
			findAll(request, response);
		}else if("add".equals(op)){
			add(request, response);
		}else if("update".equals(op)){
			update(request, response);
		}else if("delete".equals(op)){
			delete(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
		this.send(response, goodsTypeBiz.delete(tno));
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GoodsType type = RequestParamUtil.getParams(GoodsType.class, request);
		IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
		this.send(response, goodsTypeBiz.update(type));
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GoodsType type = RequestParamUtil.getParams(GoodsType.class, request);
		IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
		this.send(response, goodsTypeBiz.add(type));
		
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
		this.send(response, goodsTypeBiz.findAll());
	}
}
