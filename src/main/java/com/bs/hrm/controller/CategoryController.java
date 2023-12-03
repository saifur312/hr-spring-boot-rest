package com.bs.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.hrm.entity.Category;
import com.bs.hrm.entity.Category;
import com.bs.hrm.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired CategoryService	categoryService;

//	@GetMapping("category-add")
//	public String addCategory(Model model) {
//		model.addAttribute("category", new Category());
//		return "setup/category/category";
//		
//	}
//	
//	@PostMapping("category-add-save")
//	public String saveCategory(Model model, Category category) {
//		System.out.println(category);
//		categoryService.addCategory(category);
//		return "redirect:/category-add";
//		
//	}
//	
//	@PostMapping("category-update-save")
//	public String updateCategory(Model model, Category category) {
//		categoryService.updateCategory(category);
//		return "redirect:/category-add";
//		
//	}
//	
//	@GetMapping("/category-list.html")
//	public String showCategoryList(Model model) {
//		model.addAttribute("categoryList", categoryService.getAllCategory());
//		return "setup/category/category-list";
//	}
//
//	@GetMapping("category-details") 
//	public String showCategoryDetails(Model model, @RequestParam Integer cid ) {
//	  
//		model.addAttribute("category", categoryService.getCategory(cid)); 
//
//		return "setup/category/category";
//	}
	
	@PostMapping("category-add-save")
	public Category saveCategory(@RequestBody Category categoryRequst) {
		System.out.println(categoryRequst);
		Category category = categoryRequst.toBuilder().build();
		Category categorySaved = categoryService.addCategory(category);
		return categorySaved;
		
	}
	
	@GetMapping("category-list")
	public List<Category> getCategoryList() {
		return categoryService.getAllCategory();
	}

	@GetMapping("category-details") 
	public Category showCategoryDetails(@RequestParam Integer catId ) {
		return categoryService.getCategory(catId); 
	}
	
}
