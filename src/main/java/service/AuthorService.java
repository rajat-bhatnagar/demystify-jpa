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
	public Author createAuthor(String bio, String firstName, String lastName, Language language, Date dateOfBirth);

	/**
	 * Find an Author
	 * @param id
	 * @return Author
	 */
	public Author findAuthor(Long id);
	
	/**
	 * Remove an Author
	 * @param id
	 * @return boolean
	 */
	public boolean removeAuthor(Long id);
	
	/**
	 * Update an Author's language
	 * @param id
	 * @param language
	 * @return boolean
	 */
	public boolean updateAuthorLanguage(Long id, Language language);
}
