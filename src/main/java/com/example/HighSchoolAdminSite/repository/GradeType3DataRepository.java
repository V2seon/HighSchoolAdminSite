package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
public interface GradeType3DataRepository extends JpaRepository<GradeType3DataEntity, Long>, QuerydslPredicateExecutor<GradeType3DataEntity> {
}
