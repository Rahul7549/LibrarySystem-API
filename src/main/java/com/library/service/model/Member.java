package com.library.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="member")
public class Member {
	
	@Id
	@Column(name="membid")
	private Long membid;
	
	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;
	
	@Column(name="membertype")
	private String membertype;
	
	@Column(name="membdate")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date membdate;
	
	@Column(name="mobile")
	private Long mobile;
	
	@Column(name="email")
	private String email;

	public Long getMembid() {
		return membid;
	}

	public void setMembid(Long membid) {
		this.membid = membid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	public Date getMembdate() {
		return membdate;
	}

	public void setMembdate(Date membdate) {
		this.membdate = membdate;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
