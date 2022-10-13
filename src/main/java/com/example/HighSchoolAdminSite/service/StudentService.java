package com.example.HighSchoolAdminSite.service;


import com.example.HighSchoolAdminSite.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository;

    public int get17thUserCount(){
        return studentRepository.find17thUserCount();
    }
    public int get18thUserCount(){
        return studentRepository.find18thUserCount();
    }
    public int get19thUserCount(){
        return studentRepository.find19thUserCount();
    }
    public int get20thUserCount(){
        return studentRepository.find20thUserCount();
    }
    public int getTotalUserCount(){
        return 0;
    }
}
