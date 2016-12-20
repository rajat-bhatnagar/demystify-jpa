package bl;

import java.math.BigDecimal;
import service.BookService;
import model.Book;

public class Application {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		
		//Remove a Book
		boolean removeSpringBook = bookService.removeBook(1L);
		System.out.println("Has the Book with Id 1l Removed : "+removeSpringBook);
		
		//Add a Book
		Book book = bookService.createBook(1L, "Spring", "123-76-7867", 564, "Spring in Action", new BigDecimal("1115.37"));
		System.out.println("#Book : "+book);	
		
		//Find a Book
		Book findSpringbook = bookService.findBook(1L);
		System.out.println("Find Book with id 1L # "+findSpringbook);
		
		//Update Cost of a Book
		BigDecimal raiseCostFactor = new BigDecimal(1000);
		boolean isCostUpdated = bookService.updateCostOfBook(1L, raiseCostFactor);
		System.out.println("Did Cost of Book get updated "+isCostUpdated);
		
 }
}