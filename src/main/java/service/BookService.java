package service;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Book;

/*
 * BookService does CRUD operations on Book Entity by establishing an EntityTransaction
 */
public class BookService {
	
	/**
	 * Gets an entity manager
	 */
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book-persistence-unit");
	private EntityManager entityManager= entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();
	
	/**
	 * Persists the book to the database
	 */
	public Book createBook(Long id, String description, String isbn, int nbOfPage,
			String title, BigDecimal unitCost) {
		Book book = new Book();
		book.setId(id);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setNbOfPage(nbOfPage);
		book.setTitle(title);
		book.setUnitCost(unitCost);
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
		return book;
	}
	
	/**
	 * Remove a book from database
	 */
	public boolean removeBook(Long id){
		boolean isBookRemoved = false;
		Book removeBook = entityManager.find(Book.class, id);
		if(removeBook != null){
			/*
			 * Return a managed entity from a detached entity
			 * Then Begin a transaction and remove the entity
			 */
			entityTransaction.begin();
			entityManager.remove(entityManager.merge(removeBook));
			entityTransaction.commit();
			isBookRemoved = true;
		}
		return isBookRemoved;
	}
	
	/*
	 * Find a book
	 * Remember find is not transactional
	 */
	public Book findBook(Long id){
		return entityManager.find(Book.class, id);
	}
	
	/*
	 * Update Cost of a Book
	 */
	public boolean updateCostOfBook(Long id , BigDecimal raiseCost){
		boolean isBookCostUpdated = false;
		Book existingBook = entityManager.find(Book.class, id);
		if(existingBook!=null){
			entityTransaction.begin();
			existingBook.setUnitCost(existingBook.getUnitCost().add(raiseCost));
			entityTransaction.commit();
			isBookCostUpdated = true;
		}
		return isBookCostUpdated;
	}
}
