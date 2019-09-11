package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.NhanVien;
import com.ttcscn.repository.NhanVienDAO;

@Service("nhanvienService")
public class NhanVienService {
	
	@Autowired
	NhanVienDAO nhanvienDao;
	
	@Transactional
	public List<NhanVien> getAllList(){
		return nhanvienDao.getAll();
	}
	
	@Transactional
	public void saveNhanVien(NhanVien nv) {
		nhanvienDao.save(nv);
	}
	
	@Transactional
	public void updateNhanVien(NhanVien nv) {
		nhanvienDao.update(nv);
	}
	
	@Transactional
	public void deleteNhanVien(NhanVien nv) {
		nhanvienDao.delete(nv);
	}
	
	@Transactional
	public NhanVien findNhanVienById(String username) {
		return nhanvienDao.findById(username);
	}
	
	@Transactional
	public boolean loginToServer(String username, String password) {
		return nhanvienDao.loginToServer(username, password);
	}
}
