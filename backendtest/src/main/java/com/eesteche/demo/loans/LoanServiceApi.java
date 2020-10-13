package com.eesteche.demo.loans;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanServiceApi  {
	
	Page<Loan> getAll(Pageable pageable);		
	
}
