package com.yqm.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IOrderInfoDao;
import com.yqm.shop.entity.OrderInfo;
import com.yqm.shop.entity.OrderItemInfo;

public class OrderInfoDaoImpl implements IOrderInfoDao{

	public int add(String cnos, double totalPrice, String ano) {
		
		String ono = UUID.randomUUID().toString().replace("-", "");
		String sql1 = "insert into orderinfo values(?, now(), ?, null, null, 1, ?, 0)";
		List<Object> param1 = new ArrayList<Object>();
		
		param1.add(ono);
		param1.add(ano);
		param1.add(totalPrice);
		
		String sql2 = "insert into orderiteminfo select 0, ?, c.gno, c.num, price, 1 from cartinfo c, goodsinfo g where c.gno=g.gno and cno in(";
		List<Object> param2 = new ArrayList<Object>();
		param2.add(ono);
		String[] temp = cnos.split(",");
		for(String cno : temp){
			sql2 +="?,";
			param2.add(cno);
			
		}
		sql2 = sql2.substring(0, sql2.lastIndexOf(",")) + ")";
		
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> params = new ArrayList<List<Object>>();
		sqls.add(sql1);
		params.add(param1);
		
		sqls.add(sql2);
		params.add(param2);
		
		String sql3 = null;
		List<Object> param = null;
		for(String cno : temp){
			param = new ArrayList<Object>();
			sql3 = "update goodsinfo set balance = balance - (select num from cartinfo where cno=?) where gno = (select gno from cartinfo where cno=?)";
			param.add(cno);
			param.add(cno);
			
			sqls.add(sql3);
			params.add(param);
		}
		
		String sql4 = "delete from cartinfo where cno in(";
		List<Object> param4 = new ArrayList<Object>();
		for(String cno : temp){
			sql4 +="?,";
			param4.add(cno);
		}
		sql4 = sql4.substring(0, sql4.lastIndexOf(",")) + ")";
		sqls.add(sql4);
		params.add(param4);
		
		DBHelper db = new DBHelper();
		return db.updates(sqls, params);
	}

	@Override
	public List<Map<String, String>> find(Integer mno) {
		DBHelper db = new DBHelper();
		String sql = "select o.ono, date_format(odate, '%Y-%m-%d %H:%i:%s') odate, totalprice, o.status, i.gno, nums, i.price, gname, pics, weight, unit "
				+ " from orderinfo o, orderiteminfo i, goodsinfo g, addrinfo a where o.ono=i.ono and i.gno=g.gno and a.ano=o.ano and a.mno=? order by odate desc";
		return db.gets(sql, mno);
	}

	@Override
	public List<Map<String, String>> findAll(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select o.ono,i.ino, date_format(odate, '%Y-%m-%d %H:%i:%s') odate, nums, i.price,sum(i.price * nums) as total, o.status, i.gno,  gname, pics, weight, unit "
				+ " from orderinfo o, orderiteminfo i, goodsinfo g, addrinfo a where o.ono=i.ono and i.gno=g.gno and a.ano=o.ano group by i.ino order by odate desc limit ?,?";
		return db.gets(sql,(page-1)*rows,rows);
	}

	@Override
	public int delete(String ino) {
		DBHelper db = new DBHelper();
		String sql="delete from orderiteminfo where  ino=? ";
		return db.update(sql, ino);
	}

	@Override
	public int update(OrderInfo order) {
		DBHelper db = new DBHelper();
		String sql="update orderinfo set status=? where ono=?";
		return db.update(sql, order.getStatus(),order.getOno());
	}

	

	

}
