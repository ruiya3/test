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
	private AdminDAO AdminDAO=new AdminDAO();
	private ArrayList<AdminDTO>adminList=new ArrayList<AdminDTO>();
	private String deleteFlg;
	private String message;

	public String execute()throws SQLException{
		if(!session.containsKey("login_user_id".equals("ad"))){
			return ERROR;
		}
		if(deleteFlg==null){
			adminList=AdminDAO.getAdminUserInfo();

			System.out.println(adminList.get(0));
	        System.out.println(adminList.get(1));
	        System.out.println(adminList.get(2));

		}
//		else if(deleteFlg.equals("1")){
//			delete();
//		}
		String result=SUCCESS;
		return result;
	}
//		public void delete() throws SQLException{
//			String item_transaction_id=session.get("id").toString();
//			String user_master_id=session.get("login_user_id").toString();
//
//			int res=AdminDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
//
//			if(res>0){
//				adminList=null;
//				setMessage("商品情報を正しく削除しました。");
//			}else if(res==0){
//				setMessage("商品情報の削除に失敗しました。");
//				}
//		}
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