package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class MortgageCalculatorService {
	public double calculateMonthlyPayment(double purchasePrice,
			double deposit,
			double bondTermYears,
			double fixedInterestRate) {

		double r = (fixedInterestRate / 100 / 12), n = bondTermYears * 12;
		double payment = r / (1 - Math.pow(1 + r, -n)) * (purchasePrice-deposit);
		payment = (double) Math.round(payment * 100) / 100;
		return payment;
	}
}
