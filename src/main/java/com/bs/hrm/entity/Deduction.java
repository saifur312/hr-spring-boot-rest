

package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.DecimalMin;

import com.bs.hrm.entity.ids.DeductionId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@IdClass(DeductionId.class) 
@NoArgsConstructor
@AllArgsConstructor
@Data @Builder(toBuilder = true)
public class Deduction {

	@Id
	private Long 			employeeId;
	@Id
	private Long 			deductionId;
	@DecimalMin(value = "0.0")
	private BigDecimal 		roomCharge;
	@DecimalMin(value = "0.0")
	private BigDecimal 		incomeTax;
	@DecimalMin(value = "0.0")
	private BigDecimal 		providentFund;
	@DecimalMin(value = "0.0")
	private BigDecimal 		walefareFund;
	@DecimalMin(value = "0.0")
	private BigDecimal 		meal;
	@DecimalMin(value = "0.0")
	private BigDecimal 		otherDeductions;
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
