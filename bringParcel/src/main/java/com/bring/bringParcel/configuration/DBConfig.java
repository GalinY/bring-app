package com.bring.bringParcel.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement

public class DBConfig {

  private String dbUrl, dbUsername, dbPassword, driverClassName;

  @Autowired
  public DBConfig(Environment env) {
    this.dbUrl = env.getProperty("database.url");
    this.dbUsername = env.getProperty("database.username");
    this.dbPassword = env.getProperty("database.password");
    this.driverClassName = env.getProperty("driverClassName");
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(dbUsername);
    dataSource.setPassword(dbPassword);
    System.out.println(dbUrl + " " + dbUsername + " " + "password: successful");

    return dataSource;
  }

  Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");

    return properties;
  }
}