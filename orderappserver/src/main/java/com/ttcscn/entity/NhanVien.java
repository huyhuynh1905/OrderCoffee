package com.ttcscn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "nhanvien")
public class NhanVien {
	
	@Id
	private String username;
	
	private String password;
	
	private String hoTen;
	
	private int namSinh;
	
	private String soDienThoai;
	
	private String diaChi;
	
	private boolean chucVu;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String username, String password, String hoTen, int namSinh, String soDienThoai, String diaChi,
			boolean chucVu) {
		super();
		this.username = username;
		this.password = password;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isChucVu() {
		return chucVu;
	}

	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "NhanVien [username=" + username + ", password=" + password + ", hoTen=" + hoTen + ", namSinh=" + namSinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", chucVu=" + chucVu + "]";
	}
	

}
