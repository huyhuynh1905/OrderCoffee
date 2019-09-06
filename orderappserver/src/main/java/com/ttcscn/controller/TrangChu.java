package com.ttcscn.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ttcscn.model.MyFile;

@Controller
public class TrangChu {
	
	
	@RequestMapping("/")
	@ResponseBody
	public String trangChu() {
		return "Test";
	}
	
	@RequestMapping(value = "/uploadanh", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("imageFile") MultipartFile imageFile) {
	    System.out.println("Chay duoc");
	    try {
	      String fileName = imageFile.getOriginalFilename();
	      File file = new File("D:\\Acount", fileName);
	      imageFile.transferTo(file);
	    } catch (Exception e) {
	    	System.out.println("Uploadddd Errrorrrr");
	      //e.printStackTrace();
	    }
	    System.out.println("Uploadddd");
	    return "result_ok";
	  }
}
