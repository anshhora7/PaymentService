package com.pament.transaction.payment.configuration;


import java.lang.invoke.MethodHandles;

import javax.inject.Named;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
// @ConfigurationProperties("staging.datasource")
@MapperScan(basePackages = "com.pament.transaction.payment.writemapper", sqlSessionFactoryRef = WriteDatasourceConfig.SQL_SESSION_FACTORY_NAME)
public class WriteDatasourceConfig {
	public static final String SQL_SESSION_FACTORY_NAME = "writeSessionFactory";
	private static final Logger log = LoggerFactory.getLogger(MethodHandles
			.lookup().lookupClass());

	@Autowired
	@Qualifier(DatabaseConfiguration.WRITE_DATASOURCE)
	DataSource writeDS;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String url;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * @Bean(name = "stagingDatasource")
	 * 
	 * @Primary public DataSource stagingDatasource() throws SQLException{
	 * 
	 * OracleDataSource dataSource = new OracleDataSource();
	 * dataSource.setUser(username); dataSource.setPassword(password);
	 * dataSource.setURL(url); dataSource.setImplicitCachingEnabled(true);
	 * dataSource.setFastConnectionFailoverEnabled(true);
	 * 
	 * return dataSource; }
	 */

	@Bean(name = WriteDatasourceConfig.SQL_SESSION_FACTORY_NAME)
	@Primary
	public SqlSessionFactory sqlSessionFactoryBean(
			@Named(DatabaseConfiguration.WRITE_DATASOURCE) final DataSource stagingDatasource)
			throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		// Can no longer use application.properties for mybatis configuration
		// settings, so this is a hack for
		// application.properties:
		// mybatis.configuration.map-underscore-to-camel-case=true
		org.apache.ibatis.session.Configuration ibatisConfiguration = new org.apache.ibatis.session.Configuration();
		ibatisConfiguration.setMapUnderscoreToCamelCase(true);
		sqlSessionFactoryBean.setConfiguration(ibatisConfiguration);

		sqlSessionFactoryBean.setDataSource(stagingDatasource);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {

		return new DataSourceTransactionManager(writeDS);
	}

}
