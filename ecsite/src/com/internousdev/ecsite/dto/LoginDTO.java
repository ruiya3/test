package com.internousdev.ecsite.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean AdminId;
	private boolean loginFlg;


	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}
	public String getLoginId(){
		return loginId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void  setAdminId(boolean AdminId){
		this.AdminId=AdminId;
	}
	public boolean getAdminId(){
		return AdminId;
	}


}
