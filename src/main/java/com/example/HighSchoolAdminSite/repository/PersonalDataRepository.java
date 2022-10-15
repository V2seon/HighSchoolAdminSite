package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PersonalDataRepository extends JpaRepository<PersonalDataEntity, Long>, QuerydslPredicateExecutor<PersonalDataEntity> {

    @Query(value = "SELECT * FROM information" , nativeQuery = true)
    Page<PersonalDataEntity> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM information where graduation_type = ?" , nativeQuery = true)
    Page<PersonalDataEntity> findAgraduation_typeBy(int agraduation_type, Pageable pageable);

}
