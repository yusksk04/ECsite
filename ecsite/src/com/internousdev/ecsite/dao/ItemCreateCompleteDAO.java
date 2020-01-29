package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;;

public class ItemCreateCompleteDAO {

	public void createItem(String createItemName,String createItemPrice,String createItemStock)throws SQLException{

		DateUtil dateUtil = new DateUtil();//????????
		DBConnector db= new DBConnector();
		Connection con= db.getConnection();

		String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date) VALUES(?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, createItemName);
			ps.setString(2, createItemPrice);
			ps.setString(3, createItemStock);
			ps.setString(4, dateUtil.getDate());//dateUtilから日付を取得してセット
			ps.execute();//executequeryはselectのときだけ

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
