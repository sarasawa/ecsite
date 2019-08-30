package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {
	
	public Map<String, Object>session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserInfoDTO>userList = new ArrayList<UserInfoDTO>();
	
	public String execute()throws SQLException{
		userList = userListDAO.getUser_info();
		String result = SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}
	public ArrayList<UserInfoDTO>getUserList(){
		return this.userList;
	}
}
