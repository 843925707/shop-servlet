package com.yqm.shop.biz;

import java.util.List;

import com.yqm.shop.entity.AddrInfo;

public interface IAddrInfoBiz {

	public List<AddrInfo> finds(String mno);

	public int add(AddrInfo af);
}
