package model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

import bl.types.Language;

/**
 * Entity implementation class for Entity: Author
 *
 */
@Entity
@Table(name="author", schema="rso_jpa")

public class Author implements Serializable {	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="bio", length=5000)
	private String bio;
	
	@Column(name="firstName", length=40)
	private String firstName;
	
	@Column(name="lastName", length=40)
	private String lastName;
	
	/**
	 * Language is an enumeration
	 */
	@Column(name="language", length=30)
	@Enumerated(EnumType.STRING)
	private Language language;
	
	@Column(name="dateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public Author() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public Author(String bio, String firstName, String lastName,
			Language language, Date dateOfBirth) {
		super();
		this.bio = bio;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.dateOfBirth = dateOfBirth;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", bio=" + bio + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", language=" + language
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	/*
	 * Callback entities are a neat way of adding business logic to our entities and this
	 * business logic is called automatically by the Persistence Provider
	 */
	@PrePersist
	@PreUpdate
	private void validateAuthorName(){
		if(StringUtils.isBlank(firstName)){
			throw new IllegalArgumentException("Firstname of Author cannot be empty !");
		}
		if(StringUtils.isBlank(lastName)){
			throw new IllegalArgumentException("Lastname of Author cannot be empty");
		}
	}
	
}
