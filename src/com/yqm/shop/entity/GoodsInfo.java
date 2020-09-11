package com.yqm.shop.entity;

import java.io.Serializable;

import com.yqm.shop.util.StringUtil;

public class GoodsInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181535293633021388L;
	
	private Integer gno;
	private String gname;
	private Integer tno;
	private double price;
	private String intro;
	private Integer balance;
	private String pics;
	private String unit;
	private String qperied;
	private String weight;
	private String descr;
	private Integer status;
	private String pic;
	
	private String tname;

	@Override
	public String toString() {
		return "GoodsInfo [gno=" + gno + ", gname=" + gname + ", tno=" + tno + ", price=" + price + ", intro=" + intro
				+ ", balance=" + balance + ", pics=" + pics + ", unit=" + unit + ", qperied=" + qperied + ", weight="
				+ weight + ", descr=" + descr + ", status=" + status + ", pic=" + pic + ", tname=" + tname + "]";
	}

	public Integer getGno() {
		return gno;
	}

	public void setGno(Integer gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getPics() {
		return pics;
	}

	public String getPic() {
		return pic;
	}
	 
	public void setPics(String pics) {
		this.pics = pics;
		setPic(pics);
	}

	public void setPic(String pics) {
		if(!StringUtil.checkNull(pics)){
			this.pic = pics.split(";")[0];
			return;
		}
		this.pic = pics;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQperied() {
		return qperied;
	}

	public void setQperied(String qperied) {
		this.qperied = qperied;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((qperied == null) ? 0 : qperied.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		GoodsInfo other = (GoodsInfo) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
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
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (qperied == null) {
			if (other.qperied != null)
				return false;
		} else if (!qperied.equals(other.qperied))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
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

	public GoodsInfo(Integer gno, String gname, Integer tno, double price, String intro, Integer balance, String pics,
			String unit, String qperied, String weight, String descr, Integer status, String pic, String tname) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.balance = balance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
		this.status = status;
		this.pic = pic;
		this.tname = tname;
	}

	public GoodsInfo() {
		super();
	}


	
}
