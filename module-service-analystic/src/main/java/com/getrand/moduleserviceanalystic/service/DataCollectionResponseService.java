package com.getrand.moduleserviceanalystic.service;

import com.getrand.moduleserviceanalystic.client.DataCollectionServiceClient;
import com.getrand.moduleserviceanalystic.dto.DefaultPastOYResponseDTO;
import com.getrand.moduleserviceanalystic.dto.RealTimeTrendResponseDTO;
import com.getrand.moduleserviceanalystic.dto.RelatedQueriesResponseDTO;
import com.getrand.moduleserviceanalystic.dto.RelatedTopicsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataCollectionResponseService {
    private final DataCollectionServiceClient dataCollectionServiceClient;

    public List<DefaultPastOYResponseDTO> getAllDefaultPastOY() {
        return dataCollectionServiceClient.getAllDefaultPastOY();
    }

    public List<DefaultPastOYResponseDTO> updateDefaultPastOY() {
        return dataCollectionServiceClient.updateDefaultPastOY();
    }

    public List<RealTimeTrendResponseDTO> getAllRealTimeTrend() {
        return dataCollectionServiceClient.getAllRealTimeTrend();
    }

    public List<RealTimeTrendResponseDTO> updateRealTimeTrend() {
        return dataCollectionServiceClient.updateRealTimeTrend();
    }

    public List<RelatedTopicsResponseDTO> getAllRelatedTopics() {
        return dataCollectionServiceClient.getAllRelatedTopics();
    }

    public List<RelatedTopicsResponseDTO> updateRelatedTopics() {
        return dataCollectionServiceClient.updateRelatedTopics();
    }

    public List<RelatedQueriesResponseDTO> getAllRelatedQueries() {
        return dataCollectionServiceClient.getAllRelatedQueries();
    }

    public List<RelatedQueriesResponseDTO> updateRelatedQueries() {
        return dataCollectionServiceClient.updateRelatedQueries();
    }
}
