package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Loan;
import com.example.demo.objects.InputData;
import com.example.demo.objects.OutputData;
import com.example.demo.repositories.LoanRepository;
import com.example.demo.services.MortgageCalculatorService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class testController {
	@Autowired
	private MortgageCalculatorService service;
	@Autowired
	private List<OutputData> calculations;
	@Autowired
	private LoanRepository repo;
	
	@RequestMapping("/persistence")
	public String ReadDb(Model model) {
		model.addAttribute("loans" ,repo.findAll());
		return "Dbrecords";
	}
	
	@GetMapping("/form")
	public String form(InputData inputData, Model model) {
		model.addAttribute("calculations", calculations);
		return "Form";
	}
	@PostMapping("/Calculation")
	public String calculation(@Valid InputData inputData, Model model) {

	double result =	service.calculateMonthlyPayment(inputData.getPurchasePrice(),
		inputData.getDeposit(),
		inputData.getBondTermYears(),
		inputData.getFixedInterestRate());
	log.info(""+result);
	if(!inputData.getName().isEmpty()) {
		OutputData outputData = new OutputData();
		outputData.setInputData(inputData);
		outputData.setMonthlyPayment(result);
		log.info(""+outputData);
		calculations.add(outputData);
	}
	Loan loan = Loan.builder()
			.name(inputData.getName())
			.purchasePrice(inputData.getPurchasePrice())
			.deposit(inputData.getDeposit())
			.bondTermYears(inputData.getBondTermYears())
			.fixedInterestRate(inputData.getFixedInterestRate())
			.monthlyPayment(result)
			.build();
	repo.save(loan);
	model.addAttribute("result", result);
	model.addAttribute("inputData", inputData);
	return "Results";
}
}
