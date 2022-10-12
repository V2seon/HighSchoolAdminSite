package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.dto.FinalreceptionDto;
import com.example.HighSchoolAdminSite.dto.PersonalDataDto;
import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType2DataEntity;
import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import com.example.HighSchoolAdminSite.repository.GradeType1DataRepository;
import com.example.HighSchoolAdminSite.repository.GradeType2DataRepository;
import com.example.HighSchoolAdminSite.repository.GradeType3DataRepository;
import com.example.HighSchoolAdminSite.repository.PersonalDataRepository;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping
public class PersonalDataController {

    private PersonalDataService personalDataService;
    private PersonalDataRepository personalDataRepository;
    private GradeType1DataRepository gradeType1DataRepository;
    private GradeType2DataRepository gradeType2DataRepository;
    private GradeType3DataRepository gradeType3DataRepository;

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

    @GetMapping("/getdata")
    public String getdata(Model model, Pageable pageable, HttpServletRequest session,
                                @RequestParam(required = false, defaultValue = "0", value = "percode") long percode){
        String returnValue = "";
        if (new SessionCheck().loginSessionCheck(session)){
            Optional<PersonalDataEntity> sss = personalDataRepository.findById(percode);
            if(sss.get().getAgraduation_type() == 0){
                Optional<GradeType1DataEntity> s1 = gradeType1DataRepository.findById(percode);
                System.out.println("gogo");
                returnValue = "Persondatalist0 :: Success";
            }else if(sss.get().getAgraduation_type() == 1){
                Optional<GradeType2DataEntity> s2 = gradeType2DataRepository.findById(percode);
                System.out.println("gogo");
                returnValue = "Persondatalist1 :: Success";
            }else if(sss.get().getAgraduation_type() == 2){
                Optional<GradeType3DataEntity> s3 = gradeType3DataRepository.findById(percode);
                System.out.println("gogo");
                returnValue = "Persondatalist2 :: Success";
            }
        }else{
            return "redirect:/";
        }
        return returnValue;
    }

    //2.페이징 기능
    @RequestMapping(value = "/paging", method = RequestMethod.POST) // 비동기 페이지네이션
    public String pagingButton(Model model,
                               @RequestParam(required = false, defaultValue = "0", value = "page") int page,
                               @RequestParam(required = false, defaultValue = "", value = "selectKey") String selectKey,
                               @RequestParam(required = false, defaultValue = "", value = "titleText") String titleText,
                               Pageable pageable) {

        System.out.println("이 함수에 들어옴2");
        pageable = PageRequest.of(page, 10, Sort.by("tipk").descending());
        int totalPages = personalDataService.treasurehunt_list(selectKey, titleText, pageable).getTotalPages();

        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함

        return "Persondatalist0 :: #pageList";
    }
}
