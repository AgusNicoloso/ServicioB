package com.utn.final2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Final2Application {

  public static void main(String[] args) {
    SpringApplication.run(Final2Application.class, args);
  }

}
