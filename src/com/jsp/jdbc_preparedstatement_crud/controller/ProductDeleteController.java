package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDeleteController {
	public static void main(String[] args) {

		Connection connection = null;

		try {
			// 1. Load Register
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			String deleteUpdateQuery = "delete from product where productid= ?";

			PreparedStatement preparedStatement = connection.prepareStatement(deleteUpdateQuery);

			preparedStatement.setInt(1, 100);
			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Date is deleted");
			} else {
				System.out.println("Given data is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}