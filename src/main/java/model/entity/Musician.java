package model.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Musician
 *
 */
@Entity
@Table(name="musician")
@NamedQueries({
	@NamedQuery(name="Musician.findActor", query="select m from Musician m where m.bio='Actor'")
})
public class Musician implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=50)
	private String lastName;
	
	@Column(length=3000)
	private String bio;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Transient
	private Integer age;
	
	@Column(length=50)
	private String preferredInstrument;
	
	public Musician() {
		super();
	} 
	
	public Musician(String firstName, String lastName, String preferredInstrument) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredInstrument = preferredInstrument;
	}

	public Musician(String firstName, String lastName, String bio,
			Date dateOfBirth, Integer age, String preferredInstrument) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.preferredInstrument = preferredInstrument;
	}

	@Override
	public String toString() {
		return "Musician [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", bio=" + bio + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + ", preferredInstrument="
				+ preferredInstrument + "]";
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}   
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}   
	public String getPreferredInstrument() {
		return this.preferredInstrument;
	}

	public void setPreferredInstrument(String preferredInstrument) {
		this.preferredInstrument = preferredInstrument;
	}
   
}
