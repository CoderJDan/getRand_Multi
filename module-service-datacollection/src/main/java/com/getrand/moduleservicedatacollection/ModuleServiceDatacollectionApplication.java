package com.getrand.moduleservicedatacollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.getrand.moduleservicedatacollection")
@EnableScheduling
public class ModuleServiceDatacollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleServiceDatacollectionApplication.class, args);
    }

}
