package com.example.HighSchoolAdminSite.controller;


import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.service.Gradetype1DataService;
import com.example.HighSchoolAdminSite.service.Gradetype2DataService;
import com.example.HighSchoolAdminSite.service.Gradetype3DataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping
public class GradetypeDataController {
    private Gradetype1DataService Gradetype1DataService;
    private Gradetype2DataService Gradetype2DataService;
    private Gradetype3DataService Gradetype3DataService;

    @GetMapping("/Gradetype0")
    public String Gradetype0(Model model, Pageable pageable, HttpServletRequest session,
                             @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15,Sort.by("seq").descending());
            Page<GradeType1DataEntity> memberEntities = Gradetype1DataService.selectALLTable(pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/Gradetype");
            model.addAttribute("nowurl1", "/Gradetype0");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "gradetypedatalist0";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/Gradetype0_search", method = RequestMethod.POST)
    public String Gradetype0_search(Model model,
                                    @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                    @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                    @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("Gradetype0 ok");
        Pageable pageable = PageRequest.of(page, 15,Sort.by("aSeq").descending());
        int totalPages = Gradetype1DataService.selectALLTable2(selectKey, titleText, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<GradeType1DataEntity> pageList = Gradetype1DataService.selectALLTable2(selectKey, titleText, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "gradetypedatalist0 :: #example3";
    }

    @GetMapping("/Gradetype1")
    public String Gradetype1(Model model, Pageable pageable, HttpServletRequest session,
                             @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15,Sort.by("seq").descending());
            Page<GradeType2DataEntity> memberEntities = Gradetype2DataService.selectALLTable(pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/Gradetype");
            model.addAttribute("nowurl1", "/Gradetype1");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "gradetypedatalist1";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/Gradetype1_search", method = RequestMethod.POST)
    public String Gradetype1_search(Model model,
                                    @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                    @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                    @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("Gradetype1 ok");
        Pageable pageable = PageRequest.of(page, 15,Sort.by("aSeq").descending());
        int totalPages = Gradetype2DataService.selectALLTable2(selectKey, titleText, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<GradeType2DataEntity> pageList = Gradetype2DataService.selectALLTable2(selectKey, titleText, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "gradetypedatalist1 :: #example3";
    }

    @GetMapping("/Gradetype2")
    public String Gradetype2(Model model, Pageable pageable, HttpServletRequest session,
                             @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15,Sort.by("seq").descending());
            Page<GradeType3DataEntity> memberEntities = Gradetype3DataService.selectALLTable(pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/Gradetype");
            model.addAttribute("nowurl1", "/Gradetype2");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "gradetypedatalist2";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/Gradetype2_search", method = RequestMethod.POST)
    public String Gradetype2_search(Model model,
                                    @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                    @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                    @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("Gradetype2 ok");
        Pageable pageable = PageRequest.of(page, 15,Sort.by("aSeq").descending());
        int totalPages = Gradetype3DataService.selectALLTable2(selectKey, titleText, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<GradeType3DataEntity> pageList = Gradetype3DataService.selectALLTable2(selectKey, titleText, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "gradetypedatalist2 :: #example3";
    }

    //2.페이징 기능

}
