package com.yqm.shop.biz;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.OrderInfo;
import com.yqm.shop.entity.OrderItemInfo;

public interface IOrderInfoBiz {
	public int add(String cnos, double totalPrice, String ano);

	public List<Map<String, String>> find(Integer mno);

	public List<Map<String, String>> findAll( int page, int rows);

	public int delete(String ino);

	public int update(OrderInfo order);
}
