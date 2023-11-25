package com.costcontrol.model;

import com.costcontrol.enums.DirectionEnum;

import lombok.Data;

@Data
public class CostMovimentModel {
	
	private Integer id;
	private String justtificationTxt;
	private String dateRegister;
	private Double currencyValue;
	private Enum<DirectionEnum> direction;


}
