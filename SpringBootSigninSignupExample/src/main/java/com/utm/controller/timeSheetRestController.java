package com.utm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utm.model.TimeSheet;
import com.utm.service.TimeSheetService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class timeSheetRestController {
	private	TimeSheetService timesheetService;
	
	@Autowired
	public timeSheetRestController(TimeSheetService timesheetService) {
		this.timesheetService = timesheetService;
	}
	
	@Operation(summary = "Get all timesheets")
	@GetMapping("/timesheets")
	public List<TimeSheet> getAllTimeSheets() {
		return timesheetService.getAllTimeSheets();
	}
	
	@Operation(summary = "Get timesheets by userid")
	@GetMapping("/timesheet/{id}")
	public List<TimeSheet> getTimesheetsById(@PathVariable("id")int employeeID) {
		//List<TimeSheet> timesheet = timesheetService.getTimeSheets(employeeID);
			//if(timesheet == null) {
				//return new ResponseEntity<List<TimeSheet>> (timesheet, HttpStatus.NOT_FOUND);
			//}
			return timesheetService.getTimeSheets(employeeID);
	}
	
	
	@Operation(summary = "create new timesheet")
	@PostMapping("/timesheet/add")
	public ResponseEntity<Void> createTimeSheetbyEmployeeID( TimeSheet timeSheet) throws IOException {
		timesheetService.save(timeSheet);
		 return ResponseEntity.noContent().build();
	}
	
}
