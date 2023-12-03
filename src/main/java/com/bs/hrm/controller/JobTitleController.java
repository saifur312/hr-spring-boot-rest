package com.bs.hrm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.JobTitle;
import com.bs.hrm.service.JobTitleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobTitleController {
	
	@Autowired JobTitleService jobTitleService;
	
	private static final Logger logger = LoggerFactory.getLogger(JobTitleController.class);
	
//	@GetMapping("jobtitle-add")
//	public String addJobTitle(Model model) {
//		model.addAttribute("jobtitle", new JobTitle());
//		return "setup/jobtitle/jobtitle";
//		
//	}
//	
//	@PostMapping("jobtitle-add-save")
//	public String saveJobTitle(Model model, JobTitle jobTitle) {
//		System.out.println(jobTitle);
//		jobTitleService.addJobTitle(jobTitle);
//		return "redirect:/jobtitle-add";
//		
//	}
//	
//	@PostMapping("jobtitle-update-save")
//	public String updateJobTitle(Model model, JobTitle jobTitle) {
//		jobTitleService.updateJobTitle(jobTitle);
//		return "redirect:/jobtitle-add";
//		
//	}
//	
//	@GetMapping("/jobtitle-list.html")
//	public String showJobTitleList(Model model) {
//		model.addAttribute("jobtitleList", jobTitleService.getAllJobTitle());
//		return "setup/jobtitle/jobtitle-list";
//	}
//
//
//	@GetMapping("jobtitle-details") 
//	public String showJobTitleDetails(Model model, @RequestParam Integer jid ) {
//	  
//		model.addAttribute("jobtitle", jobTitleService.getJobTitle(jid));
//		return "setup/jobtitle/jobtitle"; 
//	}	
	
	
	@PostMapping("jobtitle-add-save")
	public JobTitle saveJobTitle(@RequestBody JobTitle jobTitleRequst) {
		logger.info("Form Data\t" +  jobTitleRequst);
		JobTitle jobTitle = jobTitleRequst.toBuilder().build();
		logger.info("Copy Data\t" +  jobTitle);
		JobTitle jobTitleSaved = jobTitleService.addJobTitle(jobTitle);
		return jobTitleSaved;
		
	}
	
	@GetMapping("jobtitle-list")
	public List<JobTitle> getJobTitleList() {
		return jobTitleService.getAllJobTitle();
	}

	@GetMapping("jobtitle-details") 
	public JobTitle showJobTitleDetails(@RequestParam Integer jobId ) {
		return jobTitleService.getJobTitle(jobId); 
	}

}
