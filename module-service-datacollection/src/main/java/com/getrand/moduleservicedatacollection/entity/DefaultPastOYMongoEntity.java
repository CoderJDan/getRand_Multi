package com.getrand.moduleservicedatacollection.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@Document(collection = "default_past_oy")
public class DefaultPastOYMongoEntity {
    @Id
    private String id;
    private String date;
    private String value;
}
