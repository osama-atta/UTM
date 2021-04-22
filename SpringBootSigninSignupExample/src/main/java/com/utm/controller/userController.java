package com.utm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.utm.model.ShiftReport;
import com.utm.model.TimeSheet;
import com.utm.model.User;
import com.utm.service.ShiftReportService;
import com.utm.service.TimeSheetService;
import com.utm.service.UserService;

@Controller
@SessionAttributes("userid")
public class userController {
	
	@Autowired
	private ShiftReport reportObj;
	@Autowired
	private UserService userService;
	@Autowired
	private ShiftReportService reportService;
	@Autowired
	private TimeSheet timesheet;
	@Autowired
	private TimeSheetService tservice;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView landingPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/index");
		return model;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");

		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createuser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already Exists!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "User had been registered Successfully");
			model.addObject("user", user);
			model.setViewName("user/signup");// I would like to change this but when it redirects the message goes away.

		}

		return model;
	}

	@RequestMapping(value = { "/home/home" }, method = RequestMethod.GET)
	public String homeHome() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		// System.out.println("User service is: "+userService.findUserById((long)
		// 6).getId());
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) // convert																				// for
																											// anymatch
		{
			return "redirect:/home/admin";
		}
		return "redirect:/home/employee";

		// model.setViewName("/home/home");
		// return model;
	}

	@RequestMapping(value = { "/home/admin" }, method = RequestMethod.GET)
	public ModelAndView homeAdmin() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("timesheet", timesheet);
		model.setViewName("/home/admin");
		return model;
	}

	@RequestMapping(value = { "/home/employee" }, method = RequestMethod.GET)
	public ModelAndView homeEmployee() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		List<ShiftReport> report = reportService.getReports();
		List<ShiftReport> recentReport = sortedReport(report);
		model.addObject("userName", user.getFirstname() + " " + user.getLastname());
		model.addObject("userid", user.getId());
		model.addObject("reports", recentReport);
		model.addObject("timesheet", timesheet);
		model.setViewName("/home/employee");
		return model;
	}

	@RequestMapping(value = { "/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public ModelAndView profile(@ModelAttribute("userid") Integer id) {
		ModelAndView model = new ModelAndView();
		System.out.println("ID is: " + id);
		model.setViewName("user/profile");
		User user = userService.findUserById(id);
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public ModelAndView editprofile(@ModelAttribute("userid") Integer id) {
		System.out.println("Edit called");
		ModelAndView model = new ModelAndView();
		model.setViewName("user/profile");
		User user = userService.findUserById(id);
		model.addObject("edit", "editable");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = { "/updateuserinfo" }, method = RequestMethod.POST)
	public String updateprofile(@ModelAttribute("user") User user, @ModelAttribute("userid") Integer id) {
		ModelAndView model = new ModelAndView();
		userService.updateUserProfile(user, id);
		return "redirect:/profile";
	}

	@RequestMapping(value = { "/resetPassword" }, method = RequestMethod.GET)
	public ModelAndView resetpass(@ModelAttribute("user") User user, Integer id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/resetPassword");
		return model;
	}

	@RequestMapping(value = { "/resetP" }, method = RequestMethod.POST)
	public String updatePassword(@ModelAttribute("userid") Integer id, @ModelAttribute("pass2") String password) {
		ModelAndView model = new ModelAndView();
		System.out.println("you are here" + password);
		System.out.println("you are here" + id);
		userService.updateUserPassword(id, password);
		return "redirect:/profile";
	}

	@RequestMapping(value = { "/report" }, method = RequestMethod.POST)
	public String shiftReport(@ModelAttribute("userid") Integer id,
			@ModelAttribute("report") String report, 
			@ModelAttribute("firstAndLastName") String firstAndLastName) {
		System.out.println("User id in report is: " + id);
		System.out.println("Report is: " + report);
		reportService.Save(report, id, firstAndLastName, reportObj);
		return "redirect:/home/employee";
	}
	
	private List<ShiftReport> sortedReport(List<ShiftReport> reportList) {
		Collections.reverse(reportList);
		List<ShiftReport> returnedReport = new ArrayList<ShiftReport>();
		for(int i = 0; i < 4; i++) {
			returnedReport.add(reportList.get(i));
			//Integer userid = returnedReport.get(i).getUserid();			
		}
		return returnedReport;	
	}
}
