package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnector {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/ecsite";

	private static String user="root";
	private static String password="mysql";

	public Connection getConnection(){
//		DAOから来て処理を行う
		Connection con=null;
//		Connection型の変数conの初期値はnull;
	try{
		Class.forName(driverName);
//		DriverManagerを使う宣言
		con = DriverManager.getConnection(url,user,password);
//		conの中にDriverManagerのgetConnectionメソッドを引数url,user,passwordの引数で処理をする。その値をconの中にいれる
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
//		エラー内容をeの中にいれて表示する。
	}
	return con;
	}
}
// conを返す