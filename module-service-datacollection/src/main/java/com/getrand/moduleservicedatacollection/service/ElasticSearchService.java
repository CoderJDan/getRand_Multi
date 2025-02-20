package com.getrand.moduleservicedatacollection.service;
// 필요한 클래스들을 임포트합니다
import co.elastic.clients.elasticsearch.ElasticsearchClient;    // Elasticsearch 클라이언트
import co.elastic.clients.elasticsearch.core.InfoResponse;      // Elasticsearch 정보 응답
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class ElasticSearchService {
    // ElasticsearchClient 인스턴스를 저장할 final 필드
    private final ElasticsearchClient esClient;

    // 생성자: ElasticsearchClient를 주입받음 (의존성 주입)
    public ElasticSearchService(ElasticsearchClient esClient) {
        this.esClient = esClient;
    }

    // Elasticsearch 연결 상태를 확인하는 메소드
    public boolean checkElasticsearchConnection() {
        try {
            // Elasticsearch 서버의 정보를 요청합니다
            InfoResponse info = esClient.info();
            // 정보를 성공적으로 받아오면 true 반환
            return true;
        } catch (IOException e) {
            // 연결 실패시 스택트레이스 출력하고 false 반환
            e.printStackTrace();
            return false;
        }
    }
}