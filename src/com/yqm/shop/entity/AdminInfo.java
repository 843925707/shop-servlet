package com.yqm.shop.entity;

import java.io.Serializable;

public class AdminInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4137914989328954495L;

	private Integer aid;
	private String aname;
	private String pwd;
	private Integer level;
	private String tel;
	private String email;
	private Integer status;
	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd=" + pwd + ", level=" + level + ", tel=" + tel
				+ ", email=" + email + ", status=" + status + "]";
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		AdminInfo other = (AdminInfo) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	public AdminInfo(Integer aid, String aname, String pwd, Integer level, String tel, String email, Integer status) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
		this.level = level;
		this.tel = tel;
		this.email = email;
		this.status = status;
	}
	public AdminInfo() {
		super();
	}
	
	
	
	
	
}
