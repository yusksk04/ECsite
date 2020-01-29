package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	private DBConnector db=new DBConnector();
	private Connection con = db.getConnection();
	//商品情報のListをDBから取得
	public List<ItemInfoDTO> getItemInfo() throws SQLException{

		 List<ItemInfoDTO> itemListDTO = new ArrayList<ItemInfoDTO>();
		 String sql = "SELECT * from item_info_transaction ORDER BY id ASC";

		 try{
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();

			 while(rs.next()){
				 ItemInfoDTO dto=new ItemInfoDTO();
				 dto.setId(rs.getString("id"));
				 dto.setItemName(rs.getString("item_name"));
				 dto.setItemPrice(rs.getString("item_price"));
				 dto.setItemStock(rs.getString("item_stock"));
				 dto.setInsert_date(rs.getString("insert_date"));
				 itemListDTO.add(dto);
			 }
		}catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 con.close();
		 }

		return itemListDTO;
	}

	public int deleteItemInfo()throws SQLException{//削除しその数を返す
		String sql="DELETE FROM item_info_transaction";//item_info_transactionのデータ全件削除
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

	public int getItemStock(String item_id) throws SQLException{
		int result =-1;
		con = db.getConnection();
		String sql ="SELECT item_stock FROM item_info_transaction where id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(Integer.parseInt(rs.getString("item_stock")));
			result = Integer.parseInt(rs.getString("item_stock"));
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return result;
	}



}
