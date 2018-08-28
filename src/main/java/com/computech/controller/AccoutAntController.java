package com.computech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.computech.dto.AccoutAntCondition;
import com.computech.pagination.Pagination;
import com.computech.pojo.AccoutAnt;
import com.computech.service.IAccoutAntService;

@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/accoutaut")
public class AccoutAntController {
	
	@Autowired
	IAccoutAntService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Pagination<AccoutAnt> getAccoutAnts(String condition,int pageNumber,int pageSize){
		
		AccoutAntCondition accoutAntCondition = JSONObject.parseObject(condition, AccoutAntCondition.class);
		
		return service.getPaginationAccoutAnts(accoutAntCondition,pageNumber,pageSize);
	}
}
