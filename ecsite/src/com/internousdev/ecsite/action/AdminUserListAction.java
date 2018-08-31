package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AdminUserListDAO;
import com.internousdev.ecsite.dto.AdminUserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private AdminUserListDAO AdminUserDAO=new AdminUserListDAO();
	private ArrayList<AdminUserListDTO>adminUserListDTO=new ArrayList<AdminUserListDTO>();
	private String deleteFlg;
	private String message;

	public String execute()throws SQLException{
		if(!session.containsValue("ad")){
			return ERROR;
		}
		if(deleteFlg==null){
			adminUserListDTO=AdminUserDAO.getAdminUserInfo();

		}
		else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}
		public void delete() throws SQLException{
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();

			int res=AdminUserDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

			if(res>0){
				setAdminUserListDTO(null);
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

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public ArrayList<AdminUserListDTO> getAdminUserListDTO() {
		return adminUserListDTO;
	}
	public void setAdminUserListDTO(ArrayList<AdminUserListDTO> adminUserListDTO) {
		this.adminUserListDTO = adminUserListDTO;
	}
	public AdminUserListDAO getAdminUserDAO() {
		return AdminUserDAO;
	}
	public void setAdminUserDAO(AdminUserListDAO adminUserDAO) {
		AdminUserDAO = adminUserDAO;
	}
}