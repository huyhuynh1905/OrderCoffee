package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ttcscn.entity.Order;

@Repository("orderDao")
public class OrderDAO implements Dao<Order> {
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Order> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<Order> arrOrder = session.createQuery("from ordertab").getResultList();
		return arrOrder;
	}
	
	//
	public List<Order> chuaOder() {
		Session session = sessionHibernate.getCurrentSession();
		List<Order> arrOrder = session.createQuery("from ordertab where tinhTrang = 1").list();
		return arrOrder;
	}
	public List<Order> getListWithId(String maOrder, String maBan) {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from ordertab where maOrder = '"+maOrder+"' and maBan = '"+maBan+"'";
		System.out.println(sql);
		List<Order> arrOrder = session.createQuery(sql).getResultList();
		return arrOrder;
	}

	public String save(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Đặt thành công!";
	}

	public String update(String maOrder, String maBan,String nguoiOrder) {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "update ordertab set tinhTrang = 0 , nguoiOrder = '"+nguoiOrder+"' where maOrder = '"+maOrder+"' and maBan = '"+maBan+"'";
		System.out.println(sql);
		int result = session.createQuery(sql).executeUpdate();
		return "Success!";
	}

	public String delete(String maOrder, String maBan) {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "delete ordertab where maOrder = '"+maOrder+"' and maBan = '"+maBan+"'";
		System.out.println(sql);
		int result = session.createQuery(sql).executeUpdate();
		return "Success!";
	}

	public Order findById(String maOrder) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(Order.class, maOrder);
	}

	public String update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

}
