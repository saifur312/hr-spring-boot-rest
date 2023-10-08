package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.MenuPermission;

public interface MenuPermissionService {

	MenuPermission addMenuPermission(MenuPermission menuPermission);
	
	List<MenuPermission> getAllMenuByRoleId(Long roleId);
}
