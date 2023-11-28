 /*******************************************************************************
 Author: Md. Saifur Rahman
 Created Date: 03-Jan-2021
 Last Update: 06-Jan-2021
 
 *******************************************************************************/

package com.bs.hrm.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.dto.EmployeeDto;
import com.bs.hrm.dto.EmployeeSub;
import com.bs.hrm.entity.Employee;
import com.bs.hrm.entity.Section;
import com.bs.hrm.service.DepartmentService;
import com.bs.hrm.service.EmployeeService;
import com.bs.hrm.service.SectionService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired EmployeeService 		employeeService;
	@Autowired DepartmentService 	departmentService;
	@Autowired SectionService 		sectionService;
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//@GetMapping({"/", "employee-add"}) 
//	@GetMapping("employee-add") 
//	public String showEmployee(Model model) {
//		EmployeeDto employeeDto = new EmployeeDto();
//		model.addAttribute("allDepartment", departmentService.getAllDepartment());
//		model.addAttribute("allSection", sectionService.getAllSection());
//		model.addAttribute("employeeDto", employeeDto);
//		return "employee/employee-info/employee";
//	}
//	
//	@PostMapping("employee-add-save")
//	public String saveEmployee(Model model, EmployeeDto employeeDto) throws Exception {
//		System.out.println(employeeDto);
//		employeeDto.setEmployeeImage(employeeDto.getImageFile().getBytes());
//		employeeService.addEmployee(employeeDto);
//		return "redirect:/employee-add";
//	}
//	
//	@GetMapping("employee-details")
//	public String showEmployeeDetails(Model model, @RequestParam Long id) {
//		model.addAttribute("employeeDto", employeeService.getEmployee(id));
//		return "employee/employee-info/empdet";
//	}
//	
//	@GetMapping("employee-edit")
//	public String editEmployee(Model model, @RequestParam Long id) {
//		model.addAttribute("employeeDto", employeeService.getEmployee(id));
//		return "employee/employee-info/empedit";
//	}
//	
//	@PostMapping("employee-edit-save")
//	public String saveEmployeeEdit(Model model, EmployeeDto employeeDto) {
//		return "";
//	}
//	
//	@PostMapping("employee-delete")
//	public String DeleteEmployee(Model model, Long employeeId) {
//		return "";
//	}
//
//	
//	@GetMapping("employee-list")
//	public String showAllEmployee(Model model) {
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());
//		return "employee/employee-info/emplist.html";
//	}
//	
//	@PostMapping("employee-list-find")
//	public String finEmployees(@RequestBody MultiValueMap<String, String> values, Model model) {
//		System.out.println("Values:{}" + values);
//		Object findBy		=	values.getFirst("findBy");
//        String findByValue	=	values.getFirst("findByValue");
//        String reqFlag		=	values.getFirst("reqFlag");
//		System.out.println("After extract\t" + findBy + "\t" + findByValue + "\t" +  reqFlag);
//		
//		model.addAttribute("flag", reqFlag);
//		
//		if(findBy.equals("EmployeeId")) {
//			model.addAttribute("allEmployee", employeeService
//					.getAllByEmployeeId(Long.parseLong(findByValue)));
//		}
//		else if(findBy.equals("Name")) {
//			model.addAttribute("allEmployee", employeeService.getAllByName(findByValue));
//		}
//		else if(findBy.equals("NickName")) {
//			model.addAttribute("allEmployee", employeeService.getAllByNickName(findByValue));
//		}
//		else if(findBy.equals("NID")) {
//			model.addAttribute("allEmployee", employeeService.getAllByNID(findByValue));
//		}
//		else if(findBy.equals("FingerId")) {
//			model.addAttribute("allEmployee", employeeService.getAllByFingerId(findByValue));
//		}
//		model.addAttribute("show", true);
//		return "employee/employee-info/emplist.html";
//	}
//	
//	@GetMapping("employee-select")
//	public String copyAndPasteEmployeeId(Model model, @RequestParam Long id, @RequestParam String reqflag) {
//		//model.addAttribute("employeeDto", employeeService.getEmployee(id));
//		Employee emp = new Employee();
//		emp.setEmployeeId(employeeService.getEmployee(id).getEmployeeId());
//		model.addAttribute("employee", emp);
//		
//		//model.addAttribute("selectedEmpID", employeeService.getEmployee(id).getEmployeeId());
//		return "employee/experience/explist";
//	}	
//	
//	@ResponseBody
//	@PostMapping("findEmployee")
//	public EmployeeSub getProductDetails(@RequestParam Long employeeId){
//		logger.info("Ajax call success");
//		EmployeeDto employee = employeeService.getEmployee(employeeId);
//		
//		EmployeeSub employeeSub = new EmployeeSub();
//		employeeSub.setFullName(employee.getFullName());
//		employeeSub.setBasicSalary(employee.getBasicSalary());
//		
//		System.out.println("Eemployee\t" + employeeSub);
//		return employeeSub;
//	
//	}
	
	@PostMapping("employee-add-save")
	public String saveEmployee(@RequestBody EmployeeDto empRequest) {
		System.out.println(empRequest);
		//employeeService.addEmployee(employeeDto);
		EmployeeDto empDto = new EmployeeDto(empRequest);
//		Employee employee = new Employee();
//		BeanUtils.copyProperties(empRequest, employee);
		System.out.println(empDto);
		employeeService.addEmployee(empDto);
		return "Data saved successfull";
	}
	
	@GetMapping("employee-details")
	public EmployeeDto showEmployeeDetails(@RequestParam Long id) {
		EmployeeDto empDto = employeeService.getEmployee(id);
		return empDto;
	}
	
}
