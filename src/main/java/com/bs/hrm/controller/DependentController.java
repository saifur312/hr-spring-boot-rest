package com.bs.hrm.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Dependent;
import com.bs.hrm.entity.Dependent;
import com.bs.hrm.service.DependentService;
import com.bs.hrm.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DependentController {
	@Autowired DependentService 	dependentService;
	@Autowired EmployeeService 		employeeService;
	
	public static final Logger logger = LoggerFactory.getLogger(DependentController.class);
	
	
//	@GetMapping("/dependents-add")
//	public String addDependents(Model model) {
//		model.addAttribute("dependents", new Dependent());
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());	
//		return "employee/dependents/dependents";
//		
//	}
//	
//	@PostMapping("dependents-add-save")
//	public String addSaveDepartment(Model model, Dependent dependent) {
//		logger.info("Form Data\t"+ dependent);
//		Dependent savedDependent = dependentService.addDependent(dependent);
//		logger.info("after save\t"+ savedDependent);
//		return "redirect:/dependents-add";
//		
//	}
//	
//	@GetMapping("dependents-list")
//	public String showDepartmentList(Model model) {
//		return "employee/dependents/dependents-list";
//	}
//
//	@PostMapping("dependents-list-find")
//	public String finDepartment(@RequestBody MultiValueMap<String, String> values, Model model) {
//		System.out.println("Values:{}" + values);
//		Object findBy = values.getFirst("findBy");
//		String findByValue = values.getFirst("findByValue");
//		System.out.println("After extract\t" + findBy + "\t" + findByValue);
//
//		if (findBy.equals("EmployeeId")) {
//			model.addAttribute("allDependents",
//					dependentService.getDependentsByEmployeeId(Long.parseLong(findByValue)));
//		}
//		model.addAttribute("show", true);
//		return "employee/dependents/dependents-list";
//	}
//
//
//	@GetMapping("dependents-details") 
//	public String showDepartmentDetails(Model model, @RequestParam Long eid, @RequestParam Long did ) {
//	  
//	  model.addAttribute("dependents", dependentService.getDependent(eid, did)); 
//
//	  return "employee/dependents/dependents";
//	}
	
	
	
	@PostMapping("dependent-add-save")
	public Dependent addSaveDependent(@RequestBody Dependent dependentRequest) {
		logger.info("Form Data\t" +  dependentRequest);
		Dependent dependent = dependentRequest.toBuilder().build();
		logger.info("Copy Data\t" +  dependent);
		Dependent savedDependent = dependentService.addDependent(dependent);
		return savedDependent;
		
	}

	@GetMapping("dependent-list")
	public List<Dependent> showDependentList(@RequestParam Long employeeId) {
		return dependentService.getDependentsByEmployeeId(employeeId);
	}


	@GetMapping("dependent-details") 
	public Dependent showDependentDetails(
			@RequestParam Long employeeId, @RequestParam Long dependentId ) {
		return dependentService.getDependent(employeeId, dependentId);
	}
	 

}
