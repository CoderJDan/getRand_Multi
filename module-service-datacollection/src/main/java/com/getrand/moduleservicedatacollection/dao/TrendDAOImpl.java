package com.getrand.moduleservicedatacollection.dao;

import com.getrand.moduleservicedatacollection.entity.DefaultPastOYEntity;
import com.getrand.moduleservicedatacollection.entity.RealTimeTrendEntity;
import com.getrand.moduleservicedatacollection.entity.RelatedQueriesEntity;
import com.getrand.moduleservicedatacollection.entity.RelatedTopicsEntity;
import com.getrand.moduleservicedatacollection.repository.DefaultPastOYRepository;
import com.getrand.moduleservicedatacollection.repository.RealTimeTrendRepository;
import com.getrand.moduleservicedatacollection.repository.RelatedQueriesRepository;
import com.getrand.moduleservicedatacollection.repository.RelatedTopicsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrendDAOImpl implements TrendDAO {
    private final RealTimeTrendRepository rtRepository;
    private final RelatedQueriesRepository relatedQueriesRepository;
    private final RelatedTopicsRepository relatedTopicsRepository;
    private final DefaultPastOYRepository defaultPastOYRepository;

    @Override
    public void insertRtt(List<RealTimeTrendEntity> dtos) {
        rtRepository.saveAll(dtos);
    }

    @Override
    public void insertRq(List<RelatedQueriesEntity> dtos) {
        relatedQueriesRepository.saveAll(dtos);
    }

    @Override
    public void insertRt(List<RelatedTopicsEntity> dtos) {
        relatedTopicsRepository.saveAll(dtos);
    }

    @Override
    public void insertDOY(List<DefaultPastOYEntity> dtos) {
        defaultPastOYRepository.saveAll(dtos);
    }

    @Override
    public void deleteRtt() {
        rtRepository.deleteAll();
    }

    @Override
    public void deleteRq() {
        relatedQueriesRepository.deleteAll();
    }

    @Override
    public void deleteRt() {
        relatedTopicsRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteDOY() {
        defaultPastOYRepository.deleteAll();
        defaultPastOYRepository.resetAutoIncrement();
    }

    @Override
    public List<DefaultPastOYEntity> findDOY() {
        return defaultPastOYRepository.findAll();
    }

    @Override
    public List<RealTimeTrendEntity> findRtt() {
        return rtRepository.findAll();
    }

    @Override
    public List<RelatedTopicsEntity> findRt() {
        return relatedTopicsRepository.findAll();
    }

    @Override
    public List<RelatedQueriesEntity> findRq() {
        return relatedQueriesRepository.findAll();
    }
}