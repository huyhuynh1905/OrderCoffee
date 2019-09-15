package com.ttcscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.dto.HoanThanhDto;
import com.ttcscn.entity.HoanThanh;
import com.ttcscn.service.HoanThanhService;

@RestController
public class HoanThanhController {

	@Autowired
	HoanThanhService hoanthanhService;
	
	@RequestMapping(value = "/hoanthanh/get", method = RequestMethod.GET)
	@ResponseBody
	public List<HoanThanh> getAllHoanThanh(){
		return hoanthanhService.getAllList();
	}
	
	@RequestMapping(value = "/hoanthanh/add", method = RequestMethod.POST)
	@ResponseBody
	public HoanThanhDto saveHoanthanh(@RequestBody HoanThanh ht) {
		HoanThanhDto htdto = new HoanThanhDto();
		HoanThanh hthanh = hoanthanhService.findHtById(ht.getMaDaOrder());
		if(hthanh!=null) {
			htdto.setStatus("Failed");
			htdto.setMessage("Đã tồn tại!");
		} else {
			htdto.setStatus("Success");
			htdto.setMessage(hoanthanhService.saveHt(ht));
		}
		return htdto;
	}
	
	@RequestMapping(value = "/hoanthanh/update", method = RequestMethod.POST)
	@ResponseBody
	public HoanThanhDto updateHoanthanh(@RequestBody HoanThanh ht) {
		HoanThanhDto htdto = new HoanThanhDto();
		HoanThanh hthanh = hoanthanhService.findHtById(ht.getMaDaOrder());
		if(hthanh!=null) {
			htdto.setStatus("Success");
			htdto.setMessage(hoanthanhService.updateHt(ht));
		} else {
			htdto.setStatus("Failed");
			htdto.setMessage("Không tìm thấy");
		}
		return htdto;
	}
	
	@RequestMapping(value = "/hoanthanh/delete", method = RequestMethod.POST)
	@ResponseBody
	public HoanThanhDto removeHoanthanh(@RequestBody HoanThanh ht) {
		HoanThanhDto htdto = new HoanThanhDto();
		HoanThanh hthanh = hoanthanhService.findHtById(ht.getMaDaOrder());
		if(hthanh!=null) {
			htdto.setStatus("Success");
			htdto.setMessage(hoanthanhService.deleteHt(ht));
		} else {
			htdto.setStatus("Failed");
			htdto.setMessage("Không tìm thấy");
		}
		return htdto;
	}
	
	@RequestMapping(value = "/hoanthanh/find", method = RequestMethod.GET)
	@ResponseBody
	public HoanThanh findHoanThanh(@RequestParam("maDaOrder") String maDaOrder) {
		return hoanthanhService.findHtById(maDaOrder);
	}
}

