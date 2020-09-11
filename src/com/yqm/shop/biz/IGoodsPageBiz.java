package com.yqm.shop.biz;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.entity.GoodsType;

public interface IGoodsPageBiz {
	public List<Map<String, String>> findByPage(int page, int rows); 
	
	public Map<String, Object> findsPage(int page, int rows);
	
	public List<GoodsInfo> findByPage2(int page, int rows,String tno,String gname);
	
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows);
}
