package com.yqm.shop.dao;

import com.yqm.shop.entity.AdminInfo;

public interface IAdminInfoDao {

	public AdminInfo login(String aname,String pwd);

	public int update(AdminInfo af);

	public AdminInfo findAll();

	public int pwdUpdate(String aname, String newpwd);
}
