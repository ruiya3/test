package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
//	loginUseIdとloginPasswordはjspから来てActionSupportの機能でValueStackに入れられている。
	private String result;
	private Map<String,Object>session;
// フィールド↑メソッド↓
	public String execute(){
//	Actionクラスは司令塔、DTO,DAOなどは原本クラス
		LoginDAO loginDAO=new LoginDAO();
		LoginDTO loginDTO=new LoginDTO();
		BuyItemDAO buyItemDAO=new BuyItemDAO();
		result=ERROR;
//result初期値はERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);
//	loginDTOにloginDAOのgetLoginUserInfoのloginUserIdとloginPasswordの引数処理をおこない、値をいれる。LoginDTOが帰ってくる。
		session.put("loginUser", loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			return result;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {

		this.loginPassword = loginPassword;

		}
		public Map<String, Object> getSession() {

		return session;

		}
		public void setSession(Map<String, Object> session) {

		this.session = session;
		}
}
