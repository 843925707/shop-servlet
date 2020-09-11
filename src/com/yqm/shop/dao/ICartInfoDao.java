package com.yqm.shop.dao;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.CartInfo;

public interface ICartInfoDao {

	public List<Map<String, Object>> findCart(String mno);
	
	public List<CartInfo> finds(String mno);
	
	public int updateNum(String cno, int num);
	
	public int add(CartInfo of);
	
	public int delete(String cnos);
	
	public int delete(String[] cnos);

	public List<CartInfo> findByCnos(String[] temp);
	
	
}
