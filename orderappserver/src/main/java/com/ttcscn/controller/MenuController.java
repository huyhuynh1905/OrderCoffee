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
import com.ttcscn.entity.Message;
import com.ttcscn.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/menu/get", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> getAllListMenuPost() {
		List<Menu> arrMenu = menuService.getAllList();
		return arrMenu;
	}
	@RequestMapping(value = "/menu/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> getAllListMenuGet() {
		List<Menu> arrMenu = menuService.getAllList();
		return arrMenu;
	}

	@RequestMapping(value = "/menu/add", method = RequestMethod.POST)
	@ResponseBody
	public Message saveMenu(@RequestBody Menu menu) {
		Message mess = new Message();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData!=null) {
			mess.setMessage("Failse");
		} else {
			String message = menuService.saveMenu(menu);
			mess.setMessage(message);
		}
		return mess;
	}
	
	@RequestMapping(value = "/menu/update", method = RequestMethod.POST)
	@ResponseBody
	public Message updateMenu(@RequestBody Menu menu) {
		Message mess = new Message();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData==null) {
			mess.setMessage("Failse");
		} else {
			String message = menuService.updateMenu(menu);
			mess.setMessage(message);
		}
		return mess;
	}
	
	@RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteMenu(@RequestBody Menu menu) {
		Message message = new Message();
		Menu menufromData = menuService.findItemById(menu.getMaThucUong());
		if(menufromData==null) {
			message.setMessage("Failse");
		} else {
			String mess = menuService.deleteMenu(menufromData);
			message.setMessage("Success");
		}
		return message;
	}
	
	@RequestMapping(value = "/menu/find", method = RequestMethod.GET)
	@ResponseBody
	public Menu findById(@RequestParam("maThucUong") String maThucUong) {
		Menu menu = menuService.findItemById(maThucUong);
		return menu;
	}
	
	//Test
	@RequestMapping(value = "/menu/test", method = RequestMethod.POST)
	@ResponseBody
	public MenuDto testList(@RequestBody List<Menu> menus) {
		MenuDto menuDto = new MenuDto();
		menuDto.setMessage(menus.get(0).getTenThucUong());
		menuDto.setStatus(menus.get(0).getHinhAnh());
		return menuDto;
	}
}
