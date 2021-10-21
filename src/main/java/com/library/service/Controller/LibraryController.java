package com.library.service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.model.Books;
import com.library.service.model.Loans;
import com.library.service.serviceImp.*;


@RestController
@RequestMapping("/library")
@Transactional
public class LibraryController {
	
	@Autowired
	BookServiceImp bookServiceImp;
	
	@Autowired
	LoansServiceImp loansServiceImp;
	
	
	@Autowired
	MemberServiceImp memberServiceImp;
	
	@GetMapping("/book")  
	public ResponseEntity<?> getAllBooks()   
	{  
		return bookServiceImp.getAllBooks(); 	
	}  
	
	@GetMapping("/book/{id}")
	public Books getBookById(@PathVariable Long id )   
	{  
		return bookServiceImp.getBookById(id);
	}
	
	@PostMapping("/book")
	public Books CreateBook(@RequestBody  Books newBook)
	{
		return bookServiceImp.createBook(newBook);
	}
	
	@PutMapping("/book")
	public Books updateBook(@RequestBody Books newBook)
	{
		return bookServiceImp.updateBook(newBook);
	}
	
	@DeleteMapping("/book/{Bookid}")
	public void deleteBook(@PathVariable Long Bookid)
	{
		 bookServiceImp.deleteBook(Bookid);
		
	}
	
	@GetMapping("/loans")
	public ResponseEntity<?> getAllLoans()
	{
		return loansServiceImp.getAllLoans();
		
	}
	
	
	@GetMapping("/loan/{issue_id}")
	public Loans getLoanById(@PathVariable Long issue_id)
	{
		return loansServiceImp.getLoanById(issue_id);
	}
	
	
	@PostMapping("/loan")
	public Loans createLoan(@RequestBody Loans newLoan)
	{
		return loansServiceImp.createLoan(newLoan);
	}
	@PutMapping("/loan")
	public Loans updateLoan(@RequestBody Loans newLoan)
	{
		return loansServiceImp.updateLoan(newLoan);
	}
	
	@DeleteMapping("/loan/{issue_id}")
	public void deleteLoan(@PathVariable Long issue_id)
	{
		loansServiceImp.deleteLoan(issue_id);
		
	}
	
	@GetMapping("/member")
	public ResponseEntity<?> getAllMember()
	{
		return memberServiceImp.getAllMember();
		
	}
	
	
}
