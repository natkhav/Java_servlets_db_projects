package com.firstproject.natal.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseUpdatableResults {
	
	String qry;
	Connection dbCon;
	Statement theStatement;
	
	UseUpdatableResults(){
		try {
    		//Define the URL to connect
    		String urlToConnect = "jdbc:mysql://localhost:3306/my_first_database";
    		
    		//Define the username for db to connect
    		String dbUserName= "root";
    		
    		//Define the password
    		String dbUserPassword = "";
    		
    		//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Try to establish the connection to DB
			dbCon =DriverManager.getConnection(urlToConnect, dbUserName, dbUserPassword);
					
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getLocalizedMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect DB database : " + e.getLocalizedMessage());
		}    	
    }

	public static void main(String[] args) {
		
		new UseUpdatableResults().fetchAndUpdate();

	}

	void fetchAndUpdate() {
		// Write the query to fetch records from the table:students
		qry = "select*from students";
		
		
		try {
			//Get a reference to the PreparedStatement
			PreparedStatement pstmt = dbCon.prepareStatement(qry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Execute the query
			ResultSet theResultSet = pstmt.executeQuery();
			
			//Traverse through the results
			while(theResultSet.next()) {
				if(theResultSet.getInt("studentID") == 2) {
					//Update the current student
					theResultSet.updateString("studentName", theResultSet.getString("studentName")+ " Chan");
					
					//Commit the change
					theResultSet.updateRow();
					System.out.println("Name was updated...");
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to PreparedStatement : " + e.getMessage());
			

			

		}
		
	}
}
