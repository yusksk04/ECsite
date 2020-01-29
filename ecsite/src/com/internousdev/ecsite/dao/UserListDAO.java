package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public List<UserInfoDTO> getUserInfo()throws SQLException{
		 List<UserInfoDTO> userListDTO = new ArrayList<UserInfoDTO>();
		 String sql = "SELECT * from login_user_transaction ORDER BY id ASC";

		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();

			 while(rs.next()){
				 UserInfoDTO dto=new UserInfoDTO();
				 dto.setId(rs.getString("id"));
				 dto.setUser_name(rs.getString("user_name"));
				 dto.setLogin_id(rs.getString("login_id"));
				 dto.setLogin_pass(rs.getString("login_pass"));
				 dto.setInsert_date(rs.getString("insert_date"));
				 dto.setAdmin_flg(rs.getString("admin_flg"));
				 System.out.println(rs.getString("id"));

				 userListDTO.add(dto);
			 }
		}catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 con.close();
		 }

		return userListDTO;
	}

	public int deleteUserInfo()throws SQLException{//削除しその数を返す
		String sql="DELETE FROM login_user_transaction WHERE admin_flg != 1 OR admin_flg IS NULL";//login_user_transactionのデータ全件削除
		int result =0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}



}
