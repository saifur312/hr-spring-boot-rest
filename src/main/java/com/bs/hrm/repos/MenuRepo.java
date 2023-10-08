package com.bs.hrm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long>{

}
