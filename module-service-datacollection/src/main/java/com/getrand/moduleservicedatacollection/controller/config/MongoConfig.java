package com.getrand.moduleservicedatacollection.controller.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void checkConnection() {
        try {
            mongoTemplate.getDb().getName();
            System.out.println("MongoDB 연결 성공!");
        } catch (Exception e) {
            System.err.println("MongoDB 연결 실패: " + e.getMessage());
        }
    }
}