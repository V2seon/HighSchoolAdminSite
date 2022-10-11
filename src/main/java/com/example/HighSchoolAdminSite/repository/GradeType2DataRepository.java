package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GradeType2DataRepository extends JpaRepository<GradeType2DataEntity, Long>, QuerydslPredicateExecutor<GradeType2DataEntity> {

    @Query(value = "SELECT * FROM grade_type2" , nativeQuery = true)
    Page<GradeType2DataEntity> findAll(Pageable pageable);
}
