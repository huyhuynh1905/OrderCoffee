package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.HoanThanh;
import com.ttcscn.entity.Order;

@Repository("orderDao")
public class OrderDAO implements Dao<Order> {
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Order> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<Order> arrOrder = session.createQuery("from order").getResultList();
		return arrOrder;
	}

	public String save(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "";
	}

	public String update(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "";
	}

	public String delete(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "Huy");
		hoanthanhDao.save(hoanthanh);
		return "";
	}

	public Order findById(String id) {
		return null;
	}
	
	HoanThanhDAO hoanthanhDao;
	//hoanthanhOrder
	public void changeOrder(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "HoanThanh");
		hoanthanhDao.save(hoanthanh);
	}

}
