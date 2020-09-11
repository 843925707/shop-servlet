package com.yqm.shop.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yqm.shop.biz.IGoodsPageBiz;
import com.yqm.shop.dao.IGoodsInfoDao;
import com.yqm.shop.dao.IGoodsPageDao;
import com.yqm.shop.dao.impl.GoodsInfoDaoImpl;
import com.yqm.shop.dao.impl.GoodsPageDaoImpl;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.entity.GoodsType;

public class GoodsPageBizImpl implements IGoodsPageBiz{

	@Override
	public List<Map<String, String>> findByPage(int page, int rows) {
		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		return goodsPageDao.findByPage(page, rows);
	}

	@Override
	public Map<String, Object> findsPage(int page, int rows) {
		IGoodsPageDao  goodsPageDao = new GoodsPageDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsPageDao.getTotal());
		map.put("rows", goodsPageDao.findByPage(page, rows));
		return map;
	}

	@Override
	public List<GoodsInfo> findByPage2(int page, int rows, String tno, String gname) {
		IGoodsPageDao goodsPageDao = new GoodsPageDaoImpl();
		return goodsPageDao.findByPage2(page, rows,tno,gname);
	}

	@Override
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows) {
		IGoodsPageDao  goodsInfoDao = new GoodsPageDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsInfoDao.Total(tno, gname));
		map.put("rows", goodsInfoDao.findByCondition(tno, gname, page, rows));
		return map;
	}

}
