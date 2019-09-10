package com.ttcscn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ttcscn.entity.NhanVien;

@Transactional
public class NhanVienDAO implements Dao<NhanVien>{
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<NhanVien> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<NhanVien> arrNv = session.createQuery("from nhanvien").getResultList();
		return arrNv;
	}

	public void save(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
	}

	public void update(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
	}

	public void delete(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.delete(t);
	}

	public NhanVien findById(String username) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(NhanVien.class, username);
	}

}
