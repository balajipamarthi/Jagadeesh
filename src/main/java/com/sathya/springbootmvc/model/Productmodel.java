package com.sathya.springbootmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
//@Builder
public class Productmodel {
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private double discountRate;
	public static void main(String[] args) {
		
	
//	Productmodel promodel=Productmodel.builder()
//			.name()
//			.brand()
//			.madein()
//			.price()
//			.quantity()
//			.build();
//	System.out.println(promodel);
	}

}
