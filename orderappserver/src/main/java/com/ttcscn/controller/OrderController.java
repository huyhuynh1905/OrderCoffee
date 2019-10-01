package com.ttcscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttcscn.dto.OrderDto;
import com.ttcscn.entity.Message;
import com.ttcscn.entity.Order;
import com.ttcscn.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllListMenu() {
		List<Order> arrOrder = orderService.getAllList();
		return arrOrder;
	}

	@RequestMapping(value = "/order/add", method = RequestMethod.POST)
	@ResponseBody
	public OrderDto saveMenu(@RequestBody Order order) {
		OrderDto orderDto = new OrderDto();
		Order orderfromData = orderService.findOrder(order.getMaOrder());
		if(orderfromData!=null) {
			orderDto.setStatus("Failse");
			orderDto.setMessage("Order thất bại!");
		} else {
			String mess = orderService.saveOrder(order);
			orderDto.setStatus("Success");
			orderDto.setMessage(mess);
		}
		return orderDto;
	}
	/*
	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	@ResponseBody
	public OrderDto updateMenu(@RequestBody Order order) {
		OrderDto orderDto = new OrderDto();
		Order orderfromData = orderService.findOrder(order.getMaOrder());
		if(orderfromData==null) {
			orderDto.setStatus("Failse");
			orderDto.setMessage("Khong tim thay đơn nay");
		} else {
			String mess = orderService.updateOrder(order);
			orderDto.setStatus("Success");
			orderDto.setMessage(mess);
		}
		return orderDto;
	}*/
	
	@RequestMapping(value = "/order/delete", method = RequestMethod.POST)
	@ResponseBody
	public OrderDto deleteMenu(@RequestBody Order order) {
		OrderDto orderDto = new OrderDto();
		Order orderfromData = orderService.findOrder(order.getMaOrder());
		if(orderfromData==null) {
			orderDto.setStatus("Failse");
			orderDto.setMessage("Khong tim thay thuc uong nay");
		} else {
			String mess = orderService.deleteOrder(order.getMaOrder(), order.getMaBan());
			orderDto.setStatus("Success");
			orderDto.setMessage(mess);
		}
		return orderDto;
	}
	
	@RequestMapping(value = "/order/find", method = RequestMethod.GET)
	@ResponseBody
	public Order findById(@RequestParam("orderService") String maOrder) {
		Order order = orderService.findOrder(maOrder);
		return order;
	}
	
	//Thêm
	@RequestMapping(value = "/order/addlist", method = RequestMethod.POST)
	@ResponseBody
	public Message addListOrder(@RequestBody List<Order> arrOrder) {
		OrderDto orderDto = new OrderDto();
		for(Order order : arrOrder) {
			orderService.saveOrder(order);
		}
		Message message = new Message();
		message.setMessage("Đã order thành công! Vui lòng đợi!");
		return message;
	}
	
}
