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
public class userController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TimeSheet timesheet;
	@Autowired
	private TimeSheetService tservice;
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView login( ) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");
		
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	public ModelAndView createuser(@Valid User user, BindingResult bindingResult ) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		
		if(userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already Exists!"); 
		}
		if(bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		}else {
			userService.saveUser(user);
			model.addObject("msg", "User had been registered Successfully");
			model.addObject("user", user);
			model.setViewName("user/signup");
		}
		
		return model;
	}
	
	@RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
	public ModelAndView home () {
		ModelAndView model = new ModelAndView();
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		model.addObject("userName",user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		model.setViewName("/home/home");
		return model;
	}
	
	@RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	public ModelAndView accessDenied () {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
	@RequestMapping(value= {"/timesheet"}, method=RequestMethod.GET)
	public ModelAndView saveTimesheet(@ModelAttribute("timesheet") TimeSheet timesheet) {
		ModelAndView model = new ModelAndView();
		tservice.Save(timesheet);
		model.setViewName("/home/home");
		return model;
	}
	
	
}
