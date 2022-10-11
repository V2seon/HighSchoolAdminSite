package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GradeType3DataRepository extends JpaRepository<GradeType3DataEntity, Long>, QuerydslPredicateExecutor<GradeType3DataEntity> {

    @Query(value = "SELECT * FROM grade_type3" , nativeQuery = true)
    Page<GradeType3DataEntity> findAll(Pageable pageable);
}
