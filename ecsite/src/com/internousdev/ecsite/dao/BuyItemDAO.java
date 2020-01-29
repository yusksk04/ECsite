package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){

		DBConnector db=new DBConnector();
		Connection con = db.getConnection();//db接続

		BuyItemDTO buyItemDTO =new BuyItemDTO();

		String sql="select id,item_name,item_price from item_info_transaction";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){//ここでは商品情報をひとつしか取得しない
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));


			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}


}
