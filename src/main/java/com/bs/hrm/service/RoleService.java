package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.Role;

public interface RoleService {

	Role addRole(Role role);
	
	Role getRole(Long roleId);
	
	List<Role> getAllRole();
	
	
	
	
}
