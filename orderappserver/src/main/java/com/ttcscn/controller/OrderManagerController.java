package com.ttcscn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.entity.MenuOrder;
import com.ttcscn.entity.Message;
import com.ttcscn.entity.Order;
import com.ttcscn.entity.OrderManager;
import com.ttcscn.service.BanService;
import com.ttcscn.service.MenuService;
import com.ttcscn.service.OrderService;

@RestController
public class OrderManagerController {

	@Autowired
	MenuService menuService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	BanService banService;
	
	@RequestMapping(value = "/ordermanager/get", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderManager> getAllListMenuOrder(@RequestParam("username") String username) {
		List<OrderManager> arrOrderMaganer = new ArrayList();
		List<Order> arrOrder = orderService.chuaOrder();
		int i = -1;
		double tongGia = 0;
		for(Order order : arrOrder) {
			OrderManager orderManager = new OrderManager();
			String maOrder = order.getMaOrder();
			String tenBan = order.getMaBan();
			orderManager.setMaOrder(maOrder);
			orderManager.setTenBan(tenBan);
			String tenThucUong = menuService.findItemById(order.getMaThucUong()).getTenThucUong();
			int soLuong = order.getSoLuong();
			double donGia = order.getDonGiaOrder();
			
			if(arrOrderMaganer.contains(orderManager)) {
				arrOrderMaganer.get(i).addItem(new MenuOrder(tenThucUong, soLuong, donGia));
			} else {
				//Gán giá trị tổng đơn
				if(i!=-1) {
					tongGia = 0;
					for(MenuOrder menuOrder : arrOrderMaganer.get(i).getListMenuOrder()) {
						tongGia += menuOrder.getDonGia();
					}
					arrOrderMaganer.get(i).setTongGia(tongGia);
				}
				//Tạo một đơn mới
				MenuOrder menuOrder = new MenuOrder(tenThucUong, soLuong, donGia);
				List<MenuOrder> arrMenuOrders = new ArrayList<MenuOrder>();
				arrMenuOrders.add(menuOrder);
				orderManager.setTongGia(donGia);
				orderManager.setListMenuOrder(arrMenuOrders);
				arrOrderMaganer.add(orderManager);
				i+=1;
			}
			
		}
		return arrOrderMaganer;
	}
	
	//Xác nhận order
	@RequestMapping(value = "/ordermanager/xacnhan", method = RequestMethod.POST)
	@ResponseBody
	public Message xacNhanOrder(@RequestBody OrderManager dsOrder) {
		String nguoiOrder = dsOrder.getMessage();
		String maOrder = dsOrder.getMaOrder();
		String maBan = dsOrder.getTenBan();
		String mess = orderService.updateOrder(maOrder, maBan, nguoiOrder);
		System.out.println(mess);
		Message message = new Message();
		message.setMessage(mess);
		return message;
	}
	
	//Xác nhận order
	@RequestMapping(value = "/ordermanager/huyorder", method = RequestMethod.POST)
	@ResponseBody
	public Message huyOrder(@RequestBody OrderManager dsOrder) {
		String maOrder = dsOrder.getMaOrder();
		String maBan = dsOrder.getTenBan();
		String mess = orderService.deleteOrder(maOrder, maBan);
		System.out.println(mess);
		Message message = new Message();
		message.setMessage(mess);
		return message;
	}
}
