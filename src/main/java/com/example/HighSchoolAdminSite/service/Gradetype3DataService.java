package com.example.HighSchoolAdminSite.service;


import com.example.HighSchoolAdminSite.dto.GradeType2DataDto;
import com.example.HighSchoolAdminSite.dto.GradeType3DataDto;
import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import com.example.HighSchoolAdminSite.predicate.GradetypeData3Predicate;
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
    public Page<GradeType3DataEntity> selectALLTable2(String selectKey, String titleText, Pageable pageable){
        return gradeType3DataRepository.findAll(GradetypeData3Predicate.search(selectKey, titleText),pageable);
    }
    @Transactional
    public Page<GradeType3DataEntity> selectALLTable(Pageable pageable){
        return gradeType3DataRepository.findAll(pageable);
    }

    @Transactional
    public Long insertData3(GradeType3DataDto gradeType3DataDto){
        return gradeType3DataRepository.save(gradeType3DataDto.toEntity()).getASeq();
    }
}
