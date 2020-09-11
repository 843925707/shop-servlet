package com.yqm.shop.entity;

import java.io.Serializable;

public class GoodsType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -850749864306811306L;

	private Integer tno;
	private String tname;
	private String pic;
	private Integer status;
	@Override
	public String toString() {
		return "GoodsType [tno=" + tno + ", tname=" + tname + ", pic=" + pic + ", status=" + status + "]";
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		GoodsType other = (GoodsType) obj;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
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
		return true;
	}
	public GoodsType(Integer tno, String tname, String pic, Integer status) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pic = pic;
		this.status = status;
	}
	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
