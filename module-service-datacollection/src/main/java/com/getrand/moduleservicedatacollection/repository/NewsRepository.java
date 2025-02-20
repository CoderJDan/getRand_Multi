package com.getrand.moduleservicedatacollection.repository;

import com.getrand.moduleservicedatacollection.entity.News;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, ObjectId> {
    List<News> findByKeywordsContaining(String keyword);
}
