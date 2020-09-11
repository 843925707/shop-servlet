package com.yqm.shop.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqm.shop.biz.IAddrInfoBiz;
import com.yqm.shop.biz.IOrderInfoBiz;
import com.yqm.shop.biz.impl.AddrInfoBizImpl;
import com.yqm.shop.biz.impl.OrderInfoBizImpl;
import com.yqm.shop.entity.AddrInfo;
import com.yqm.shop.entity.CartInfo;
import com.yqm.shop.entity.MemberInfo;
import com.yqm.shop.util.RequestParamUtil;

@WebServlet("/addr")
public class AddrInfoController extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5470328105257780924L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if("find".equals(op)){
			find(request, response);
		}else if("add".equals(op)) {
			add(request,response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		/*String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String addr = request.getParameter("addr_addr");
		
		IAddrInfoBiz orderInfoBiz = new AddrInfoBizImpl();
		int result = orderInfoBiz.add(name,tel,province,city,area,addr);
		if(result > 0){
			this.send(response, 200, null, null);
			return;
		}
		this.send(response, 500, null, null);*/
		AddrInfo af=RequestParamUtil.getParams(AddrInfo.class, request);
		IAddrInfoBiz addrInfoBiz=new AddrInfoBizImpl();
		String ano = UUID.randomUUID().toString().replace("-", "");
		af.setAno(ano);
		int result=addrInfoBiz.add(af);
		if(result>0) {
			this.send(response, 200,ano,null);
		}else {
			this.send(response, 500, "", null);
		}
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500, "", null);
			return;
		}
		
		MemberInfo mf = (MemberInfo) obj;
		IAddrInfoBiz addrInfoBiz = new AddrInfoBizImpl();
		List<AddrInfo> addrs = addrInfoBiz.finds(String.valueOf(mf.getMno()));
		if(addrs != null && !addrs.isEmpty()){
			this.send(response, 200, null, addrs);
			return;
		}
		this.send(response, 500, null, null);
	}
}
