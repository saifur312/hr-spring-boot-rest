package com.bs.hrm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu_permission")
@Data @NoArgsConstructor
public class MenuPermission {
	@Id @GeneratedValue
	public Long id;
	
	private Long roleId;
	
	private Long menuId;
	
	

}
