package service.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Author;
import bl.types.Language;
import service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
	
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public AuthorServiceImpl(EntityManager entityManager, EntityTransaction entityTransaction) {
		super();
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	@Override
	public Author createAuthor(String bio, String firstName, String lastName, Language language, Date dateOfBirth) {
		Author author = new Author();
		author.setBio(bio);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setLanguage(language);
		author.setDateOfBirth(dateOfBirth);
		entityTransaction.begin();
		entityManager.persist(author);
		entityTransaction.commit();
		return author;
	}

	@Override
	public Author findAuthor(Long id) {
		return entityManager.find(Author.class, id);
	}

	@Override
	public boolean removeAuthor(Long id) {
		boolean isAuthorRemoved = false;
		Author existingAuthor = findAuthor(id);
		if(existingAuthor != null){
			entityTransaction.begin();
			/**
			 * Return a managed entity to be persisted from a detached entity
			 */
			entityManager.remove(entityManager.merge(existingAuthor));
			entityTransaction.commit();
			isAuthorRemoved = true;
		}
		return isAuthorRemoved;
	}

	@Override
	public boolean updateAuthorLanguage(Long id, Language language) {
		boolean isLanguageUpdated = false;
		Author existingAuthor = findAuthor(id);
		if(existingAuthor != null){
			entityTransaction.begin();
			existingAuthor.setLanguage(language);
			entityTransaction.commit();
			isLanguageUpdated = true;
		}
		return isLanguageUpdated;
	}

}
