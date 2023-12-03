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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Leave;
import com.bs.hrm.entity.Leave;
import com.bs.hrm.service.EmployeeService;
import com.bs.hrm.service.LeaveService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveController {
	
	@Autowired LeaveService 		leaveService;
	@Autowired EmployeeService 		employeeService;

	public static final Logger logger = LoggerFactory.getLogger(LeaveController.class);
	
//	@GetMapping("/leave-add")
//	public String addLeave(Model model) {
//		model.addAttribute("leave", new Leave());
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());	
//		return "leave/leave";
//		
//	}
//	
//	@PostMapping("leave-add-save")
//	public String addSaveLeave(Model model, Leave leave) {
//		logger.info("Form Data\t"+ leave);
//		Leave savedLeave = leaveService.addLeave(leave);
//		logger.info("after save\t"+ savedLeave);
//		return "redirect:/leave-add";
//		
//	}
//	
//	@GetMapping("leave-list")
//	public String showLeaveList(Model model) {
//		return "leave/leave-list";
//	}
//
//	@PostMapping("leave-list-find")
//	public String finLeave(@RequestBody MultiValueMap<String, String> values, Model model) {
//		System.out.println("Values:{}" + values);
//		Object findBy = values.getFirst("findBy");
//		String findByValue = values.getFirst("findByValue");
//
//		if (findBy.equals("EmployeeId")) {
//			model.addAttribute("allLeave",
//					leaveService.getLeavesByEmployeeId(Long.parseLong(findByValue)));
//		}
//		model.addAttribute("show", true);
//		return "leave/leave-list";
//	}
//
//
//	@GetMapping("leave-details") 
//	public String showLeaveDetails(Model model, @RequestParam Long eid, @RequestParam Long lvid ) {
//	  
//	  model.addAttribute("leave", leaveService.getLeave(eid, lvid));
//		return "leave/leave";
//	}

	@PostMapping("leave-add-save")
	public Leave saveLeave(@RequestBody Leave leaveRequest) {
		logger.info("Form Data\t" +  leaveRequest);
		Leave leave = leaveRequest.toBuilder().build();
		logger.info("Copy Data\t" +  leave);
		Leave savedLeave = leaveService.addLeave(leave);
		return savedLeave;
		
	}

	@GetMapping("leave-list")
	public List<Leave> showLeaveList(@RequestParam Long employeeId) {
		return leaveService.getLeavesByEmployeeId(employeeId);
	}


	@GetMapping("leave-details") 
	public Leave showLeaveDetails(
			@RequestParam Long employeeId, @RequestParam Long leaveId ) {
		return leaveService.getLeave(employeeId, leaveId);
	}
}
