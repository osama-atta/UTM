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
	
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public ModelAndView landingPage( ) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/index");
		return model;
	}
	
	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
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
			model.setViewName("user/signup");//I would like to change this but when it redirects the message goes away. 
		}
		
		return model;
	}
	
	@RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
	public String homeHome () {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName",user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) //convert collection to a stream and look for anymatch 
				{
			return "redirect:/home/admin";
				}
		return "redirect:/home/employee";
					
		//model.setViewName("/home/home");
		//return model;
	}
	
	@RequestMapping(value= {"/home/admin"}, method=RequestMethod.GET)
	public ModelAndView homeAdmin () {
		ModelAndView model = new ModelAndView();
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		model.addObject("userName",user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		model.setViewName("/home/admin");
		return model;
	}
	@RequestMapping(value= {"/home/employee"}, method=RequestMethod.GET)
	public ModelAndView homeEmployee () {
		ModelAndView model = new ModelAndView();
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		model.addObject("userName",user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		model.setViewName("/home/employee");
		return model;
	}
	
	@RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	public ModelAndView accessDenied () {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
}
