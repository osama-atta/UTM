package com.utm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utm.model.ShiftReport;

@Repository("ShiftReportReposistory")
public interface ShiftReportRepository extends CrudRepository<ShiftReport, Integer> {
}
