package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

import com.bs.hrm.entity.ids.ExperienceId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(ExperienceId.class)
@NoArgsConstructor @AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Experience {
	@Id
	private LocalDate       lastActiveDate;
	@Id 
	private Long 			employeeId;
	@Transient
	private String       	lastActiveDateStr;
	@Column(length=100)
 	private String	    	companyName;
	@Column(length=80)
 	private String	    	designation;
	
	  @Column(length=150)
	  private String responsibilities; 
	  private LocalDate startDate; 
	  private LocalDate endDate;
	  
	  @Transient private String startDateStr;
	  
	  @Transient private String endDateStr;
	  
	  @Transient private Boolean status;
	  
	  @Column(length=80) private String filler1;
	  
	  @Column(length=80) private String filler2;
	  
	  @Column(length=80) private String filler3;
	  
	  @Column(length=80) private String filler4;
	  
	  @Column(length=80) private String filler5; 
	  
	  private LocalDateTime createdDate;
	  
	  @Column(length=30) private String createdBy;
	  
	  @Column(length=50) private String createdIp; 
	  private LocalDateTime updatedDate;
	  
	  @Column(length=30) private String updatedBy;
	  
	  @Column(length=40) private String updatedIp;
	
	  
}
