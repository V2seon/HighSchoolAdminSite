package com.example.HighSchoolAdminSite.service;


import com.example.HighSchoolAdminSite.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Transactional
    public Long get17thUserCount(){
        return studentRepository.find17thUserCount();
    }

    @Transactional
    public Long get18thUserCount(){
        return studentRepository.find18thUserCount();
    }

    @Transactional
    public Long get19thUserCount(){
        return studentRepository.find19thUserCount();
    }

    @Transactional
    public Long get20thUserCount(){
        return studentRepository.find20thUserCount();
    }
}
