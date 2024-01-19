package com.costcontrol.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.costcontrol.entities.Moventcost;

@Component
public interface CostMovimentService {

	public Iterable<Moventcost> findAll();
	
	public Iterable<Moventcost> findByDate(String startDate);
}
