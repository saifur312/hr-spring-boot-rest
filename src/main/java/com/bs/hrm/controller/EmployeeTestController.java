package com.bs.hrm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.bs.hrm.dto.EmployeeDto;
import com.bs.hrm.dto.EmployeeTest;
import com.bs.hrm.email.EmailSender;
import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.User;
import com.bs.hrm.service.EmployeeService;
import com.bs.hrm.service.UserService;
import com.bs.sms.SmsController;

@RestController
public class EmployeeTestController {
	@Autowired UserService	userService;
	@Autowired EmployeeService	employeeService;

	HashMap<Long, String> loginVerifyMap = new HashMap<Long, String>();

//	@CrossOrigin(origins = "http://localhost:3000")
//	@PostMapping("employee-add-test")
//	public String saveEmployee( @RequestBody EmployeeTest request)  {
//		
//		System.out.println("Get Data:\t" + request.toString());
//		return "";
//	}
	
	/*
	 * @GetMapping("employee-details") public String showEmployeeDetails(Model
	 * model, @RequestParam Long id) { return " "; }
	 */
	
	@CrossOrigin(origins = "http://localhost:3000")
	//@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("employee-login")
	public Boolean testEmployee( @RequestBody EmployeeTest request)  {
		//EmailSender emailSender = new EmailSender();
		
		Long userId = Long.parseLong(request.getUserId());
		String password = request.getPassword();
		
		System.out.println("userId:\t" + userId+ 
						   "\npassword:\t" + password);
		
		//System.out.println("User " + userService.getUser(userId));
		
		Boolean isValid = userService.checkValidUser(userId, password);
		System.out.println("Valid User " + isValid);
		if(isValid) {
			String loginCode =  randomNumberGenerator();
			
			System.out.println("Random Number " + loginCode);
			
			loginVerifyMap.put(userId, loginCode);
			
			SmsController smsController = new SmsController();
			//smsController.sendSMS("+8801645299007", loginCode);
			
//			emailSender.sendEmail("saifurcuet12@gmail.com", "Test", "High this is a dummy test mail");
//			System.out.println("Email has sent successfully");
		}
		return isValid;
	}
	
	public String randomNumberGenerator() {
		
		Random random = new Random();
		String number = String.valueOf(random.nextInt(10001, 100000));
		return number;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("verify-login")
	public Boolean verifyLogin( @RequestBody EmployeeTest request)  {
		//String userId = request.getUserId();
		Long userId = Long.parseLong(request.getUserId());
		String loginCode = request.getLoginCode();
		Boolean isVerified = false;
		
		loginVerifyMap.forEach((key, value) -> System.out.println(key + " " + value));
		
		for(Map.Entry m : loginVerifyMap.entrySet()) {
			if(m.getKey().equals(userId) && m.getValue().equals(loginCode)) {
				isVerified = true;
				System.out.println("Verified true");
				loginVerifyMap.remove(userId);
				break;
			}
		}
		System.out.println("userId:\t" + userId+ "\tloginCode:\t" + loginCode);

		System.out.println("isVerified " + isVerified);
		return isVerified;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("user-menu-list")
	public String[] fetchMenuArray( @RequestParam Long userId)  {
		System.out.println("User Id " + userId);
		User user = userService.getUser(userId);

		System.out.println("Menu Set " + user.getUserMenuSet());
		List<String> menuList = new ArrayList<String>();
//		for(Menu m : user.getUserMenuSet()) {
//			menuList.add(m.getMenu());
//		}
		
		String[] menuArray = menuList.toArray(new String[0]);
		System.out.println(Arrays.toString(menuArray));
		return menuArray;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("employee-list")
	public List<EmployeeDto> getEmployeeList( )  {

		//System.out.println("Menu Set " + user.getUserMenuSet());
		//List<String> menuList = new ArrayList<String>();
//		for(Menu m : user.getUserMenuSet()) {
//			menuList.add(m.getMenu());
//		}
		List<EmployeeDto> employeeList = employeeService.getAllEmployee();
		
		//String[] menuArray = menuList.toArray(new String[0]);
		employeeList.forEach(System.out::println);
		
		//System.out.println(Arrays.toString(employeeList));
		return employeeList;
	}
	

	
	@PostMapping("employee-list-find")
	public String finEmployees(@RequestBody MultiValueMap<String, String> values, Model model) {
		System.out.println("Values:{}" + values);
		Object findBy		=	values.getFirst("findBy");
        String findByValue	=	values.getFirst("findByValue");
        String reqFlag		=	values.getFirst("reqFlag");
        //List<String> findByValue1	=	values.get("findByValue");
		System.out.println("After extract\t" + findBy + "\t" + findByValue + "\t" +  reqFlag);
		
		model.addAttribute("flag", reqFlag);
		
		if(findBy.equals("EmployeeId")) {
			model.addAttribute("allEmployee", employeeService
					.getAllByEmployeeId(Long.parseLong(findByValue)));
		}
		else if(findBy.equals("Name")) {
			model.addAttribute("allEmployee", employeeService.getAllByName(findByValue));
		}
		else if(findBy.equals("NickName")) {
			model.addAttribute("allEmployee", employeeService.getAllByNickName(findByValue));
		}
		else if(findBy.equals("NID")) {
			model.addAttribute("allEmployee", employeeService.getAllByNID(findByValue));
		}
		else if(findBy.equals("FingerId")) {
			model.addAttribute("allEmployee", employeeService.getAllByFingerId(findByValue));
		}
		model.addAttribute("show", true);
		return "employee/employee-info/emplist.html";
	}
	
}
