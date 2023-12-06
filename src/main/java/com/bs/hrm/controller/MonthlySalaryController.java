package com.bs.hrm.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bs.hrm.dto.BSMonth;
import com.bs.hrm.repos.MonthlySalaryRepo;
import com.bs.hrm.service.DepartmentService;
import com.bs.hrm.service.MonthlySalaryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MonthlySalaryController {

	@Autowired
	MonthlySalaryService monthlySalaryService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	MonthlySalaryRepo monthlySalaryRepo;

//	@GetMapping("monthly-salary.html")
//	public String showMonthlySalary(Model model) {
//		BSMonth m =  BSMonth.valueOf("MARCH");
//		System.out.println(m.getShortForm() + m.ordinal() + " " + BSMonth.values()[5]);
//		model.addAttribute("departmentList", departmentService.getAllDepartment());
//		return "salary/monthly-salary/monthly-salary.html";
//	}
//
//	@PostMapping("show-monthly-salary")
//	public String showSelectedMonthlySalary(Model model, @RequestBody MultiValueMap<String, String> values,
//			RedirectAttributes redirectAttrs) {
//		System.out.println("Values: " + values);
//		String findBy = values.getFirst("findBy");
//		String findByValue = values.getFirst("findByValue");
//		String employeeType = values.getFirst("employeeType");
//		String department = values.getFirst("department");
//		System.out.println("After extract\t" + findBy + "\t" + findByValue + "\t" + employeeType + "\t" + department);
//
//		Integer year = 0, month = 0;
//		if (findBy.equalsIgnoreCase("Year")) {
//			year = Integer.parseInt(findByValue);
//			redirectAttrs.addFlashAttribute("monthlySalaryList", monthlySalaryService.getMonthlySalaryByYear(year));
//			redirectAttrs.addFlashAttribute("prevValue", findByValue);
//		}
//		else if (findBy.equalsIgnoreCase("BSMonth")) {
//			String[] parts = findByValue.split(" ");
//			String yearPart = parts[0];
//			String monthPart = parts[1];
//
//			year = Integer.parseInt(yearPart);
//			switch (monthPart) {
//			case "Jan":
//				month = 1;
//				break;
//			case "Feb":
//				month = 2;
//				break;
//			case "Mar":
//				month = 3;
//				break;
//			case "Apr":
//				month = 4;
//				break;
//			case "May":
//				month = 5;
//				break;
//			case "Jun":
//				month = 6;
//				break;
//			default:
//				break;
//			}
//			redirectAttrs.addFlashAttribute("monthlySalaryList",
//					monthlySalaryService.getMonthlySalaryByYearAndMonth(year, month));
//			redirectAttrs.addFlashAttribute("prevValue", findByValue);
//		} 
//		else if (findBy.equalsIgnoreCase("Employee Type")) {
//			redirectAttrs.addFlashAttribute("monthlySalaryList",
//					monthlySalaryService.getMonthlySalaryByEmployeeType(employeeType));
//			redirectAttrs.addFlashAttribute("prevValue", employeeType);
//		} 
//		else if (findBy.equalsIgnoreCase("Department")) {
//			Integer departmentId = Integer.parseInt(department);
//			System.out.println("departmentId " + departmentId);
//			redirectAttrs.addFlashAttribute("monthlySalaryList",
//					monthlySalaryService.getMonthlySalaryByDepartment(departmentId));
//			System.out.println(monthlySalaryService.getMonthlySalaryByDepartment(departmentId));
//			redirectAttrs.addFlashAttribute("prevValue", departmentId);
//		}
//		redirectAttrs.addFlashAttribute("prevFind", findBy);
//		return "redirect:/monthly-salary.html";
//	}
//
//	@GetMapping("monthly-salary-chart.html")
//	public String showMonthlySalaryChart(Model model) {
//		model.addAttribute("monthlySalaryMap", getMonthlySalry());
//
//		return "salary/monthly-salary/monthly-salary-chart.html";
//	}
//
//	@GetMapping("monthly-salary-bar-chart.html")
//	public String showMonthlySalaryBarChart(Model model) {
//		model.addAttribute("monthlySalaryMap", getMonthlySalry());
//
//		return "salary/monthly-salary/monthly-salary-bar-chart.html";
//	}
//
//	@GetMapping("monthly-salary-line-chart.html")
//	public String showMonthlySalaryLineChart(Model model) {
//		model.addAttribute("monthlySalaryMap", getMonthlySalry());
//
//		return "salary/monthly-salary/monthly-salary-line-chart.html";
//	}

	private Map<String, Double> getMonthlySalry() {

		Double[][] query2D = monthlySalaryRepo.findTotalMonthlySalaray();
		Map<String, Double> monthlySalaryList = new LinkedHashMap<>();
		for (Double[] row : query2D) {
			monthlySalaryList.put("Basic", row[0]);
			monthlySalaryList.put("Overtime", row[1]);
			monthlySalaryList.put("Allowance", row[2]);
			monthlySalaryList.put("Total Salary", row[3]);
			monthlySalaryList.put("Loan Deduction", row[4]);
			monthlySalaryList.put("Net Salary", row[5]);
		}
		return monthlySalaryList;
	}
	
	@GetMapping("monthly-salary-bar-chart")
	public Map<String, Double>  showMonthlySalaryBarChart() {
		return getMonthlySalry();
	}

}
