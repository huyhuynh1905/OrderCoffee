package com.ttcscn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "hoanthanh")
public class HoanThanh {
	
	@Id
	private String maOrder;
	
	private double tongGia;
	
	private String tinhTrang;
	
	public HoanThanh() {
		super();
	}

	public HoanThanh(String maOrder, double tongGia, String tinhTrang) {
		super();
		this.maOrder = maOrder;
		this.tongGia = tongGia;
		this.tinhTrang = tinhTrang;
	}

	public String getMaOrder() {
		return maOrder;
	}

	public void setMaOrder(String maOrder) {
		this.maOrder = maOrder;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "HoanThanh [maOrder=" + maOrder + ", tongGia=" + tongGia + ", tinhTrang=" + tinhTrang + "]";
	}

	
}
