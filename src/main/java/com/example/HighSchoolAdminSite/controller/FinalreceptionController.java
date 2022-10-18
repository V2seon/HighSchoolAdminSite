package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.service.FinalreceptionService;
import com.example.HighSchoolAdminSite.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@Controller
@AllArgsConstructor
@RequestMapping
public class FinalreceptionController {

    private FinalreceptionService finalreceptionService;

    @GetMapping("/finalreception")
    public String main(Model model, HttpServletRequest session, Pageable pageable,
                       @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            Page<FinalreceptionEntity> memberEntities = finalreceptionService.findAll(pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/Finalreception");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "Finalreception";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/finalreception_search", method = RequestMethod.POST)
    public String main_search(Model model,
                              @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                              @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                              @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        Pageable pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
        int totalPages = finalreceptionService.findAll2(selectKey, titleText, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<FinalreceptionEntity> pageList = finalreceptionService.findAll2(selectKey, titleText, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "Finalreception :: #example3";
    }

}
