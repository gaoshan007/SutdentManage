package com.xnsy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryid;
	private String categoryname;
	private Set items = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String categoryname, Set items) {
		this.categoryname = categoryname;
		this.items = items;
	}

	// Property accessors

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}