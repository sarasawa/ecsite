package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	
	public BuyItemDTO getBuyItemInfo(){
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				//取得したデータをDTOに格納
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
	public BuyItemDTO getItemInfo(int Id){
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction WHERE id = ?";
		
		try{
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, Id);
			ResultSet res = pre.executeQuery();
			while(res.next()){
				buyItemDTO.setId(res.getInt("id"));
				buyItemDTO.setItemName(res.getString("item_name"));
				buyItemDTO.setItemPrice(res.getString("item_price"));
				buyItemDTO.setItemStock(res.getString("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
}
