package com.example.demo.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputData {
	private double purchasePrice;
	private double deposit;
	private double bondTermYears;
	private double fixedInterestRate;
	private String name;
}
