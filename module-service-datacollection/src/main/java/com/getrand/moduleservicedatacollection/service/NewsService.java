package com.getrand.moduleservicedatacollection.service;

import com.getrand.moduleservicedatacollection.entity.News;
import com.getrand.moduleservicedatacollection.repository.NewsRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final MongoTemplate mongoTemplate;


    public NewsService(NewsRepository newsRepository, MongoTemplate mongoTemplate) {
        this.newsRepository = newsRepository;
        this.mongoTemplate = mongoTemplate;
    }
    public List<News> getAllNews(){
        List<News> newsList = newsRepository.findAll();
        System.out.println("에러 체크 :  ::::::::" +newsList);
        System.out.println("에러 체크 :  ::::::::" +newsList);
        System.out.println("에러 체크 :  ::::::::" +newsList);
        return newsRepository.findAll();
    }
    public List<News> searchByKeyword(String keyword){
        return  newsRepository.findByKeywordsContaining(keyword);
    }
}
