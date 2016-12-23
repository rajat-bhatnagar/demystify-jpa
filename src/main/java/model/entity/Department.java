package model.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import model.entity.University;

/**
 * Entity implementation class for Entity: Department
 *
 */
@Entity
@Table(name="department")
public class Department extends University implements Serializable {
	   
	private Long id;
	private String subject;
	private static final long serialVersionUID = 1L;

	public Department() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
   
}
