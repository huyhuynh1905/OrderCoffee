package com.ttcscn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ttcscn.entity.HoanThanh;

@Transactional
public class HoanThanhDAO implements Dao<HoanThanh> {

	@Autowired
	SessionFactory sessionHibernate;

	public List<HoanThanh> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<HoanThanh> arrHoanThanh = session.createQuery("from hoanthanh").getResultList();
		return arrHoanThanh;
	}

	public void save(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
	}

	public void update(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
	}

	public void delete(HoanThanh t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
	}

	public HoanThanh findById(String maOrder) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(HoanThanh.class, maOrder);
	}
	
	
}
