package com.getrand.moduleserviceanalystic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.getrand.moduleserviceanalystic")
@EnableDiscoveryClient
public class ModuleServiceAnalysticApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleServiceAnalysticApplication.class, args);
    }

}
