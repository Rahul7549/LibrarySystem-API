package com.library.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.service.Repository.MenberRepository;
import com.library.service.model.Member;

@Service
public class MemberServiceImp {

	
	@Autowired
	MenberRepository menberRepository;
	
	public ResponseEntity<?> getAllMember()
	{
		List<Member> member=menberRepository.findAll();
		if(member.size()>0)
			return new ResponseEntity<List<Member>>(member,HttpStatus.OK);
		else
			return new ResponseEntity<>("No loans available",HttpStatus.NOT_FOUND);
	}
	
}
