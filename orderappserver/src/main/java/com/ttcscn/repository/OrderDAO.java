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

	public void save(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
	}

	public void update(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
	}

	public void delete(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "Huy");
		hoanthanhDao.save(hoanthanh);
	}

	public Order findById(String id) {
		return null;
	}
	@Autowired
	HoanThanhDAO hoanthanhDao;
	//hoanthanhOrder
	public void changeOrder(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "HoanThanh");
		hoanthanhDao.save(hoanthanh);
	}
	

}
