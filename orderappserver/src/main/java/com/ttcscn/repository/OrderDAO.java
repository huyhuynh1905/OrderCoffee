package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ttcscn.entity.Order;

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

	public void delete(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
	}

	public Order findById(String id) {
		return null;
	}
	

}
