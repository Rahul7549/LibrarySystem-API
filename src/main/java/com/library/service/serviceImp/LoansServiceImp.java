package com.library.service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.library.service.Repository.*;
import com.library.service.model.Loans;

@Service
public class LoansServiceImp {
	
	
	@Autowired
	LoansRepository loansRepository;
	
	public ResponseEntity<?> getAllLoans()
	{
		List<Loans> books=loansRepository.findAll();
		if(books.size()>0)
			return new ResponseEntity<List<Loans>>(books,HttpStatus.OK);
		else
			return new ResponseEntity<>("No loans available",HttpStatus.NOT_FOUND);
	}
	
	public Loans getLoanById(Long issue_id)
	{
		
		Optional<Loans> loan=loansRepository.findById(issue_id);
		if(loan.isPresent())
		{
			return loan.get();
		}
		else
		{
				return null;
		}
	}
	
	
	public Loans createLoan(Loans newLoan)
	{
		return loansRepository.save(newLoan);
	}
	
	//Update Loans
	public Loans updateLoan(Loans newLoan)
	{
		return loansRepository.findById(newLoan.getIssue_id())
				.map(loan -> {
					loan.setBookid(newLoan.getBookid());
					loan.setDue_date(newLoan.getDue_date());
					loan.setMembid(newLoan.getMembid());
					loan.setReturn_date(newLoan.getReturn_date());
					loan.setIssue_date(newLoan.getIssue_date());
					return loansRepository.save(loan);
				})
				.orElseGet(()->{
					return loansRepository.save(newLoan);
				});
	}
	
	
	///Delete Loans...
	public void deleteLoan(Long issue_id) {
		  loansRepository.deleteById(issue_id);
		
	}

}
