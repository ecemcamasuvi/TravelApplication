/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.controller;

import com.basic.business.entities.Destinations;
import com.basic.business.system.IDestinationService;
import com.basic.business.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ecem
 */
@Controller
public class DestinationController {
    private MainView mainView;
    private  IDestinationService destinationManager;
    @Autowired
    public DestinationController(MainView mainView,IDestinationService destinationManager){
        this.mainView=mainView;
        this.destinationManager=destinationManager;
    }
    public void init(){
    	mainView.fillTable(destinationManager);
    	mainView.setVisible(true);
    	mainView.setManager(destinationManager);

    }
}