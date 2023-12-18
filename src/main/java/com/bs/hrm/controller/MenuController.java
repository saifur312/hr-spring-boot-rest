package com.bs.hrm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.repos.MenuRepo;
import com.bs.hrm.service.MenuService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {
	
	@Autowired MenuRepo menuRepo;
	@Autowired MenuService menuService;
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
//	@GetMapping("test-query")
//	public void testQuery() {
//		logger.info("Last System Id: " + menuRepo
//				.findLastSystemId());
//		logger.info("Last Sub System Id of system Id 1: " + menuRepo
//				.findLastSubSystemIdOfSystemId(1));
//		logger.info("Last Function Id of system Id 1 And Subsystem 1: " + menuRepo
//				.findLastFunctionIdOfSystemIdAndSubSystemId(1,1));
//		
//		List<Object[]> results = menuRepo.findAllSystemIdWithFunctionName();
//		logger.info("All System : " + Arrays.toString(results.toArray()));
//		
//		for (Object[] result : results) {
//		      System.out.println(
//		      "System Id: " + result[0] + ", Function : " + result[1]);
//		  }
//		
//	}
	
//	@GetMapping("save-system")
//	public Menu saveSystem(@RequestBody Menu menu) {
//		logger.info("Request Received " + menu);
//		return menu;
//	}
	
//	@PostMapping("save-system")
//	public Menu saveSystem(HttpServletRequest request) {
//		logger.info("Request\t" + request.toString());
//		String functionName = request.getParameter("functionName"); 
//		logger.info("function Name\t" + functionName);
//		//Menu savedMenu = menuService.addSystem(functionName);
//		return null;
//	}
	
    @PostMapping("save-system")
    public Menu saveSystem(@RequestBody Map<String, Object> payload) {
        String functionName = (String) payload.get("functionName");
		logger.info("function Name\t" + functionName);
		Menu savedMenu = menuService.addSystem(functionName);
        return savedMenu;
    }
	
	@GetMapping("system-list")
	public List<Object[]> getAllSystemIdAndName(){
		List<Object[]> results = menuRepo.findAllSystemIdWithFunctionName();
		return results;
	}
	
	@PostMapping("save-sub-system")
	public Menu saveSubSystem(@RequestBody Map<String, Object> payload) {
		String functionName = payload.get("functionName").toString();
		Integer systemId =Integer.parseInt(payload.get("systemId").toString());
		logger.info("systemId\t" + systemId + "  function Name\t" + functionName);
		Menu savedMenu = menuService.addSubSystem(systemId, functionName);
		return savedMenu;
	}
	
	@GetMapping("sub-system-list")
	public List<Object[]> getAllSystem(@RequestParam int systemId){
		List<Object[]> results = menuService.getAllSubSystemIdAndNameOfSystemId(systemId);
		return results;
	}
	
	@PostMapping("save-function")
	public Menu saveFunction(@RequestBody Menu menuRequest) {
		logger.info("Menu request " + menuRequest);
		Menu menu = menuRequest.toBuilder().build();
		logger.info("Menu copy " + menu);
		Menu savedMenu = menuService.addFunction(menu);
		return savedMenu;
		//return null;
	}
	
	@GetMapping("function-list")
	public List<Object[]> getAllFunction(@RequestParam int systemId, int subSystemId){
		//
		return null;
	}
	
	
	

}
