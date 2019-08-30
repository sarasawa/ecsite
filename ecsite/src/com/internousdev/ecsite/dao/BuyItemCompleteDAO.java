package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {
	
	public void buyItemInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String item_name, String pay)
	throws SQLException{
		
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, item_name, pay, insert_date)VALUES(?,?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, item_name);
			preparedStatement.setString(6, pay);
			preparedStatement.setString(7, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
			}
		}
	
	public void itemInfo(String item_stock, String id)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE item_info_transaction SET item_stock = ? WHERE id = ?";
		try{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, item_stock);
		preparedStatement.setString(2, id);
		preparedStatement.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
	}
}
