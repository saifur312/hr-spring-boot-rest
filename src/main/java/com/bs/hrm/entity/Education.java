package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bs.hrm.entity.ids.EducationId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(EducationId.class)
@Table(name="education")
@NoArgsConstructor @AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Education {
	@Id 
	private Long 			employeeId;
	@Id
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate       completionDate;
	@Transient
	private String       	completionDateStr;
	@Column(length=100)
 	private String	    	certificate;
	@Column(length=150)
 	private String	    	institute;
	@Column(length=50)
	private String 			studyGroup;
	@Column(length=50)
 	private String	    	result;
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
