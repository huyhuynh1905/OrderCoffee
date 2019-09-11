package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Order;
import com.ttcscn.repository.OrderDAO;

@Service("orderService")
public class OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Transactional
	public List<Order> getAllList(){
		return orderDao.getAll();
	}
	
	@Transactional
	public void saveOrder(Order order) {
		orderDao.save(order);
	}
	
	@Transactional
	public void updateOrder(Order order) {
		orderDao.update(order);
	}
	
	@Transactional
	public void deleteOrder(Order order) {
		orderDao.delete(order);
	}
	
	@Transactional
	public void hoanThanhOrder(Order order) {
		orderDao.changeOrder(order);
	}
}
