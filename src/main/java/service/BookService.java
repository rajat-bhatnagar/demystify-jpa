package service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.entity.Book;

/*
 * BookService does CRUD operations on Book Entity by establishing an EntityTransaction
 */
public interface BookService {
	
	 Book createBook(String description, String isbn, int nbOfPage, String title, BigDecimal unitCost);
	
	 boolean removeBook(Long id);
	
	 Book findBook(Long id);
	
	 boolean updateCostOfBook(Long id , BigDecimal raiseCost);
	
}
