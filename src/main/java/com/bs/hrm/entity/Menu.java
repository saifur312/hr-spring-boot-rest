package com.bs.hrm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bs.hrm.entity.ids.MenuId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu")
@IdClass(MenuId.class)
@Data @NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class Menu {
	
	@Id private Integer systemId;

	@Id private Integer subSystemId;
	
	@Id private Integer functionId;
	
	private String functionName;
	
	private String route;
	
	//private String menu;

 	private LocalDateTime   createdDate;
	@Column(length=30)
 	private String	    	createdBy;
	
 	private LocalDateTime 	updatedDate;
	@Column(length=30)
 	private String	    	updatedBy;

}
