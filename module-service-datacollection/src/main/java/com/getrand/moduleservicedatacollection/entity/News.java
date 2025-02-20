package com.getrand.moduleservicedatacollection.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;
@Data
@Document(collection = "news")
public class News {
    @Id
    private ObjectId id;

    @Field(name = "news_id")
    private String newsId;

    @Field(name = "title")
    private String title;

    @Field(name = "contents")
    private String contents;

    @Field(name = "publish_date")
    private String publishDate;

    @Field(name = "keywords")
    private List<String> keywords;

    @Field(name = "source_link")
    private String sourceLink;
}