package com.firstproject.natal.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
	String qry;
	Connection dbCon;
	Statement theStatement;
	
	App(){
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
			
			//Connection dbCon =DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_database", "root", "");
			//System.out.println("Succesfully connected...");
			
	    	//Get a reference to  the Statement
			theStatement = dbCon.createStatement();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getLocalizedMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect DB database : " + e.getLocalizedMessage());
		}    	
    }
	
	
    public static void main( String[] args ) {
    	
    	//1. Get all records method. Uncomment to see results
    	//new App().getAllRecords();
    	
    	//2. Look for records by ID number from runtime. Uncomment to see result
    	//System.out.println("Please enter the ID: "); 	
    	//int id = new Scanner(System.in).nextInt();
    	//new App().getStudentDetailsById(id);
    	
    	//3. Add new student/hard coded. Uncomment to see results
    	//new App().addNewStudent();
    	
    	//4. Add new student using runtime. 
    	System.out.println("Please enter student Name and Country: ");
    	Scanner theScanner = new Scanner(System.in);
    	String stName =theScanner.nextLine();
    	String stCountry =theScanner.nextLine();
    	
    	new App().addNewStudentFromRuntime(stName, stCountry);
    	
    	
    }
       	
    
    //Get all records from table:students    
    void getAllRecords(){
    	
    //Write the query to fetch all rows from table:lstudents
    qry="select * from students";
    
    
    try {		
		//Execute the query
		ResultSet theResultSet = theStatement.executeQuery(qry);
		
		//Traverse through the results
		while(theResultSet.next()) {
			System.out.print("Name : " + theResultSet.getString("studentName"));
			System.out.print(" , ID : " + theResultSet.getInt("studentID"));
			System.out.print(" , Country : " + theResultSet.getString("studentCountry"));
			
		}
						
	} catch (SQLException e) {
		System.out.println("Can't get a reference to Statement : " + e.getMessage());
	}
 }
    
    // Get Student details for a particular ID
    void getStudentDetailsById(int id) {
    	// Write the query to fetch details from table:students
    	qry = " select * from students where studentID = " + id;
    	
    	
    	try {
    		//Execute the query
			ResultSet theResultSet = theStatement.executeQuery(qry);
			
			//Traverse through the results
			while(theResultSet.next()) {
				System.out.println("Name : " + theResultSet.getString("studentName") + ", Country : " + theResultSet.getString("studentCountry"));
			}
			
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}   	
    }
    // Add a new student to the table:students
    void addNewStudent() {
    	// Write a query to insert a new record
    	qry = "insert into students(studentName, studentCountry) values ('Emma Moore', 'England')";
    	//Execute the query
    	try {
			int result = theStatement.executeUpdate(qry);
			if(result >0)
				System.out.println("New Student information added succesfully...");
				
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}    	
    }
    // Add new student to the table:students from runtime
    void addNewStudentFromRuntime(String sName, String sCountry) {
    	//Write the query to insert the code
    	qry = "insert into students(studentName, studentCountry) values ('" + sName + "', '" + sCountry + "')"; 

    	
    	//Execute the query
    	try {
			if(theStatement.executeUpdate(qry)>0)
				System.out.println("New student was added successfully.... ");
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}  	
    }
    // Update an already existing student
    void updateStudentById(int id, String sName, String sCountry) {
    	//Write the query to update
    	qry = "update students set studentName= '" + sName + "', studentCountry = '" + sCountry + "' where studentID = '" + id + "'";
    	
    	//Execute the query
    	try {
			if(theStatement.executeUpdate(qry)>0)
				System.out.println("The student info  was updated successfully.... ");
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}
    		
    }
}
