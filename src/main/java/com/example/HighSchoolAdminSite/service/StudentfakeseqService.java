package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.dto.StudentfakeseqDto;
import com.example.HighSchoolAdminSite.repository.StudentfakeseqRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class StudentfakeseqService {
    private StudentfakeseqRepository studentfakeseqRepository;

    @Transactional
    public Long save(StudentfakeseqDto studentfakeseqDto){
        return studentfakeseqRepository.save(studentfakeseqDto.toEntity()).getSeq();
    }
}
