package service.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Musician;
import service.MusicianService;

public class MusicianServiceImpl implements MusicianService{
	
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public MusicianServiceImpl(EntityManager entityManager,
			EntityTransaction entityTransaction) {
		super();
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	@Override
	public Musician addMusician(String firstName, String lastName, String bio,
			Date dateOfBirth, Integer age, String preferredInstrument) {
		Musician musician = new Musician();
		musician.setFirstName(firstName);
		musician.setLastName(lastName);
		musician.setBio(bio);
		musician.setDateOfBirth(dateOfBirth);
		musician.setAge(age);
		musician.setPreferredInstrument(preferredInstrument);
		entityTransaction.begin();
		entityManager.persist(musician);
		entityTransaction.commit();
		return musician;
	}

	@Override
	public Musician findMusician(Long id) {
		return entityManager.find(Musician.class, id);
	}

	@Override
	public boolean updateMusicianInstrument(Long id, String newInstrument) {
		boolean isInstrumentUpdated = false;
		Musician updateExistingMusician = findMusician(id);
		if(updateExistingMusician != null){
			entityTransaction.begin();
			updateExistingMusician.setPreferredInstrument(newInstrument);
			entityTransaction.commit();
			isInstrumentUpdated = true;
		}
		return isInstrumentUpdated;
	}

	@Override
	public boolean removeMusician(Long id) {
		boolean isMusicianRemoved = false;
		Musician removeExistingMusician = findMusician(id);
		if(removeExistingMusician != null){
			entityTransaction.begin();
			/**
			 * Get a managed entity from a detached entity
			 * before using entity manager to remove entity
			 */
			entityManager.remove(entityManager.merge(removeExistingMusician));
			entityTransaction.commit();
			isMusicianRemoved = true;
		}
		return isMusicianRemoved;
	}

}
