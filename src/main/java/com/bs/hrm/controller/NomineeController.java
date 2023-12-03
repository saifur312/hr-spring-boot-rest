package com.bs.hrm.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Experience;
import com.bs.hrm.entity.Nominee;
import com.bs.hrm.entity.Nominee;
import com.bs.hrm.entity.ids.ExperienceId;
import com.bs.hrm.entity.ids.NomineeIdentity;
import com.bs.hrm.repos.NomineeRepo;
import com.bs.hrm.service.EmployeeService;
import com.bs.hrm.service.NomineeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("employee")
public class NomineeController {
	
	@Autowired NomineeService 	nomineeService;
	@Autowired EmployeeService 	employeeService;
	@Autowired NomineeRepo 		nomineeRepo;
	
	public static final Logger logger = LoggerFactory.getLogger(NomineeController.class);
	
//	@GetMapping("/nominee-add")
//	public String addNominee(Model model) {
//		model.addAttribute("nominee", new Nominee());
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());
//		return "employee/nominee/nominee";
//		
//	}
//	
//	@PostMapping("/nominee-add-save")
//	public String saveNominee(Model model, Nominee nominee) {
//		System.out.println(nominee);
//		nomineeService.addNominee(nominee);
//		return "redirect:/nominee-add";
//		
//	}	
//	
//	@GetMapping("nominee-list")
//	public String showAllNominee(Model model) {
//		//model.addAttribute("allNominee", nomineeService.getAllNomineeByEmployeeId(null));
//		return "employee/nominee/nomineelist";
//	}
//	
//	@PostMapping("/nominee-list-find")
//	public String finNominees(@RequestBody MultiValueMap<String, String> values, Model model) {
//		System.out.println("Values:{}" + values);
//		Object findBy		=	values.getFirst("findBy");
//        String findByValue	=	values.getFirst("findByValue");
//        //List<String> findByValue1	=	values.get("findByValue");
//		System.out.println("After extract\t" + findBy + "\t" + findByValue);
//		
//		
//		if(findBy.equals("EmployeeId")) {
//			model.addAttribute("allNominee", nomineeService
//					.getAllNomineeByEmployeeId(Long.parseLong(findByValue)));
//		}
//		else if(findBy.equals("FirstName")) {
//			model.addAttribute("allNominee", nomineeRepo.findAllByFirstNameIsContainingIgnoreCase(findByValue));
//		}
//		else if(findBy.equals("LastName")) {
//			model.addAttribute("allNominee", nomineeRepo.findAllByLastNameContainingIgnoreCase(findByValue));
//		}
//		else if(findBy.equals("NID")) {
//			model.addAttribute("allNominee", nomineeRepo.findAllByNIDContainsIgnoreCase(findByValue));
//		}
//		else if(findBy.equals("Relation")) {
//			model.addAttribute("allNominee", nomineeRepo.findAllByRelationContainsIgnoreCase(findByValue));
//		}		
//		if(findBy.equals("Contact")) {
//			model.addAttribute("allNominee", nomineeRepo.findAllByContactContains(findByValue));
//		}
//		model.addAttribute("show", true);
//		return "employee/nominee/nomineelist";
//	}	
//	
//	@GetMapping("nominee-details")
//	public String showNomineeDetails(Model model, @RequestParam Long nomid, @RequestParam Long eid) {
//		model.addAttribute("nominee", nomineeService.getNominee(new NomineeIdentity(nomid, eid)));
//		return "employee/nominee/nomineedet";
//	}
	

	@PostMapping("nominee-add-save")
	public Nominee saveNominee(@RequestBody Nominee nomineeRequest) {
		logger.info("Form Data\t" +  nomineeRequest);
		Nominee nominee = nomineeRequest.toBuilder().build();
		logger.info("Copy Data\t" +  nominee);
		Nominee savedNominee = nomineeService.addNominee(nominee);
		return savedNominee;
		
	}

	@GetMapping("nominee-list")
	public List<Nominee> showNomineeList(@RequestParam Long employeeId) {
		logger.info("Nominee\t" + nomineeService.getAllNomineeByEmployeeId(employeeId));
		return nomineeService.getAllNomineeByEmployeeId(employeeId);
	}


	@GetMapping("nominee-details") 
	public Nominee showNomineeDetails(
			@RequestParam Long employeeId, @RequestParam Long nomineeId ) {
		return nomineeService.getNominee(new NomineeIdentity(nomineeId, employeeId));
	}

}
