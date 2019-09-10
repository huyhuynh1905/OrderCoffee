package com.ttcscn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ttcscn.entity.Menu;

@Transactional
public class MenuDAO implements Dao<Menu>{
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Menu> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from menu";
		List<Menu> arrMenu = session.createQuery(sql).getResultList(); //Trả về một list còn chỉ 1 thì getSingleResult()
		return arrMenu;
	}

	public void save(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
	}

	public void update(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
	}

	public void delete(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
	}

	public Menu findById(String maThucUong) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(Menu.class, maThucUong);
	}

}
