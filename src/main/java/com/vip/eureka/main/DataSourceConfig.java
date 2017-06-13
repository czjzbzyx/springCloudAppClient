package com.vip.eureka.main;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean(name="dataSource")
	@Qualifier(value="dataSource")
	 @Primary
	 @ConfigurationProperties(prefix="c3p0")
	 public DataSource dataSource(){
	        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();//创建数据源
	    }
	
	
	@Bean(name="sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        
        
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        
        
//        PageInterceptor pagePlugin=new PageInterceptor();
//        
//        Properties properties=new Properties();
//        
//        properties.setProperty("dialect", "com.github.pagehelper.dialect.helper.MySqlDialect");
//        
//        pagePlugin.setProperties(properties);
//        sqlSessionFactory.setPlugins(new Interceptor[]{pagePlugin});
        return sqlSessionFactory;
    }
	
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
	
	  @Bean
	  public PlatformTransactionManager annotationDrivenTransactionManager() {
	        return new DataSourceTransactionManager(dataSource());
	   }

}
