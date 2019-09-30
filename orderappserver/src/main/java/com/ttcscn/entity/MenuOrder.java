package com.ttcscn.entity;

public class MenuOrder {
	private String tenThucUong;
	private int soLuong;
	private double donGia;
	
	public MenuOrder() {
		super();
	}
	public MenuOrder(String tenThucUong, int soLuong, double donGia) {
		super();
		this.tenThucUong = tenThucUong;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	public String getTenThucUong() {
		return tenThucUong;
	}
	public void setTenThucUong(String tenThucUong) {
		this.tenThucUong = tenThucUong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	
}
