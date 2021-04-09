package com.utm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.utm.model.TimeSheet;
import com.utm.model.User;
import com.utm.service.TimeSheetService;
import com.utm.service.UserService;

@Controller
public class timesheetController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TimeSheet timesheet;
	@Autowired
	private TimeSheetService timeSheetService;
	
	//@RequestMapping(value= {"/timesheet"}, method=RequestMethod.GET)
	public ModelAndView saveTimesheet(@ModelAttribute("timesheet") TimeSheet timesheet) {
		ModelAndView model = new ModelAndView();
		timeSheetService.Save(timesheet);
		model.setViewName("/home/home");
		return model;
	}
	
	
}
