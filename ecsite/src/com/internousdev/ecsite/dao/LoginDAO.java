package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		DBConnector db=new DBConnector();
		Connection con = db.getConnection();//db接続

		LoginDTO loginDTO =new LoginDTO();//取得した結果入れる
		//sql文作成
		String sql ="select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,loginPassword);


			ResultSet rs =ps.executeQuery();//execute実行
			System.out.println("てすと");


			if(rs.next()){//取得した行が1行以上あるなら
				System.out.println("つうか");
				loginDTO.setLoginId(rs.getString("login_id"));//databaseでの名前で指定
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				loginDTO.setAdmin_flg(rs.getString("admin_flg"));
				if(rs.getString("login_id")!=null){//login_idが取得できているなら
					loginDTO.setLoginFlg(true);//loginフラグtrue
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
