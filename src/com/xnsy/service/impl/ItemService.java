package com.xnsy.service.impl;

import java.util.List;

import com.xnsy.dao.IItemDAO;
import com.xnsy.model.Item;
import com.xnsy.service.IItemService;

public class ItemService implements IItemService{
	
	private IItemDAO itemDAO;

	public IItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(IItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public List getNewItem() {
		return itemDAO.getNewItem();
	}

	@Override
	public List getItemByCategoryidPaging(int categoryid, int currentPage,
			int pageSize) {
		return itemDAO.getItemByCategoryidPaging(categoryid, currentPage, pageSize);
	}

	@Override
	public int getTotalByCategory(int categoryid) {
		return itemDAO.getTotalByCategory(categoryid);
	}

	@Override
	public boolean addOrUpdateItem(Item item) {
		return itemDAO.addOrUpdateItem(item);
	}

	@Override
	public List getAllItem() {
		
		return itemDAO.getAllItem();
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return itemDAO.getItemById(id);
	}

	@Override
	public boolean deleteItemById(int id) {
		return itemDAO.deleteItemById(id);
	}
	
	
}
