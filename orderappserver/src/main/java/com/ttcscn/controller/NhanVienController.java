package com.ttcscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.dto.NhanVienDto;
import com.ttcscn.entity.NhanVien;
import com.ttcscn.service.NhanVienService;

@RestController
public class NhanVienController {

	@Autowired
	NhanVienService nhanvienService;
	
	@RequestMapping(value = "/nhanvien/get", method = RequestMethod.GET)
	@ResponseBody
	public List<NhanVien> getAllNhanVien(){
		return nhanvienService.getAllList();
	}
	@RequestMapping(value = "/nhanvien/get", method = RequestMethod.POST)
	@ResponseBody
	public List<NhanVien> getAllNhanVienPost(){
		return nhanvienService.getAllList();
	}
	
	@RequestMapping(value = "/nhanvien/add", method = RequestMethod.POST)
	@ResponseBody
	public NhanVienDto saveNhanvien(@RequestBody NhanVien nhanvien) {
		NhanVienDto nvdto = new NhanVienDto();
		NhanVien nv = nhanvienService.findNhanVienById(nhanvien.getUsername());
		if(nv!=null) {
			nvdto.setStatus("Failed");
			nvdto.setMessage("Tài khoản này đã tồn tại");
		} else {
			nvdto.setStatus("Success");
			nvdto.setMessage(nhanvienService.saveNhanVien(nhanvien));
		}
		return nvdto;
	}
	
	@RequestMapping(value = "/nhanvien/update", method = RequestMethod.POST)
	@ResponseBody
	public NhanVienDto updateNhanvien(@RequestBody NhanVien nhanvien) {
		NhanVienDto nvdto = new NhanVienDto();
		NhanVien nv = nhanvienService.findNhanVienById(nhanvien.getUsername());
		if(nv!=null) {
			nvdto.setStatus("Success");
			nvdto.setMessage(nhanvienService.updateNhanVien(nhanvien));
		} else {
			nvdto.setStatus("Failed");
			nvdto.setMessage("Tài khoản này không tồn tại");
		}
		return nvdto;
	}
	
	@RequestMapping(value = "/nhanvien/delete", method = RequestMethod.POST)
	@ResponseBody
	public NhanVienDto deleteNhanvien(@RequestBody NhanVien nhanvien) {
		NhanVienDto nvdto = new NhanVienDto();
		NhanVien nv = nhanvienService.findNhanVienById(nhanvien.getUsername());
		if(nv!=null) {
			nvdto.setStatus("Success");
			nvdto.setMessage(nhanvienService.deleteNhanVien(nhanvien));
		} else {
			nvdto.setStatus("Failed");
			nvdto.setMessage("Tài khoản này không tồn tại");
		}
		return nvdto;
	}
	
	@RequestMapping(value = "/nhanvien/find",method = RequestMethod.GET)
	@ResponseBody
	public NhanVien findNhanvien(@RequestParam("username") String username) {
		return nhanvienService.findNhanVienById(username);
	}
	
	@RequestMapping(value = "/nhanvien/login",method = RequestMethod.POST)
	@ResponseBody
	public NhanVien loginServer(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		boolean login = nhanvienService.loginToServer(username, password);
		if(login) {
			return nhanvienService.findNhanVienById(username);
		} else {
			return new NhanVien();
		}
	}
}
