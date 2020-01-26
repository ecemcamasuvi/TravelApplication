/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ecem
 */

@Entity
@Table(name="Destinations")
public class Destinations {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sürekli değeri artsın
    private int id;
    
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;
    
    @Column(name="city")
    private String city;
    
    @Column(name="description")
    private String description;
    
    @Column(name="imageurl")
    private String imageUrl;

    public Destinations() {
    }

    public Destinations(int id, String name, String country, String city, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
        this.imageUrl = imageUrl;
    }
   
  
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getCity() {
        return city;
    }

 
    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

 
    public void setDescription(String description) {
        this.description = description;
    }

  
    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


/*@Entity
@Table(name="city")
public class Destinations {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="countrycode")
	private String countryCode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="population")
	private int population;

	public Destinations() {
		
	}
	
	public Destinations(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
*/