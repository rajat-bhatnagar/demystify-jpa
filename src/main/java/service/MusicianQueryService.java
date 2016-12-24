package service;

import java.sql.Date;

public interface MusicianQueryService {
	
	/*
	 * Find musicians by using JPQL and Query Interface
	 */
	void findMusiciansByQuery();
	/*
	 * Find Musicians by using JPQL and TypedQuery interface
	 */
	void findMusiciansByTypedQuery();
	
	/*
	 * Find musicians by using JPQL , Passing parametes to JPQL and TypedQuery interface
	 */
	
	void findMusiciansByTypedQueryAndParameters(String bio, Date dateOfBirth, String preferredInstrument);
	
	/*
	 * Update Musicians Instrument by constructing a dynamic query
	 */
	boolean findMusiciansInstrumentQuery(String preferredInstrument);

}
