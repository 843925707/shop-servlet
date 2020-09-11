package com.yqm.shop.dao;

import java.util.List;

import com.yqm.shop.entity.MemberInfo;

public interface IMemberInfoDao {

	public MemberInfo login(String nickName, String pwd);

	public List<MemberInfo> findAll();

	public int update(MemberInfo mf);

	public List<MemberInfo> findByPage(int page, int rows);

	public int add(String nickname, String pwd, String tel, String email);

	public int pwdUpdate(String nickname, String newpwd);
}
