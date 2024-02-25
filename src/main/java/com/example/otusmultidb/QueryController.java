package com.example.otusmultidb;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class QueryController {

  @Autowired
  @Qualifier("dataSources")
  Map<String, JdbcTemplate> dataSourceMap;

  @GetMapping("{data}")
  public ResponseEntity<String> execute(@PathVariable String data) {
    return ResponseEntity.ok(executeQuery(data));
  }

  private String executeQuery(String data) {
    JdbcTemplate t = dataSourceMap.get(data);
    return t.queryForObject("select 1", String.class);
  }
}
