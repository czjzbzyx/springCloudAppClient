package com.vip.eureka.main;

import java.util.List;

public interface DataSourceService {
	
	public void updateById(Long id) throws Exception;
	
	
	public List<MyDataSource> getDs();

}
