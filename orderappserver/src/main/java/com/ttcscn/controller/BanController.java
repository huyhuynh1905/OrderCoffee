package com.ttcscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.dto.BanDto;
import com.ttcscn.entity.Ban;
import com.ttcscn.service.BanService;

@RestController
public class BanController {

	@Autowired
	BanService banService;
	
	@RequestMapping(value = "/ban/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Ban> getAllBan(){
		List<Ban> arrBan = banService.getAllList();
		return arrBan;
	}
	
	@RequestMapping(value = "/ban/add", method = RequestMethod.POST)
	@ResponseBody
	public BanDto saveBan(@RequestBody Ban ban) {
		BanDto bandto = new BanDto();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			bandto.setStatus("Failed");
			bandto.setMessage("Mã bàn đã tồn tại!");
		} else {
			bandto.setStatus("Success");
			bandto.setMessage(banService.saveBan(ban));
		}
		return bandto;
	}
	
	@RequestMapping(value = "/ban/update", method = RequestMethod.POST)
	@ResponseBody
	public BanDto updateBan(@RequestBody Ban ban) {
		BanDto bandto = new BanDto();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			bandto.setStatus("Success");
			bandto.setMessage(banService.updateBan(ban));
		} else {
			bandto.setStatus("Failed");
			bandto.setMessage("Không tìm thấy mã bàn này!");
		}
		return bandto;
	}
	
	@RequestMapping(value = "/ban/delete", method = RequestMethod.POST)
	@ResponseBody
	public BanDto deleteBan(@RequestBody Ban ban) {
		BanDto bandto = new BanDto();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			bandto.setStatus("Success");
			bandto.setMessage(banService.deleteBan(ban));
		} else {
			bandto.setStatus("Failed");
			bandto.setMessage("Không tìm thấy mã bàn này!");
		}
		return bandto;
	}
	
	@RequestMapping(value = "/ban/find", method = RequestMethod.GET)
	@ResponseBody
	public Ban findBan(@RequestParam("maBan") String maBan) {
		return banService.findBanById(maBan);
	}
	
	@RequestMapping(value = "/ban/find", method = RequestMethod.POST)
	@ResponseBody
	public Ban findBanByPost(@RequestParam("maBan") String maBan) {
		return banService.findBanById(maBan);
	}
}
