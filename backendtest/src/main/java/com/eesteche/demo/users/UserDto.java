package com.eesteche.demo.users;

import java.util.List;

import com.eesteche.demo.loans.Loan;

public class UserDto {
	
	private int idUser;
	private String email;
	private String firstName;
	private String lastName;
	private List<Loan> loans;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Loan> getLoans() {
		return this.loans;
	}
	public void setLoans(List<Loan> userLoans) {
		this.loans = userLoans;
	}
	
}
