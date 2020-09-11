package com.yqm.shop.dao;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.GoodsInfo;

public interface IGoodsPageDao {

	public List<Map<String, String>> findByPage(int page, int rows);

	public Map<String, Object> findsPage(int page, int rows);
	
	public List<GoodsInfo> findByPage2(int page, int rows,String tno,String gname);
	
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows);

	public int getTotal();

	public int Total(String tno, String gname);

	

}
