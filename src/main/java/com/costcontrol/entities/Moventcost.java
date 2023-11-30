package com.costcontrol.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


import lombok.Data;


/**
 * The persistent class for the moventcost database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Moventcost.findAll", query="SELECT m FROM Moventcost m")
public class Moventcost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double currencyvalue;

	private String dateregister;

	private String direction;

	private String justtificationtxt;
	
	private String registerdate;

	public Moventcost() {
	}

}