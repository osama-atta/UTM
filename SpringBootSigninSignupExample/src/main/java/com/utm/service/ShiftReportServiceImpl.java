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
	
//	@Autowired
//	private ShiftReport reportObj;
	@Override
	public void Save(String report, Integer id, ShiftReport reportObj) {
		reportObj.setReport(report);
		reportObj.setUserid(id);
		repo.save(reportObj);
		System.out.println("Services executed......");
	}

	@Override
	public List<ShiftReport> getReports() {
		return (List<ShiftReport>) repo.findAll();
	}

}
