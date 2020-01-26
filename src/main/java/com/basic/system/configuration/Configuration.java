/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.system.configuration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 *
 * @author ecem
 */
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.basic.business")
@EnableJpaRepositories(basePackages = "com.basic.business.dataAccess")
@EntityScan(basePackages="com.basic.business.entities")
public class Configuration {
    
}
