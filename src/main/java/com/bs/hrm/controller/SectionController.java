package com.bs.hrm.controller;

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

import com.bs.hrm.entity.Department;
import com.bs.hrm.entity.Section;
import com.bs.hrm.service.DepartmentService;
import com.bs.hrm.service.SectionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SectionController {
	
	@Autowired SectionService sectionService;
	@Autowired DepartmentService departmentService;
	
//	@GetMapping("section-add")
//	public String showSection(Model model) {
//		model.addAttribute("alldepartment", departmentService.getAllDepartment());
//		model.addAttribute("section", new Section());
//		return "setup/section/section";
//		
//	}
//	
//	@PostMapping("section-add-save")
//	public String addSection(Model model, Section Section) {
//		System.out.println(Section);
//		sectionService.addSection(Section);
//		return "redirect:/section-add";
//		
//	}
//	
//	@GetMapping("section-edit")
//	public String showSectionEdit(Model model) {
//		return "section";
//		
//	}
//	
//	@PostMapping("section-edit-save")
//	public String saveSectionEdit(Model model) {
//		return "section";
//		
//	}
//	
//	@PostMapping("section-delete")
//	public String deleteSection(Model model) {
//		return "section";
//		
//	}	
//	
//	@GetMapping("/section-list.html")
//	public String showSectionList(Model model) {
//		model.addAttribute("sectionList", sectionService.getAllSection());
//		return "setup/section/section-list";
//	}
//
//
//	@GetMapping("section-details") 
//	public String showSectionDetails(Model model, @RequestParam Integer sid ) {
//	  
//		model.addAttribute("section", sectionService.getSection(sid));
//		return "setup/section/section";
//	}
	
	@PostMapping("section-add-save")
	public String addSection(@RequestBody Section sectionRequest) {
		
		Section section = new Section();
		section.setSectionName(sectionRequest.getSectionName());
		section.setDepartmentId(sectionRequest.getDepartmentId());
		section.setSerail(sectionRequest.getSerail());
		
		System.out.println(section);
		sectionService.addSection(section);
		
		return "Data saved successfull";
		
	}
	
	@GetMapping("/section-list")
	public List<Section> showSectionList(Model model) {
		
		return sectionService.getAllSection();
	}
	
	@PostMapping("/section-list-deptarmentwise")
	public List<Section> showSectionList(@RequestBody Section request) {
		System.out.println("department ID:\t" + request.getDepartmentId());
		return sectionService.getAllSectionByDepartmentId(request.getDepartmentId());
	}

}
