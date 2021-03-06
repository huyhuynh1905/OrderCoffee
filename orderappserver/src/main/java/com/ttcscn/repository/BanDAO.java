package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Ban;

@Repository("banDao")
public class BanDAO implements Dao<Ban> {
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Ban> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from ban";
		List<Ban> arrBan = session.createQuery(sql).getResultList(); //Trả về một list còn chỉ 1 thì getSingleResult()
		return arrBan;
	}

	public String save(Ban t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Success";
	}

	public String update(Ban t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "Success";
	}

	public String delete(Ban t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
		return "Success";
	}

	public Ban findById(String maBan) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(Ban.class, maBan);
	}

}
