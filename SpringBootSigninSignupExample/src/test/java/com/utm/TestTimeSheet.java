package com.utm;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.utm.service.TimeSheetService;
import com.utm.model.TimeSheet;

public class TestTimeSheet extends UTMTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testTimeSheets() throws Exception {
		mockMvc.perform(get("/UTM/Timesheets")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("102"))
				.andExpect(jsonPath("$.employeeid").value("6"))
				.andExpect(jsonPath("$.date").value("6 April 2021"))
				.andExpect(jsonPath("$.comments").value("1 hr lunch"))
				.andExpect(jsonPath("$.datesubmitted").value("5 April 2021"))
				.andExpect(jsonPath("$.starttime").value("0900"))
				.andExpect(jsonPath("$.endtime").value("1600"));
		
	}
	@Test
	public void testTimeSheet() throws Exception {
		mockMvc.perform(get("http://localhost:8080/UTM/timesheet/8")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("104"))
				.andExpect(jsonPath("$.employeeid").value("8"));
		
	}
}//end of TestTimeSheet