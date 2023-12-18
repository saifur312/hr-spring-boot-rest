package com.bs.hrm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bs.hrm.entity.ids.OperatorFunctionId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name= "opfunc")
@IdClass(OperatorFunctionId.class)
@Data @Builder(toBuilder = true)
@AllArgsConstructor 
public class OperatorFunction {

	@Id private Integer operatorId; //employee Id
	@Id private Integer functionId;
	@Id private Integer systemId;
	@Id private Integer subSystemId;
	
	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;

}
