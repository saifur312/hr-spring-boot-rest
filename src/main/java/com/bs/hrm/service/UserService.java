package com.bs.hrm.service;

import com.bs.hrm.entity.User;

public interface UserService {
	
	User addUser(User user);
	
	User getUser(Long userId);
	
	Boolean checkValidUser(Long userId, String password);
	
	
}
