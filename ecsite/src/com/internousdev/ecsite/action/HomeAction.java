package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware {
	public Map<String, Object>session;
	private String message;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO>itemList = new ArrayList<ItemInfoDTO>();
	public String execute() throws SQLException{
		String result = "login";
		//ログイン状態の確認
		//ログインしていたら商品情報をbuyItemDTOから持ってきて格納している。
		if(session.containsKey("login_user_id")){
			itemList = itemListDAO.getItemListinfo();
			result = SUCCESS;
		}else{
			 setMessage("商品情報がありません");
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
	public Map<String, Object>getSEssion(){
		return this.session;
	}
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
