package com.bs.hrm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="role_permission")
@Data @NoArgsConstructor
public class RolePermission {
	
	@Id @GeneratedValue
	private Long id;
	
	private Long userId;
	
	private Long roleId;
	
}
