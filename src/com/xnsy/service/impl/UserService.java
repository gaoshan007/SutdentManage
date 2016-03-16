package com.xnsy.service.impl;

import com.xnsy.dao.IUserDAO;
import com.xnsy.model.User;
import com.xnsy.service.IUserService;

public class UserService implements IUserService{
	
	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User checkUser(User user) {
		return userDAO.checkUser(user);
	}
	
}
