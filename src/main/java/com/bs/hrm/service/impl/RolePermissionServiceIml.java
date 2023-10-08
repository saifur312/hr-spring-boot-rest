package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.RolePermission;
import com.bs.hrm.repos.RolePermissionRepo;
import com.bs.hrm.service.RolePermissionService;

@Service
public class RolePermissionServiceIml implements RolePermissionService{

	@Autowired RolePermissionRepo rolePermissionRepo;
	
	@Override
	public RolePermission addRolePermission(RolePermission rolePermission) {

		RolePermission savedRolePermission = rolePermissionRepo.saveAndFlush(rolePermission);
		
		return savedRolePermission;
	}

	@Override
	public List<RolePermission> getAllRoleByUserId(Long userId) {
		List<RolePermission> rolePermissionList = rolePermissionRepo.findAllByUserId(userId);
		if(!rolePermissionList.isEmpty())
			return rolePermissionList;
		else 
			return null;
	}

}
