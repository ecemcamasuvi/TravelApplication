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