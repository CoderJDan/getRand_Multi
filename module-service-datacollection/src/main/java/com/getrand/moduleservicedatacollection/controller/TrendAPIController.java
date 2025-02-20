package com.getrand.moduleservicedatacollection.controller;

import com.getrand.moduleservicedatacollection.dto.DefaultPastOYResponseDTO;
import com.getrand.moduleservicedatacollection.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/google")
@RequiredArgsConstructor
public class TrendAPIController {
    private final TrendService service;
    @GetMapping("/defaultPastOY")
    public String defaultTrendYear() {
        service.pastOneYear();
        return "ok";
    }

    @GetMapping("/realtime")
    public String realtime() {
        service.fetchRealTimeTrend();
        return "ok";
    }

    @GetMapping("/relatedQueries")
    public String relatedQueries() {
        service.fetchRelatedQueries();
        return "ok";
    }

    @GetMapping("/relatedTopics")
    public String relatedTopics() {
        service.fetchRelatedTopics();
        return "ok";
    }
    @GetMapping("/defaultPastOY/findAll")
    public List<DefaultPastOYResponseDTO> getDefaultTrendYearData(){
        return service.pastOneYearFindAll();
    }
}
