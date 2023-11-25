package com.costcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.costcontrol.entities.Moventcost;
import com.costcontrol.impl.CostMovimentImpl;

@RestController
@RequestMapping("/costcontrol")
public class RegisterCostController {
	
	@Autowired
	CostMovimentImpl service;
	
	
	@CrossOrigin
	@GetMapping("/all")
	public Iterable<Moventcost> getPostbyId() {
		return service.findAll();
	}

}
