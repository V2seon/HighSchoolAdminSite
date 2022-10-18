package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.dto.GradeType1DataDto;
import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.predicate.GradetypeData1Predicate;
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
    public Page <GradeType1DataEntity> selectALLTable2(String selectKey,String titleText, Pageable pageable){
        return gradeType1DataRepository.findAll(GradetypeData1Predicate.search(selectKey, titleText),pageable);
    }

    @Transactional
    public Page<GradeType1DataEntity> selectALLTable(Pageable pageable){
        return gradeType1DataRepository.findAll(pageable);
    }

    @Transactional
    public Long insertData1(GradeType1DataDto gradeType1DataDto){
        return gradeType1DataRepository.save(gradeType1DataDto.toEntity()).getASeq();
    }
}
