package com.ttcscn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "taborder")
public class Order {
	
	@Id
	private String maOrder;

	private String maBan;

	private String maThucUong;
	
	private int soLuong;
	
	private double donGiaOrder;
	
	private String ghiChu;
	
	private String nguoiOrder;
	
	private boolean tinhTrang;
	
	public Order() {
		super();
	}
	public Order(String maOrder, String maBan, String maThucUong, int soLuong, double donGiaOrder, String ghiChu, boolean tinhTrang) {
		super();
		this.maOrder = maOrder;
		this.maBan = maBan;
		this.maThucUong = maThucUong;
		this.soLuong = soLuong;
		this.donGiaOrder = donGiaOrder;
		this.ghiChu = ghiChu;
		this.tinhTrang = tinhTrang;
	}
	
	public String getMaOrder() {
		return maOrder;
	}
	public void setMaOrder(String maOrder) {
		this.maOrder = maOrder;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getMaThucUong() {
		return maThucUong;
	}
	public void setMaThucUong(String maThucUong) {
		this.maThucUong = maThucUong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGiaOrder() {
		return donGiaOrder;
	}
	public void setDonGiaOrder(double donGiaOrder) {
		this.donGiaOrder = donGiaOrder;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "Order [maOrder=" + maOrder + ", maBan=" + maBan + ", maThucUong=" + maThucUong + ", soLuong=" + soLuong
				+ ", donGiaOrder=" + donGiaOrder + ", ghiChu=" + ghiChu + "]";
	}
	
}
