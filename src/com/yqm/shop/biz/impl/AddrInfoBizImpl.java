package com.yqm.shop.biz.impl;

import java.util.Collections;
import java.util.List;

import com.yqm.shop.biz.IAddrInfoBiz;
import com.yqm.shop.dao.IAddrInfoDao;
import com.yqm.shop.dao.impl.AddrInfoDaoImpl;
import com.yqm.shop.entity.AddrInfo;
import com.yqm.shop.util.StringUtil;

public class AddrInfoBizImpl implements IAddrInfoBiz{

	@Override
	public List<AddrInfo> finds(String mno) {
		if(StringUtil.checkNull(mno)){
			return Collections.emptyList();
		}
		IAddrInfoDao addrInfoDao = new AddrInfoDaoImpl();
		return addrInfoDao.finds(mno);
	}

	@Override
	public int add(AddrInfo af) {
		if(StringUtil.checkNull(af.getAno())){
			return -1;
		}
		IAddrInfoDao addrInfoDao=new AddrInfoDaoImpl();
		return addrInfoDao.add(af);
	}

	
}
