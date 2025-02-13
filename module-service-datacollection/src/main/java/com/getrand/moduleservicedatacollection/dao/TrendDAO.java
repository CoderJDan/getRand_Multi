package com.getrand.moduleservicedatacollection.dao;

import com.getrand.moduleservicedatacollection.entity.DefaultPastOYEntity;
import com.getrand.moduleservicedatacollection.entity.RealTimeTrendEntity;
import com.getrand.moduleservicedatacollection.entity.RelatedQueriesEntity;
import com.getrand.moduleservicedatacollection.entity.RelatedTopicsEntity;

import java.util.List;

public interface TrendDAO {
    void insertRtt(List<RealTimeTrendEntity> dto);
    void insertRq(List<RelatedQueriesEntity> dto);
    void insertRt(List<RelatedTopicsEntity> dto);
    void insertDOY(List<DefaultPastOYEntity> dto);
    void deleteRtt();
    void deleteRq();
    void deleteRt();
    void deleteDOY();
    List<DefaultPastOYEntity> findDOY();
    List<RealTimeTrendEntity> findRtt();
    List<RelatedTopicsEntity> findRt();
    List<RelatedQueriesEntity> findRq();
}