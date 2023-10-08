package com.bs.hrm.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	public Optional<User> findByUserIdAndPassword(Long userId, String password);
	
	public Optional<User> findByUserId(Long userId);

}
