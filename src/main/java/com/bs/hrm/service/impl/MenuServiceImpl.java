package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.repos.MenuRepo;
import com.bs.hrm.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired MenuRepo menuRepo;
	
	@Transactional @Override
	public Menu addMenu(Menu menu) {

		menu.setCreatedDate(LocalDateTime.now());
		Menu savedMenu = menuRepo.saveAndFlush(menu);
		
		return savedMenu;
	}

	@Override
	public Menu getMenu(Long menuId) {
		Optional<Menu> menuOptional = menuRepo.findById(menuId);
		if(menuOptional.isPresent())
			return menuOptional.get();
		else
			return null;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menuList = menuRepo.findAll();
		if(!menuList.isEmpty())
			return menuList;
		else 
			return null;
	}

}
