package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Order;
import com.ttcscn.repository.OrderDAO;

@Service("orderService")
@Transactional
public class OrderService {

	@Autowired
	OrderDAO orderDao;
	
	public List<Order> getAllList(){
		return orderDao.getAll();
	}
	
	public String saveOrder(Order order) {
		return orderDao.save(order);
	}
	
	public String updateOrder(Order order) {
		return orderDao.update(order);
	}
	
	public String deleteOrder(Order order) {
		return orderDao.delete(order);
	}
	public Order findOrder(String maOrder) {
		return orderDao.findById(maOrder);
	}
	public void hoanThanhOrder(Order order) {
		orderDao.changeOrder(order);
	}
}
