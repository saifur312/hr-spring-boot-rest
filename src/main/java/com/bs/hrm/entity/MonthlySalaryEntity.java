package com.bs.hrm.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bs.hrm.entity.ids.MonthlySalaryEntityId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(MonthlySalaryEntityId.class)
@Table(name = "monthly_sal")
@Data @AllArgsConstructor @NoArgsConstructor
public class MonthlySalaryEntity {
	@Id
	private Long employeeId;
	@Id
	private Integer	year;
	@Id
	private Integer month;
	@Id
	private String employeeType;
	private BigDecimal basicSalary;
	private BigDecimal overtimeAmount;
	private BigDecimal allowance;
	private BigDecimal totalSalary;
	private BigDecimal loanDeduction;
	private BigDecimal netSalary;
	private LocalDate salaryDate;
	private Integer 		departmentId;
	
//	private String filler1;
//	private String filler2;
//	private String filler3;
//	private String filler4;
//	private String filler5;
//	private String filler6;
//	private String filler7;
//	private String filler8;
//	private String filler9;
//	private String filler10;
//	private String filler11;
//	private String filler12;
//	private String filler13;
//	private String filler14;
//	private String filler15;
//	private String filler16;
//	private String filler17;
//	private String filler18;
//	private String filler19;
//	private String filler20;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	@Column(length=30) private String createdBy;
	@Column(length=50) private String createdIp; 
	@Column(length=30) private String updatedBy;
	@Column(length=40) private String updatedIp;

}
