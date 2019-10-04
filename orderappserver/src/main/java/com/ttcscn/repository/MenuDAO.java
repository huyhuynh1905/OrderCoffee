package com.ttcscn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttcscn.entity.Menu;

@Repository("menuDao")
public class MenuDAO implements Dao<Menu>{
	
	@Autowired
	SessionFactory sessionHibernate;

	public List<Menu> getAll() {
		Session session = sessionHibernate.getCurrentSession();
		String sql = "from menu";
		List<Menu> arrMenu = session.createQuery(sql).getResultList(); //Trả về một list còn chỉ 1 thì getSingleResult()
		return arrMenu;
	}

	public String save(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.save(t);
		return "Success";
	}

	public String update(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.update(t);
		return "Success";
	}

	public String delete(Menu t) {
		Session session = sessionHibernate.getCurrentSession();
		session.remove(t);
		return "Success";
	}

	public Menu findById(String maThucUong) {
		Session session = sessionHibernate.getCurrentSession();
		return session.get(Menu.class, maThucUong);
	}

}
