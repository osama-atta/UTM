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
@Table(name="shiftReport")
public class ShiftReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "report")
	private String report;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReport() {
		return report;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "ShiftReport [id=" + id + ", report=" + report + "]";
	}
	
}
