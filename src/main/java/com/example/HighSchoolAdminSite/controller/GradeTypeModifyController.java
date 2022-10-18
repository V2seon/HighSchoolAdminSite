package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.dto.GradeType1DataDto;
import com.example.HighSchoolAdminSite.dto.GradeType2DataDto;
import com.example.HighSchoolAdminSite.dto.GradeType3DataDto;
import com.example.HighSchoolAdminSite.entity.*;
import com.example.HighSchoolAdminSite.repository.*;
import com.example.HighSchoolAdminSite.service.Gradetype1DataService;
import com.example.HighSchoolAdminSite.service.Gradetype2DataService;
import com.example.HighSchoolAdminSite.service.Gradetype3DataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class GradeTypeModifyController {

    private Gradetype1DataService gradetype1DataService;
    private Gradetype2DataService gradetype2DataService;
    private Gradetype3DataService gradetype3DataService;
    private GradeType1DataRepository gradeType1DataRepository;
    private GradeType2DataRepository gradeType2DataRepository;
    private GradeType3DataRepository gradeType3DataRepository;
    private PersonalDataRepository personalDataRepository;
    private StudentfakeseqRepository studentfakeseqRepository;

    @PostMapping("/gt1/save")
    public Object insert1(HttpServletRequest request, Model model,
                          @RequestParam(required = false, defaultValue = "", value = "sf1") String mySecondFirstType1,
                          @RequestParam(required = false, defaultValue = "", value = "sf2") String mySecondFirstType2,
                          @RequestParam(required = false, defaultValue = "", value = "sf3") String mySecondFirstType3,
                          @RequestParam(required = false, defaultValue = "", value = "sf4") String mySecondFirstType4,
                          @RequestParam(required = false, defaultValue = "", value = "sf5") String mySecondFirstType5,
                          @RequestParam(required = false, defaultValue = "", value = "sf6") String mySecondFirstType6,
                          @RequestParam(required = false, defaultValue = "", value = "sf7") String mySecondFirstType7,
                          @RequestParam(required = false, defaultValue = "", value = "sf8") String mySecondFirstType8,
                          @RequestParam(required = false, defaultValue = "", value = "sf9") String mySecondFirstType9,
                          @RequestParam(required = false, defaultValue = "", value = "sf10") String mySecondFirstType10,
                          @RequestParam(required = false, defaultValue = "", value = "sf11") String mySecondFirstType11,
                          @RequestParam(required = false, defaultValue = "", value = "fpl1") String myFirstPlusType1,
                          @RequestParam(required = false, defaultValue = "", value = "fpl2") String myFirstPlusType2,
                          @RequestParam(required = false, defaultValue = "", value = "fpl3") String myFirstPlusType3,
                          @RequestParam(required = false, defaultValue = "", value = "infpl1") String myFirstPlusName,
                          @RequestParam(required = false, defaultValue = "", value = "ss1") String mySecondSecondType1,
                          @RequestParam(required = false, defaultValue = "", value = "ss2") String mySecondSecondType2,
                          @RequestParam(required = false, defaultValue = "", value = "ss3") String mySecondSecondType3,
                          @RequestParam(required = false, defaultValue = "", value = "ss4") String mySecondSecondType4,
                          @RequestParam(required = false, defaultValue = "", value = "ss5") String mySecondSecondType5,
                          @RequestParam(required = false, defaultValue = "", value = "ss6") String mySecondSecondType6,
                          @RequestParam(required = false, defaultValue = "", value = "ss7") String mySecondSecondType7,
                          @RequestParam(required = false, defaultValue = "", value = "ss8") String mySecondSecondType8,
                          @RequestParam(required = false, defaultValue = "", value = "ss9") String mySecondSecondType9,
                          @RequestParam(required = false, defaultValue = "", value = "ss10") String mySecondSecondType10,
                          @RequestParam(required = false, defaultValue = "", value = "ss11") String mySecondSecondType11,
                          @RequestParam(required = false, defaultValue = "", value = "spl1") String mySecondPlusType1,
                          @RequestParam(required = false, defaultValue = "", value = "spl2") String mySecondPlusType2,
                          @RequestParam(required = false, defaultValue = "", value = "spl3") String mySecondPlusType3,
                          @RequestParam(required = false, defaultValue = "", value = "infpl2") String mySecondPlusName,
                          @RequestParam(required = false, defaultValue = "", value = "tf1") String myThirdFirstType1,
                          @RequestParam(required = false, defaultValue = "", value = "tf2") String myThirdFirstType2,
                          @RequestParam(required = false, defaultValue = "", value = "tf3") String myThirdFirstType3,
                          @RequestParam(required = false, defaultValue = "", value = "tf4") String myThirdFirstType4,
                          @RequestParam(required = false, defaultValue = "", value = "tf5") String myThirdFirstType5,
                          @RequestParam(required = false, defaultValue = "", value = "tf6") String myThirdFirstType6,
                          @RequestParam(required = false, defaultValue = "", value = "tf7") String myThirdFirstType7,
                          @RequestParam(required = false, defaultValue = "", value = "tf8") String myThirdFirstType8,
                          @RequestParam(required = false, defaultValue = "", value = "tf9") String myThirdFirstType9,
                          @RequestParam(required = false, defaultValue = "", value = "tf10") String myThirdFirstType10,
                          @RequestParam(required = false, defaultValue = "", value = "tf11") String myThirdFirstType11,
                          @RequestParam(required = false, defaultValue = "", value = "tpl1") String myThirdPlusType1,
                          @RequestParam(required = false, defaultValue = "", value = "tpl2") String myThirdPlusType2,
                          @RequestParam(required = false, defaultValue = "", value = "tpl3") String myThirdPlusType3,
                          @RequestParam(required = false, defaultValue = "", value = "infpl3") String myThirdPlusname,
                          @RequestParam(required = false, defaultValue = "", value = "fab") int myFirstAbsant,
                          @RequestParam(required = false, defaultValue = "", value = "fla") int myFirstLate,
                          @RequestParam(required = false, defaultValue = "", value = "fle") int myFirstLeave,
                          @RequestParam(required = false, defaultValue = "", value = "fre") int myFirstResult,
                          @RequestParam(required = false, defaultValue = "", value = "fbd") double myFirstBehaviorDevelopment,
                          @RequestParam(required = false, defaultValue = "", value = "fea") double myFirstExpActivities,
                          @RequestParam(required = false, defaultValue = "", value = "fvat") int myFirstVolunteerActivityTime,
                          @RequestParam(required = false, defaultValue = "", value = "sab") int mySecondAbsant,
                          @RequestParam(required = false, defaultValue = "", value = "sla") int mySecondLate,
                          @RequestParam(required = false, defaultValue = "", value = "sle") int mySecondLeave,
                          @RequestParam(required = false, defaultValue = "", value = "sre") int mySecondResult,
                          @RequestParam(required = false, defaultValue = "", value = "sbd") double mySecondBehaviorDevelopment,
                          @RequestParam(required = false, defaultValue = "", value = "sea") double mySecondExpActivities,
                          @RequestParam(required = false, defaultValue = "", value = "svat") int mySecondVolunteerActivityTime,
                          @RequestParam(required = false, defaultValue = "", value = "tab") int myThirdAbsant,
                          @RequestParam(required = false, defaultValue = "", value = "tla") int myThirdLate,
                          @RequestParam(required = false, defaultValue = "", value = "tle") int myThirdLeave,
                          @RequestParam(required = false, defaultValue = "", value = "tre") int myThirdResult,
                          @RequestParam(required = false, defaultValue = "", value = "tbd") double myThirdBehaviorDevelopment,
                          @RequestParam(required = false, defaultValue = "", value = "tea") double myThirdExpActivities,
                          @RequestParam(required = false, defaultValue = "", value = "tvat") int myThirdVolunteerActivityTime,
                          @RequestParam(required = false, defaultValue = "", value = "t1") double t1,
                          @RequestParam(required = false, defaultValue = "", value = "t2") double t2,
                          @RequestParam(required = false, defaultValue = "", value = "t3") double t3){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);
        System.out.println(t1);
        // 출결점수
        double sc1 = 0;
        double notsc1 = 0;
        double scscore1 =0;
        double sc2 = 0;
        double notsc2 = 0;
        double scscore2 =0;
        double sc3 = 0;
        double notsc3 = 0;
        double scscore3 =0;
        if (myFirstLate+myFirstLeave+myFirstResult >3){
            notsc1 = Math.floor((myFirstLate+myFirstLeave+myFirstResult)/3);
        }
        sc1= myFirstAbsant+notsc1;
        if(sc1 >= 5){
            scscore1 = 0;
        }else if(sc1 == 4){
            scscore1 = 1;
        }else if(sc1 == 3){
            scscore1 = 2;
        }else if(sc1 == 2){
            scscore1 = 3;
        }else if(sc1 == 1){
            scscore1 = 4;
        }else if(sc1 == 0){
            scscore1 = 5;
        };
        if (mySecondLate+mySecondLeave+mySecondResult >3){
            notsc2 = Math.floor((mySecondLate+mySecondLeave+mySecondResult)/3);
        }
        sc2= mySecondAbsant+notsc2;
        if(sc2 >= 5){
            scscore2 = 0;
        }else if(sc2 == 4){
            scscore2 = 1;
        }else if(sc2 == 3){
            scscore2 = 2;
        }else if(sc2 == 2){
            scscore2 = 3;
        }else if(sc2 == 1){
            scscore2 = 4;
        }else if(sc2 == 0){
            scscore2 = 5;
        };
        if (myThirdLate+myThirdLeave+myThirdResult >3){
            notsc3 = Math.floor((myThirdLate+myThirdLeave+myThirdResult)/3);
        }
        sc3= myThirdAbsant+notsc3;
        if(sc3 >= 5){
            scscore3 = 0;
        }else if(sc3 == 4){
            scscore3 = 1;
        }else if(sc3 == 3){
            scscore3 = 2;
        }else if(sc3 == 2){
            scscore3 = 3;
        }else if(sc3 == 1){
            scscore3 = 4;
        }else if(sc3 == 0){
            scscore3 = 5;
        };
        double totalad = scscore1 + scscore2 + scscore3;

        double fvatscore = 0;
        double svatscore = 0;
        double tvatscore = 0;

        if(myFirstVolunteerActivityTime >= 7){
            fvatscore = 5;
        }else if(myFirstVolunteerActivityTime >= 6){
            fvatscore = 4.5;
        }else if(myFirstVolunteerActivityTime >= 5){
            fvatscore = 4;
        }else if(myFirstVolunteerActivityTime >= 4){
            fvatscore = 3.5;
        }else if(myFirstVolunteerActivityTime <= 3){
            fvatscore = 3;
        };
        if(mySecondVolunteerActivityTime >= 7){
            svatscore = 5;
        }else if(mySecondVolunteerActivityTime >= 6){
            svatscore = 4.5;
        }else if(mySecondVolunteerActivityTime >= 5){
            svatscore = 4;
        }else if(mySecondVolunteerActivityTime >= 4){
            svatscore = 3.5;
        }else if(mySecondVolunteerActivityTime <= 3){
            svatscore = 3;
        };
        if(myThirdVolunteerActivityTime >= 7){
            tvatscore = 5;
        }else if(myThirdVolunteerActivityTime >= 6){
            tvatscore = 4.5;
        }else if(myThirdVolunteerActivityTime >= 5){
            tvatscore = 4;
        }else if(myThirdVolunteerActivityTime >= 4){
            tvatscore = 3.5;
        }else if(myThirdVolunteerActivityTime <= 3){
            tvatscore = 3;
        };
        double vatscore = fvatscore + svatscore + tvatscore;

        GradeType1DataDto gradeType1TableDto = new GradeType1DataDto(seq,s10.get().getStudentfakeseq(),s1.get().getAname(),mySecondFirstType1,mySecondFirstType2,mySecondFirstType3,mySecondFirstType4,
                mySecondFirstType5,mySecondFirstType6,mySecondFirstType7,mySecondFirstType8,mySecondFirstType9,mySecondFirstType10,mySecondFirstType11,
                myFirstPlusType1,myFirstPlusType2,myFirstPlusType3, myFirstPlusName,
                mySecondSecondType1,mySecondSecondType2,mySecondSecondType3,mySecondSecondType4,mySecondSecondType5,
                mySecondSecondType6,mySecondSecondType7,mySecondSecondType8,mySecondSecondType9,mySecondSecondType10,mySecondSecondType11,
                mySecondPlusType1, mySecondPlusType2, mySecondPlusType3,mySecondPlusName,
                myThirdFirstType1,myThirdFirstType2,myThirdFirstType3,myThirdFirstType4,myThirdFirstType5,
                myThirdFirstType6,myThirdFirstType7,myThirdFirstType8,myThirdFirstType9,myThirdFirstType10,myThirdFirstType11,
                myThirdPlusType1,myThirdPlusType2,myThirdPlusType3,myThirdPlusname,
                myFirstAbsant,myFirstLate,myFirstLeave,myFirstResult,myFirstBehaviorDevelopment+4.5,myFirstExpActivities+4.5,myFirstVolunteerActivityTime,
                mySecondAbsant,mySecondLate,mySecondLeave,mySecondResult,mySecondBehaviorDevelopment+4.5,mySecondExpActivities+4.5,mySecondVolunteerActivityTime,
                myThirdAbsant,myThirdLate,myThirdLeave,myThirdResult,myThirdBehaviorDevelopment+4.5,myThirdExpActivities+4.5,myThirdVolunteerActivityTime,
                totalad,vatscore,t1,t2,t3);
        gradetype1DataService.insertData1(gradeType1TableDto);
        Optional<GradeType1DataEntity> sss = gradeType1DataRepository.findById(seq);
        model.addAttribute("sss", sss);
        return "Modify/gradeType1Modify :: Success";
    }

    @PostMapping("/gt2/save")
    public Object insert2(HttpServletRequest request, Model model,
                          @RequestParam(required = false, defaultValue = "", value = "ic") int myIsCheck,
                          @RequestParam(required = false, defaultValue = "", value = "t1") double t1,
                          @RequestParam(required = false, defaultValue = "", value = "t2") double t2,
                          @RequestParam(required = false, defaultValue = "", value = "t3") double t3,
                          @RequestParam(required = false, defaultValue = "", value = "step0") double step0,
                          @RequestParam(required = false, defaultValue = "", value = "step1") double step1,
                          @RequestParam(required = false, defaultValue = "", value = "step2") double step2,
                          @RequestParam(required = false, defaultValue = "", value = "step3") double step3,
                          @RequestParam(required = false, defaultValue = "", value = "grade2") double grade2){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);

        GradeType2DataDto gradeType2TableDto = new GradeType2DataDto(seq,s10.get().getStudentfakeseq(),s1.get().getAname(),myIsCheck, 0,t3,"","","","",
                "","","","","","","",
                "","","","","",
                "","","","","","",
                "","","","","",
                "","","","","","",
                0,0,0,0,0,0,0,
                0,0,0,0,grade2,0,0,
                0,0,0,0,step1,step2,0 ,
                step0,step3,t1,t2,t3);
        gradetype2DataService.insertData2(gradeType2TableDto);
        Optional<GradeType2DataEntity> sss = gradeType2DataRepository.findById(seq);

        model.addAttribute("sss", sss);
        return "Modify/gradeType2Modify :: Success";
    }

    @PostMapping("/insert2")
    public Object insert3(HttpServletRequest request, Model model,
                          @RequestParam(required = false, defaultValue = "", value = "ic") int myIsCheck,
                          @RequestParam(required = false, defaultValue = "", value = "op") double myOrderPercentage,
                          @RequestParam(required = false, defaultValue = "", value = "totalscore") double totalscore
    ){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);

        GradeType2DataDto gradeType2TableDto = new GradeType2DataDto(seq,s10.get().getStudentfakeseq(),s1.get().getAname(),myIsCheck, myOrderPercentage,0,"","","","",
                "","","","","","","",
                "","","","","",
                "","","","","","",
                "","","","","",
                "","","","","","",
                0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,
                0,0,0,0,0,0,0 ,
                0,0,0,0,totalscore);
        gradetype2DataService.insertData2(gradeType2TableDto);
        Optional<GradeType2DataEntity> sss = gradeType2DataRepository.findById(seq);
        model.addAttribute("sss", sss);
        return "Modify/gradeType2Modify :: Success";
    }

    @PostMapping("/gt3/save")
    public Object insert3(HttpServletRequest request, Model model,
                          @RequestParam(required = false, defaultValue = "", value = "g1") double myGrade1,
                          @RequestParam(required = false, defaultValue = "", value = "g2") double myGrade2,
                          @RequestParam(required = false, defaultValue = "", value = "mop") double mop){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);
        GradeType3DataDto gradeType3TableDto = new GradeType3DataDto(seq,s10.get().getStudentfakeseq(),s1.get().getAname(),myGrade1,myGrade2,myGrade1);
        gradetype3DataService.insertData3(gradeType3TableDto);
        Optional<GradeType3DataEntity> sss = gradeType3DataRepository.findById(seq);
        model.addAttribute("sss", sss);
        return "Modify/gradeType3Modify :: Success";
    }
}
