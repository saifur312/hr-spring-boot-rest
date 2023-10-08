package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.Menu;

public interface MenuService {
	
	public Menu addMenu(Menu menu);
	
	public Menu getMenu(Long menuId);
	
	List<Menu> getAllMenu();
}
