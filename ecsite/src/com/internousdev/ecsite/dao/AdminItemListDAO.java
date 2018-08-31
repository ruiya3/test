package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.AdminItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AdminItemListDAO {
	private DBConnector dbConnector= new DBConnector ();
	private Connection connection=dbConnector.getConnection();

	public ArrayList<AdminItemListDTO>getAdminItemInfo()throws SQLException{
		 ArrayList<AdminItemListDTO>adminListDTO=new ArrayList<AdminItemListDTO>();
		 String sql="SELECT * FROM `item_info_transaction` ORDER BY id DESC";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			AdminItemListDTO dto = new AdminItemListDTO();
			dto.setId(resultSet.getString("id"));
			dto.setItemName(resultSet.getString("item_Name"));
			dto.setItemPrice(resultSet.getString("item_Price"));
			dto.setItemStock(resultSet.getString("item_Stock"));
			dto.setInsert_date(resultSet.getString("insert_date"));
			dto.setUpdate_date(resultSet.getString("update_date"));
			adminListDTO.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
			} finally {
			connection.close();
			}
			return adminListDTO;

			}

			public int buyItemHistoryDelete

			(String item_transaction_id, String user_master_id) throws SQLException {
				String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";

					PreparedStatement preparedStatement;
					int result =0;
					try {
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, item_transaction_id);
						preparedStatement.setString(2, user_master_id);
						result = preparedStatement.executeUpdate();

						} catch (SQLException e) {

						e.printStackTrace();
						} finally {
						connection.close();

						}
						return result;


		}
	}
