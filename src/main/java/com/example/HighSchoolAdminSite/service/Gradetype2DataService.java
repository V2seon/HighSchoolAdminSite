package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.dto.GradeType1DataDto;
import com.example.HighSchoolAdminSite.dto.GradeType2DataDto;
import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import com.example.HighSchoolAdminSite.predicate.GradetypeData1Predicate;
import com.example.HighSchoolAdminSite.predicate.GradetypeData2Predicate;
import com.example.HighSchoolAdminSite.repository.GradeType1DataRepository;
import com.example.HighSchoolAdminSite.repository.GradeType2DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class Gradetype2DataService {

    private GradeType2DataRepository gradeType2DataRepository;

    @Transactional
    public Page <GradeType2DataEntity> selectALLTable2(String selectKey,String titleText, Pageable pageable){
        return gradeType2DataRepository.findAll(GradetypeData2Predicate.search(selectKey, titleText),pageable);
    }
    @Transactional
    public Page<GradeType2DataEntity> selectALLTable(Pageable pageable){
        return gradeType2DataRepository.findAll(pageable);
    }

    @Transactional
    public Long insertData2(GradeType2DataDto gradeType2DataDto){
        return gradeType2DataRepository.save(gradeType2DataDto.toEntity()).getASeq();
    }
}
