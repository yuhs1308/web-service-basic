package com.yuhs.admin.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value="com.yuhs.admin.mapper.systemdb",sqlSessionFactoryRef="systemSqlSessionFactory")
public class SystemDataSourceConfig {

	@Bean(name="systemDatasource")
	@ConfigurationProperties(prefix="spring.datasource.systemdb")
	public DataSource systemDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="systemSqlSessionFactory")
	public SqlSessionFactory systemSqlSessionFactory(@Qualifier("systemDatasource")DataSource systemDatasource) throws Exception {
		SqlSessionFactoryBean systemSqlSessionFactoryBean = new SqlSessionFactoryBean();
		systemSqlSessionFactoryBean.setDataSource(systemDatasource);
//		systemSqlSessionFactoryBean.setTypeAliasesPackage("com.yuhs.admin.mapper.systemdb");
		systemSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/systemdb/*.xml"));
		return systemSqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="systemSqlSession")
	public SqlSessionTemplate systemSqlSession(SqlSessionFactory systemSqlSessionFactory) {
		return new SqlSessionTemplate(systemSqlSessionFactory);
	}
}
