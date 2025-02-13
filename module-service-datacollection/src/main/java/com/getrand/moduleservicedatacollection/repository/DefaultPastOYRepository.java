package com.getrand.moduleservicedatacollection.repository;

import com.getrand.moduleservicedatacollection.entity.DefaultPastOYEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DefaultPastOYRepository extends JpaRepository<DefaultPastOYEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE default_pastoneyear AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
