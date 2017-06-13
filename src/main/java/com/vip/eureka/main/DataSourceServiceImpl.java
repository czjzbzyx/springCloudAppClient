package com.vip.eureka.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.vip.eureka.mapper.ExamPleMapper;

@Component
public class DataSourceServiceImpl implements DataSourceService {

	
	
	
	  @Autowired
	 public ExamPleMapper examPleMapper;
	  
	  
	
	@Transactional  
	@Override
	public void updateById(Long id) throws Exception {
		
		
		examPleMapper.updateById(id);
		
		throw new RuntimeException();
		
	}



	public ExamPleMapper getExamPleMapper() {
		return examPleMapper;
	}



	public void setExamPleMapper(ExamPleMapper examPleMapper) {
		this.examPleMapper = examPleMapper;
	}



	@Override
	public List<MyDataSource> getDs( Integer pageNum, Integer pageSize) {
		PageHelper.clearPage();
		 PageHelper.startPage(pageNum,pageSize,false);
		return examPleMapper.getDs();
	}
	
	

}
