package com.getrand.moduleservicedatacollection.controller;

import com.getrand.moduleservicedatacollection.entity.ArticleDocument;
import com.getrand.moduleservicedatacollection.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    // 1. 문서 저장 엔드포인트
    @PostMapping
    public ResponseEntity<ArticleDocument> createArticle(@RequestBody ArticleDocument article) {
        return ResponseEntity.ok(articleService.saveArticle(article));
    }

    // 2. 유사 문서 검색 엔드포인트
    @GetMapping("/search/similar")
    public ResponseEntity<List<ArticleDocument>> searchSimilarArticles(@RequestParam String text) {
        return ResponseEntity.ok(articleService.searchMoreLikeThis(text));
    }
}