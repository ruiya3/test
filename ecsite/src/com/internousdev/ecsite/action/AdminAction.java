package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AdminDAO;
import com.internousdev.ecsite.dto.AdminDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private AdminDAO adminDAO=new AdminDAO();
	private ArrayList<AdminDTO>adminList=new ArrayList<AdminDTO>();
	private String deleteFlg;
	private String message;

	public String execute()throws SQLException{
		if(!session.containsKey("")){
			return ERROR;
		}
		if(deleteFlg==null){
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			adminList=adminDAO.getAdminUserInfo(item_transaction_id,user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}
		public void delete() throws SQLException{
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();

			int res=adminDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

			if(res>0){
				adminList=null;
				setMessage("商品情報を正しく削除しました。");
			}else if(res==0){
				setMessage("商品情報の削除に失敗しました。");
				}
		}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public ArrayList<AdminDTO>getadminList(){
		return this.adminList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}