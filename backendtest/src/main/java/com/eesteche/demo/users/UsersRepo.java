package com.eesteche.demo.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eesteche.demo.loans.Loan;

public interface UsersRepo extends JpaRepository<User,Integer>{
	
	List<Loan> getByLoans(int idUser);
}
