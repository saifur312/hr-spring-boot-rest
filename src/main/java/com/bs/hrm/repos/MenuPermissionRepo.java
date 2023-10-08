package com.bs.hrm.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.MenuPermission;

@Repository
public interface MenuPermissionRepo extends JpaRepository<MenuPermission, Long> {
	
	public List<MenuPermission> findAllByRoleId(Long roleId);

}
