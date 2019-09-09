package com.ttcscn.controller;

import java.io.File;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttcscn.entity.Menu;


@Controller
@RequestMapping("/")
public class TrangChu {
	
	@Autowired
	SessionFactory sessionHibernate;
	
	@GetMapping
	@ResponseBody
	@Transactional
	public String trangChu() {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from menu";
		List<Menu> arrMenu = session.createQuery(sql).getResultList(); //Trả về một list còn chỉ 1 thì getSingleResult()
		for(Menu mn : arrMenu) {
			System.out.println(mn.toString());
		}
		return "Thành công!";
	}
	/*
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
	  */
}
