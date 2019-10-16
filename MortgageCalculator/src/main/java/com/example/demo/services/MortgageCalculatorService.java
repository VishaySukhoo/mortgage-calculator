package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.objects.TableData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MortgageCalculatorService {
	public double calculateMonthlyPayment(double purchasePrice, double deposit, double bondTermYears,
			double fixedInterestRate) {

		double r = (fixedInterestRate / 100 / 12), n = bondTermYears * 12;
		double payment = r / (1 - Math.pow(1 + r, -n)) * (purchasePrice - deposit);
		payment = (double) Math.round(payment * 100) / 100;
		return payment;
	}

	public List<TableData> calculateRepaymentSplit(double monthlyPayment, double interestRate, double numberYears,
			double principal, double deposit) {
		
		double principalPaid, interestPaid, newBalance;
		List<TableData> list = new ArrayList<>();
		principal = principal - deposit;
		double yearlyPayment = monthlyPayment * 12;
		double monthlyInterestRate = interestRate / 12;

		for (int i = 1; i <= numberYears; i++) {
			double sumInt = 0;
			double sumCapital = 0;
			for (int month = 1; month <= 12; month++) {

				interestPaid = principal * (monthlyInterestRate / 100);
				principalPaid = monthlyPayment - interestPaid;
				newBalance = principal - principalPaid;
				sumInt += interestPaid;
				sumCapital += principalPaid;

				principal = newBalance;
			}

			int percentageInterest = (int) Math.round((sumInt / yearlyPayment) * 100);
			int percentageCapital = (int) Math.round((sumCapital / yearlyPayment) * 100);
			log.info("Year " + i + "  Percentage interest:  " + percentageInterest);
			log.info("Year " + i + "  Percentage Capital: " + percentageCapital);
			TableData tableData = new TableData();
			tableData.setYear(i);
			tableData.setPercentageInterest(percentageInterest);
			tableData.setPercentageCapital(percentageCapital);
			list.add(tableData);

		}
		return list;
	}
}
