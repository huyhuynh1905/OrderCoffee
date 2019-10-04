package com.ttcscn.controller;

import java.io.File;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ttcscn.entity.Menu;
import com.ttcscn.entity.Message;


@Controller
@RequestMapping("/")
public class TrangChu {
	
	@GetMapping
	@ResponseBody
	public String getAllListMenu() {
		return "Trang Chủ";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/uploadanh", method = RequestMethod.POST)
	@ResponseBody
	public Message uploadFile(@RequestParam("imageFile") MultipartFile imageFile) {
	    System.out.println("Chay duoc");
	    Message message = new Message();
	    try {
	      String fileName = imageFile.getOriginalFilename();
	      File file = new File("C:\\xampp\\htdocs\\ordercoffee\\image", fileName);
	      imageFile.transferTo(file);
	    } catch (Exception e) {
	    	System.out.println("Uploadddd Errrorrrr");
	      //e.printStackTrace();
	    }
	    message.setMessage("Success");
	    return message;
	  }
	  
}
