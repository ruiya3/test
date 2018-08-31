package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AdminItemAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemAddCompleteAction extends ActionSupport implements SessionAware{
	private String ItemId;
	private String ItemName;
	private String ItemPrice;
	private String ItemCount;
	public Map<String,Object> session;
	private AdminItemAddCompleteDAO adminItemAddCompleteDAO=new AdminItemAddCompleteDAO();

	public String execute()throws SQLException{
		adminItemAddCompleteDAO.AdminItemAdd(
				session.get("ItemId").toString(),
				session.get("ItemName").toString(),
				session.get("ItemPrice").toString(),
				session.get("ItemCount").toString());
		String result=SUCCESS;
		return result;
	}

	public String getItemId() {
		return ItemId;
	}

	public void setItemId(String itemId) {
		ItemId = itemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(String itemPrice) {
		ItemPrice = itemPrice;
	}

	public String getItemCount() {
		return ItemCount;
	}

	public void setItemCount(String itemCount) {
		ItemCount = itemCount;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AdminItemAddCompleteDAO getAdminItemAddCompleteDAO() {
		return adminItemAddCompleteDAO;
	}

	public void setAdminItemAddCompleteDAO(AdminItemAddCompleteDAO adminItemAddCompleteDAO) {
		this.adminItemAddCompleteDAO = adminItemAddCompleteDAO;
	}


}