/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.dataAccess;

import com.basic.business.entities.Destinations;
import org.hibernate.Query;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecem
 */
@Repository
public class DestinationDal implements IDestinationDal {

	private EntityManager entityManager; // session'a karşılık

	@Autowired // otomatik hibernate anotasyonu
	public DestinationDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Aspect oriented programming
	public List<Destinations> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Destinations> destinations = session.createQuery("from Destinations", Destinations.class).getResultList();
		return destinations;
	}

	@Override
	@Transactional
	public void add(Destinations destination) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(destination);
	}

	@Override
	@Transactional
	public void delete(Destinations destination) {
		Session session=entityManager.unwrap(Session.class);
		session.remove(session.contains(destination) ? destination : session.merge(destination));
	}

	@Override
	@Transactional
	public void update(Destinations destination) {
		Session session = entityManager.unwrap(Session.class);
		String updateString="update Destinations Set name= :newName,country= :newCountry,city= :newCity,description= :newDescription,imageUrl= :newImg where id= :id";
		int updatedEntities = session.createQuery(updateString) 
		        .setParameter( "id", destination.getId() ).setParameter("newName",destination.getName()).setParameter("newCountry",destination.getCountry()).setParameter("newCity",destination.getCity()).
		        setParameter("newDescription",destination.getDescription()).setParameter("newImg",destination.getImageUrl()).executeUpdate();
		        
	}

	@Override
	@Transactional
	public Destinations getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Destinations.class, id);
	}

}