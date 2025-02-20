package com.getrand.moduleservicedatacollection.controller.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Elasticsearch 관련 설정을 담당하는 클래스임을 명시하는 어노테이션
@Configuration
public class ElasticSearchConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // RestClient 생성: Elasticsearch와 HTTP 통신을 담당하는 low-level 클라이언트
        RestClient restClient = RestClient.builder(
                        // localhost:9200으로 연결 설정 (기본 Elasticsearch 주소)
                        new HttpHost("localhost", 9200))
                .build();

        // Elasticsearch와의 통신을 담당하는 Transport 객체 생성
        // RestClientTransport: HTTP를 통한 통신 방식 사용
        // JacksonJsonpMapper: JSON 데이터 변환을 담당
        ElasticsearchTransport transport = new RestClientTransport(
                restClient,
                new JacksonJsonpMapper()
        );

        // 최종적으로 high-level 클라이언트인 ElasticsearchClient 생성 및 반환
        // 이 클라이언트를 통해 Elasticsearch의 다양한 API를 사용할 수 있음
        return new ElasticsearchClient(transport);
    }
}