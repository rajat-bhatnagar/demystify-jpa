package service;

import model.entity.CD;

public interface CDService {
	
	CD createCD(CD newCD);
	CD createCD(String description, String genre, String title, Float totalDuration, Float unitcost);
	CD findCD(long id);
	boolean updateCDPrice(Long id, Float raise);
	boolean removeCD(Long id);
}
