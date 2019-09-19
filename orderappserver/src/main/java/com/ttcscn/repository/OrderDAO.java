package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttcscn.entity.HoanThanh;
import com.ttcscn.entity.Order;

@Repository("orderDao")
public class OrderDAO implements Dao<Order> {
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Order> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<Order> arrOrder = session.createQuery("from taborder").getResultList();
		return arrOrder;
	}

	public String save(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Đặt thành công!";
	}

	public String update(Order t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "Cập nhật Order thành công";
	}

	public String delete(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "Huy");
		hoanthanhDao.save(hoanthanh);
		return "Xóa thành công";
	}

	public Order findById(String maOrder) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(Order.class, maOrder);
	}
	
	HoanThanhDAO hoanthanhDao;
	//hoanthanhOrder
	public void changeOrder(Order order) {
		HoanThanh hoanthanh = new HoanThanh(order.getMaOrder(), order.getDonGiaOrder(), "HoanThanh");
		hoanthanhDao.save(hoanthanh);
	}

}
