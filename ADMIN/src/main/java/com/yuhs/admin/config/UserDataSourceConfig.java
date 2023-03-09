package com.yuhs.admin.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@Configuration
@MapperScan(value="com.yuhs.admin.mapper.userdb",sqlSessionFactoryRef="userSqlSessionFactory")
public class UserDataSourceConfig {
	
	@Bean(name="userDatasource")
	@ConfigurationProperties(prefix="spring.datasource.userdb")
	public DataSource userDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="userSqlSessionFactory")
	public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDatasource")DataSource userDatasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(userDatasource);
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.yuhs.admin.mapper.userdb");
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/userdb/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="userSqlSession")
	public SqlSessionTemplate userSqlSession(SqlSessionFactory userSqlSessionFactory) {
		return new SqlSessionTemplate(userSqlSessionFactory);
	}

}
