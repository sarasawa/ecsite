package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	public ArrayList<ItemInfoDTO>getItemListinfo
	()throws SQLException{
		ArrayList<ItemInfoDTO>itemInfoDTO = new ArrayList<ItemInfoDTO>();
		
		String sql = "SELECT * FROM item_info_transaction ";
		try{
			PreparedStatement pre = connection.prepareStatement(sql);

			
			ResultSet resultSet = pre.executeQuery();
			
			while(resultSet.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getString("item_price"));
				dto.setItem_stock(resultSet.getString("item_stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));
				itemInfoDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
	}finally{
		connection.close();
	}
	return itemInfoDTO;
	
	}
}
