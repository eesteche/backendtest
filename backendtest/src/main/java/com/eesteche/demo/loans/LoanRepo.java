package com.eesteche.demo.loans;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eesteche.demo.users.User;

public interface LoanRepo extends JpaRepository<Loan,Integer>{
					
	Page<Loan> findByUser(User user,Pageable paging);

	List<Loan> findByUser(User users);
}
