package com.getrand.moduleserviceanalystic.service;

import com.getrand.moduleserviceanalystic.dto.DefaultPastOYResponseDTO;
import com.getrand.moduleserviceanalystic.dto.RelatedQueriesResponseDTO;
import com.getrand.moduleserviceanalystic.dto.RelatedTopicsResponseDTO;

import java.util.List;

public interface TrendService {
    List<DefaultPastOYResponseDTO> pastOneYear(String query);
    List<RelatedQueriesResponseDTO> fetchRelatedQueries(String query);
    List<RelatedTopicsResponseDTO> fetchRelatedTopics(String query);
}
