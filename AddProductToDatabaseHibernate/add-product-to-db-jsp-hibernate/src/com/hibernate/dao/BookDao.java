package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Book;
import com.hibernate.util.HibernateUtil;

public class BookDao {
	
	public void saveBook(Book book) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			// start transaction
			transaction = session.beginTransaction();
			
			// save the book object
			session.save(book);
			
			//commit transaction
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
