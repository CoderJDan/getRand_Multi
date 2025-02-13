package com.getrand.moduleservicedatacollection.service;

import com.getrand.moduleservicedatacollection.dto.DefaultPastOYResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RealTimeTrendResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RelatedQueriesResponseDTO;
import com.getrand.moduleservicedatacollection.dto.RelatedTopicsResponseDTO;

import java.util.List;

public interface TrendService {
    void pastOneYear();
    void fetchRealTimeTrend();
    void fetchRelatedQueries();
    void fetchRelatedTopics();
    void pastOneYearDeleteAll();
    void fetchRealTimeTrendDeleteAll();
    void fetchRelatedQueriesDeleteAll();
    void fetchRelatedTopicsDeleteAll();
    List<DefaultPastOYResponseDTO> pastOneYearFindAll();
    List<RealTimeTrendResponseDTO> realTimeTrendFindAll();
    List<RelatedTopicsResponseDTO> relatedTopicsFindAll();
    List<RelatedQueriesResponseDTO> relatedQueriesFindAll();
}
