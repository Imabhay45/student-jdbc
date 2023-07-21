package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/* 
 * @author Daksh
 */
//	disadvantage of throw keyword
//it carry forward the exception and it need to handle where called. exeception propagation

public class ProductInsertController {

	public static void main(String[] args) {

		Connection connection = null;

		try {
			// Step-1: Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2:Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";

			// throw SQLException i.e. Checked Exception
			connection = DriverManager.getConnection(url, user, pass);

			String insertQuery = "insert into product values(?,?,?,?)";

			// Step-3: Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			// Step-4: Execute Query

			preparedStatement.setInt(1, 103);
			preparedStatement.setString(2, "Book");
			preparedStatement.setDouble(3, 45000);
			preparedStatement.setString(4, "Green");

			preparedStatement.execute();
			
/*			if(a=1) {
				System.out.println("Data Inserted");
			}
			else {
				System.out.println("Duplicate data!!");
			}
*/			
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// Step-5 Close connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
}
