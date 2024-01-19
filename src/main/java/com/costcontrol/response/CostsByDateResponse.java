package com.costcontrol.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CostsByDateResponse {
	
	BigDecimal exit;
	BigDecimal enter;
	BigDecimal dailyLimit;
	
	

}
