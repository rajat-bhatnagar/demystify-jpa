package listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import model.entity.Book;

import org.apache.commons.lang.StringUtils;

public class ValidationListener {
	/*
	 * This Entity Listener has been registered with the Book Entity
	 */
	
	@PrePersist
	@PreUpdate
	public void validateBookISBN(Book book){
		if(StringUtils.isBlank(book.getIsbn())){
			throw new IllegalArgumentException("ISBN for book cannot be null");
		}
	}
}
