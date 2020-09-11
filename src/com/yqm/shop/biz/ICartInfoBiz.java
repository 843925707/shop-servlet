package com.yqm.shop.biz;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.CartInfo;

public interface ICartInfoBiz {

	public List<Map<String, Object>> findsCart(String mno);
	
	public List<CartInfo> finds(String mno);
	
	public int updateNum(String cno, int num);
	
	public int add(CartInfo cf);
	
	public int delete(String cnos);

	public List<CartInfo> findByCnos(String cnos);
}
