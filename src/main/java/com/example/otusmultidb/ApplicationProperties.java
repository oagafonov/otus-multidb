package com.example.otusmultidb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

  private Map<String,DataSourceConfig> datasources;

  public Map<String, DataSourceConfig> getDatasources() {
    return datasources;
  }

  public void setDatasources(Map<String, DataSourceConfig> datasources) {
    this.datasources = datasources;
  }

  public static class DataSourceConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    // standard getters and setters
    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

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

    public String getDriverClassName() {
      return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
      this.driverClassName = driverClassName;
    }
  }
}