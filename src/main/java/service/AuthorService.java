package service;

import java.util.Date;

import model.entity.Author;
import bl.types.Language;

public interface AuthorService {

	/**
	 * Add an Author
	 * @param bio
	 * @param firstName
	 * @param lastName
	 * @param language
	 * @param dateOfBirth
	 * @return Author
	 */
	 Author createAuthor(String bio, String firstName, String lastName, Language language, Date dateOfBirth);

	/**
	 * Find an Author
	 * @param id
	 * @return Author
	 */
	 Author findAuthor(Long id);
	
	/**
	 * Remove an Author
	 * @param id
	 * @return boolean
	 */
	 boolean removeAuthor(Long id);
	
	/**
	 * Update an Author's language
	 * @param id
	 * @param language
	 * @return boolean
	 */
	 boolean updateAuthorLanguage(Long id, Language language);
}
