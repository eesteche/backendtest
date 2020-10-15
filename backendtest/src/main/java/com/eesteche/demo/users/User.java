package com.eesteche.demo.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import com.eesteche.demo.loans.Loan;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@Table(name="users")
public class User  {	
	
	@Id
	@OnDelete(action = OnDeleteAction.CASCADE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Integer id_user;
	@NotEmpty
	@Column(nullable=false, length=100)
	private String email;
	@NotEmpty
	@Column(nullable=false, length=150)
	private String firstName;
	@NotEmpty
	@Column(nullable=false, length=150)
	private String lastName;
	
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", loans=" + loans + "]";
	}
	public Integer getIdUser() {
		return id_user;
	}
	public void setIdUser(Integer idUser) {
		this.id_user = idUser;
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
	
	@JsonManagedReference
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private List<Loan> loans = new ArrayList<Loan>();


}
