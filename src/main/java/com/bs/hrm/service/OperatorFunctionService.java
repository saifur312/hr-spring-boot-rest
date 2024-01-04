package com.bs.hrm.service;

import java.util.List;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.OperatorFunction;

public interface OperatorFunctionService {
	
	public OperatorFunction saveOpeartorFunction(OperatorFunction opfunc);
	
	public List<OperatorFunction> getOperatorFunction(Integer operatorId);
	
	public List<Menu> getOperatorFunctionDetails(Integer operatorId);

}
