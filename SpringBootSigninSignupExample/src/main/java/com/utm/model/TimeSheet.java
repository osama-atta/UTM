package com.utm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String Start_time;
	
	@Column(name = "End_time")
	private String End_time;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "date_submitted")
	private String date_submitted;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employeeid;
	}

	public void setEmployee_id(int employee_id) {
		this.employeeid = employee_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart_time() {
		return Start_time;
	}

	public void setStart_time(String start_time) {
		Start_time = start_time;
	}

	public String getEnd_time() {
		return End_time;
	}

	public void setEnd_time(String end_time) {
		End_time = end_time;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}
	
	
}
