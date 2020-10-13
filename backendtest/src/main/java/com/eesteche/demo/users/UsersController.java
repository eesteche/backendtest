package com.eesteche.demo.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eesteche.demo.loans.Loan;
import com.eesteche.demo.loans.LoanRepo;


@RestController
public class UsersController {
	@Autowired
	UsersRepo repo;
	@Autowired
	User users;
	@Autowired
	LoanRepo lrepo;
	
	@Transactional(readOnly = true)
	@GetMapping("/users")
	public List<User> users() {
			
		return repo.findAll();
	}
	
	@Transactional
	@PostMapping(path="/users")
	public User postUsers(User usr) {
		
		repo.save(usr);
		return usr;
	}
	
	@Transactional
	@DeleteMapping("/users/{idUser}")
	public String deleteUsers(@PathVariable Integer idUser) {
		
		
		if(idUser==null || idUser<=0) {return "Id incorrecto";}
		
		else if(!repo.existsById(idUser)) {return "El usuario no existe";}
		
		else {
			User u = repo.getOne(idUser);
			repo.delete(u);	}
		
		return "Usuario eliminado correctamente.";
	}
	
	@Transactional(readOnly=true)
	@GetMapping("/users/{idUser}")
	public Optional<UserDto> getUser(@PathVariable Integer idUser) {
		UserDto dto = new UserDto();
		
		if(idUser==null || idUser<=0) {return Optional.of(dto);}
		else if(!repo.existsById(idUser)) {return Optional.of(dto);}
		else {
			
		users = repo.getOne(idUser);				
		List<Loan> userLoans = lrepo.findByUser(users) ;
				
		dto.setIdUser(users.getIdUser());
		dto.setEmail(users.getEmail());
		dto.setFirstName(users.getFirstName());
		dto.setLastName(users.getLastName());
		dto.setLoans(userLoans);}		
		
		return Optional.of(dto);	
	}	
	
}
