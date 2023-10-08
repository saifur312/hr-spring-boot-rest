package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.MenuPermission;
import com.bs.hrm.repos.MenuPermissionRepo;
import com.bs.hrm.service.MenuPermissionService;

@Service
public class MenuPermissionServiceIml implements MenuPermissionService{

	@Autowired MenuPermissionRepo menuPermissionRepo;
	
	@Override
	public MenuPermission addMenuPermission(MenuPermission menuPermission) {

		MenuPermission savedMenuPermission = menuPermissionRepo.saveAndFlush(menuPermission);
		
		return savedMenuPermission;
	}

	@Override
	public List<MenuPermission> getAllMenuByRoleId(Long roleId) {
		List<MenuPermission> menuPermissionList = menuPermissionRepo.findAllByRoleId(roleId);
		if(!menuPermissionList.isEmpty())
			return menuPermissionList;
		else 
			return null;
	}

}
