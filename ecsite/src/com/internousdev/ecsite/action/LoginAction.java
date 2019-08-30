package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware {
	
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object>session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	
	public String execute(){
		String result = ERROR;
		//loginDAOにIDとPASSを送ってDBと確認している。
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			session.put("login_user_id", loginDTO.getId());
			//管理者でログインする
			if((((LoginDTO)session.get("loginUser")).getAdminFlg() !=null)
					&& (((LoginDTO)session.get("loginUser")).getAdminFlg().equals("2"))){
				session.put("adminFlg", 2);
				result = "login";
			}else{
				result = SUCCESS;
			}
		}
		
	return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}

}
