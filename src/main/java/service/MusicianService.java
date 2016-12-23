package service;

import java.util.Date;

import model.entity.Musician;

public interface MusicianService {
	Musician addMusician(String firstName, String lastName, String bio,
			Date dateOfBirth, Integer age, String preferredInstrument);
	
	Musician findMusician(Long id);
	
	boolean updateMusicianInstrument(Long id, String newInstrument);
	
	boolean removeMusician(Long id);
}
