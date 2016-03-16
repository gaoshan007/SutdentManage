package com.xnsy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xnsy.dao.ICategoryDAO;

public class CategoryDAO implements ICategoryDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getAllCategorys() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Category");
		List categorys = query.list();
		ts.commit();
		session.close();
System.out.println("nenenenene--------");
		return categorys;		
	}
	
	
}
