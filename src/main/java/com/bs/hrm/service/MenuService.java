package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.Menu;

public interface MenuService {
	
	public Menu addFunction(Menu menu);
	
	public Menu addSystem(String systemName);
	
	public Menu addSubSystem(Integer systemId, String subSystemName);
	
	public Menu getMenu(Integer systemId, Integer subSystemId, Integer functionId);
	
	public List<Menu> getAllMenu();
	
	public List<Object[]> getAllSystemIdAndName();
	
	public List<Object[]> getAllSubSystemIdAndNameOfSystemId(Integer systemId);
	
	public List<Object[]> getAllFunctionIdAndNameofSubSystemOfSystem(Integer systemId, Integer subSystemId);
	
	public List<Object[]> getAllSystemWithSubSystemsAndFunctions();
	
	public List<Menu> getAllFunction();
}
