package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.MenuPermission;
import com.bs.hrm.entity.Role;
import com.bs.hrm.entity.RolePermission;
import com.bs.hrm.entity.User;
import com.bs.hrm.repos.UserRepo;
import com.bs.hrm.service.MenuPermissionService;
import com.bs.hrm.service.RolePermissionService;
import com.bs.hrm.service.MenuService;
import com.bs.hrm.service.RoleService;
import com.bs.hrm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepo 				userRepo;
	@Autowired RoleService				roleService;
	@Autowired MenuService				menuService;
	@Autowired RolePermissionService 	rolePermissionService;
	@Autowired MenuPermissionService	menuPermissionService;
	
	@Override
	public User addUser(User user) {

		user.setCreatedDate(LocalDateTime.now());
		User savedUser = userRepo.saveAndFlush(user);
		
		return savedUser;
	}

	@Override
	public User getUser(Long userId) {
		Optional<User> userOptional = userRepo.findByUserId(userId);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			
			Set<Role> userRoleSet = getUserRoleSet(userId);
			Set<Menu> userMenuSet = getUserMenuList(userRoleSet);
			
			user.setUserRoleSet(userRoleSet);
			user.setUserMenuSet(userMenuSet);
			
			return user;
		} 
		else
			return null;
	}

	@Override
	public Boolean checkValidUser(Long userId, String password) {
		Optional<User> userOptional = userRepo.findByUserIdAndPassword(userId, password);
		if(userOptional.isPresent())
			return true;
		else
			return false;
	}
	
	private Set<Role> getUserRoleSet(Long userId) {
		Set<Role> roleSet = new LinkedHashSet<Role>();
		//get All rolePermission of user
		List<RolePermission> rolePermissionList = 
				rolePermissionService.getAllRoleByUserId(userId);
		//filter only role Ids from Role Permission
		for(RolePermission rp : rolePermissionList) {
			Role role = roleService.getRole(rp.getRoleId());
			roleSet.add(role);
		}
		return roleSet;
		
	}
	
	
	private Set<Menu> getUserMenuList(Set<Role> roleSet) {
		//Set<Role> roleSet = getUserRoleSet(userId);
		Set<Menu> menuSet = new LinkedHashSet<Menu>();
		for(Role role : roleSet){
			List<MenuPermission> menuPermissionList =
					menuPermissionService.getAllMenuByRoleId(role.getRoleId());
			for(MenuPermission mp : menuPermissionList) {
//				Menu menu = menuService.getMenu(mp.getMenuId());
//				menuSet.add(menu);
			}
		}
		return menuSet;
		
	}
	
	
	
}
