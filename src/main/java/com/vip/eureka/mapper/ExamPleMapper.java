package com.vip.eureka.mapper;

import java.util.List;

import com.vip.eureka.main.MyDataSource;

public interface ExamPleMapper {
	
	
    public List<MyDataSource> getDs();
    
    
    public void  updateById(Long id) throws Exception;
}