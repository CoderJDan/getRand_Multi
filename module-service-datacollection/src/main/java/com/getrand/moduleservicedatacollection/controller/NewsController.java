package com.getrand.moduleservicedatacollection.controller;

import com.getrand.moduleservicedatacollection.entity.News;
import com.getrand.moduleservicedatacollection.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews(){
        System.out.println("✅ NewsController: GET /api/news 요청 수신됨"); // 👈 디버깅 추가

        return newsService.getAllNews();

    }
//    @GetMapping("/search")
//    public List<News> searchNews(@RequestParam String keyword){
//        return newsService.searchByKeyword(keyword);
//    }
}
