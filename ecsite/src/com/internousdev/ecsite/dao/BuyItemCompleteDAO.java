package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
				con.close();

		}
	}

	public void buyItemUpdate(String item_transaction_id,String total_count) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String item_stock="";
		int update_stock;
		//まず現在の個数を取得
		String sql = "SELECT item_stock from item_info_transaction where id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				item_stock=rs.getString("item_stock");
			}
			//反映するストック数
			update_stock=Integer.parseInt(item_stock)-Integer.parseInt(total_count);
			//Itemstockを更新する
			sql = "UPDATE item_info_transaction set item_stock = ? ,update_date= ? where id = ?";//SQL文の更新
			ps = con.prepareStatement(sql);
			ps.setString(1, String.valueOf(update_stock));
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, item_transaction_id);
			ps.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}



	}

}
