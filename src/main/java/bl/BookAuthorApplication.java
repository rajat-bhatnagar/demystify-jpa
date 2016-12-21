package bl;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Author;
import model.Book;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;

public class BookAuthorApplication {
	/**
	 * Gets an Entity manager
	 * Gets an Entity transaction
	 */
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book-persistence-unit");
	private static EntityManager entityManager= entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static void main(String[] args){
		BookServiceImpl bookService = new BookServiceImpl(entityManager, entityTransaction);
		
		//Remove a Book
		boolean removeSpringBook = bookService.removeBook(1L);
		System.out.println("Has the Book with Id 1l Removed : "+removeSpringBook);
		
		//Add a Book
		Book book = bookService.createBook("Spring", "123-76-7867", 564, "Spring in Action", new BigDecimal("1115.37"));
		System.out.println("#Book : "+book);	
		
		//Find a Book
		Book findSpringbook = bookService.findBook(1L);
		System.out.println("Find Book with id 1L # "+findSpringbook);
		
		//Update Cost of a Book
		BigDecimal raiseCostFactor = new BigDecimal(1000);
		boolean isCostUpdated = bookService.updateCostOfBook(1L, raiseCostFactor);
		System.out.println("Did Cost of Book get updated "+isCostUpdated);
		
		AuthorServiceImpl authorService = new AuthorServiceImpl(entityManager, entityTransaction);
		
		//Add an Author
		Author author = authorService.createAuthor("Thriller Specialist", "Sydney", "Sheldon", Language.GERMAN, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		System.out.println("Added Author # "+author);
		
		//Find an Author
		Author findThrillerAuthor = authorService.findAuthor(3L);
		System.out.println("findThrillerAuthor # "+findThrillerAuthor);
		
		//Update an Author s language
		boolean updateAuthorlanguage = authorService.updateAuthorLanguage(3L, Language.SPANISH);
		System.out.println("Is Author Language Updated : "+updateAuthorlanguage);
		
		//Remove an Author
		boolean removeThrillerAuthor = authorService.removeAuthor(3L);
		System.out.println("Is Author Removed : "+removeThrillerAuthor);
		
	}
}