package com.utm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utm.model.TimeSheet;
import com.utm.repository.TimeSheetRepository;

@Service
public class TimeSheetService {
	@Autowired
	TimeSheetRepository repo;
	
	public void Save(TimeSheet ts) {
		repo.save(ts);
	}
	
	public TimeSheet GetTimeSheet(int employee_id) {
		return repo.findByEmployeeid(employee_id);
	}
	
	public void DeleteTimeSheet(int employee_id) {
		repo.deleteByEmployeeid(employee_id);
	}
	
}
