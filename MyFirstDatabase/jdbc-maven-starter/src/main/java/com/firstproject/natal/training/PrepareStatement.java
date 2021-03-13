package com.firstproject.natal.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepareStatement {
	String qry;
	Connection dbCon;
	Statement theStatement;
	
	PrepareStatement(){
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
	
	public static void main( String[] args ) {
		
		Scanner theScanner = new Scanner(System.in);
		//1.Add new student. Uncomment to see
		//System.out.println("Please enter Name and Country: ");
		//new PrepareStatement().addNewStudent(theScanner.nextLine(), theScanner.nextLine());
		
		//2.Get student info
		System.out.println("Enter ID: " );
		int id = theScanner.nextInt();
		new PrepareStatement().getStudentInfo(id);
		
	}
	
	// Insert a new record inn the table:students using PreparedStatment 
	void addNewStudent(String studentName, String studentCountry) {
		//Write the query to insert
		qry="insert into students(studentName, studentCountry) values(?,?)";
		
		
		try {
			//Get a reference to the PreparedStatement
			PreparedStatement  thePreparedStatement =  dbCon.prepareStatement(qry);
			
			//Set the values for ?
			thePreparedStatement.setString(1, studentName);
			thePreparedStatement.setString(2, studentCountry);
			
			//Execute the query
			if(thePreparedStatement.executeLargeUpdate()>0)
				System.out.println("Record added");
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to PreparedStatement : " + e.getMessage());
		}
		
	}
	//Fetch all records from table:students
	void getStudentInfo(int id) {
		//Write the query
		qry= "select * from students where studentID = ?";
		
		//Get a reference to the PreparedStatement
		try {
			//Get a reference to the PreparedStatement
			PreparedStatement  thePreparedStatement =  dbCon.prepareStatement(qry);
			
			//Set the value for ?
			thePreparedStatement.setInt(1, id);
			
			//Execute the query
			ResultSet theResultSet = thePreparedStatement.executeQuery();
			
			//Traverse through results
			while(theResultSet.next()) {
				System.out.print("Name : " + theResultSet.getString("studentName") );
				System.out.println("Country : " + theResultSet.getString("studentCountry") );
			}
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to PreparedStatement : " + e.getMessage());
		}		
	}

}
