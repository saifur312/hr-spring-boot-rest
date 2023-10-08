package com.bs.hrm.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.RolePermission;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermission, Long>{

	
	public List<RolePermission> findAllByUserId(Long userId);
	
	public List<RolePermission> findAllByRoleId(Long roleId);

}
