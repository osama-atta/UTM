package com.utm;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.utm.model.ShiftReport;
import com.utm.repository.ShiftReportRepository;
import com.utm.service.ShiftReportService;

@DataJpaTest
public class ShiftReportServiceTest {

	@Autowired
	private ShiftReportRepository repo;
	
	@Autowired
	private ShiftReportService shiftservice;
	
	
@Test
	@Rollback(false)
	public void testSave()
	{
		ShiftReport shiftobj = new ShiftReport();
		ShiftReport sr = shiftservice.Save("test",9999,"testTest",shiftobj);
		assertNotNull(sr);
	}
	
	
	

}
