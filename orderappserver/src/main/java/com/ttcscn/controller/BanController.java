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
import com.ttcscn.entity.Message;
import com.ttcscn.service.BanService;

@RestController
public class BanController {

	@Autowired
	BanService banService;
	
	@RequestMapping(value = "/ban/get", method = RequestMethod.POST)
	@ResponseBody
	public List<Ban> getAllBan(){
		List<Ban> arrBan = banService.getAllList();
		return arrBan;
	}
	
	@RequestMapping(value = "/ban/add", method = RequestMethod.POST)
	public Message saveBan(@RequestBody Ban ban) {
		Message mess = new Message();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			mess.setMessage("Failed");
		} else {
			mess.setMessage(banService.saveBan(ban));
		}
		return mess;
	}
	
	@RequestMapping(value = "/ban/update", method = RequestMethod.POST)
	public Message updateBan(@RequestBody Ban ban) {
		Message mess = new Message();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			mess.setMessage(banService.updateBan(ban));
		} else {
			mess.setMessage("Failed");
		}
		return mess;
	}
	
	@RequestMapping(value = "/ban/delete", method = RequestMethod.POST)
	public Message deleteBan(@RequestBody Ban ban) {
		Message mess = new Message();
		Ban b = banService.findBanById(ban.getMaBan());
		if(b!=null) {
			mess.setMessage(banService.deleteBan(b));
		} else {
			mess.setMessage("Failed");
		}
		return mess;
	}
	
	@RequestMapping(value = "/ban/find", method = RequestMethod.GET)
	public Ban findBan(@RequestParam("maBan") String maBan) {
		return banService.findBanById(maBan);
	}
	
	@RequestMapping(value = "/ban/find", method = RequestMethod.POST)
	public Ban findBanByPost(@RequestParam("maBan") String maBan) {
		return banService.findBanById(maBan);
	}
}
