package com.bs.hrm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.OperatorFunction;
import com.bs.hrm.service.OperatorFunctionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OperatorFunctionController {

	private static final Logger logger = LoggerFactory.getLogger(OperatorFunctionController.class);
	
	@Autowired OperatorFunctionService opfuncService;
	
    @PostMapping("save-opfunc")
    public List<OperatorFunction> saveSystem(@RequestBody List<OperatorFunction> payload) {
        logger.info("" +payload);
        List<OperatorFunction> savedOpFunList = new ArrayList<OperatorFunction>();
        for(OperatorFunction opfunc : payload) {
            OperatorFunction savedOpFun = opfuncService.saveOpeartorFunction(opfunc);
            savedOpFunList.add(savedOpFun);
        }
        return savedOpFunList;
    }
	
}
