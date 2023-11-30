package com.costcontrol.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.costcontrol.dto.RegisterCostDto;
import com.costcontrol.entities.Moventcost;
import com.costcontrol.impl.CostMovimentImpl;


@RestController
@RequestMapping("/costcontrol")
public class RegisterCostController {
	
	@Autowired
	CostMovimentImpl service;
	
	
	@CrossOrigin
	@GetMapping("/all")
	public Iterable<Moventcost> getAll() {
		return service.findAll();
	}
	
	@CrossOrigin
	@PostMapping(path = "/register", consumes = "application/json")
	public ResponseEntity registerCost(@RequestBody String postData) {
		
		
		JSONObject jsonItem = new JSONObject(postData);
		RegisterCostDto registerDto = new RegisterCostDto();
		registerDto.registerCost(jsonItem);
		
		System.out.println(jsonItem);

		try {
			
			service.save(registerDto.registerCost(jsonItem));

			return ResponseEntity.status(HttpStatus.CREATED).body(0);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: Houve um erro no processamento dos dados");
		}
	}
	
	@CrossOrigin
	@GetMapping("/bydirection")
	public Iterable<Moventcost> getCostsByDirection() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/bydate")
	public Iterable<Moventcost> getCostsByDate(@RequestBody String postData) {
		
		JSONObject jsonItem = new JSONObject(postData);
		
		String startDate = jsonItem.getString("startDate");
		String endDate = jsonItem.getString("endDate");
		
		return service.findByDate(startDate,endDate);
	}
	
	

}
