package com.bs.hrm.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

	@Id @GeneratedValue
	private Long id;
	
	private Long userId;
	
	//private String userName;
	
	private String password;
	
	private String email;
	
	@Transient
	private Boolean verified;
	
	@Transient
	private Set<Role> userRoleSet;
	
	@Transient
	private Set<Menu> userMenuSet;
	
 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;
	
	

}
