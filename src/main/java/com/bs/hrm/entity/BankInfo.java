package com.bs.hrm.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bs.hrm.dto.EmployeeSub;
import com.bs.hrm.entity.ids.BankInfoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(BankInfoId.class)
@Table(name="bankinfo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder=true)//to make copy object
public class BankInfo {
	
	@Id
	private Long 			employeeId;
	@Id
	@Column(length=80, unique=true)
	@NotNull
	@NotEmpty
	private String 			accountNo;
	@Column(length=100)
	private String 			bankName;
	@Column(length=100)
	private String 			branchName;
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
