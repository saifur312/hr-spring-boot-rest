package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.Role;
import com.bs.hrm.repos.RoleRepo;
import com.bs.hrm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired RoleRepo roleRepo;
	
	@Transactional @Override
	public Role addRole(Role role) {

		role.setCreatedDate(LocalDateTime.now());
		Role savedRole = roleRepo.saveAndFlush(role);
		
		return savedRole;
	}

	@Override
	public Role getRole(Long roleId) {
		Optional<Role> roleOptional = roleRepo.findById(roleId);
		if(roleOptional.isPresent())
			return roleOptional.get();
		else
			return null;
	}

	@Override
	public List<Role> getAllRole() {
		List<Role> roleList = roleRepo.findAll();
		if(!roleList.isEmpty())
			return roleList;
		else 
			return null;
	}

}
