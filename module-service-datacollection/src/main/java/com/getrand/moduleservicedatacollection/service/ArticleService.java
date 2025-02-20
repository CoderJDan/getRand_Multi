package com.getrand.moduleservicedatacollection.service;


import com.getrand.moduleservicedatacollection.entity.ArticleDocument;
import com.getrand.moduleservicedatacollection.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import co.elastic.clients.elasticsearch._types.query_dsl.MoreLikeThisQuery;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ElasticsearchTemplate elasticsearchTemplate;
    private final ArticleRepository articleRepository;

    /**
     * 문서를 Elasticsearch에 저장하는 메서드
     * param article 저장할 문서 객체
     * return 저장된 ArticleDocument 객체
     */

    public List<ArticleDocument> findAllArticles() {
        Iterable<ArticleDocument> articles = articleRepository.findAll();
        return StreamSupport.stream(articles.spliterator(), false)
                .collect(Collectors.toList());
    }

    public ArticleDocument saveArticle(ArticleDocument article) {
        return articleRepository.save(article);

    }

    /**
     * More Like This(MLT) 기반으로 유사한 문서를 검색하는 메서드
     *
     * @param text 검색 기준이 될 입력된 문장
     * @return 입력된 문장과 유사한 문서 목록 반환
     */
    public List<ArticleDocument> searchMoreLikeThis(String text) {
        // 1. MoreLikeThisQuery 객체 생성
        // Builder 패턴: 객체 생성을 단계별로 하고 마지막에 build()로 완성하는 디자인 패턴
        // new MoreLikeThisQuery.Builder()로 빌더 객체를 생성하고
        // .fields(), .like() 등으로 필요한 설정을 체이닝(연쇄) 방식으로 추가
        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery.Builder()
                // 검색할 필드명들을 지정 (제목과 내용에서 검색)
                .fields("title", "content")
                // 람다식(l -> l.text(text))을 사용하여 검색할 텍스트 설정
                // l은 임시 파라미터로, 입력받은 text를 검색어로 설정
                .like(l -> l.text(text))
                // 단어가 최소 몇 번 이상 등장해야 유사도 계산에 포함할지 설정
                .minTermFreq(1)
                // 유사도 계산에 사용할 최대 단어 개수 설정
                .maxQueryTerms(12)
                // 설정이 완료된 쿼리 객체 생성
                .build();

        // 2. Elasticsearch 네이티브 쿼리 생성
        // NativeQuery도 마찬가지로 빌더 패턴 사용
        NativeQuery searchQuery = NativeQuery.builder()
                // 위에서 만든 MoreLikeThisQuery를 실제 검색 쿼리로 변환
                .withQuery(moreLikeThisQuery._toQuery())
                // 쿼리 객체 생성 완료
                .build();

        // 3. 검색 실행
        // elasticsearchTemplate.search() 메서드로 검색 수행
        // searchQuery: 검색 조건
        // ArticleDocument.class: 검색 결과를 매핑할 클래스 타입
        SearchHits<ArticleDocument> searchHits = elasticsearchTemplate.search(
                searchQuery,          // 첫 번째 인자: 검색 조건
                ArticleDocument.class // 두 번째 인자: 검색 결과를 변환할 클래스 타입
        );

        // 4. 검색 결과 변환 및 반환
        // Stream API를 사용하여 검색 결과를 List로 변환
        // 1. stream() 생성
       return searchHits.stream()
                // SearchHits 객체를 스트림으로 변환
                // 스트림은 데이터의 흐름을 나타냄
                // 2. map() 변환
                .map(hit -> hit.getContent())
                // hit는 SearchHit<ArticleDocument> 타입의 각 검색 결과
                // hit.getContent()는 실제 ArticleDocument 객체를 추출
                // 람다식 (hit -> hit.getContent())은 아래 코드와 동일:
                /*
                .map(new Function<SearchHit<ArticleDocument>, ArticleDocument>() {
                    @Override
                    public ArticleDocument apply(SearchHit<ArticleDocument> hit) {
                        return hit.getContent();
                    }
                })
                */
// 3. collect() 수집
                .collect(Collectors.toList());
        // 스트림의 결과를 List로 모음
        // Collectors.toList()는 결과를 ArrayList로 수집하는 수집기

    }
}


//
//
//package com.getrand.moduleservicedatacollection.service;
//import com.getrand.moduleservicedatacollection.entity.ArticleDocument;
//import com.getrand.moduleservicedatacollection.repository.ArticleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.client.elc.NativeQuery;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.stereotype.Service;
//import co.elastic.clients.elasticsearch._types.query_dsl.MoreLikeThisQuery;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ArticleService {
//    private final ElasticsearchTemplate elasticsearchTemplate;
//    private final ArticleRepository articleRepository;
//
//    /**
//     * 문서를 Elasticsearch에 저장하는 메서드
//     * @param article 저장할 문서 객체
//     * @return 저장된 ArticleDocument 객체
//     */
//    public ArticleDocument saveArticle(ArticleDocument article) {
//        return articleRepository.save(article);
//    }
//
//    /**
//     * More Like This(MLT) 기반으로 유사한 문서를 검색하는 메서드
//     * @param text 검색 기준이 될 입력된 문장
//     * @return 입력된 문장과 유사한 문서 목록 반환
//     */
//    public List<ArticleDocument> searchMoreLikeThis(String text) {
//        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery.Builder()
//                .fields("title", "content")
//                .like(l -> l.text(text))
//                .minTermFreq(1)
//                .maxQueryTerms(12)
//                .build();
//
//        NativeQuery searchQuery = NativeQuery.builder()
//                .withQuery(moreLikeThisQuery._toQuery())
//                .build();
//
//        SearchHits<ArticleDocument> searchHits = elasticsearchTemplate.search(
//                searchQuery,
//                ArticleDocument.class
//        );
//
//        return searchHits.stream()
//                .map(hit -> hit.getContent())
//                .collect(Collectors.toList());
//    }
//}
//
//    public List<ArticleDocument> searchMoreLikeThis(String text) {
//        // 1. MoreLikeThisQuery 객체 생성
//        // Builder 패턴: 객체 생성을 단계별로 하고 마지막에 build()로 완성하는 디자인 패턴
//        // new MoreLikeThisQuery.Builder()로 빌더 객체를 생성하고
//        // .fields(), .like() 등으로 필요한 설정을 체이닝(연쇄) 방식으로 추가
//        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery.Builder()
//                // 검색할 필드명들을 지정 (제목과 내용에서 검색)
//                .fields("title", "content")
//                // 람다식(l -> l.text(text))을 사용하여 검색할 텍스트 설정
//                // l은 임시 파라미터로, 입력받은 text를 검색어로 설정
//                .like(l -> l.text(text))
//                // 단어가 최소 몇 번 이상 등장해야 유사도 계산에 포함할지 설정
//                .minTermFreq(1)
//                // 유사도 계산에 사용할 최대 단어 개수 설정
//                .maxQueryTerms(12)
//                // 설정이 완료된 쿼리 객체 생성
//                .build();
//
//        // 2. Elasticsearch 네이티브 쿼리 생성
//        // NativeQuery도 마찬가지로 빌더 패턴 사용
//        NativeQuery searchQuery = NativeQuery.builder()
//                // 위에서 만든 MoreLikeThisQuery를 실제 검색 쿼리로 변환
//                .withQuery(moreLikeThisQuery._toQuery())
//                // 쿼리 객체 생성 완료
//                .build();
//
//        // 3. 검색 실행
//        // elasticsearchTemplate.search() 메서드로 검색 수행
//        // searchQuery: 검색 조건
//        // ArticleDocument.class: 검색 결과를 매핑할 클래스 타입
//        SearchHits<ArticleDocument> searchHits = elasticsearchTemplate.search(
//                searchQuery,
//                ArticleDocument.class
//        );
//
//        // 4. 검색 결과 변환 및 반환
//        // Stream API를 사용하여 검색 결과를 List로 변환
//        return searchHits.stream()  // SearchHits를 스트림으로 변환
//                .map(hit -> hit.getContent())  // 각 검색 결과에서 실제 문서 객체만 추출
//                .collect(Collectors.toList());  // 최종적으로 List로 변환
//    }

// searchHits에 이런 데이터가 있다고 가정해봅시다:
//searchHits = [
//        SearchHit(ArticleDocument{제목: "첫번째 글", 내용: "안녕하세요"}),
//        SearchHit(ArticleDocument{제목: "두번째 글", 내용: "반갑습니다"}),
//        SearchHit(ArticleDocument{제목: "세번째 글", 내용: "좋은하루"})
//        ]
//
//// 코드가 실행되면:
//        1회차 반복:
//        hit = SearchHit(ArticleDocument{제목: "첫번째 글", 내용: "안녕하세요"})
//        article = ArticleDocument{제목: "첫번째 글", 내용: "안녕하세요"}
//        resultList에 추가
//
//        2회차 반복:
//        hit = SearchHit(ArticleDocument{제목: "두번째 글", 내용: "반갑습니다"})
//        article = ArticleDocument{제목: "두번째 글", 내용: "반갑습니다"}
//        resultList에 추가
//
//        3회차 반복:
//        hit = SearchHit(ArticleDocument{제목: "세번째 글", 내용: "좋은하루"})
//        article = ArticleDocument{제목: "세번째 글", 내용: "좋은하루"}
//        resultList에 추가
//
//// 최종 결과:
//        resultList = [
//        ArticleDocument{제목: "첫번째 글", 내용: "안녕하세요"},
//        ArticleDocument{제목: "두번째 글", 내용: "반갑습니다"},
//        ArticleDocument{제목: "세번째 글", 내용: "좋은하루"}
//        ]