package com.library.service.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="loans")
public class Loans {

	
	@Id
	@Column(name="issue_id")
	private Long issue_id;	
	
	@Column(name="return_date")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date return_date;
	
	@Column(name="issue_date")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date issue_date;
	
	@Column(name="due_date")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date due_date;
	
	@OneToOne
	@JoinColumn(name="bookid")
	private Books bookid;
	
	@ManyToOne
	@JoinColumn(name="membid")
	private Member membid;

	public Long getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Long issue_id) {
		this.issue_id = issue_id;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Books getBookid() {
		return bookid;
	}

	public void setBookid(Books bookid) {
		this.bookid = bookid;
	}

	public Member getMembid() {
		return membid;
	}

	public void setMembid(Member membid) {
		this.membid = membid;
	}

	
	
	
	
	
	
}

