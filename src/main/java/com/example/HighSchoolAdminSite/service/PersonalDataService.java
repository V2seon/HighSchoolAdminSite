package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.dto.FinalreceptionDto;
import com.example.HighSchoolAdminSite.dto.PersonalDataDto;
import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.predicate.PersonalDataPredicate;
import com.example.HighSchoolAdminSite.repository.FinalreceptionRepository;
import com.example.HighSchoolAdminSite.repository.PersonalDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PersonalDataService {
    private PersonalDataRepository personalDataRepository;
    private FinalreceptionRepository finalreceptionRepository;

    @Transactional
    public Page <PersonalDataEntity> selectALLTable(String mname,String titleText, Pageable pageable){
        return personalDataRepository.findAll(PersonalDataPredicate.search(mname, titleText),pageable);
    }

    @Transactional
    public Page <PersonalDataEntity> selectALLTable0(int agraduation_type, Pageable pageable){
        return personalDataRepository.findAgraduation_typeBy(agraduation_type,pageable);
    }

    @Transactional
    public Page<PersonalDataEntity> treasurehunt_list(String selectKey, String titleText, Pageable pageable) {
        return personalDataRepository.findAll(PersonalDataPredicate.search(selectKey, titleText),pageable);
    }

    @Transactional
    public Long save(PersonalDataDto personalDataDto){
        return personalDataRepository.save(personalDataDto.toEntity()).getAseq();
    }
}
