package com.yqm.shop.biz;

import com.yqm.shop.entity.AdminInfo;

public interface IAdminInfoBiz {

	public int update(AdminInfo af);

	public AdminInfo login(String aname, String pwd);

	public AdminInfo findAll();

	public int pwdUpdate(String aname, String newpwd);
}
