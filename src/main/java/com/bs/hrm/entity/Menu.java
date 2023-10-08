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
@Table(name="menu")
@Data @NoArgsConstructor
public class Menu {
	@Id @GeneratedValue
	private Long menuId;
	
	private String menu;

 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;

}
