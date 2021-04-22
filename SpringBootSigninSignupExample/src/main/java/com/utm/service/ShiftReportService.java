package com.utm.service;

import java.util.List;

import com.utm.model.ShiftReport;

public interface ShiftReportService {
	
	public void Save(String report, Integer id, String firstAndLastName, ShiftReport reportObj);
	public List<ShiftReport> getReports();
}
