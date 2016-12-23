package model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	//Doing one to Many relationship b/w a CD and a Musician by Join Column strategy
	//Several Musicians exist on a CD
	//By this Musician will have a FK to CD PK
	
	/**
	 * Added Cascade to CD Entity
	 * This implies that we will have a Cascade to Musicians whenever CD is added
	 */
	@OneToMany(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "cd_fk")
	private Set<Musician> musicians = new HashSet<>();
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Musician> getMusicians() {
		return musicians;
	}

	public void setMusicians(Set<Musician> musicians) {
		this.musicians = musicians;
	}
	
}
