package com.xnsy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xnsy.dao.IUserDAO;
import com.xnsy.model.User;

public class UserDAO implements IUserDAO{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User checkUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from User where username='"+user.getUsername()+"' and password='" + user.getPassword() + "'");
		User user1 = new User();
		List list = query.list();
		ts.commit();
		session.close();
		if(list.size() != 0) {
			user1=(User) list.get(0);
			return user1;
		}
		return null;
	}

}
