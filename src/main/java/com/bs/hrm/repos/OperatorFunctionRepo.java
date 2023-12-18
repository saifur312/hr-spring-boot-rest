package com.bs.hrm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.OperatorFunction;
import com.bs.hrm.entity.ids.OperatorFunctionId;

@Repository
public interface OperatorFunctionRepo extends 
	JpaRepository<OperatorFunction, OperatorFunctionId>{
	
	
	
}
