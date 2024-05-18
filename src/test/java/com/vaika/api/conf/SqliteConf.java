package com.vaika.api.conf;

import com.vaika.api.PojaGenerated;
import org.springframework.test.context.DynamicPropertyRegistry;

@PojaGenerated
public class SqliteConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("driverClassName", () -> "org.sqlite.JDBC");
    registry.add("spring.datasource.url", () -> "jdbc:sqlite:/tmp/sqlite-data:db?cache=shared");
    registry.add("spring.datasource.username", () -> "sa");
    registry.add("spring.datasource.password", () -> "sa");
  }
}
