package service.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;

import model.entity.Musician;
import service.MusicianQueryService;

public class MusicianQueryServiceImpl implements MusicianQueryService {
	
	private EntityManager entityManager;
	
	public MusicianQueryServiceImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void findMusiciansByQuery() {
		Query query = entityManager.createQuery("select m from Musician m where m.bio='Actor' and m.preferredInstrument='Saxophone'");
		List musicians = query.getResultList();
		for(int counter=0;counter<musicians.size();counter++){ 
			/*
			 * We have to do an explicit case here as getResultList() retuens an Object
			 */
			Musician musician = (Musician)musicians.get(counter);
			System.out.println("Musician ["+counter+"] # "+musician);
		}
		
	}

	@Override
	public void findMusiciansByTypedQuery() {
		/*
		 * TypedQyery is recommended as we can use generics to enforce and check the type
		 * of Object being returned
		 */
		String musicianJPQL = "select m from Musician m where m.bio='Musician' and m.preferredInstrument='Harmonium'";
		TypedQuery<Musician> typedQuery = entityManager.createQuery(musicianJPQL, Musician.class);
		List<Musician> musicians = typedQuery.getResultList();
		for(Musician musician : musicians){
			System.out.println("Musician Playing Harmonium# "+musician);
		}
	}

	@Override
	public void findMusiciansByTypedQueryAndParameters(String bio,Date dateOfBirth, String preferredInstrument) {
		String jpqlQuery = "select m from Musician m where m.bio = ?1 and"
				+ " m.dateOfBirth = ?2 "
				+ "and m.preferredInstrument = ?3";
		TypedQuery<Musician> musiciansQuery = entityManager.createQuery(jpqlQuery, Musician.class);
		musiciansQuery.setParameter(1, bio);
		/*
		 * If the parameters are of type DATE or TIMESTAMP , 
		 * then youNeed to specify the type for binding the value
		 */
		musiciansQuery.setParameter(2, dateOfBirth, TemporalType.DATE);
		musiciansQuery.setParameter(3, preferredInstrument);
		List<Musician> musicians = musiciansQuery.getResultList();
		for(Musician musician : musicians){
			System.out.println("Musicians found # "+musician);
		}
	}

	@Override
	public boolean findMusiciansInstrumentQuery(String preferredInstrument) {
		boolean musicianFound = false;
		if(StringUtils.isNotBlank(preferredInstrument)){
			String qlString = "select m from Musician m where preferredInstrument = :instrument";
			TypedQuery<Musician> musiciansInstrumentQuery = entityManager.createQuery(qlString, Musician.class);
			musiciansInstrumentQuery.setParameter("instrument", preferredInstrument);
			List<Musician> musicians = musiciansInstrumentQuery.getResultList();
			for(Musician musician: musicians){
				System.out.println("Musician # "+musician);
			}
			musicianFound = true;
		}
		return musicianFound;
	}

	@Override
	public boolean findMusiciansActors() {
		/*
		 * Constructing a TypedQuery based of a named query defined in Musician entity
		 */
		boolean musiciansFound = false;
		TypedQuery<Musician> findMusiciansWhoAreActors = entityManager.createNamedQuery("Musician.findActor", Musician.class);
		List<Musician> actorMusicians = findMusiciansWhoAreActors.getResultList();
		if(!actorMusicians.isEmpty()){
			musiciansFound = true;
			for(Musician musician : actorMusicians){
				System.out.println("ActorMusician # "+musician);
			}
		}
		return musiciansFound;
	}
}
