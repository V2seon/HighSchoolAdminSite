package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.repository.GradeType1DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class Gradetype1DataService {

    private GradeType1DataRepository gradeType1DataRepository;
    @Transactional
    public Page<GradeType1DataEntity> selectALLTable(Pageable pageable){
        return gradeType1DataRepository.findAll(pageable);
    }
}
