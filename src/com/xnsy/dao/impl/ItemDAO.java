package com.xnsy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xnsy.dao.IItemDAO;
import com.xnsy.model.Item;

public class ItemDAO implements IItemDAO{
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getNewItem() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item order by itemid desc");
		query.setFirstResult(0);
		query.setMaxResults(8);
		List items = query.list();
System.out.println("lalalalal-----------------");
		ts.commit();
		session.close();
System.out.println(items);

		return items;
	}

	@Override
	public List getItemByCategoryidPaging(int categoryid, int currentPage,
			int pageSize) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item where categoryid = " + categoryid);
		int startRow = (currentPage-1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List items = query.list();
		session.close();
		return items;
	}

	@Override
	public int getTotalByCategory(int categoryid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item where categoryid = " + categoryid);
		List items = query.list();
		session.close();
		return items.size();
	}

	@Override
	public boolean addOrUpdateItem(Item item) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(item);
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public List getAllItem() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item order by categoryid desc");
		List items = query.list();
		
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		
		return items;
	}

	@Override
	public Item getItemById(int id) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item where itemid = " + id);
		List items = query.list();
		session.close();
		
		return (Item) items.get(0);
	}

	@Override
	public boolean deleteItemById(int id) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Item where itemid = " + id);
		List items = query.list();
		session.delete((Item)items.get(0));
		ts.commit();
		session.close();
		
		return true;
	}
		
}
