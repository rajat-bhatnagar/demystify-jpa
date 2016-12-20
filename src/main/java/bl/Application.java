package bl;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Book;

public class Application {
	
	/**
	 * Gets an entity manager
	 */
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book-persistence-unit");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	/**
	 * Persists the book to the database
	 */

	private static void persistBook(Book book){
		entityManager.persist(book);
	}
	
	/**
	 * Finds the book from the database
	 */
	private static Book findBook(Long id){
		return entityManager.find(Book.class, id);
	}
	
	public static void main(String[] args) {
		persistBook(new Book(11L, "Spring", "123-76-7867", 564, "Spring in Action", new BigDecimal("1115.37")));
		Book book = findBook(11L);
		System.out.println("#"+book);
 }
}