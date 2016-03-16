package com.xnsy.action;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xnsy.model.User;
import com.xnsy.service.IUserService;

public class userAction extends ActionSupport{
	
	private User user;
	private IUserService userService;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String checkUser() throws Exception
	{
		Map session=(Map) ActionContext.getContext().getSession(); 
		User user1=userService.checkUser(user);
//System.out.println(user1.getUsername());
		if(user1!=null)	{
			session.put("user",user1);
			//((java.util.Map<String, User>) session).put("user",user1);
System.out.println("CheckUser-------------------");
			return SUCCESS;	
		}
		else
			return ERROR;
	}
	
	public String logOut() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	
}
