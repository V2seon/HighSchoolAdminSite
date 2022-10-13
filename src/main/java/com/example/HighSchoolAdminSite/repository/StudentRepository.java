package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository {
    // 17일
    // SELECT * FROM table_a WHERE signupdatetime >= '2022-10-17 00:00:00' AND create_dt <= '2021-10-18 00:00:00';
    @Query(value = "SELECT * FROM student WHERE signupdatetime >= '2022-10-17 00:00:00' AND create_dt <= '2021-10-18 00:00:00'" , nativeQuery = true)
    int find17thUserCount();

    // 18일
    // SELECT * FROM student WHERE signupdatetime >= '2022-10-18 00:00:00' AND create_dt <= '2021-10-19 00:00:00';
    @Query(value = "SELECT * FROM student WHERE signupdatetime >= '2022-10-18 00:00:00' AND create_dt <= '2021-10-19 00:00:00'" , nativeQuery = true)
    int find18thUserCount();

    // 19일
    // SELECT * FROM student WHERE signupdatetime >= '2022-10-19 00:00:00' AND create_dt <= '2021-10-20 00:00:00';
    @Query(value = "SELECT * FROM student WHERE signupdatetime >= '2022-10-19 00:00:00' AND create_dt <= '2021-10-20 00:00:00'" , nativeQuery = true)
    int find19thUserCount();

    // 20일
    // SELECT * FROM student WHERE signupdatetime >= '2022-10-20 00:00:00' AND create_dt <= '2021-10-21 00:00:00';
    @Query(value = "SELECT * FROM student WHERE signupdatetime >= '2022-10-20 00:00:00' AND create_dt <= '2021-10-21 00:00:00'" , nativeQuery = true)
    int find20thUserCount();

}
