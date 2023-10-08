package com.bs.hrm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
