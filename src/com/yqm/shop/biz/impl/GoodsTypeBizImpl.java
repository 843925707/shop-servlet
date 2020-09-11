package com.yqm.shop.biz.impl;

import java.util.List;

import com.yqm.shop.biz.IGoodsTypeBiz;
import com.yqm.shop.dao.IGoodsTypeDao;
import com.yqm.shop.dao.impl.GoodsTypeDaoImpl;
import com.yqm.shop.entity.GoodsType;
import com.yqm.shop.util.StringUtil;

public class GoodsTypeBizImpl implements IGoodsTypeBiz{

	@Override
	public List<GoodsType> findAll() {
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.findAll();
	}

	@Override
	public int update(GoodsType type) {
		if(StringUtil.checkNull(type.getTname(), type.getPic())){
			return  -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.update(type);
	}

	@Override
	public int add(GoodsType type) {
		if(StringUtil.checkNull(type.getTname(), type.getPic())){
			return  -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.add(type);
	}

	@Override
	public int delete(String tno) {
		if(StringUtil.checkNull(tno)){
			return -1;
		}
		
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.delete(tno);
	}


}
