package bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.entity.Author;
import model.entity.Book;
import model.entity.CD;
import model.entity.Musician;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.CDServiceImpl;
import service.impl.MusicianQueryServiceImpl;
import service.impl.MusicianServiceImpl;
import bl.types.Language;

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
		
		CDServiceImpl cdService = new CDServiceImpl(entityManager, entityTransaction);
		
		//Add a CD
		CD addedCD = cdService.createCD("Oye Lucky Lucky Oye", "Bollywood", "Lucky Oye", 35f, 13.87f);
		System.out.println("CD # "+addedCD);
		
		//Update a CD
		boolean isCDPriceUpdated = cdService.updateCDPrice(21L, 87f);
		System.out.println("CD Price Updated # "+isCDPriceUpdated);
		
		//Find a CD
		CD findMyCD = cdService.findCD(21L);
		System.out.println("findMyCD # "+findMyCD);
		
		//RemoveCD
		boolean isCDRemoved = cdService.removeCD(24L);
		System.out.println("Is CD Removed # "+isCDRemoved);
		
		MusicianServiceImpl musicianService = new MusicianServiceImpl(entityManager, entityTransaction);
		//Add a musician
		Musician  newMusician = musicianService.addMusician("Tom", "Hanks", "Actor", new java.sql.Date(Calendar.getInstance().getTimeInMillis()) , 54, "Saxophone");
		System.out.println("Musician # "+newMusician);
		
		//Update a musician
		boolean updatedInstrument = musicianService.updateMusicianInstrument(16L, "Trumpet");
		System.out.println("Is Musical instrument updated # "+updatedInstrument);
		
		//Find a Musician
		Musician findMusician = musicianService.findMusician(16L);
		System.out.println(" Is Musician found # "+findMusician);
		
		//Remove a Musician
		boolean removeMusician = musicianService.removeMusician(2L);
		System.out.println("Is Musician removed # "+removeMusician);
		
		//Demonstrating Cascade Functionality of JPA
		/**
		 * There is a 1 to Many relationship between a CD and Musician's
		 * We will be creating four musicians and adding them to a CD
		 * When a CD is persisted it will automatically do an add cascade for musicians
		 */
		Set<Musician> indianMusicians = new HashSet<>();
		indianMusicians.add(new Musician("A R", "Rahman", "Musician", new java.sql.Date(Calendar.getInstance().getTimeInMillis()) , 54, "Piano"));
		indianMusicians.add(new Musician("Lata", "MangeshKar", "Musician", new java.sql.Date(Calendar.getInstance().getTimeInMillis()) , 44, "Harmonium"));
		indianMusicians.add(new Musician("Zakir", "Hussain", "Musician", new java.sql.Date(Calendar.getInstance().getTimeInMillis()) , 44, "Tabla"));
		CD newCD = new CD();
		newCD.setTitle("Indian Musicians");
		newCD.setDescription("Indian Musicians");
		newCD.setTotalDuration(67f);
		newCD.setGenre("Classical");
		newCD.setMusicians(indianMusicians);
		CD addedCDwithCascadeADD = cdService.createCD(newCD);
		System.out.println("New CD with musicians added # "+addedCDwithCascadeADD);
		
		//Find musicians
		MusicianQueryServiceImpl musiciansQueryService = new MusicianQueryServiceImpl(entityManager);
		musiciansQueryService.findMusiciansByQuery();

		//Find musicians playing Harmonium
		musiciansQueryService.findMusiciansByTypedQuery();
		
		//Find Musicians by passing arguments to JPQL
		musiciansQueryService.findMusiciansByTypedQueryAndParameters("Musician", java.sql.Date.valueOf("2016-12-23"), "Piano");
	
		//Find Musicians by TypedQuery playing Instrument Tabla
		System.out.println("Musicans Playing Tabla found # "+musiciansQueryService.findMusiciansInstrumentQuery("Tabla"));
		
	}
}