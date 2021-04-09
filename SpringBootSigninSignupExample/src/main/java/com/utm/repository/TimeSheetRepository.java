package com.utm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.utm.model.TimeSheet;

@Repository("timesheet")
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer>
{
	TimeSheet findByEmployeeid(int employee_id);
	TimeSheet deleteByEmployeeid(int employee_id);
	List<TimeSheet> findAllByEmployeeid(int employee_id);
}
