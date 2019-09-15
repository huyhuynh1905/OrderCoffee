package com.ttcscn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "hoanthanh")
public class HoanThanh {
	
	@Id
	private String maDaOrder;
	
	private double tongGia;
	
	private String tinhTrang;
	
	public HoanThanh() {
		super();
	}

	public HoanThanh(String maDaOrder, double tongGia, String tinhTrang) {
		super();
		this.maDaOrder = maDaOrder;
		this.tongGia = tongGia;
		this.tinhTrang = tinhTrang;
	}

	public String getMaDaOrder() {
		return maDaOrder;
	}

	public void setMaOrder(String maOrder) {
		this.maDaOrder = maOrder;
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
		return "HoanThanh [maOrder=" + maDaOrder + ", tongGia=" + tongGia + ", tinhTrang=" + tinhTrang + "]";
	}

	
}
