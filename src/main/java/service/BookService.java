package service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Book;

/*
 * BookService does CRUD operations on Book Entity by establishing an EntityTransaction
 */
public interface BookService {
	
	public Book createBook(String description, String isbn, int nbOfPage, String title, BigDecimal unitCost);
	
	public boolean removeBook(Long id);
	
	public Book findBook(Long id);
	
	public boolean updateCostOfBook(Long id , BigDecimal raiseCost);
	
}
