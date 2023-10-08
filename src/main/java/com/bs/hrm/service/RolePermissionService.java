package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.Role;
import com.bs.hrm.entity.RolePermission;

public interface RolePermissionService {

	RolePermission addRolePermission(RolePermission rolePermission);

	
	List<RolePermission> getAllRoleByUserId(Long userId);
}
