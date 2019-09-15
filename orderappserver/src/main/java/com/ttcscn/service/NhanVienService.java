package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.NhanVien;
import com.ttcscn.repository.NhanVienDAO;

@Service("nhanvienService")
@Transactional
public class NhanVienService {
	
	@Autowired
	NhanVienDAO nhanvienDao;
	
	public List<NhanVien> getAllList(){
		return nhanvienDao.getAll();
	}
	
	public String saveNhanVien(NhanVien nv) {
		return nhanvienDao.save(nv);
	}
	
	public String updateNhanVien(NhanVien nv) {
		return nhanvienDao.update(nv);
	}
	
	public String deleteNhanVien(NhanVien nv) {
		return nhanvienDao.delete(nv);
	}
	
	public NhanVien findNhanVienById(String username) {
		return nhanvienDao.findById(username);
	}
	
	public boolean loginToServer(String username, String password) {
		return nhanvienDao.loginToServer(username, password);
	}
}
