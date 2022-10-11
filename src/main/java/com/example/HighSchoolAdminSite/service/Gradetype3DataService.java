package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import com.example.HighSchoolAdminSite.repository.GradeType2DataRepository;
import com.example.HighSchoolAdminSite.repository.GradeType3DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class Gradetype3DataService {

    private GradeType3DataRepository gradeType3DataRepository;
    @Transactional
    public Page<GradeType3DataEntity> selectALLTable(Pageable pageable){
        return gradeType3DataRepository.findAll(pageable);
    }
}
