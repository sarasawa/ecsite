package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
	
	private String item_name;
	private String item_price;
	private String item_stock;
	public  Map<String, Object>session;
	private String errorMessage;
	public String execute(){
		String result = SUCCESS;
		
		
		if(!(item_name.equals(""))
				&&!(item_price.equals(""))
				&&!(item_stock.equals(""))){
			session.put("item_name", item_name);
			session.put("item_price", item_price);
			session.put("item_stock", item_stock);
			
			try{
				Integer.parseInt(item_price);
				Integer.parseInt(item_stock);
			}catch(NumberFormatException e){
				setErrorMessage("値段または在庫に数値以外が入力されています");
				result = ERROR;
			}
		}else{
			setErrorMessage("未記入の項目があります");
			result = ERROR;
		}
		
		return result;
	}

	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	public String getItem_price() {
		return item_price;
	}



	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}



	public String getItem_stock() {
		return item_stock;
	}



	public void setItem_stock(String item_stock) {
		this.item_stock = item_stock;
	}



	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
		// TODO 自動生成されたメソッド・スタブ
		
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
