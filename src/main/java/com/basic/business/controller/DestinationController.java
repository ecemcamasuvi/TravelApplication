/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.controller;

import com.basic.business.system.IDestinationService;
import com.basic.business.view.DestinationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ecem
 */
@Controller
public class DestinationController {
    private DestinationView destinationView;
    private  IDestinationService destinationManager;
    @Autowired
    public DestinationController(DestinationView destinationView,IDestinationService destinationManager){
        this.destinationView=destinationView;
        this.destinationManager=destinationManager;
    }
    public void init(){
        destinationView.fillTable(destinationManager);
        destinationView.setVisible(true);

    }
}