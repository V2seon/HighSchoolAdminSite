package com.example.HighSchoolAdminSite.repository;

import com.example.HighSchoolAdminSite.entity.StudentfakeseqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentfakeseqRepository extends JpaRepository<StudentfakeseqEntity, Long> {

    @Query( value="SELECT * FROM student_fake_seq WHERE num =:num ORDER BY studentfakeseq DESC LIMIT 1" , nativeQuery = true)
    Optional<StudentfakeseqEntity> findBynum(int num);

    Optional<StudentfakeseqEntity> findBySseq(Long Sseq);
}
