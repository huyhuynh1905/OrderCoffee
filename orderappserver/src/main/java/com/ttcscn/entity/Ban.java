package com.ttcscn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ban")
public class Ban {
	
	@Id
	private String maBan;
	
	private String tenBan;
	
	private String moTa;
	
	public Ban() {
		super();
	}
	public Ban(String maBan, String tenBan, String moTa) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.moTa = moTa;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", tenBan=" + tenBan + ", moTa=" + moTa + "]";
	}
}
