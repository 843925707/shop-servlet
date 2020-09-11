package com.yqm.shop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yqm.shop.biz.IGoodsPageBiz;
import com.yqm.shop.biz.impl.GoodsPageBizImpl;
import com.yqm.shop.dao.IGoodsPageDao;
import com.yqm.shop.dao.impl.GoodsPageDaoImpl;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.entity.GoodsType;


@WebServlet("/page")
public class GoodsPageController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894424813376279421L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
		
		if("findsPage".equals(op)){
			findsPage(request, response);
		}else if("findByPage".equals(op)){
			findByPage(request, response);
		}else if("findByCondition".equals(op)){
			findByCondition(request, response);
		}else if("findByPage2".equals(op)){
			findByPage2(request, response);
		}
	}


	private void findByPage2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");

		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		
		goodsPageDao.findByCondition(tno, gname, page, rows);
		this.send(response, goodsPageDao.findByCondition(tno, gname, page, rows));
		
	}


	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");

		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		
		int total = goodsPageDao.Total(tno, gname);
		
		
		goodsPageDao.findByCondition(tno, gname, page, rows);
		this.send(response,total, goodsPageDao.findByCondition(tno, gname, page, rows));
	}


	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		
		
		List<Map<String, String>> list = goodsPageDao.findByPage(page, rows);
		
		this.send(response, list);
		
		
	}


	private void findsPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		
		int total = goodsPageDao.getTotal();
		
		List<Map<String, String>> list = goodsPageDao.findByPage(page, rows);
		
		this.send(response, total, list);
		
	}
	
	
}
