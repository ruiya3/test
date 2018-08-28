package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
//		Actionから来て処理を行う

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
//		DBConnectorをインスタン化してgetConnectionメゾットを実行する。変数conが帰ってきてconnectionの中にはいる。これでデータベースへの道ができる。
		LoginDTO loginDTO=new LoginDTO();
//　LoginDTOをインスタンス化
		String sql="SELECT*FROM login_user_transaction where login_id=? AND login_pass=?";
//　SELECT文を文字列として変数sqlに入れる。
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//　connectionのpreparedStatementメソッドをsql変数で処理をしてpreparedStatementに入れる、上でいれたSELECT文が入り?に代入できるようになる。

			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);
//	preparedStatementのsetStringメゾットで?に順番を参照して入れる値を決める。
//　ここのloginUserIdとloginPasswordは呼び出し元の値を入れて行う。

			ResultSet resultSet=preparedStatement.executeQuery();
// executeQueryはSELECT文をjavaで行うための実行文、sql文のテーブルを表みたいな形で呼び出し矢印を備えているイメージ。

			if(resultSet.next()){
//				resultSetのnextメゾットで矢印を↓に移動していく。
				 loginDTO.setLoginId(resultSet.getString("login_id"));
				 loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				 loginDTO.setUserName(resultSet.getString("user_name"));
//	かっこの中はresultSetのgetStringメソッドでテーブルの中の各カラムを参照する。
//  loginDTO.setLoginId(internous) loginDTO.setLoginpassword(internous01) loginDTOsetUserName(test)
//上記のようになりLoginDTOにセッターでセットされていく。

				 if(!(resultSet.getString("login_id").equals(null))){
					 loginDTO.setLoginFlg(true);
//　値が入っていればDTOのflgに値trueを入れる
				 }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
// loginDTOを返す
	}
}
