package com.bs.hrm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.bs.hrm.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job")
  @NoArgsConstructor
  @AllArgsConstructor
  @Data @Builder(toBuilder = true)
public class JobTitle {
	
	@Id @GeneratedValue
	private Integer 		jobId;
	@Column(length=40)
	//jobTitle is renamed into title because of matching with Object Type name
	private String 			title;
	@Column(length=150)
	private String 			description;
	@Column(length=100)
	private String 			responsibility;
 	private Boolean	    	status;
	@Column(length=80)
 	private String	    	filler1;
	@Column(length=80)
 	private String	    	filler2;
	@Column(length=80)
 	private String	    	filler3;
	@Column(length=80)
 	private String	    	filler4;
	@Column(length=80)
 	private String	    	filler5;
 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	@Column(length=50)
 	private String	    	createdIp;
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;
	@Column(length=40)
 	private String	    	updatedIp;	
	

}
