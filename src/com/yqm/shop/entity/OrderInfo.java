package com.yqm.shop.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8700410980566181150L;

	private String ono;
	private String odate;
	private String ano;
	private String sdate;
	private String rdate;
	private Integer status;
	private double price;
	private Integer invoice;
	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", status=" + status + ", price=" + price + ", invoice=" + invoice + "]";
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getInvoice() {
		return invoice;
	}
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}
	public OrderInfo(String ono, String odate, String ano, String sdate, String rdate, Integer status, double price,
			Integer invoice) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.price = price;
		this.invoice = invoice;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
