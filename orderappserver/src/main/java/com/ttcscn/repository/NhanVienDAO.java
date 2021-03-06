package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttcscn.entity.NhanVien;

@Repository("nhanvienDao")
public class NhanVienDAO implements Dao<NhanVien>{
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<NhanVien> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		List<NhanVien> arrNv = session.createQuery("from nhanvien").getResultList();
		return arrNv;
	}

	public String save(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Success";
	}

	public String update(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "Success";
	}

	public String delete(NhanVien t) {
		Session session = sessionHibernate.getCurrentSession();
		session.delete(t);
		return "Success";
	}

	public NhanVien findById(String username) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(NhanVien.class, username);
	}
	
	public boolean loginToServer(String username,String password) {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from nhanvien where username = '"+username+"' and password = '"+password+"'";
		List<NhanVien> nv = session.createQuery(sql).getResultList();
		if(nv.size()>0) {
			return true;
		} else return false;
	}

}
