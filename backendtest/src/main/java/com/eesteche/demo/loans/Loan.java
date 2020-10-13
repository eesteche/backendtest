package com.eesteche.demo.loans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.eesteche.demo.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name="loans")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLoan;
	public int getIdLoan() {
		return idLoan;
	}
	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@JsonBackReference
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Double total;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(name="id_user", referencedColumnName="id_user")
	private User user;

}
