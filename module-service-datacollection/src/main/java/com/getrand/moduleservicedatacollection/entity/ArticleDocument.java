package com.getrand.moduleservicedatacollection.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName ="articles")// 인덱스명은 db이름 같은거임, document는 엔티티같은거 아닐 수도 있음 난 그래 이해함

public class ArticleDocument {
    @Id
    private String id ;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String content;



}
