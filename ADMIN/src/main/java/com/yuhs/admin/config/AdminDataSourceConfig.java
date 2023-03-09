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
@MapperScan(value="com.yuhs.admin.mapper.admindb",sqlSessionFactoryRef="adminSqlSessionFactory")
public class AdminDataSourceConfig {
	
	@Primary
	@Bean(name="adminDataSource")
	@ConfigurationProperties(prefix="spring.datasource.admindb")
	public DataSource adminDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="adminSqlSessionFactory")
	public SqlSessionFactory adminSqlSessionFactory(@Qualifier("adminDataSource")DataSource adminDataSource) throws Exception {
		SqlSessionFactoryBean adminSqlSessionFactoryBean = new SqlSessionFactoryBean();
		adminSqlSessionFactoryBean.setDataSource(adminDataSource);
//		sqlSessionFactory.setTypeAliasesPackage("com.yuhs.admin.mapper.admindb");
		adminSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/admindb/*.xml"));
		return adminSqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name="adminSqlSession")
	public SqlSessionTemplate adminSqlSession(SqlSessionFactory adminSqlSessionFactory) {
		return new SqlSessionTemplate(adminSqlSessionFactory);
	}

}
