package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Menu;
import com.ttcscn.repository.MenuDAO;

@Service("menuService")
public class MenuService {

	@Autowired
	MenuDAO menuDao;
	
	@Transactional
	public List<Menu> getAllList(){
		return menuDao.getAll();
	}
	
	@Transactional
	public void saveMenu(Menu menu) {
		menuDao.save(menu);
	}
	
	@Transactional
	public void updateMenu(Menu menu) {
		menuDao.update(menu);
	}
	
	@Transactional
	public void deleteMenu(Menu menu) {
		menuDao.delete(menu);
	}
	
	@Transactional
	public Menu findItemById(String maThucUong) {
		return menuDao.findById(maThucUong);
	}
}
