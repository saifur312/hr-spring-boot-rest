package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.OperatorFunction;
import com.bs.hrm.repos.OperatorFunctionRepo;
import com.bs.hrm.service.OperatorFunctionService;

@Service
public class OperatorFunctionServiceImpl implements OperatorFunctionService{

	@Autowired OperatorFunctionRepo opfuncRepo;
	
	@Override
	public OperatorFunction saveOpeartorFunction(OperatorFunction opfunc) {
		opfunc.setCreatedDate(LocalDateTime.now());
		OperatorFunction savedOpFunc = opfuncRepo.saveAndFlush(opfunc);
		return savedOpFunc;
	}

	@Override
	public List<OperatorFunction> getOperatorFunction(Integer operatorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
