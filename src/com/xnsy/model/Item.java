package com.xnsy.model;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer itemid;
	private Category category;
	private String itemname;
	private String picture;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	public Item(Category category, String itemname, String picture) {
		this.category = category;
		this.itemname = itemname;
		this.picture = picture;
	}

	// Property accessors

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}