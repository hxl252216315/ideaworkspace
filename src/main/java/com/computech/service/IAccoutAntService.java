package com.computech.service;

import com.computech.dto.AccoutAntCondition;
import com.computech.pagination.Pagination;
import com.computech.pojo.AccoutAnt;

public interface IAccoutAntService {
	
	Pagination<AccoutAnt> getPaginationAccoutAnts(AccoutAntCondition accoutAntCondition, int pageNumber, int pageSize);
}
