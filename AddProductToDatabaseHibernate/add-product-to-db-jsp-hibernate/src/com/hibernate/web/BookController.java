package com.hibernate.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.BookDao;
import com.hibernate.model.Book;



	
	@WebServlet("/register")
	public class BookController extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private BookDao bookDao;

	    public void init() {
	        bookDao = new BookDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        register(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.sendRedirect("addBook.jsp");
	    }

	    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        String genre = request.getParameter("genre");


	        Book book = new Book();
	        book.setTitle(title);
	        book.setAuthor(author);
	        book.setGenre(genre);


	        bookDao.saveBook(book);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("dbUpdated.jsp");
	        dispatcher.forward(request, response);
	    }

}
