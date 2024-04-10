package com.tongweb.springboot3graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springboot3graalvmApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot3graalvmApplication.class, args);
  }

  @RequestMapping("/")
  public String hello(){
    return "hello, world";
  }

}
