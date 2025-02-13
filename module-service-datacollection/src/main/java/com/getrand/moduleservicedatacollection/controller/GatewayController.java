package com.getrand.moduleservicedatacollection.controller;

import com.getrand.moduleservicedatacollection.dto.DefaultPastOYResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RealTimeTrendResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RelatedQueriesResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RelatedTopicsResponseDTO;
import com.getrand.moduleservicedatacollection.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datacollection")
@RequiredArgsConstructor
public class GatewayController {
    private final TrendService service;

    @GetMapping("/defaultPastOY/findall")
    public List<DefaultPastOYResponseDTO> findDefaultTrendYear() {
        return service.pastOneYearFindAll();
    }

    @GetMapping("/defaultPastOY/update")
    public List<DefaultPastOYResponseDTO> UpdateDefaultTrendYear() {
        service.pastOneYearDeleteAll();
        service.pastOneYear();
        return service.pastOneYearFindAll();
    }

    @GetMapping("/realTimeTrend/findall")
    public List<RealTimeTrendResponseDTO> findRealTimeTrend() {
        return service.realTimeTrendFindAll();
    }

    @GetMapping("/realTimeTrend/update")
    public List<RealTimeTrendResponseDTO> UpdateRealTimeTrend() {
        service.fetchRealTimeTrendDeleteAll();
        service.fetchRealTimeTrend();
        return service.realTimeTrendFindAll();
    }

    @GetMapping("/relatedTopics/findall")
    public List<RelatedTopicsResponseDTO> relatedTopics() {
        return service.relatedTopicsFindAll();
    }

    @GetMapping("/relatedTopics/update")
    public List<RelatedTopicsResponseDTO> UpdateRelatedTopics() {
        service.fetchRelatedTopicsDeleteAll();
        service.fetchRelatedTopics();
        return service.relatedTopicsFindAll();
    }

    @GetMapping("/relatedQueries/findall")
    public List<RelatedQueriesResponseDTO> relatedQueries() {
        return service.relatedQueriesFindAll();
    }

    @GetMapping("/relatedQueries/update")
    public List<RelatedQueriesResponseDTO> UpdateRelatedQueries() {
        service.fetchRelatedQueriesDeleteAll();
        service.fetchRelatedQueries();
        return service.relatedQueriesFindAll();
    }
}
