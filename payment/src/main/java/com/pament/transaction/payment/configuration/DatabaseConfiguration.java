package com.pament.transaction.payment.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
//	public static final String READ_DATASOURCE = "ReadDS";
	public static final String WRITE_DATASOURCE = "WriteDS";
//	public static final String READ_DATASOURCE = null;

//	@Bean(name = READ_DATASOURCE, destroyMethod = "")
//	@ConfigurationProperties(prefix = "datasources.readds")
//	@Primary
//	public DataSource dataSourceRead() {
//		// Filled up with the properties specified about thanks to Spring Boot
//		// black
//		// magic
//		return new HikariDataSource();
//	}
//	public static final String READ_DATASOURCE = null;

	@Bean(name = WRITE_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "datasources.writeds")
	public DataSource dataSourceWrite() {
		// Filled up with the properties specified about thanks to Spring Boot
		// black
		// magic
		return new HikariDataSource();
	}

}
