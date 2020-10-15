package com.eesteche.demo.loans;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eesteche.demo.errors.ErrorHandler;
import com.eesteche.demo.users.User;
import com.eesteche.demo.users.UsersRepo;

@RestController
public class LoanController {
		
	@Autowired
	private LoanServiceImpl lsa;
	@Autowired
	private LoanRepo lrepo;
	@Autowired
	private UsersRepo urepo;
	@Autowired User user;
	Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@GetMapping("/loans")
	public ResponseEntity<?> getLoans(
	        @RequestParam(value ="user_id",required = false) Integer id_user,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "4") int size) {			
		
			LoanDto dto = new LoanDto();
			try {
		      List<Loan> loans = new ArrayList<Loan>();
		      Pageable paging = PageRequest.of(page, size);		      
		      Page<Loan> pageList;
		      
		      if (id_user == null) 
		    	  {pageList = lsa.getAll(paging);}
		      		      
		      else  {	
		      user = urepo.getOne(id_user);  		      
		      pageList  = lrepo.findByUser(user, paging);}
		      	      
		      loans = pageList.getContent();
		      dto.setItems(loans);
		      dto.setPage(pageList.getNumber());
		      dto.setSize(pageList.getTotalElements());
		      dto.setTotal(pageList.getTotalPages());	
		        
		      return new ResponseEntity<>(dto,HttpStatus.FOUND);
		      
		     } catch (Exception e) {
		      logger.error("error en GetMap/loans: "+e.getMessage()); 
		      throw new ErrorHandler("There was a problem retrieving data from the server.");	
		    }
	}	
}
