package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.repo.ReportRepo;

@Repository
public class ReportDao {


	@Autowired
	ReportRepo reportRepo;
	
	
	public Report saveReport(Report report) {
		return reportRepo.save(report);
	}
	
	public Report updateReportById(int oldReportId, Report newReport) {
		newReport.setReportId(oldReportId);
	//	return ReportRepo.save(newReport);
		return saveReport(newReport);
	}
	
	public Report fetchReportById(int reportId) {
		Optional<Report> report = reportRepo.findById(reportId);
		if(report.isEmpty()) {
			return null;
		}
		else {
			return report.get();
		}
	}
	
	public Report deleteReportById(int reportId) {
	//	Report Report=ReportRepo.findById(ReportId).get();
		Report Report=fetchReportById(reportId);
		reportRepo.delete(Report);
		return Report;
	}
	
	public List<Report> fetchAllReport(){
		return reportRepo.findAll();
	}
}
