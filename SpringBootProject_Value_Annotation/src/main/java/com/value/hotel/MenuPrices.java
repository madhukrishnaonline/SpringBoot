package com.value.hotel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("menu")
public class MenuPrices 
{
	@Value("${menu.puriPrice}")
	private Float puriPrice;
	@Value("${menu.idlyPrice}")
	private Float idlyPrice;
	@Value("${menu.dosaPrice}")
	private Float dosaPrice;
	
	
}
