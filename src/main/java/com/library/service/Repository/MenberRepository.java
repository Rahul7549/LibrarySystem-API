package com.library.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.service.model.Member;

public interface MenberRepository extends JpaRepository<Member,Long>{

}
