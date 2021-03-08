package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//This declaration is used to initialize email and password 
				//strings to values entered by the user
				String email= request.getParameter("username");
				String pass= request.getParameter("password");
				
				RequestDispatcher rd = null;
				if(email.equalsIgnoreCase("John") && pass.equals("john123")){
					rd = request.getRequestDispatcher("LogoutServlet");
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("index.html");
					PrintWriter out = response.getWriter();
					rd.include(request, response);
					out.println(("<center> <span style = 'color: red'> Invalid Credentials! </span></center>"));
				}
		
	}

}
