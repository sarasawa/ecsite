package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemListAction extends ActionSupport implements SessionAware {
	public Map<String, Object>session;
	private int Id;
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private String errorMessage;
	public String execute()throws SQLException{
		
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		buyItemDTO = buyItemDAO.getItemInfo(Id);
		String result = ERROR;
		if(!(buyItemDTO == null)){
			session.put("id", buyItemDTO.getId());
			session.put("itemname", buyItemDTO.getItemName());
			session.put("itemprice", buyItemDTO.getItemPrice());
			session.put("item_ss", buyItemDTO.getItemStock());
			result = SUCCESS;
		}else{
			setErrorMessage("商品がありません");
			result = ERROR;
		}
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}