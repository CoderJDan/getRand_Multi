package com.getrand.moduleservicedatacollection.controller;

import com.getrand.moduleservicedatacollection.service.ArticleService;
import com.getrand.moduleservicedatacollection.service.ElasticSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elastic")
public class ElasticSearchController {

    private final ElasticSearchService elasticSearchService;
    private final ArticleService articleService;

    public ElasticSearchController(ElasticSearchService elasticSearchService, ArticleService articleService) {
        this.elasticSearchService = elasticSearchService;
        this.articleService = articleService;
    }


    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        boolean isConnected = elasticSearchService.checkElasticsearchConnection();
        return ResponseEntity.ok(isConnected ? "Connected to Elasticsearch" : "Connection failed");
    }
}