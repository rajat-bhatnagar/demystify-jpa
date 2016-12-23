package service;

import java.math.BigDecimal;
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
