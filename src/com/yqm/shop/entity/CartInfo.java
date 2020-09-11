package com.yqm.shop.entity;

import java.io.Serializable;

import com.yqm.shop.util.StringUtil;

public class CartInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 246571561931057947L;

	
	private String cno;
	private Integer mno;
	private Integer gno;
	private Integer num;
	
	private String gname;
	private double price;
	private String pics;
	private String unit;
	private String weight;
	@Override
	public String toString() {
		return "CartInfo [cno=" + cno + ", mno=" + mno + ", gno=" + gno + ", num=" + num + ", gname=" + gname
				+ ", price=" + price + ", pics=" + pics + ", unit=" + unit + ", weight=" + weight + "]";
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		if(!StringUtil.checkNull(pics)){
			this.pics = pics.split(";")[0];
			return;
		}
		this.pics = pics;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cno == null) ? 0 : cno.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartInfo other = (CartInfo) obj;
		if (cno == null) {
			if (other.cno != null)
				return false;
		} else if (!cno.equals(other.cno))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	
	public CartInfo(String cno, Integer mno, Integer gno, Integer num, String gname, double price, String pics,
			String unit, String weight) {
		super();
		this.cno = cno;
		this.mno = mno;
		this.gno = gno;
		this.num = num;
		this.gname = gname;
		this.price = price;
		this.pics = pics;
		this.unit = unit;
		this.weight = weight;
	}
	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
