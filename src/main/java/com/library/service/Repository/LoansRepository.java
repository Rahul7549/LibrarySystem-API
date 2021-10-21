package com.library.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.service.model.Loans;

public interface LoansRepository  extends JpaRepository<Loans,Long> {

}
