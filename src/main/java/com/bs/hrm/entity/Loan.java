package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;

import com.bs.hrm.entity.ids.LoanId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@IdClass(LoanId.class)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Loan {
	@Id
	private Long 			employeeId;
	@Id
	private Long 			loanId;
	@DecimalMin(value = "0.0")
	private BigDecimal 		loanAmount;
	private BigDecimal 		deductionAmount;
	private LocalDate		transactionDate;
	private LocalDate		loanEndDate;
	@Transient
	private String 			transactionDateStr;
	@Transient
	private String 			loanEndDateStr;
	@Column(length=50)
	private String 			deductionType;
	@Column(length=150)
	private String 			remarks;	
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
