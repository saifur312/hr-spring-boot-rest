package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.bs.hrm.entity.ids.DependentsIdentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@IdClass(DependentsIdentity.class)
@NoArgsConstructor @AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Dependent {
	
	@Id
	private Long 			dependentsId;
	@Id
	private Long 			employeeId;
	@Column(length=30)
	private	String 			NID; //NID of dependents
	@Column(length=50, nullable=false)
	private String  		name;
	@Column(length=20)
 	private String	    	nickName;
	@Column(length=10)
 	private String	    	bloodGroup;
	@Column(length=40)
 	private String	    	relationship;
	@Column(length=80)
 	private String	    	nomineeName; // nominee of dependents
	@Column(length=40)
 	private String	    	nomineeNID; // NID of nominee of dependents
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
