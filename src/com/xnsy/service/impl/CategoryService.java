package com.xnsy.service.impl;

import java.util.List;

import com.xnsy.dao.ICategoryDAO;
import com.xnsy.service.ICategoryService;

public class CategoryService implements ICategoryService{
	private ICategoryDAO categoryDAO;

	public ICategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List getAllCategorys() {
		return categoryDAO.getAllCategorys();
	}
	
}
