package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    Optional<AdminEntity> findByAidAndApw(String A_ID, String A_PW);
}