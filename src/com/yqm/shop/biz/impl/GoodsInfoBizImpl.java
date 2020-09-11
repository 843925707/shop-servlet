package com.yqm.shop.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yqm.shop.biz.IGoodsInfoBiz;
import com.yqm.shop.dao.IGoodsInfoDao;
import com.yqm.shop.dao.IGoodsTypeDao;
import com.yqm.shop.dao.impl.GoodsInfoDaoImpl;
import com.yqm.shop.dao.impl.GoodsTypeDaoImpl;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.util.StringUtil;

public class GoodsInfoBizImpl implements IGoodsInfoBiz{

	@Override
	public List<GoodsInfo> findByPage(int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByPage(page, rows);
	}

	@Override
	public Map<String, Object> finds(int page, int rows) {
		IGoodsInfoDao  goodsInfoDao = new GoodsInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsInfoDao.total());
		map.put("rows", goodsInfoDao.findByPage(page, rows));
		return map;
	}

	@Override
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows) {
		IGoodsInfoDao  goodsInfoDao = new GoodsInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsInfoDao.total(tno, gname));
		map.put("rows", goodsInfoDao.findByCondition(tno, gname, page, rows));
		return map;
	}

	@Override
	public Map<String, Object> findIndex() {
		Map<String, Object> map = new HashMap<String, Object>();
		IGoodsTypeDao typeDao = new GoodsTypeDaoImpl();
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		map.put("types", typeDao.findAll());
		map.put("goods", goodsInfoDao.findIndex());
		return map;
	}

	@Override
	public GoodsInfo findByGno(String gno) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByGno(gno);
	}

	@Override
	public List<GoodsInfo> findByTno(String tno, int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByTno(tno, page, rows);
	}

	@Override
	public Map<String, Object> findByTnos(String tno, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		map.put("total", goodsInfoDao.total(tno));
		map.put("rows", goodsInfoDao.findByTno(tno, page, rows));
		return map;
	}

	@Override
	public int add(GoodsInfo info) {
		if(StringUtil.checkNull(info.getGname(), String.valueOf(info.getTno()),String.valueOf(info.getPrice()),info.getIntro(),String.valueOf(info.getBalance()),info.getPics(),info.getUnit(),info.getQperied(),info.getWeight())){
			return  -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.add(info);
	}

	@Override
	public int update(GoodsInfo info) {
		if(StringUtil.checkNull(info.getGname(), String.valueOf(info.getTno()),String.valueOf(info.getPrice()),info.getIntro(),String.valueOf(info.getBalance()),info.getPics(),info.getUnit(),info.getQperied(),info.getWeight())){
			return  -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.update(info);
	}

	@Override
	public int delete(String gno) {
		if(StringUtil.checkNull(gno)){
			return  -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.delete(gno);
	}

	@Override
	public GoodsInfo find(String gname) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.find(gname);
	}

	@Override
	public GoodsInfo findByTno(String tno) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByTno(tno);
	}

	@Override
	public GoodsInfo findTno(String tno) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findTno(tno);
	}

}
