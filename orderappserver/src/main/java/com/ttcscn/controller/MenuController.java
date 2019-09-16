package com.ttcscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.dto.MenuDto;
import com.ttcscn.entity.Menu;
import com.ttcscn.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/menu/get", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> getAllListMenu(@RequestParam("maBan") String maBan) {
		List<Menu> arrMenu = menuService.getAllList();
		return arrMenu;
	}

	@RequestMapping(value = "/menu/add", method = RequestMethod.POST)
	@ResponseBody
	public MenuDto saveMenu(@RequestBody Menu menu) {
		MenuDto menuDto = new MenuDto();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData!=null) {
			menuDto.setStatus("Failse");
			menuDto.setMessage("Da ton tai thuc uong nay");
		} else {
			String mess = menuService.saveMenu(menu);
			menuDto.setStatus("Success");
			menuDto.setMessage(mess);
		}
		return menuDto;
	}
	
	@RequestMapping(value = "/menu/update", method = RequestMethod.POST)
	@ResponseBody
	public MenuDto updateMenu(@RequestBody Menu menu) {
		MenuDto menuDto = new MenuDto();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData==null) {
			menuDto.setStatus("Failse");
			menuDto.setMessage("Khong tim thay thuc uong nay");
		} else {
			String mess = menuService.updateMenu(menu);
			menuDto.setStatus("Success");
			menuDto.setMessage(mess);
		}
		return menuDto;
	}
	
	@RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
	@ResponseBody
	public MenuDto deleteMenu(@RequestBody Menu menu) {
		MenuDto menuDto = new MenuDto();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData==null) {
			menuDto.setStatus("Failse");
			menuDto.setMessage("Khong tim thay thuc uong nay");
		} else {
			String mess = menuService.deleteMenu(menu);
			menuDto.setStatus("Success");
			menuDto.setMessage(mess);
		}
		return menuDto;
	}
	
	@RequestMapping(value = "/menu/find", method = RequestMethod.GET)
	@ResponseBody
	public Menu findById(@RequestParam("maThucUong") String maThucUong) {
		Menu menu = menuService.findItemById(maThucUong);
		return menu;
	}
}
