package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name = "book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String description;

	private String isbn;

	private int nbOfPage;

	private String title;

	private BigDecimal unitCost;

	public Book() {
	}
	
	public Book(Long id) {
		super();
		this.id = id;
	}

	public Book(Long id, String description, String isbn, int nbOfPage,
			String title, BigDecimal unitCost) {
		super();
		this.id = id;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.title = title;
		this.unitCost = unitCost;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", description=" + description + ", isbn="
				+ isbn + ", nbOfPage=" + nbOfPage + ", title=" + title
				+ ", unitCost=" + unitCost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + nbOfPage;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((unitCost == null) ? 0 : unitCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (nbOfPage != other.nbOfPage)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (unitCost == null) {
			if (other.unitCost != null)
				return false;
		} else if (!unitCost.equals(other.unitCost))
			return false;
		return true;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNbOfPage() {
		return this.nbOfPage;
	}

	public void setNbOfPage(int nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getUnitCost() {
		return this.unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

}