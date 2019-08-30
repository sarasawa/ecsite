package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object>session;	
	private String message;
	private ItemListDeleteCompleteDAO itemDeleteDAO = new ItemListDeleteCompleteDAO();
	public String execute()throws SQLException{
		String result = ERROR;
		int res = itemDeleteDAO.itemListDelete();
		
		if(res > 0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報の削除を失敗しました。");
		}
		result = SUCCESS;
		return result;
	}
	
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
}
