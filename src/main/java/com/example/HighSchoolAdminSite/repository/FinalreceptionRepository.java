package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.AdminEntity;
import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface FinalreceptionRepository extends JpaRepository<FinalreceptionEntity, Long>, QuerydslPredicateExecutor<FinalreceptionEntity> {

    Optional<FinalreceptionEntity> findByreceptionnum(Long _reception_num);

    @Query(value = "SELECT * FROM final_reception" , nativeQuery = true)
    Page<FinalreceptionEntity> findAll( Pageable pageable);

}
