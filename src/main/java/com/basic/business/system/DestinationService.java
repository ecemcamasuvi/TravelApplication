/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.system;

import com.basic.business.dataAccess.IDestinationDal;
import com.basic.business.entities.Destinations;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecem
 */
@Service
public class DestinationService implements IDestinationService {

    private IDestinationDal destinationDal;

    @Autowired
    public DestinationService(IDestinationDal destinationDal) {
        this.destinationDal = destinationDal;
    }

    @Override
    @Transactional
    public List<Destinations> getAll() {
        return this.destinationDal.getAll();
    }

    @Override
    @Transactional
    public void add(Destinations destination) {
       this.destinationDal.add(destination);
    }

    @Override
    @Transactional
    public void delete(Destinations destination) {
    	this.destinationDal.delete(destination);
    }

    @Override
    @Transactional
    public void update(Destinations destination) {
    	this.destinationDal.update(destination);
    }

    @Override
    @Transactional
    public Destinations getById(int id) {
    	return this.destinationDal.getById(id);
    }

}