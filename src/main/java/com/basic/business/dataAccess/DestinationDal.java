/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.dataAccess;

import com.basic.business.entities.Destinations;
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

    private EntityManager entityManager; //session'a karşılık

    @Autowired //otomatik hibernate anotasyonu
    public DestinationDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional//Aspect oriented programming
    public List<Destinations> getAll() {
            Session session = entityManager.unwrap(Session.class);
            List<Destinations> destinations = session.createQuery("from Destinations", Destinations.class).getResultList();
            return destinations;
    }

    @Override
    public void add(Destinations destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Destinations destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Destinations destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Destinations getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}