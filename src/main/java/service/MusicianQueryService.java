package service;

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
	
	void findMusiciansByTypedQueryAndParameters(String bio, String preferredInstrument);

}
