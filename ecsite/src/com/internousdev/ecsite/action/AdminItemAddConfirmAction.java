package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AdminItemAddConfirmAction extends ActionSupport implements SessionAware{
	private String ItemId;
	private String ItemName;
	private String ItemPrice;
	private String ItemCount;
	public Map<String,Object> session;

	public String execute(){
		String result=SUCCESS;
			session.put("ItemId", ItemId);
			session.put("ItemName",ItemName);
			session.put("ItemPrice", ItemPrice);
			session.put("ItemCount", ItemCount);


	return result;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getItemId() {
		return ItemId;
	}

	public void setItemId(String itemId) {
		ItemId = itemId;
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
}


