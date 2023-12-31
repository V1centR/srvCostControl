package com.costcontrol.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costcontrol.entities.Moventcost;
import com.costcontrol.repo.CostMovimentRepo;
import com.costcontrol.service.CostMovimentService;

@Service("costMovimentImpl")
public class CostMovimentImpl implements CostMovimentService {

	
	@Autowired
	CostMovimentRepo repo;
	
	@Override
	public Iterable<Moventcost> findAll() {
		return repo.findAll();
	}
	
	public Moventcost save(Moventcost item) {
		return repo.save(item);
	}
	
	@Override
	public Iterable<Moventcost> findByDate(String startDate, String endDate){
		return repo.findByDate(startDate, endDate);
	}

}
