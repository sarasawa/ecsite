package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport {
	private String login_id;
	public String execute(){
		return SUCCESS;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	

}
