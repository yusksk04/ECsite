package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	/**ドライバ名**/
	private static String driverName="com.mysql.jdbc.Driver";
	//データベース接続url
	private static String url="jdbc:mysql://localhost/ecsite";
	//ユーザ名
	private static String user="root";
	//パスワード
	private static String password="mysql";

	//接続状態にする
	public Connection getConnection(){
		//状態を初期化
		Connection con =null;
		try{
			Class.forName(driverName);
			con= (Connection)DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e){//クラスが見つからない場合
			e.printStackTrace();
		}catch(SQLException e){//データベース処理に関する例外
			e.printStackTrace();
		}
		return con;

	}


}
