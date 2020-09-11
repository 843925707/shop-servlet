package com.yqm.shop.biz;

import java.util.List;
import java.util.Map;

import com.yqm.shop.entity.MemberInfo;

public interface IMemberInfoBiz {

	public MemberInfo login(String nickName, String pwd);

	public int update(MemberInfo mf);

	public List<MemberInfo> findAll();

	public int add(String nickname, String pwd, String tel, String email);

	public int pwdUpdate(String nickname, String newpwd);
}
