package com.xnsy.service;

import java.util.List;

import com.xnsy.model.Item;

public interface IItemService {
	
	public List getNewItem();
	public List getItemByCategoryidPaging(int categoryid, int currentPage, int pageSize);
	public int getTotalByCategory(int categoryid);
	public boolean addOrUpdateItem(Item item);
	public List getAllItem();
	public Item getItemById(int id);
	public boolean deleteItemById(int id);
	
}
