package com.utm.service;

import java.util.List;

import com.utm.model.TimeSheet;
import com.utm.repository.TimeSheetRepository;


public interface TimeSheetService {
		
	public void Save(TimeSheet timesheet);
	
	public List<TimeSheet> getTimeSheets(int employee_id);
	
	public void DeleteTimeSheet(int employee_id);
	
	public List<TimeSheet> getAllTimeSheets();
	

	public TimeSheet addTimeSheet( TimeSheet newTimeSheet);
	
}
