package com.computech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.computech.dto.AccoutAntCondition;
import com.computech.mapper.AccoutAntMapper;
import com.computech.pagination.Pagination;
import com.computech.pojo.AccoutAnt;
import com.computech.service.IAccoutAntService;
import com.computech.util.MathUtil;
import com.computech.util.ReflectUtil;

@Service
public class AccoutAntServiceImpl implements IAccoutAntService{

	@Autowired
	AccoutAntMapper accoutAntMapper;
	
	@Override
	public Pagination<AccoutAnt> getPaginationAccoutAnts(AccoutAntCondition accoutAntCondition,int pageNumber,int pageSize) {
		Pagination<AccoutAnt> page = new Pagination<AccoutAnt>();
		int index = (pageNumber-1)*pageSize;
		long totalSize = accoutAntMapper.selectCountByAccoutAnt(accoutAntCondition);
		
		try {
			accoutAntCondition = ReflectUtil.concatPercent(accoutAntCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		page.setResult(accoutAntMapper.selectByAccoutAnt(accoutAntCondition,index,pageSize))
			.setPageNumber(pageNumber)
			.setPageSize(pageSize)
			.setTotalSize(totalSize)
			.setTotal(MathUtil.ceil(totalSize, pageSize));
		
		return page;
	}
}
