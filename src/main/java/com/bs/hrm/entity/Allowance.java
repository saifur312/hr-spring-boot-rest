

package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.DecimalMin;

import com.bs.hrm.entity.ids.AllowanceId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@IdClass(AllowanceId.class)
@NoArgsConstructor @AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Allowance {
	@Id
	private Long 			employeeId;
	@Id
	private Long 			allowanceId;
	@DecimalMin(value = "0.0")
	private BigDecimal 		basic;
	@DecimalMin(value = "0.0")
	private BigDecimal 		houseRent;
	@DecimalMin(value = "0.0")
	private BigDecimal 		medicalAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		clinicalAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		attendanceAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		dearnessAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		nonPracticeAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		conveyAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		transportAllowance;
	@DecimalMin(value = "0.0")
	private BigDecimal 		otherAllowance;
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
