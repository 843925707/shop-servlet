package com.yqm.shop.biz.impl;

import java.util.List;
import java.util.Map;

import com.yqm.shop.biz.IOrderInfoBiz;
import com.yqm.shop.dao.IOrderInfoDao;
import com.yqm.shop.dao.impl.OrderInfoDaoImpl;
import com.yqm.shop.entity.OrderInfo;
import com.yqm.shop.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz{

	@Override
	public int add(String cnos, double totalPrice, String ano) {
		if(StringUtil.checkNull(cnos, ano)){
			return -1;
		}
		
		IOrderInfoDao  orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, totalPrice, ano);
	}

	@Override
	public List<Map<String, String>> find(Integer mno) {
		IOrderInfoDao  orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.find(mno);
	}

	@Override
	public List<Map<String, String>> findAll(int page, int rows) {
		IOrderInfoDao  orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.findAll(page, rows);
	}

	@Override
	public int delete(String ino) {
		IOrderInfoDao  orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.delete(ino);
	}

	@Override
	public int update(OrderInfo order) {
		IOrderInfoDao  orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.update(order);
	}

	
}
