package com.yqm.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IGoodsInfoDao;
import com.yqm.shop.entity.GoodsInfo;
import com.yqm.shop.util.StringUtil;

public class GoodsInfoDaoImpl implements IGoodsInfoDao{

	@Override
	public List<GoodsInfo> findByPage(int page, int rows) {
		
		DBHelper db = new DBHelper();
		String sql = "select gno, g.tno, tname, gname, price, intro,  pics, concat( balance ,unit) unit,qperied ,concat (weight,'/',unit) weight,descr,g.status from goodsinfo g, goodstype t where g.tno=t.tno order by gno desc limit ?, ?";
		return db.finds(GoodsInfo.class, sql, (page - 1) * rows, rows);
	}

	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql = "select count(gno) from goodsinfo";
		return db.total(sql);
	}

	@Override
	public int total(String tno, String gname) {
		DBHelper db = new DBHelper();
		String sql = "select count(gno) from goodsinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tno)) {
			sql += " and tno = ?";
			params.add(tno);
		}
		
		if(!StringUtil.checkNull(gname)) {
			sql += " and gname like concat('%', ?, '%')";
			params.add(gname);
		}
		return db.total(sql, params);
	}

	@Override
	public List<GoodsInfo> findByCondition(String tno, String gname, int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select gno, g.tno, tname, gname, price, intro, pics,concat( balance, '/',unit) unit,qperied ,concat (weight,'/',unit) weight,descr,g.status from goodsinfo g, goodstype t "
				+ "where g.tno=t.tno";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tno)){
			sql += " and g.tno = ?";
			params.add(tno);
		}
		
		if(!StringUtil.checkNull(gname)){
			sql += " and gname like concat('%', ?, '%')";
			params.add(gname);
		}
		
		sql += " order by gno desc limit ?, ?";
		params.add((page - 1) * rows);
		params.add(rows);
		
		return db.finds(GoodsInfo.class, sql,  params);
	}

	@Override
	public List<GoodsInfo> findIndex() {
		DBHelper db = new DBHelper();
		String sql = "select gno,t.tname, gname, price, g1.tno, pics from goodsinfo g1 , goodstype t where g1.tno=t.tno and 4 > (select count(gno) from goodsinfo g2 where g1.tno=g2.tno and g1.gno < g2.gno) order by g1.tno asc, g1.gno desc";
		return db.finds(GoodsInfo.class, sql);
	}

	@Override
	public GoodsInfo findByGno(String gno) {
		DBHelper db = new DBHelper();
		String sql = "select gno, gname, price, intro,  pics,  balance,unit, concat (weight,'/',unit) weight, qperied, descr from goodsinfo where gno=?";
		return db.find(GoodsInfo.class, sql, gno);
	}

	@Override
	public List<GoodsInfo> findByTno(String tno, int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select gno, gname, price, pics, concat( balance, '/',unit) unit, concat (weight,'/',unit) weight from goodsinfo where tno=? order by gno desc limit ?, ?";
		return db.finds(GoodsInfo.class, sql, tno, (page - 1) * rows, rows);
	}

	@Override
	public int total(String tno) {
		DBHelper db = new DBHelper();
		String sql = "select count(gno) from goodsinfo where tno=?";
		return db.total(sql, tno);
	}

	@Override
	public int add(GoodsInfo info) {
		DBHelper db = new DBHelper();
		String sql="insert into goodsinfo values(0,?,?,?,?,?,?,?,?,?,'无',1)";
		return  db.update(sql, info.getGname(), info.getTno(),info.getPrice(),info.getIntro() , info.getBalance(), info.getPics(), info.getUnit(), info.getQperied(),info.getWeight());
	}

	@Override
	public int update(GoodsInfo info) {
		DBHelper db = new DBHelper();
		String sql="update goodsinfo set gname=?,tno=?, price=?, intro=?, balance=?, pics=?, unit=?, weight=?, qperied=?, descr=?,status=? where gno=?";
		return db.update(sql,info.getGname(),info.getTno(),info.getPrice(),info.getIntro(),info.getBalance(),info.getPics(),info.getUnit(),info.getWeight(),info.getQperied(),info.getDescr(),info.getStatus(),info.getGno());
	}

	@Override
	public int delete(String gno) {
		DBHelper db = new DBHelper();
		String sql = "delete from goodsinfo where gno=?";
		return db.update(sql, gno);
	}

	@Override
	public GoodsInfo find(String gname) {
		DBHelper db = new DBHelper();
		String sql = "select gno, gname, price, intro,  pics, concat( balance, '/',unit) unit, concat (weight,'/',unit) weight, qperied, descr from goodsinfo where gname like concat('%', ?, '%')";
		return db.find(GoodsInfo.class, sql, gname);
	}

	@Override
	public GoodsInfo findByTno(String tno) {
		DBHelper db = new DBHelper();
		String sql = "select  gname, concat( balance, '/',unit) unit from goodsinfo where tno=? ";
		return db.find(GoodsInfo.class, sql, tno);
	}

	@Override
	public GoodsInfo findTno(String tno) {
		DBHelper db = new DBHelper();
		String sql = "select  gname,  balance from goodsinfo where tno=? ";
		return db.find(GoodsInfo.class, sql, tno);
	}

}
