package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd" , schema="rso_jpa")
public class CD {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=300)
	private String description;
	@Column(length=50)
	private String genre;
	@Column(length=50)
	private String title;
	private Float totalDuration;
	private Float unitcost;
	
	public CD() {
		super();
	}
	
	public CD(String description, String genre, String title,
			Float totalDuration, Float unitcost) {
		super();
		this.description = description;
		this.genre = genre;
		this.title = title;
		this.totalDuration = totalDuration;
		this.unitcost = unitcost;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", description=" + description + ", genre="
				+ genre + ", title=" + title + ", totalDuration="
				+ totalDuration + ", unitcost=" + unitcost + "]";
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}
	public Float getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(Float unitcost) {
		this.unitcost = unitcost;
	}
}
