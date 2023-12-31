package com.costcontrol.dto;

import org.json.JSONObject;

import com.costcontrol.entities.Moventcost;

public class RegisterCostDto {
	
	public Moventcost registerCost(JSONObject postData) {
		
		Moventcost movementCost = new Moventcost();
		
		movementCost.setCurrencyvalue(postData.getDouble("currencyvalue"));
		movementCost.setDateregister(postData.getString("dateregister"));
		movementCost.setDirection(postData.getString("direction")); //APPLY ENUM
		movementCost.setJusttificationtxt(postData.getString("justtificationtxt"));
		
		return movementCost;
	}

}
