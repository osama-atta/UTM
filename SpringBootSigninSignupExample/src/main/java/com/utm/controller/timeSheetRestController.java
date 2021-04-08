package com.utm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utm.model.TimeSheet;
import com.utm.service.TimeSheetService;

@RestController
public class timeSheetRestController {
	
	@Autowired
	TimeSheetService timesheetService;
	
//Get all timesheets
	@GetMapping("/timesheets")
	public List<TimeSheet> getAllTimeSheets() {
		return timesheetService.getAllTimeSheets();
	}
	
//Get timesheets by userid
	
	
//put timesheet
	
}
