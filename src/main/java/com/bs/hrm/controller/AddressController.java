package com.bs.hrm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Address;
import com.bs.hrm.entity.Address;
import com.bs.hrm.entity.Address;
import com.bs.hrm.service.AddressService;
import com.bs.hrm.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	
	@Autowired AddressService 		addressService;
	@Autowired EmployeeService 		employeeService;
	//@Autowired CodeOldService 			codeOldService;
	
	
	public static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
//	@GetMapping("address-add")
//	public String showAddress(Model model) {
//		model.addAttribute("address", new Address());
//		model.addAttribute("allEmployee", employeeService.getAllEmployee());
//		//model.addAttribute("allCode", codeOldService.getAllCode());
//		return "setup/address/address";
//		
//	}
//	
//	@PostMapping("address-add-save")
//	public String addSaveAddress(Model model, Address address) {
//		System.out.println(address);
//		addressService.addAddress(address);
//		return "redirect:/address-add";
//		
//	}
//	
//	@PostMapping("address-update-save")
//	public String updateAddress(Model model, Address address) {
//		addressService.updateAddress(address);
//		return "redirect:/address-add";
//		
//	}
	
	
	@PostMapping("address-add-save")
	public Address saveAddress(@RequestBody Address addressRequst) {
		logger.info("Form Data\t" +  addressRequst);
		Address address = addressRequst.toBuilder().build();
		logger.info("Copy Data\t" +  address);
		Address addressSaved = addressService.addAddress(address);
		return addressSaved;
		
	}

	@GetMapping("address-list")
	public List<Address> showAddressList(@RequestParam Long employeeId) {
		return addressService.getAllAddressByEmployeeId(employeeId);
	}


	@GetMapping("address-details") 
	public Address showAddressDetails(
			@RequestParam Long employeeId, @RequestParam Long addressId ) {
		return addressService.getAddress(employeeId, addressId);
	}
	
	
	
	

}
