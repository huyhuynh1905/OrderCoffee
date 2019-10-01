package com.ttcscn.entity;

import java.util.List;

public class OrderManager {
	private String maOrder;
	private String tenBan;
	private List<MenuOrder> listMenuOrder;
	private double tongGia;
	private String message;
	
	public OrderManager() {
		super();
	}

	public OrderManager(String maOrder, String tenBan, List<MenuOrder> listMenuOrder, double tongGia) {
		super();
		this.maOrder = maOrder;
		this.tenBan = tenBan;
		this.listMenuOrder = listMenuOrder;
		this.tongGia = tongGia;
	}
	
	
	//Để so sánh và kiểm tra tồn tại
	@Override
	public boolean equals(Object obj) {
		OrderManager orderManager = (OrderManager) obj;
		return this.getMaOrder().equals(orderManager.getMaOrder());
	}

	//Phương thức add item vào list
	public void addItem(MenuOrder menuOrder) {
		this.listMenuOrder.add(menuOrder);
	}
	public String getMaOrder() {
		return maOrder;
	}

	public void setMaOrder(String maOrder) {
		this.maOrder = maOrder;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public List<MenuOrder> getListMenuOrder() {
		return listMenuOrder;
	}

	public void setListMenuOrder(List<MenuOrder> listMenuOrder) {
		this.listMenuOrder = listMenuOrder;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
