package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttcscn.entity.HoanThanh;

@Repository("hoanthanhDao")
public class HoanThanhDAO implements Dao<HoanThanh> {

	@Autowired
	SessionFactory sessionHibernate;

	public List<HoanThanh> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<HoanThanh> arrHoanThanh = session.createQuery("from hoanthanh").getResultList();
		return arrHoanThanh;
	}

	public String save(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Thêm thành công!";
	}

	public String update(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "Update thành công!";
	}

	public String delete(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
		return "Xoá thành công!";
	}

	public HoanThanh findById(String maDaOrder) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(HoanThanh.class, maDaOrder);
	}
	
	
}
