package com.bs.hrm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.dto.EmployeeDto;
import com.bs.hrm.dto.EmployeeTest;
import com.bs.hrm.entity.Department;
import com.bs.hrm.service.DepartmentService;
import com.bs.sms.SmsController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
	
	@Autowired DepartmentService departmentService;
//	
//	@GetMapping("department-add")
//	public String showDepartment(Model model) {
//		model.addAttribute("department", new Department()).addAttribute("detail", false);
//		return "setup/department/department";
//		
//	}
//	
//	@PostMapping("department-add-save")
//	public String addDepartment(Model model, Department depatment) {
//		System.out.println(depatment);
//		departmentService.addDepartment(depatment);
//		return "redirect:/department-add";
//		
//	}
//	
//	@PostMapping("department-update-save")
//	public String updateDepartment(Model model, Department depatment) {
//		departmentService.updateDepartment(depatment);
//		return "redirect:/department-add";
//		
//	}
//	
//	
//	@GetMapping("/dept-list.html")
//	public String showDepartmentList(Model model) {
//		model.addAttribute("deptList", departmentService.getAllDepartment());
//		return "setup/department/dept-list";
//	}
//	
//	@GetMapping("dept-details") 
//	public String showDepartmentDetails(Model  model, @RequestParam Integer id) {
//		  model.addAttribute("department", departmentService.getDepartment(id))
//		  	.addAttribute("detail", true); 
//		  return "setup/department/department"; 
//	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("department-add-save")
	public String saveDepartment( @RequestBody Department requestAsDepartment)  {
		
		String departmentName = requestAsDepartment.getDepartmentName();
		String description = requestAsDepartment.getDescription();
		String responsibilty = requestAsDepartment.getResponsibilty();
		String managerName = requestAsDepartment.getManagerName();
		Integer totalEmployee = requestAsDepartment.getTotalEmployee();
		
		System.out.println("departmentName:\t" + departmentName+ 
						   "\ndescription:\t" + description+ 
						   "\nresponsibilty:\t" + responsibilty+ 
						   "\nmanagerName:\t" + managerName+ 
						   "\ntotalEmployee:\t" + totalEmployee);
		
		Department department = new Department();
		department.setDepartmentName(departmentName);
		department.setDescription(description);
		department.setResponsibilty(responsibilty);
		department.setManagerName(managerName);
		department.setTotalEmployee(totalEmployee);
		
		Department savedDept = departmentService.addDepartment(department);
		if (savedDept != null)
			return "Data saved successfull";
		else
			return "Data saved not successfull";
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/dept-list")
	public List<Department> showDepartmentList(Model model) {
		List<Department> deptList = departmentService.getAllDepartment();
		deptList.forEach(System.out::println);
		return deptList;
	}

}
