package com.yqm.shop.biz;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.entity.GoodsType;

public interface IGoodsInfoBiz {

	public List<GoodsInfo> findByPage(int page, int rows);
	public Map<String, Object> finds(int page, int rows);
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows);

	public Map<String, Object> findIndex();
	
	public GoodsInfo findByGno(String gno);
	public List<GoodsInfo> findByTno(String tno, int page, int rows);
	public Map<String, Object> findByTnos(String tno, int page, int rows);
	
	public int add(GoodsInfo info);
	public int update(GoodsInfo info);
	public int delete(String gno);
	public GoodsInfo find(String gname);
	public GoodsInfo findByTno(String tno);
	public GoodsInfo findTno(String tno);
}
