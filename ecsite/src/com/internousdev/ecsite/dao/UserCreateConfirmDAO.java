package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	
	public boolean isExistUser(String loginUserId) {
		String sql = "SELECT COUNT(*) AS COUNT FROM login_user_transaction WHERE login_id = ?";
		boolean result = false;
		try{
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, loginUserId);
			ResultSet resultSet = pre.executeQuery();
			if(resultSet.next()){
				if(resultSet.getInt("COUNT") > 0){
				result = true;
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
