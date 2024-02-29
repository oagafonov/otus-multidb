package com.example.otusmultidb;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

  @Autowired
  private ApplicationProperties dataSourceProperties;

  @Bean
  public Map<String, JdbcTemplate> dataSources() {
    Map<String, JdbcTemplate> dataSources = new HashMap<>();


    dataSourceProperties.getDatasources().forEach((k, v)->{
      HikariDataSource dataSource = new HikariDataSource();
      dataSource.setJdbcUrl(v.getUrl());
      dataSource.setUsername(v.getUsername());
      dataSource.setPassword(v.getPassword());
      dataSource.setDriverClassName(v.getDriverClassName());

      dataSources.put(k, new JdbcTemplate(dataSource));
      System.out.printf("created %s\t%s\n", k, dataSource);
    });
    return dataSources;
  }
}