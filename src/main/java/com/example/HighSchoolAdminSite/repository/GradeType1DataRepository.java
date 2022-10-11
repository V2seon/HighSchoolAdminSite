package com.example.HighSchoolAdminSite.repository;



import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GradeType1DataRepository extends JpaRepository<GradeType1DataEntity, Long>, QuerydslPredicateExecutor<GradeType1DataEntity> {

    @Query(value = "SELECT * FROM grade_type1" , nativeQuery = true)
    Page<GradeType1DataEntity> findAll(Pageable pageable);
}
