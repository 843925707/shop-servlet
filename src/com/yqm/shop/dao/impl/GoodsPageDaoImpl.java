package com.yqm.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IGoodsPageDao;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.util.StringUtil;
import com.yqm.shop.entity.GoodsType;


public class GoodsPageDaoImpl implements IGoodsPageDao{

	@Override
	public  List<Map<String, String>> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = " select gno, g.tno, tname, gname, price, pics,balance,unit, intro, weight, qperied from goodsinfo g, goodstype t where g.tno=t.tno order by gno asc limit ?,?";
		return db.gets(sql, (page - 1) * rows, rows);
	}

	@Override
	public Map<String, Object> findsPage(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsInfo> findByPage2(int page, int rows, String tno, String gname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Total(String tno, String gname) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
	

	
}
