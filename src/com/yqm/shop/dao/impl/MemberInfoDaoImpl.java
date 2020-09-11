package com.yqm.shop.dao.impl;

import java.util.List;

import com.yqm.shop.dao.DBHelper;
import com.yqm.shop.dao.IMemberInfoDao;
import com.yqm.shop.entity.MemberInfo;

public class MemberInfoDaoImpl implements IMemberInfoDao{

	@Override
	public MemberInfo login(String nickName, String pwd) {
		DBHelper db = new DBHelper();
		String sql = "select mno, nickName, tel, email,status from memberinfo where (nickName=? or tel=? or email=?) and pwd=?";
		return db.find(MemberInfo.class, sql, nickName, nickName, nickName, pwd);
	}

	@Override
	public List<MemberInfo> findAll() {
		DBHelper db = new DBHelper();
		String sql="select mno,nickName,pwd,tel,email,photo,regDate,status from memberinfo ";
		return db.finds(MemberInfo.class,sql);
	}

	@Override
	public int update(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql="update memberinfo set pwd=?,status=?  where  mno=? ";
		return db.update(sql, mf.getPwd(),mf.getStatus(),mf.getMno());
	}

	@Override
	public List<MemberInfo> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql="select mno,nickName,pwd,tel,email,photo,regDate,status from memberinfo where limit ?, ?";
		return db.finds(MemberInfo.class,sql,(page - 1) * rows, rows);
	}

	@Override
	public int add(String nickname, String pwd, String tel, String email) {
		DBHelper db = new DBHelper();
		String sql="insert into memberinfo values(0,?,'',?,?,?,'images/yonghutouxiang.jpg',now(),1)";
		return db.update(sql,nickname,pwd,tel,email);
	}

	@Override
	public int pwdUpdate(String nickname, String newpwd) {
		DBHelper db = new DBHelper();
		String sql="update memberinfo set pwd=? where nickname=?";
		return db.update(sql, newpwd,nickname);
	}

	
}
