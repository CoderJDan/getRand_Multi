package com.getrand.moduleservicedatacollection.repository;

import com.getrand.moduleservicedatacollection.entity.ArticleDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<ArticleDocument, String> {
}
