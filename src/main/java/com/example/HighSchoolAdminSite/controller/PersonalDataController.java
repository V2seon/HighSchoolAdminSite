package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.dto.FinalreceptionDto;
import com.example.HighSchoolAdminSite.dto.PersonalDataDto;
import com.example.HighSchoolAdminSite.entity.*;
import com.example.HighSchoolAdminSite.repository.*;
import com.example.HighSchoolAdminSite.service.FinalreceptionService;
import com.example.HighSchoolAdminSite.service.PersonalDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    private FinalreceptionRepository finalreceptionRepository;
    private FinalreceptionService finalreceptionService;
    private StudentfakeseqRepository studentfakeseqRepository;

    @GetMapping("/main")
    public String movedata(Model m, HttpServletRequest request){
        return "dashboard";
    }

    @GetMapping("/Personaldata0")
    public String Personaldata0(Model model, Pageable pageable, HttpServletRequest session,
                                @RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 10, Sort.by("seq").descending());
            int aname=0;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(selectKey, titleText, aname, pageable);
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

    @RequestMapping(value = "/Personaldata0_search", method = RequestMethod.POST)
    public String Personaldata0_search(Model model,
                                       @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                       @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                       @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("Personaldata0 ok");
        int aname=0;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("aseq").descending());
        int totalPages = personalDataService.selectALLTable(selectKey, titleText, aname, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<PersonalDataEntity> pageList = personalDataService.selectALLTable(selectKey, titleText, aname, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "Persondatalist0 :: #example3";
    }


    @GetMapping("/Personaldata1")
    public String Personaldata1(Model model, Pageable pageable, HttpServletRequest session,
                                @RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            int aname=1;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(selectKey,titleText,aname,pageable);
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

    @RequestMapping(value = "/Personaldata1_search", method = RequestMethod.POST)
    public String Personaldata1_search(Model model,
                                       @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                       @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                       @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("Personaldata1 ok");
        int aname=1;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("aseq").descending());
        int totalPages = personalDataService.selectALLTable(selectKey, titleText, aname, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<PersonalDataEntity> pageList = personalDataService.selectALLTable(selectKey, titleText, aname, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "Persondatalist1 :: #example3";
    }


    @GetMapping("/Personaldata2")
    public String Personaldata2(Model model, Pageable pageable, HttpServletRequest session,
                                @RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        if (new SessionCheck().loginSessionCheck(session)){
            System.out.println("Personaldata2 ok");
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            int aname=2;
            Page<PersonalDataEntity> memberEntities = personalDataService.selectALLTable0(selectKey,titleText,aname,pageable);
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

    @RequestMapping(value = "/Personaldata2_search", method = RequestMethod.POST)
    public String Personaldata2_search(Model model,
                                       @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                                       @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                                       @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        System.out.println("들어옴");
        int aname=2;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("aseq").descending());
        int totalPages = personalDataService.selectALLTable(selectKey, titleText, aname, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함


        //서비스 엔티티 추가후 주석 풀고 사용
        Page<PersonalDataEntity> pageList = personalDataService.selectALLTable(selectKey, titleText, aname, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "Persondatalist2 :: #example3";
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/getdata")
    public Object getdata(Model model, Pageable pageable, HttpServletRequest session,
                                           @RequestParam(required = false, defaultValue = "0", value = "percode") long percode){
        HashMap<String, String> msg = new HashMap<String, String>();
        if (new SessionCheck().loginSessionCheck(session)){
            Optional<PersonalDataEntity> sss = personalDataRepository.findById(percode);
            Optional<StudentfakeseqEntity> sss00 = studentfakeseqRepository.findBySseq(percode);
            if(sss.get().getAgraduation_type() == 0){
                Optional<GradeType1DataEntity> s1 = gradeType1DataRepository.findById(percode);
                PersonalDataDto informationDto = new PersonalDataDto(percode,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAbirthday(),sss.get().getAsex(),sss.get().getAphone()
                        ,sss.get().getApostal_code(),sss.get().getAaddress(),sss.get().getAdetailed_address(),sss.get().getAguardian(),sss.get().getAparental(),
                        sss.get().getAhome_phone(),sss.get().getAparental_phone(),sss.get().getAapplication_incharge_name(),sss.get().getAapplication_incharge_phone(),sss.get().getAid_picture(),
                        sss.get().getAmiddle_school(),1,sss.get().getAmiddle_school_phone(),sss.get().getAarea_name(),sss.get().getAarea2_name(),sss.get().getAgraduation_year()
                        ,sss.get().getAgraduation_month(), sss.get().getAgraduation_type(),sss.get().getAclassification_type());
                personalDataService.save(informationDto);

                double behavior_development = s1.get().getFirstBehaviorDevelopment() + s1.get().getSecondBehaviorDevelopment() + s1.get().getThirdBehaviorDevelopment();
                double exp_activities = s1.get().getFirstExpActivities() + s1.get().getSecondExpActivities() + s1.get().getThirdExpActivities();

                FinalreceptionDto finalreceptionDto = new FinalreceptionDto(null, sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAsex(),sss.get().getAbirthday(),sss.get().getAaddress(),sss.get().getAmiddle_school(),
                        "",sss.get().getAgraduation_type(), sss.get().getAclassification_type(),s1.get().getCurriculumGrades(),1,
                        behavior_development,exp_activities,1,s1.get().getTotalGrades(),1,1,sss.get().getAphone(),sss.get().getAparental_phone());

                finalreceptionService.save1(finalreceptionDto);
                msg.put("result","0");
            }else if(sss.get().getAgraduation_type() == 1){
                Optional<GradeType2DataEntity> s2 = gradeType2DataRepository.findById(percode);
                PersonalDataDto informationDto = new PersonalDataDto(percode,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAbirthday(),sss.get().getAsex(),sss.get().getAphone()
                        ,sss.get().getApostal_code(),sss.get().getAaddress(),sss.get().getAdetailed_address(),sss.get().getAguardian(),sss.get().getAparental(),
                        sss.get().getAhome_phone(),sss.get().getAparental_phone(),sss.get().getAapplication_incharge_name(),sss.get().getAapplication_incharge_phone(),sss.get().getAid_picture(),
                        sss.get().getAmiddle_school(),1,sss.get().getAmiddle_school_phone(),sss.get().getAarea_name(),sss.get().getAarea2_name(),sss.get().getAgraduation_year()
                        ,sss.get().getAgraduation_month(), sss.get().getAgraduation_type(),sss.get().getAclassification_type());
                personalDataService.save(informationDto);
                if(s2.get().getIsCheck() == 0){
                    double behavior_development = s2.get().getFirstBehaviorDevelopment() + s2.get().getSecondBehaviorDevelopment() + s2.get().getThirdBehaviorDevelopment();
                    double exp_activities = s2.get().getFirstExpActivities() + s2.get().getSecondExpActivities() + s2.get().getThirdExpActivities();

                    FinalreceptionDto finalreceptionDto = new FinalreceptionDto(null,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAsex(),sss.get().getAbirthday(),sss.get().getAaddress(),sss.get().getAmiddle_school(),
                            "",sss.get().getAgraduation_type(), sss.get().getAclassification_type(),s2.get().getCurriculumGrades(),1,
                            behavior_development,exp_activities,1,s2.get().getTotalGrades(),s2.get().getOrderPercentage(),1,sss.get().getAphone(),sss.get().getAparental_phone());
                    finalreceptionService.save1(finalreceptionDto);
                }else if(s2.get().getIsCheck() == 1){
                    FinalreceptionDto finalreceptionDto = new FinalreceptionDto(null,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAsex(),sss.get().getAbirthday(),sss.get().getAaddress(),sss.get().getAmiddle_school(),
                            "",sss.get().getAgraduation_type(), sss.get().getAclassification_type(),s2.get().getCurriculumGrades(),1,
                            0,0,1,s2.get().getOrderTotal(),s2.get().getOrderPercentage(),1,sss.get().getAphone(),sss.get().getAparental_phone());
                    finalreceptionService.save1(finalreceptionDto);
                }
                System.out.println("gogo");
                msg.put("result","1");
            }else if(sss.get().getAgraduation_type() == 2){
                Optional<GradeType3DataEntity> s3 = gradeType3DataRepository.findById(percode);
                PersonalDataDto informationDto = new PersonalDataDto(percode,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAbirthday(),sss.get().getAsex(),sss.get().getAphone()
                        ,sss.get().getApostal_code(),sss.get().getAaddress(),sss.get().getAdetailed_address(),sss.get().getAguardian(),sss.get().getAparental(),
                        sss.get().getAhome_phone(),sss.get().getAparental_phone(),sss.get().getAapplication_incharge_name(),sss.get().getAapplication_incharge_phone(),sss.get().getAid_picture(),
                        sss.get().getAmiddle_school(),1,sss.get().getAmiddle_school_phone(),sss.get().getAarea_name(),sss.get().getAarea2_name(),sss.get().getAgraduation_year()
                        ,sss.get().getAgraduation_month(), sss.get().getAgraduation_type(),sss.get().getAclassification_type());
                personalDataService.save(informationDto);
                FinalreceptionDto finalreceptionDto = new FinalreceptionDto(null,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAsex(),sss.get().getAbirthday(),sss.get().getAaddress(),sss.get().getAmiddle_school(),
                        "",sss.get().getAgraduation_type(), sss.get().getAclassification_type(),s3.get().getGrade1(),1,
                        0,0,1,s3.get().getTotalGrades(),0,1,sss.get().getAphone(),sss.get().getAparental_phone());
                finalreceptionService.save1(finalreceptionDto);
                System.out.println("gogo");
                msg.put("result","2");
            }
        }else{
            msg.put("result","3");
            return msg;
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public Object delete(@RequestParam(required = false, defaultValue = "", value = "percode")Long percode){
        HashMap<String, String> msg = new HashMap<String, String>();
        Optional<PersonalDataEntity> sss = personalDataRepository.findById(percode);
        Optional<StudentfakeseqEntity> sss00 = studentfakeseqRepository.findBySseq(percode);
        PersonalDataDto informationDto = new PersonalDataDto(percode,sss00.get().getStudentfakeseq(),sss.get().getAname(),sss.get().getAbirthday(),sss.get().getAsex(),sss.get().getAphone()
                ,sss.get().getApostal_code(),sss.get().getAaddress(),sss.get().getAdetailed_address(),sss.get().getAguardian(),sss.get().getAparental(),
                sss.get().getAhome_phone(),sss.get().getAparental_phone(),sss.get().getAapplication_incharge_name(),sss.get().getAapplication_incharge_phone(),sss.get().getAid_picture(),
                sss.get().getAmiddle_school(),0,sss.get().getAmiddle_school_phone(),sss.get().getAarea_name(),sss.get().getAarea2_name(),sss.get().getAgraduation_year()
                ,sss.get().getAgraduation_month(), sss.get().getAgraduation_type(),sss.get().getAclassification_type());
        personalDataService.save(informationDto);

        Optional<FinalreceptionEntity> s1 = finalreceptionRepository.findByreceptionnum(sss00.get().getStudentfakeseq());

        finalreceptionService.delete(s1.get().getSeq());
        if(sss.get().getAgraduation_type() == 0){
            msg.put("result","0");
        }else if(sss.get().getAgraduation_type() == 1){
            msg.put("result","1");
        }else if(sss.get().getAgraduation_type() == 2){
            msg.put("result","2");
        }
        return msg;
    }


}
