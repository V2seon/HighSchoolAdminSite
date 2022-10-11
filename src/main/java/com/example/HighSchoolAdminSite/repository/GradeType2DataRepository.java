package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
public interface GradeType2DataRepository extends JpaRepository<GradeType2DataEntity, Long>, QuerydslPredicateExecutor<GradeType2DataEntity> {
}
