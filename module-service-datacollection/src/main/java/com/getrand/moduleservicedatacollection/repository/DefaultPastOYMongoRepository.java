package com.getrand.moduleservicedatacollection.repository;

import com.getrand.moduleservicedatacollection.entity.DefaultPastOYMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DefaultPastOYMongoRepository extends MongoRepository< DefaultPastOYMongoEntity, String>{

}
