package com.ttcscn.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttcscn.entity.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	SessionFactory sessionHibernate;
	
	
	//Lấy ra danh sách menu
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
}
