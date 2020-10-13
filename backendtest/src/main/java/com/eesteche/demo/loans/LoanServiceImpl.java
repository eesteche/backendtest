package com.eesteche.demo.loans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanServiceApi {
	
	@Autowired
	private LoanRepo lrepo;	

	@Override
	public Page<Loan> getAll(Pageable pageable) {
		return lrepo.findAll(pageable);
	}	
	
}
