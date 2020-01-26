/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.system;

import com.basic.business.entities.Destinations;
import java.util.List;

/**
 *
 * @author ecem
 */
public interface IDestinationService {

    List<Destinations> getAll();
    void add(Destinations destination);
    void delete(Destinations destination);
    void update(Destinations destination);
    Destinations getById(int id);
    
}
