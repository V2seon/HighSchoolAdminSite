package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.service.PersonalDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping
public class PersonalDataController {

    private PersonalDataService personalDataService;

    @GetMapping("/main")
    public String movedata(Model m, HttpServletRequest request){
        return "dashboard";
    }

    @GetMapping("/Personaldata0")
    public String Personaldata0(Model model, Pageable pageable, HttpServletRequest session,
                       @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            int aname=0;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(aname,pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/log");
            model.addAttribute("nowurl1", "/Personaldata0");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "Persondatalist0";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/Personaldata1")
    public String Personaldata1(Model model, Pageable pageable, HttpServletRequest session,
                       @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            int aname=1;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(aname,pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/log");
            model.addAttribute("nowurl1", "/Personaldata1");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "Persondatalist1";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/Personaldata2")
    public String Personaldata2(Model model, Pageable pageable, HttpServletRequest session,
                                @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            int aname=2;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(aname,pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/log");
            model.addAttribute("nowurl1", "/Personaldata2");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "Persondatalist2";
        }else{
            return "redirect:/";
        }
    }
}
