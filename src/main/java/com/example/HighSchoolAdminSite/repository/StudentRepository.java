package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>, QuerydslPredicateExecutor<StudentEntity> {
    @Query(value = "SELECT COUNT(*) FROM student WHERE signupdatetime >= '2022-10-17 00:00:00' AND signupdatetime < '2022-10-18 00:00:00'" , nativeQuery = true)
    Long find17thUserCount();

    @Query(value = "SELECT COUNT(*) FROM student WHERE signupdatetime >= '2022-10-18 00:00:00' AND signupdatetime < '2022-10-19 00:00:00'" , nativeQuery = true)
    Long find18thUserCount();

    @Query(value = "SELECT COUNT(*) FROM student WHERE signupdatetime >= '2022-10-19 00:00:00' AND signupdatetime < '2022-10-20 00:00:00'" , nativeQuery = true)
    Long find19thUserCount();

    @Query(value = "SELECT COUNT(*) FROM student WHERE signupdatetime >= '2022-10-20 00:00:00' AND signupdatetime < '2022-10-21 00:00:00'" , nativeQuery = true)
    Long find20thUserCount();

}
