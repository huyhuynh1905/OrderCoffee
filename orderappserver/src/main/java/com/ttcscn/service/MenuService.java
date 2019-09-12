package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Menu;
import com.ttcscn.repository.MenuDAO;

@Service("menuService")
@Transactional
public class MenuService {

	@Autowired
	MenuDAO menuDao;
	
	public List<Menu> getAllList(){
		return menuDao.getAll();
	}
	
	public String saveMenu(Menu menu) {
		return menuDao.save(menu);
	}
	
	public String updateMenu(Menu menu) {
		return menuDao.update(menu);
	}
	
	public String deleteMenu(Menu menu) {
		return menuDao.delete(menu);
	}
	
	public Menu findItemById(String maThucUong) {
		return menuDao.findById(maThucUong);
	}
}
