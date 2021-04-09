package com.utm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utm.model.TimeSheet;
import com.utm.repository.TimeSheetRepository;

@Service
public class TimeSheetService {
	@Autowired
	TimeSheetRepository timeSheetRepository;
	
	public void Save(TimeSheet ts) {
		timeSheetRepository.save(ts);
	}
	
	public List<TimeSheet> getTimeSheets(int employee_id) {
		
		return timeSheetRepository.findAllByEmployeeid(employee_id);
	}
	
	public void DeleteTimeSheet(int employee_id) {
		timeSheetRepository.deleteByEmployeeid(employee_id);
	}
	
	public List<TimeSheet> getAllTimeSheets() {
		return timeSheetRepository.findAll();
	}

	
}
