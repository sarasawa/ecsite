package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	
	public Map<String, Object>session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	
	public String execute() throws SQLException{
		buyItemCompleteDAO.buyItemInfo(
				//id,user_idはloginActionから取得
				//total_price,count,payはBuyItemActionから取得
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("itemname").toString(),
				session.get("pay").toString());
		//下のメソッドの起動に使用
		stock();
	
		String result = SUCCESS;
		return result;
		
	}
	
	public String stock() throws SQLException{
		buyItemCompleteDAO.itemInfo(
				session.get("total_Stock").toString(),
				session.get("id").toString());
		
		String result = SUCCESS;
		return result;
	}

	
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}

}
