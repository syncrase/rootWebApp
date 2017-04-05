package com.root.databases.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLDemo {

	public static void main(String[] args) {
		MySQLDemo d = new MySQLDemo();
		// d.pushTaggedUrl(new Model("toto"));
		d.pullAllDemo();
	}

	/**
	 * @param taggedUrlsList
	 * @param statement
	 * @throws SQLException
	 */
	private void pullAllDemo() {
		ArrayList<Model> modelList = new ArrayList<Model>();
		Query query = new Query();
		query.setSelect("*");
		query.setFrom(DBInfo.DBName + ".model");
		ResultSet resultSet;
		try {
			resultSet = DBConnection.executeQuery(query.getQuery());
			Model model;
			// Get url
			while (resultSet.next()) {
				model = new Model();
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				modelList.add(model);
				System.out.println(model.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}

	}

	/**
	 * For now, just insert url in the database. Do not handle tags yet.
	 * 
	 * @param url
	 * @param tags
	 * @return
	 */
	public int pushTaggedUrl(Model model) {
		try {
			Connection connection = DBConnection.getConnection();
			// Insert the url
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into " + DBInfo.DBName + ".model (name) values (?)");
			preparedStatement.setString(1, model.getName());
			preparedStatement.executeUpdate();

			// Get the id of the last inserted row
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id FROM model ORDER BY id DESC LIMIT 1");
			resultSet.next();
			model.setId(resultSet.getInt("id"));

		} catch (Exception e) {
			System.out.println(e.getClass() + ": " + e.getMessage());
			// System.out.println(e.getStackTrace());
		} finally {
			DBConnection.close();
		}
		return model.getId();
	}
}
