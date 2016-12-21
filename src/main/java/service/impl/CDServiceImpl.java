package service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.CD;
import service.CDService;

public class CDServiceImpl implements CDService {
	
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public CDServiceImpl(EntityManager entityManager, EntityTransaction entityTransaction) {
		super();
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	@Override
	public CD createCD(String description, String genre, String title, Float totalDuration, Float unitcost) {
		CD cd = new CD();
		cd.setDescription(description);
		cd.setGenre(genre);
		cd.setTitle(title);
		cd.setTotalDuration(totalDuration);
		cd.setUnitcost(unitcost);
		entityTransaction.begin();
		entityManager.persist(cd);
		entityTransaction.commit();
		return cd;
	}

	@Override
	public CD findCD(long id) {
		return entityManager.find(CD.class, id);
	}

	@Override
	public boolean updateCDPrice(Long id, Float raise) {
		boolean isCDPriceUpdated = false;
		CD cd = findCD(id);
		if(cd != null){
			/*
			 * Get Managed Entity from Detached entity and persist using entityManager
			 */
			entityTransaction.begin();
			cd.setUnitcost(Float.sum(cd.getUnitcost(), raise));
			entityTransaction.commit();
			isCDPriceUpdated = true;
		}
		return isCDPriceUpdated;
	}

	@Override
	public boolean removeCD(Long id) {
		boolean isCDRemoved = false;
		CD cd = findCD(id);
		if(cd != null){
			entityTransaction.begin();
			entityManager.remove(entityManager.merge(cd));
			entityTransaction.commit();
		}
		return isCDRemoved;
	}

}
