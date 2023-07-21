package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {
	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			// Step-1: Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2:Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";

			// throw SQLException i.e. Checked Exception
			connection = DriverManager.getConnection(url, user, pass);
			
			String displayQuery="Select * from product";
			
			PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id= resultSet.getInt("productid");
				String name= resultSet.getString("productname");
				double price= resultSet.getDouble("productprice");
				String color=  resultSet.getString("productcolor");	
			
//			System.out.println(resultSet.next());
			System.out.println("id="+id);
			System.out.println("name="+name);
			System.out.println("price="+price);
			System.out.println("color="+color);
			
			System.out.println("####################");
			System.out.println("");
			}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}}
