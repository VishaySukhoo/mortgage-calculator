package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.objects.InputData;
import com.example.demo.objects.OutputData;

@SpringBootApplication
public class MortgageCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageCalculatorApplication.class, args);
	}
	@Bean
	public List<OutputData> calculations(){
		List<OutputData> list = new ArrayList<>();
		return list;
	}
}
