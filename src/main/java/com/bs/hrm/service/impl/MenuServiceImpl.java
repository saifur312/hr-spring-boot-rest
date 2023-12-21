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
	
//	@Transactional @Override
//	public Menu addMenu(Menu menu) {
//		menu.setCreatedDate(LocalDateTime.now());
//		Menu savedMenu = menuRepo.saveAndFlush(menu);	
//		return savedMenu;
//	}

	@Override
	public Menu addSystem(String systemName) {
		Menu menu = new Menu();

		//set system Id and primary keys
		Integer lastSystemId = menuRepo.findLastSystemId();
		if(lastSystemId == null)
			lastSystemId = 0;
		menu.setSystemId(lastSystemId + 1);
		menu.setSubSystemId(0);
		menu.setFunctionId(0);
		//set system name
		menu.setFunctionName(systemName);
		menu.setRoute(null);
		menu.setCreatedDate(LocalDateTime.now());
		
		Menu savedMenu = menuRepo.saveAndFlush(menu);
		return savedMenu;
	}

	@Override
	public Menu addSubSystem(Integer systemId, String subSystemName) {
		Menu menu = new Menu();
		menu.setSystemId(systemId);
		// set subsystemId
		Integer lastSubsystemId = menuRepo.findLastSubSystemIdOfSystemId(systemId);
		if(lastSubsystemId == null)
			lastSubsystemId = 0;
		menu.setSubSystemId(lastSubsystemId + 1);
		menu.setFunctionId(0);
		//set system name
		menu.setFunctionName(subSystemName);
		menu.setRoute(null);
		menu.setCreatedDate(LocalDateTime.now());
		
		Menu savedMenu = menuRepo.saveAndFlush(menu);
		return savedMenu;
	}

	@Override
	public Menu addFunction(Menu menu) {
		//set function Id
		Integer lastFunctionId = menuRepo
				.findLastFunctionIdOfSystemIdAndSubSystemId(
						menu.getSystemId(), menu.getSubSystemId());
		if(lastFunctionId == null)
			lastFunctionId = 0;
		menu.setFunctionId(lastFunctionId + 1);
		menu.setCreatedDate(LocalDateTime.now());
		
		Menu savedMenu = menuRepo.saveAndFlush(menu);
		return savedMenu;
	}
	
//	@Override
//	public Menu getMenu(Long menuId) {
//		Optional<Menu> menuOptional = menuRepo.findById(menuId);
//		if(menuOptional.isPresent())
//			return menuOptional.get();
//		else
//			return null;
//	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menuList = menuRepo.findAll();
		if(!menuList.isEmpty())
			return menuList;
		else 
			return null;
	}

	@Override
	public List<Object[]> getAllSystemIdAndName() {
		List<Object[]> results = menuRepo.findAllSystemIdWithFunctionName();
		return results;
	}

	@Override
	public List<Object[]> getAllSubSystemIdAndNameOfSystemId(Integer systemId) {
		List<Object[]> results = menuRepo.findAllSubSystemIdWithName(systemId);
		return results;
	}

	@Override
	public List<Object[]> getAllFunctionIdAndNameofSubSystemOfSystem(Integer systemId, Integer subSystemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getAllSystemWithSubSystemsAndFunctions() {
		List<Object[]> systems = menuRepo.findAllSystemIdWithFunctionName();
		
		return null;
	}

	@Override
	public List<Menu> getAllFunction() {
		
		return menuRepo.findAllFunction();
	}


}
