package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductUpdateController {
	
	public static void main(String[] args) {
		Connection connection= null;
		
		
		try{
			//1. Load Register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="root";


			connection = DriverManager.getConnection(url, user, pass);
			
			//3. create statement
			String updateColorQuery="update product set productcolor=? Where productid=?";
			
			PreparedStatement preparedStatement= connection.prepareStatement(updateColorQuery);
			
			preparedStatement.setString(1, "white");
			preparedStatement.setInt(2, 100);
			
			int a= preparedStatement.executeUpdate();
			
			if(a==1) {
				System.out.println("Date is updated");
			}else {
				System.out.println("Given data is not present");
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
