package model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Canteen
 *
 */
@Entity
@Table(name="canteen")
public class Canteen extends University implements Serializable {

	private Long id;
	private String foodType;
	private static final long serialVersionUID = 1L;

	public Canteen() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
   
}
