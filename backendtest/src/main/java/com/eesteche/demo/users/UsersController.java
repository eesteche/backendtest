package com.eesteche.demo.users;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eesteche.demo.errors.ErrorHandler;
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
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Transactional(readOnly = true)
	@GetMapping("/users")
	public ResponseEntity<?> users() {
		
		if(repo.findAll().isEmpty()) {
		throw new ErrorHandler("No hay usuarios cargados");	
		}else {
			List<User> listado = repo.findAll();	
			return new ResponseEntity<>(listado,HttpStatus.FOUND);		
		}
		
	}
	
	@Transactional
	@PostMapping(path="/users")
	public ResponseEntity<?> postUsers(User usr) {
       
		if(usr.getEmail().isEmpty()
			|| usr.getFirstName().isEmpty()
			|| usr.getLastName().isEmpty()) {
				
			throw new ErrorHandler("No se permiten campos vacíos");	
			
			}else if(!Valid(usr.getEmail().toString())){
				
				throw new ErrorHandler("Por favor, ingrese un correo electrónico válido.");}
		
				else{			
				repo.save(usr);
				logger.trace("/users/id post method correct access");
				String ok = "Usuario agregado correctamente. Datos: "+ usr.toString();
				return new ResponseEntity<>(ok,HttpStatus.FOUND);	
				}
		
		
	}
	
	@Transactional
	@DeleteMapping("/users/{idUser}")
	public ResponseEntity<?> deleteUsers(@PathVariable String idUser) {		
		int intId = NumberUtils.toInt(idUser, -1);
		
		if(intId<1) {
			throw new ErrorHandler("Existe un error en su ID. Debe ser numérico y mayor a 0.");	
		}else{
			  if(!repo.existsById(intId)) {throw new ErrorHandler("El usuario no existe.");
			  }else {
				try {
				User u = repo.getOne(intId);
				String recuerdo = "Usuario: "+u.toString()+" ha sido eliminado correctamente.";
				repo.delete(u);
				logger.trace("/users/id delete method correct access");
				return new ResponseEntity<>(recuerdo,HttpStatus.FOUND);}
				
				catch (Exception e){
				logger.error("/users/id delete method error: ");
				throw new ErrorHandler("Hubo un error eliminando el user.");}
				}
		}						
	}
	
	@Transactional(readOnly=true)
	@GetMapping("/users/{idUser}")
	public ResponseEntity<?> getUser(@PathVariable String idUser) {
		int intId = NumberUtils.toInt(idUser, -1);
		
		if(intId<1) {
			throw new ErrorHandler("Existe un error en su ID. Debe ser numérico y mayor a 0.");	
		}else {
			if(!repo.existsById(intId)) {
				throw new ErrorHandler("El usuario que usted busca no existe.");	
			}else {
				UserDto dto = new UserDto();
				
				users = repo.getOne(intId);				
				List<Loan> userLoans = lrepo.findByUser(users) ;
						
				dto.setIdUser(users.getIdUser());
				dto.setEmail(users.getEmail());
				dto.setFirstName(users.getFirstName());
				dto.setLastName(users.getLastName());
				dto.setLoans(userLoans);		
				
				logger.trace("/users/id get method correct access");	    
				return new ResponseEntity<>(dto,HttpStatus.FOUND);		
			}	
		}				
		
		
	}
	
	public static final Pattern VALID_EMAIL = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean Valid(String mail) {
		        Matcher m = VALID_EMAIL.matcher(mail);
		        return m.find();
	}	        
}
