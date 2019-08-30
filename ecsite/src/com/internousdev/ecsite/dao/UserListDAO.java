package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	public ArrayList<UserInfoDTO>getUser_info()throws SQLException{
		ArrayList<UserInfoDTO>userInfoDTO = new ArrayList<UserInfoDTO>();
		
		String sql = "SELECT id, login_id, login_pass, user_name, insert_date FROM login_user_transaction";
		
		try{
			PreparedStatement pre = connection.prepareStatement(sql);
			
			ResultSet resultSet = pre.executeQuery();
			
			while(resultSet.next()){
				UserInfoDTO dto = new UserInfoDTO();
				
				dto.setId(resultSet.getString("id"));
				dto.setLogin_id(resultSet.getString("login_id"));
				dto.setLogin_pass(resultSet.getString("login_pass"));
				dto.setUser_name(resultSet.getString("user_name"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				userInfoDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
	}finally{
		connection.close();
	}
	return userInfoDTO;
	
	}

}
