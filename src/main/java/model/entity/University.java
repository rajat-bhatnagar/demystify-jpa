package model.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity
@Table(name="university")
/**
 * Inheritance Type Strategy can be defined on the superclass
 * If nothing is defined JPA uses configuration by exception for strategy which is InheritanceType.SINGLE_TABLE
 * @author rajatbhatnagar
 *
 */
@Inheritance(strategy=InheritanceType.JOINED)
public class University implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	private static final long serialVersionUID = 1L;

	public University() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
   
}
