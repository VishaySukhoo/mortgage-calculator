package com.example.demo.repositories;

import org.springframework.stereotype.Component;
import com.example.demo.entities.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;


@Component
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {
	
}