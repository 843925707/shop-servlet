package com.yqm.shop.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yqm.shop.biz.IMemberInfoBiz;
import com.yqm.shop.dao.IAdminInfoDao;
import com.yqm.shop.dao.IMemberInfoDao;
import com.yqm.shop.dao.impl.AdminInfoDaoImpl;
import com.yqm.shop.dao.impl.MemberInfoDaoImpl;
import com.yqm.shop.entity.MemberInfo;
import com.yqm.shop.util.StringUtil;

public class MemberInfoBizImpl implements IMemberInfoBiz{

	@Override
	public MemberInfo login(String nickName, String pwd) {
		if(StringUtil.checkNull(nickName, pwd)){
			return null;
		}
		
		IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		return memberInfoDao.login(nickName, pwd);
	}

	@Override
	public int update(MemberInfo mf) {
		if(StringUtil.checkNull(mf.getNickName(),mf.getPwd())){
			return -1;
		}
		IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		return memberInfoDao.update(mf);
	}

	@Override
	public List<MemberInfo> findAll() {
		IMemberInfoDao memberInfoDao=new MemberInfoDaoImpl();
		return memberInfoDao.findAll();
	}

	@Override
	public int add(String nickname, String pwd, String tel, String email) {
		IMemberInfoDao memberInfoDao=new MemberInfoDaoImpl();
		return memberInfoDao.add(nickname,pwd,tel,email);
	}

	@Override
	public int pwdUpdate(String nickname, String newpwd) {
		if(StringUtil.checkNull(nickname,newpwd)){
			return -1;
		}
		IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		return memberInfoDao.pwdUpdate(nickname,newpwd);
	}

	
}
