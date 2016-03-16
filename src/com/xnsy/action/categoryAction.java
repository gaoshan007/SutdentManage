package com.xnsy.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xnsy.model.Item;
import com.xnsy.service.ICategoryService;
import com.xnsy.service.IItemService;
import com.xnsy.util.Pager;
import com.xnsy.util.uploadzp;

public class categoryAction extends ActionSupport{
	private ICategoryService categoryService;
	private IItemService itemService;
	private int categoryid;
	private int currentPage = 1;
	private Item item;
	private String picture;
	private File upload;
	private String uploadFileName;
	private int itemid;
	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public IItemService getItemService() {
		return itemService;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	/*查看学生作品分配的action方法*/
	public String browseCategory() throws Exception {
		List categorys = categoryService.getAllCategorys();
System.out.println("laaaaaaaaaaaaaa-------");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("categorys", categorys);
		return SUCCESS;
	}
	
	/*查看新添加的学生作品的action方法*/
	public String browseNewItem() throws Exception {
		List newitems = itemService.getNewItem();
System.out.println("hehehehehehe--------");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("newitems", newitems);
		return SUCCESS;		
	}
	
	/*分页查看学生作品的action方法*/
	public String brwoseItemPaging() throws Exception {
		int totalSize = itemService.getTotalByCategory(categoryid);
		Pager page = new Pager(currentPage, totalSize);
		List items = itemService.getItemByCategoryidPaging(categoryid, currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("items", items);
		request.put("page", page);
System.out.println("pageing***********");
		return SUCCESS;
	}
	
	public String addOrUpdateItem() throws Exception{
		String path=ServletActionContext.getServletContext().getRealPath("/pic");
		System.out.println(path);
		List list = itemService.getNewItem();
		Item item1 = (Item) list.get(0);
		int currentItemId = item1.getItemid() + 1;
		path = path + "\\" + currentItemId + this.getUploadFileName();
		new uploadzp().upload(this.getUpload(), path);
		item.setPicture(currentItemId + this.getUploadFileName());
		Item item2 = new Item();
		item2.setCategory(item.getCategory());
		item2.setItemname(item.getItemname());
		if(item.getPicture()==null)
			item2.setPicture(picture);
		else
			item2.setPicture(item.getPicture());
			item2.setItemid(item.getItemid());
		if(itemService.addOrUpdateItem(item2))
			return SUCCESS;
		else
			return ERROR;
		
	}
	
	public String browseAllItemPaging() throws Exception {
		List items = itemService.getAllItem();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("items", items);
		return SUCCESS;
				
	}
	
	public String displayOneItem() throws Exception {
		Item modifyItem = itemService.getItemById(itemid);
		System.out.println("modify");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("flower", modifyItem);
		return SUCCESS;
	}
	
	public String deleteOneItem() throws Exception {
		itemService.deleteItemById(itemid);
		System.out.println("delete");
		return SUCCESS;
	}
	
}
