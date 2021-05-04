package com.utm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utm.model.ShiftReport;
import com.utm.repository.ShiftReportRepository;

@Service("ShiftReportService")
public class ShiftReportServiceImpl implements ShiftReportService {
	
	@Autowired
	ShiftReportRepository repo;
	
	

	@Override
	public List<ShiftReport> getReports() {
		return (List<ShiftReport>) repo.findAll();
	}

	@Override
	public ShiftReport Save(String report, Integer id, String firstAndLastName, ShiftReport reportObj) {
		reportObj.setReport(report);
		reportObj.setUserid(id);
		reportObj.setFirstAndLastName(firstAndLastName);
		return repo.save(reportObj);
	}

}
