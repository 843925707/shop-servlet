package com.yqm.shop.dao.impl;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IAdminInfoDao;
import com.yqm.shop.entity.AdminInfo;

public class AdminInfoDaoImpl implements IAdminInfoDao{

	@Override
	public int update(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql="update admininfo set pwd=? where aname=? and aid=?";
		return db.update(sql,af.getPwd(),af.getAname(),af.getAid());
	}

	@Override
	public AdminInfo login(String aname, String pwd) {
		DBHelper db = new DBHelper();
		String sql="select aname,pwd from admininfo where aname=? and pwd=?  ";
		return db.find(AdminInfo.class,sql,aname,pwd);
		
	}

	@Override
	public AdminInfo findAll() {
		DBHelper db = new DBHelper();
		String sql="select aid,aname,pwd,level,email,tel,status from admininfo ";
		return db.find(AdminInfo.class,sql);
	}

	@Override
	public int pwdUpdate(String aname, String newpwd) {
		DBHelper db = new DBHelper();
		String sql="update admininfo set pwd=? where aname=?";
		return db.update(sql, newpwd,aname);
	}

}
