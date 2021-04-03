package com.utm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name="timesheet")
public class TimeSheet 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "employee_id")
	private int employeeid;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "Start_time")
	private String Starttime;
	
	@Column(name = "End_time")
	private String Endtime;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "date_submitted")
	private String datesubmitted;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employee_id) {
		this.employeeid = employee_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStarttime() {
		return Starttime;
	}

	public void setStarttime(String start_time) {
		Starttime = start_time;
	}

	public String getEndtime() {
		return Endtime;
	}

	public void setEndtime(String end_time) {
		Endtime = end_time;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDatesubmitted() {
		return datesubmitted;
	}

	public void setDatesubmitted(String date_submitted) {
		this.datesubmitted = date_submitted;
	}
	
	
}
