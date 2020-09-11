package com.yqm.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yqm.shop.biz.IGoodsInfoBiz;
import com.yqm.shop.biz.IGoodsTypeBiz;
import com.yqm.shop.biz.impl.GoodsInfoBizImpl;
import com.yqm.shop.biz.impl.GoodsTypeBizImpl;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.entity.GoodsType;
import com.yqm.shop.util.FileUploadUtil;
import com.yqm.shop.util.RequestParamUtil;

@WebServlet("/goods")
public class GoodsInfoController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894424813376279421L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
		
		if("finds".equals(op)){
			finds(request, response);
		}else if("findByPage".equals(op)){
			findByPage(request, response);
		}else if("findByCondition".equals(op)){
			findByCondition(request, response);
		}else if("findIndex".equals(op)){
			findIndex(request,response);
		}else if("findByGno".equals(op)){
			findByGno(request, response);
		}else if("findByTnos".equals(op)){
			findByTnos(request, response);
		}else if("findByTno".equals(op)){
			findByTno(request, response);
		}else if("add".equals(op)) {
			add(request,response);
		}else if("update".equals(op)) {
			update(request,response);
		}else if("delete".equals(op)) {
			delete(request,response);
		}else if("find".equals(op)) {
			find(request,response);
		}else if("findTno".equals(op)) {
			findTno(request,response);
		}
	}

	private void findTno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String tno = request.getParameter("tno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findTno(tno));
		System.out.println(goodsInfoBiz.findTno(tno));
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String gname = request.getParameter("gname");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.find(gname));
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String gno = request.getParameter("gno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.delete(gno));
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		GoodsInfo info = RequestParamUtil.getParams(GoodsInfo.class, request);
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.update(info));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		int result = -1;
		
		try {
			GoodsInfo info = fuu.upload(GoodsInfo.class,pagecontext);
			IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
			result=goodsInfoBiz.add(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.send(response, result);
	}

	private void findByTno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByTno(tno, page, rows));
	}

	private void findByTnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByTnos(tno, page, rows));
		
	}

	private void findByGno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gno= request.getParameter("gno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByGno(gno));
		System.out.println(goodsInfoBiz.findByGno(gno));
	}

	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findIndex());
		
	}

	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByCondition(tno, gname, page, rows));
		
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.finds(page, rows));
		
	}
	
	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByPage(page, rows));
	}

	
}
