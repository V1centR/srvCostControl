package com.costcontrol.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
import com.costcontrol.enums.DirectionEnum;
import com.costcontrol.impl.CostMovimentImpl;
import com.costcontrol.response.CostsByDateResponse;
import com.costcontrol.response.EmptyDataResponse;
import com.google.gson.Gson;


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
	@PostMapping(path="/bydate",produces = "application/json")
	public String getCostsByDate(@RequestBody String postData) {
		
		JSONObject jsonItem = new JSONObject(postData);
		
		String startDate = jsonItem.getString("startDate");
		Boolean consolidated = Boolean.valueOf(jsonItem.getString("consolidated"));
		Gson response = new Gson();
		
		try {
			
			if(consolidated) {
				
				BigDecimal enterTotalValue = BigDecimal.ZERO;
				BigDecimal exitTotalValue = BigDecimal.ZERO;
				
				for(Moventcost item : service.findByDate(startDate)) {
					
					if(item.getDirection().equals(DirectionEnum.EXIT.toString())) {
						exitTotalValue = exitTotalValue.add(new BigDecimal(item.getCurrencyvalue()));
					}
					
					if(item.getDirection().equals(DirectionEnum.ENTER.toString())) {
						enterTotalValue = enterTotalValue.add(new BigDecimal(item.getCurrencyvalue()));
					}
				}
				
				CostsByDateResponse consolidatedResponse = new CostsByDateResponse();
				
				consolidatedResponse.setEnter(enterTotalValue.setScale(2, RoundingMode.HALF_UP));
				consolidatedResponse.setExit(exitTotalValue.setScale(2, RoundingMode.HALF_UP));
				consolidatedResponse.setDailyLimit(new BigDecimal("75.00").setScale(2, RoundingMode.HALF_UP));
				
				return response.toJson(consolidatedResponse);
				
			} else {
				return response.toJson(service.findByDate(startDate));
			}
			
			
		} catch (Exception e) {
			EmptyDataResponse emptyResponse = new EmptyDataResponse();
			emptyResponse.setMsg(e.getMessage());
			emptyResponse.setStatus(HttpStatus.OK);
			
			return response.toJson(emptyResponse);
		}
		
	}
	
	

}
