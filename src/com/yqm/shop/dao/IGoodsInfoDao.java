package com.yqm.shop.dao;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.GoodsInfo;

public interface IGoodsInfoDao {

	public List<GoodsInfo> findByPage(int page, int rows);
	public int total();
	public int total(String tno, String gname);
	public List<GoodsInfo> findByCondition(String tno, String gname, int page, int rows);
	public List<GoodsInfo> findIndex();
	
	public GoodsInfo findByGno(String gno);
	public List<GoodsInfo> findByTno(String tno, int page, int rows);
	public int total(String tno);
	public int add(GoodsInfo info);
	public int update(GoodsInfo info);
	public int delete(String gno);
	public GoodsInfo find(String gname);
	public GoodsInfo findByTno(String tno);
	public GoodsInfo findTno(String tno);
}
