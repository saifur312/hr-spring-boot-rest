package com.bs.hrm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EmployeeTest {
	
//	private Long id;
//	@JsonProperty("firstName")
//	private String firstName;
//	
//	@JsonProperty("lastName")
//	private String lastName;
//	
//	@JsonProperty("email")
//	private String email;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("password")
	private String password;
//	
	@JsonProperty("loginCode")
	private String loginCode;
	
	
//	@JsonProperty("name")
//	private String name;
//	
//	@JsonProperty("mobileNumber")
//	private String mobileNumber;
	
	
	

}
