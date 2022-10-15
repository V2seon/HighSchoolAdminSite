package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.dto.FinalreceptionDto;
import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import com.example.HighSchoolAdminSite.repository.FinalreceptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalreceptionService {
    private FinalreceptionRepository finalreceptionRepository;

    @Transactional
    public Long save1(FinalreceptionDto finalreceptionDto){
        return finalreceptionRepository.save(finalreceptionDto.toEntity()).getSeq();
    }

    @Transactional
    public void delete(Long seq){
        finalreceptionRepository.deleteById(seq);
    }

    @Transactional
    public Page <FinalreceptionEntity> findAll(Pageable pageable){
        return finalreceptionRepository.findAll(pageable);
    }
}
