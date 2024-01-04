package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.OperatorFunction;
import com.bs.hrm.repos.OperatorFunctionRepo;
import com.bs.hrm.service.MenuService;
import com.bs.hrm.service.OperatorFunctionService;

@Service
public class OperatorFunctionServiceImpl implements OperatorFunctionService{

	@Autowired OperatorFunctionRepo opfuncRepo;
	@Autowired MenuService menuService;
	
	@Override
	public OperatorFunction saveOpeartorFunction(OperatorFunction opfunc) {
		opfunc.setCreatedDate(LocalDateTime.now());
		OperatorFunction savedOpFunc = opfuncRepo.saveAndFlush(opfunc);
		return savedOpFunc;
	}

	@Override
	public List<OperatorFunction> getOperatorFunction(Integer operatorId) {
		List<OperatorFunction> opFuncList = opfuncRepo.findByOperatorId(operatorId);
		return opFuncList;
	}

	@Override
	public List<Menu> getOperatorFunctionDetails(Integer operatorId) {
		List<OperatorFunction> opFuncList = opfuncRepo.findByOperatorId(operatorId);
		List<Menu> menuList = new ArrayList<>();
		for(OperatorFunction opFunc : opFuncList) {
			Menu menu = menuService.getMenu(opFunc.getSystemId(), 
					opFunc.getSubSystemId(), opFunc.getFunctionId());
			if(menu != null)
				menuList.add(menu);
		}
		return menuList;
	}

}
