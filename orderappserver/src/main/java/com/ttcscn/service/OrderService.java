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
	
	public String updateOrder(String maOrder, String maBan,String nguoiOrder) {
		return orderDao.update(maOrder, maBan,nguoiOrder);
	}
	
	public String deleteOrder(String maOrder, String maBan) {
		return orderDao.delete(maOrder, maBan);
	}
	public Order findOrder(String maOrder) {
		return orderDao.findById(maOrder);
	}
	//
	public List<Order> chuaOrder(){
		return orderDao.chuaOder();
	}
	public List<Order> getListWithId(String maOrder, String maBan){
		return orderDao.getListWithId(maOrder,maBan);
	}
	
}
