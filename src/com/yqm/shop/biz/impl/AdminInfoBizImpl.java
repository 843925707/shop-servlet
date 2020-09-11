package com.yqm.shop.biz.impl;

import com.yqm.shop.biz.IAdminInfoBiz;
import com.yqm.shop.dao.IAdminInfoDao;
import com.yqm.shop.dao.impl.AdminInfoDaoImpl;
import com.yqm.shop.entity.AdminInfo;
import com.yqm.shop.util.StringUtil;

public class AdminInfoBizImpl implements IAdminInfoBiz{

	

	@Override
	public int update(AdminInfo af) {
		// TODO Auto-generated method stub
		if(StringUtil.checkNull(af.getAname(),af.getPwd())){
			return -1;
		}
		IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		return adminInfoDao.update(af);		
	}

	@Override
	public AdminInfo login(String aname, String pwd) {
		if(StringUtil.checkNull(aname,pwd)){
			return null;
		}
		IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		return adminInfoDao.login(aname,pwd);
	}

	@Override
	public AdminInfo findAll() {
		IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		return adminInfoDao.findAll();
	}

	@Override
	public int pwdUpdate(String aname, String newpwd) {
		if(StringUtil.checkNull(aname,newpwd)){
			return -1;
		}
		IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		return adminInfoDao.pwdUpdate(aname,newpwd);
	}

	
}
