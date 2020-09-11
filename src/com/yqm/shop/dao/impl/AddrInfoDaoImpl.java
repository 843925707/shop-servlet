package com.yqm.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IAddrInfoDao;
import com.yqm.shop.entity.AddrInfo;

public class AddrInfoDaoImpl implements IAddrInfoDao{

	@Override
	public List<AddrInfo> finds(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select ano, mno, name, tel, province, city, area, addr, flag from addrinfo where status !=0 and mno=?";
		return db.finds(AddrInfo.class, sql, mno);
	}

	@Override
	public int add(AddrInfo af) {
		DBHelper db = new DBHelper();
		String sql="insert into addrinfo value(?,?,?,?,?,?,?,?,1,1)";
		return db.update(sql,af.getAno(), af.getMno(),af.getName(),af.getTel(),af.getProvince(),af.getCity(),af.getArea(),af.getAddr());
	}


	

}
