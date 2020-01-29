package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;
public class ItemDetailsDAO  {
	private ItemInfoDTO itemInfoDTO =new ItemInfoDTO();
	private DBConnector db = new DBConnector();
	private Connection con =db.getConnection();

	public ItemInfoDTO getItemDetailInfo(String item_id) throws SQLException{
		String sql = "SELECT * FROM item_info_transaction WHERE id=?";

		try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, item_id);
			 ResultSet rs = ps.executeQuery();

			 if(rs.next()){
				 itemInfoDTO.setId(rs.getString("id"));
				 itemInfoDTO.setItemName(rs.getString("item_name"));
				 itemInfoDTO.setItemPrice(rs.getString("item_price"));
				 itemInfoDTO.setItemStock(rs.getString("item_stock"));
				 itemInfoDTO.setInsert_date(rs.getString("insert_date"));
				 itemInfoDTO.setUpdate_date(rs.getString("update_date"));


			 }
		}catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 con.close();
		 }
		return itemInfoDTO;
	}
	public int deleteItem(String item_id)throws SQLException{
		int result=0;
		String sql="DELETE FROM item_info_transaction where id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_id);
			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
