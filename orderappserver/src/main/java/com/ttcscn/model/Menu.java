package com.ttcscn.model;

public class Menu {
	private String maThucUong;
	private String tenThucUong;
	private double donGia;
	private String hinhAnh;
	private String ghiChu;
	
	public Menu() {
		super();
	}

	public Menu(String maThucUong, String tenThucUong, double donGia, String hinhAnh, String ghiChu) {
		super();
		this.maThucUong = maThucUong;
		this.tenThucUong = tenThucUong;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.ghiChu = ghiChu;
	}

	public String getMaThucUong() {
		return maThucUong;
	}

	public void setMaThucUong(String maThucUong) {
		this.maThucUong = maThucUong;
	}

	public String getTenThucUong() {
		return tenThucUong;
	}

	public void setTenThucUong(String tenThucUong) {
		this.tenThucUong = tenThucUong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "Menu [maThucUong=" + maThucUong + ", tenThucUong=" + tenThucUong + ", donGia=" + donGia + ", hinhAnh="
				+ hinhAnh + ", ghiChu=" + ghiChu + "]";
	}
	
	
}
