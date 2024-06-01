package com.vaika.api.conf;

import org.springframework.test.context.DynamicPropertyRegistry;

public class EnvConf {
  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add(
        "jwt.secret",
        () ->
            "YTU1NTI1M2E5N2UxODJjMGNlMjA4NTFiM2Q1MTRjMDFjNjEyNDcxYTBmNzJlNjMzMTAyZTA2NmY2NGJmMDIwZQ==");
    registry.add("jwt.expiration", () -> 3600000);
  }
}
