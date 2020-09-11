package com.yqm.shop.dao;

import java.util.List;

import com.yqm.shop.entity.AddrInfo;

public interface IAddrInfoDao {

	public List<AddrInfo> finds(String mno);

	public int add(AddrInfo af);
}
