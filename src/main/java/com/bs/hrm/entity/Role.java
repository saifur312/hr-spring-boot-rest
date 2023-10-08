package com.bs.hrm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="role")
@Data @NoArgsConstructor
public class Role {
	@Id @GeneratedValue
	private Long roleId;
	
	private String role;

 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;

}
