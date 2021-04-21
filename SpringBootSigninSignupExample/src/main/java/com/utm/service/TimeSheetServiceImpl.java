package com.utm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utm.model.TimeSheet;
import com.utm.repository.TimeSheetRepository;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {
	
	@Autowired
	private TimeSheetRepository timeSheetRepository;
	
	public TimeSheet save(TimeSheet timesheet) {
		return timeSheetRepository.save(timesheet);
	}
	
	@Override
	public List<TimeSheet> getTimeSheets(int employee_id) {
		
		return timeSheetRepository.findAllByEmployeeid(employee_id);
	}
	
	@Override
	public void DeleteTimeSheet(int employee_id) {
		timeSheetRepository.deleteByEmployeeid(employee_id);
	}
	
	@Override
	public List<TimeSheet> getAllTimeSheets() {
		return timeSheetRepository.findAll();
	}
	
	@Override
	public TimeSheet addTimeSheet(TimeSheet timesheet) {
		
		
		timeSheetRepository.save(timesheet);
		return timesheet;
	}
}
