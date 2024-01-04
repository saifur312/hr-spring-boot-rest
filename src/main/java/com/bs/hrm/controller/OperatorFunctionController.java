package com.bs.hrm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.OperatorFunction;
import com.bs.hrm.entity.User;
import com.bs.hrm.service.OperatorFunctionService;
import com.bs.hrm.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OperatorFunctionController {

	private static final Logger logger = LoggerFactory.getLogger(OperatorFunctionController.class);
	
	@Autowired OperatorFunctionService opfuncService;
	@Autowired UserService userService;
	
    @PostMapping("save-opfunc") @Transactional
    public List<OperatorFunction> saveSystem(@RequestBody List<OperatorFunction> payload) {
        logger.info("" +payload);
        Integer operatorId = null;
        List<OperatorFunction> savedOpFunList = new ArrayList<OperatorFunction>();
        for(OperatorFunction opfunc : payload) {
            OperatorFunction savedOpFun = opfuncService.saveOpeartorFunction(opfunc);
            savedOpFunList.add(savedOpFun);
            
            //retreive operator Id
            operatorId = savedOpFun.getOperatorId();
        }
        
        /*** Create and store password for user ***/
        if(operatorId != null && operatorId > 0 ) {
        	User user = new User();
        	user.setUserId(operatorId.longValue());
        	user.setPassword("12345");
            userService.addUser(user);
        }
        return savedOpFunList;
    }
    
    @GetMapping("operator-functions")
    public List<Menu> getOperatorFunctionDetails(@RequestParam Integer operatorId){
    	List<Menu> menuList = opfuncService.getOperatorFunctionDetails(operatorId);
    	menuList.forEach(m -> logger.info("Op Func " + m));
		return menuList;
    }
	
}
