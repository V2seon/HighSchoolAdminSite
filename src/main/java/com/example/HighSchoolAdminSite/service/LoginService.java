package com.example.HighSchoolAdminSite.service;

import com.example.HighSchoolAdminSite.entity.AdminEntity;
import com.example.HighSchoolAdminSite.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LoginService {
    private AdminRepository adminRepository;

    @Transactional
    public int loginAdmin(String userid, String userpw){
        int returnValue = 0;
        Optional<AdminEntity> optionalAdminEntity = adminRepository.findByAidAndApw(userid, userpw);
        if(!optionalAdminEntity.isPresent()){
            returnValue = 0;
        }else{
            returnValue = 1;
        }
        return returnValue;
    }
}
