package com.costcontrol.service;

import org.springframework.stereotype.Component;

import com.costcontrol.entities.Moventcost;

@Component
public interface CostMovimentService {

	public Iterable<Moventcost> findAll();
}
