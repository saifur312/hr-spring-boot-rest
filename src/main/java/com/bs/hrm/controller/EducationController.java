package com.bs.hrm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Education;
import com.bs.hrm.entity.Education;
import com.bs.hrm.service.EmployeeService;
import com.bs.hrm.service.EducationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EducationController {
	@Autowired
	EducationService educationService;
	@Autowired
	EmployeeService employeeService;

	public static final Logger logger = LoggerFactory.getLogger(EducationController.class);

//	@GetMapping("/education-add")
//	public String addEducation(Model model) {
//		model.addAttribute("education", new Education());
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());
//		return "employee/education/education";
//
//	}
//
//	@PostMapping("education-add-save")
//	public String addSaveDepartment(Model model, Education education) {
//		logger.info("Form Data\t" + education);
//		educationService.addEducation(education);
//		return "redirect:/education-add";
//
//	}
//
//	@GetMapping("education-list")
//	public String showAllNominee(Model model) {
//		return "employee/education/edulist";
//	}
//
//	@PostMapping("education-list-find")
//	public String finEducations(@RequestBody MultiValueMap<String, String> values, Model model) {
//		System.out.println("Values:{}" + values);
//		Object findBy = values.getFirst("findBy");
//		String findByValue = values.getFirst("findByValue");
//		// List<String> findByValue1 = values.get("findByValue");
//		System.out.println("After extract\t" + findBy + "\t" + findByValue);
//
//		if (findBy.equals("EmployeeId")) {
//			model.addAttribute("allEducation",
//					educationService.getAllEducationByEmployeeId(Long.parseLong(findByValue)));
//		}
//		model.addAttribute("show", true);
//		return "employee/education/edulist";
//	}
//
//
//	
//	  @GetMapping("education-details") 
//	  public String showExperienceDetails(Model model, @RequestParam Long eid, @RequestParam String compdt ) {
//	  //@RequestParam("compdt") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate compdt) {
//	  
//		  LocalDate completionDate = LocalDate.parse(compdt,
//				  DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
//		  model.addAttribute("education", educationService.getEducation(eid, completionDate)); 
//		  return "employee/education/edudet"; 
//	  }
	 
	@PostMapping("education-add-save")
	public Education addSaveEducation(@RequestBody Education educationRequest) {
		logger.info("Form Data\t" +  educationRequest);
		Education education = educationRequest.toBuilder().build();
		logger.info("Copy Data\t" +  education);
		Education savedEducation = educationService.addEducation(education);
		return savedEducation;
		
	}

	@GetMapping("education-list")
	public List<Education> showEducationList(@RequestParam Long employeeId) {
		return educationService.getAllEducationByEmployeeId(employeeId);
	}


	@GetMapping("education-details") 
	public Education showEducationDetails(
			@RequestParam Long employeeId, @RequestParam String completionDateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if(!completionDateStr.isEmpty())
			return educationService.getEducation(employeeId, 
				LocalDate.parse(completionDateStr, formatter));
		else return null;
	}
}
