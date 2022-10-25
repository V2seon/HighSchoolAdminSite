package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.entity.*;
import com.example.HighSchoolAdminSite.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/daa")
public class DownloadAdmissionApplicationController {
    private PersonalDataRepository personalDataRepository;
    private GradeType1DataRepository gradeType1dataRepository;
    private GradeType2DataRepository gradeType2dataRepository;
    private GradeType3DataRepository gradeType3dataRepository;
    private StudentfakeseqRepository studentfakeseqRepository;
    private StudentRepository studentRepository;

    @GetMapping("/getid0")
    public String getid0(Model model, HttpSession session, HttpServletRequest request,
                        @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        System.out.println(percode);
        return "redirect:/Personaldata0";
    }
    @GetMapping("/getid1")
    public String getid1(Model model, HttpSession session, HttpServletRequest request,
                        @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        System.out.println(percode);
        return "redirect:/Personaldata1";
    }
    @GetMapping("/getid2")
    public String getid2(Model model, HttpSession session, HttpServletRequest request,
                        @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        System.out.println(percode);
        return "redirect:/Personaldata2";
    }

    @GetMapping("/getid3")
    public String getid3(Model model, HttpSession session, HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        System.out.println(percode);
        return "redirect:/Gradetype0";
    }

    @GetMapping("/text")
    public String insert(Model model, HttpSession session, HttpServletRequest request) {
        Optional<PersonalDataEntity> PersonalDataEntityes = personalDataRepository.findById((Long) session.getAttribute("percode"));
        Optional<StudentfakeseqEntity> s1 = studentfakeseqRepository.findBySseq((Long) session.getAttribute("percode"));

        model.addAttribute("name",PersonalDataEntityes.get().getAname());
        model.addAttribute("birthday",PersonalDataEntityes.get().getAbirthday());
        model.addAttribute("sex",PersonalDataEntityes.get().getAsex());
        model.addAttribute("phone",PersonalDataEntityes.get().getAphone());
        model.addAttribute("address",PersonalDataEntityes.get().getAaddress());
        model.addAttribute("postal",PersonalDataEntityes.get().getApostal_code());
        model.addAttribute("detaliedaddress",PersonalDataEntityes.get().getAdetailed_address());
        model.addAttribute("guardian",PersonalDataEntityes.get().getAguardian());
        model.addAttribute("homephone",PersonalDataEntityes.get().getAhome_phone());
        model.addAttribute("parental",PersonalDataEntityes.get().getAparental());
        model.addAttribute("parentalphone",PersonalDataEntityes.get().getAparental_phone());
        model.addAttribute("inchargename",PersonalDataEntityes.get().getAapplication_incharge_name());
        model.addAttribute("inchargephone",PersonalDataEntityes.get().getAapplication_incharge_phone());
        model.addAttribute("idpicture",PersonalDataEntityes.get().getAid_picture());
        model.addAttribute("middleschool",PersonalDataEntityes.get().getAmiddle_school());
        model.addAttribute("middleschoolnum",PersonalDataEntityes.get().getAmiddle_school_unique_number());
        model.addAttribute("middleschoolphone",PersonalDataEntityes.get().getAmiddle_school_phone());
        model.addAttribute("areaname",PersonalDataEntityes.get().getAarea_name());
        model.addAttribute("area2name",PersonalDataEntityes.get().getAarea2_name());
        model.addAttribute("agraduationtype",PersonalDataEntityes.get().getAgraduation_type());
        model.addAttribute("classification",PersonalDataEntityes.get().getAclassification_type());
        model.addAttribute("agraduationyear",PersonalDataEntityes.get().getAgraduation_year());
        model.addAttribute("agraduationmonth",PersonalDataEntityes.get().getAgraduation_month());
        model.addAttribute("seq",s1.get().getStudentfakeseq());
        Long seq = (Long) session.getAttribute("percode");

        Optional<StudentEntity> main = studentRepository.findById(seq);
        String day = main.get().getStudent_signupdatetime();
        String[] day1 = day.split("-");
        String[] day2 = day1[2].split(" ");
        model.addAttribute("day", day2[0]);

        if(PersonalDataEntityes.get().getAgraduation_type() == 0){
            Optional<GradeType1DataEntity> sss = gradeType1dataRepository.findById(seq);

            //2-1 일반
            String sf1 = sss.get().getSecondFirstType1();
            String sf2 = sss.get().getSecondFirstType2();
            String sf3 = sss.get().getSecondFirstType3();
            String sf4 = sss.get().getSecondFirstType4();
            String sf5 = sss.get().getSecondFirstType5();
            String sf6 = sss.get().getSecondFirstType6();
            String sf7 = sss.get().getSecondFirstType7();
            String sf8 = sss.get().getSecondFirstType8();
            String fpl1 = sss.get().getFirstPlusType1();
            String fpl2 = sss.get().getFirstPlusType2();
            String fpl3 = sss.get().getFirstPlusType3();
            //2-2 일반
            String ss1 = sss.get().getSecondSecondType1();
            String ss2 = sss.get().getSecondSecondType2();
            String ss3 = sss.get().getSecondSecondType3();
            String ss4 = sss.get().getSecondSecondType4();
            String ss5 = sss.get().getSecondSecondType5();
            String ss6 = sss.get().getSecondSecondType6();
            String ss7 = sss.get().getSecondSecondType7();
            String ss8 = sss.get().getSecondSecondType8();
            String spl1 = sss.get().getSecondPlusType1();
            String spl2 = sss.get().getSecondPlusType2();
            String spl3 = sss.get().getSecondPlusType3();
            // 3-1 일반
            String tf1 = sss.get().getThirdFirstType1();
            String tf2 = sss.get().getThirdFirstType2();
            String tf3 = sss.get().getThirdFirstType3();
            String tf4 = sss.get().getThirdFirstType4();
            String tf5 = sss.get().getThirdFirstType5();
            String tf6 = sss.get().getThirdFirstType6();
            String tf7 = sss.get().getThirdFirstType7();
            String tf8 = sss.get().getThirdFirstType8();
            String tpl1 = sss.get().getThirdPlusType1();
            String tpl2 = sss.get().getThirdPlusType2();
            String tpl3 = sss.get().getThirdPlusType3();
            // 예체능
            String sf9 = sss.get().getSecondFirstType9();
            String sf10 = sss.get().getSecondFirstType10();
            String sf11 = sss.get().getSecondFirstType11();
            String ss9 = sss.get().getSecondSecondType9();
            String ss10 = sss.get().getSecondSecondType10();
            String ss11 = sss.get().getSecondSecondType11();
            String tf9 = sss.get().getThirdFirstType9();
            String tf10 = sss.get().getThirdFirstType10();
            String tf11 = sss.get().getThirdFirstType11();

            double val = 0;
            double val1 = 0;
            double val2 = 0;
            double val4 = 0;
            double count1 = 0;
            double count2 = 0;
            double count3 = 0;
            double count4 = 0;
            double t1 =0;
            double t2 =0;
            double t3 =0;
            double t4 =0;
            double t5 =0;
            double t6 =0;
            double t7 =0;
            double total =0;
            // 2-1
            if(sf1.equals("A")){
                val+=5; count1+=1;
            }else if(sf1.equals("B")){
                val+=4; count1+=1;
            }else if(sf1.equals("C")){
                val+=3; count1+=1;
            }else if(sf1.equals("D")){
                val+=2; count1+=1;
            }else if(sf1.equals("E")){
                val+=1; count1+=1;
            };
            if(sf2.equals("A")){
                val+=5; count1+=1;
            }else if(sf2.equals("B")){
                val+=4; count1+=1;
            }else if(sf2.equals("C")){
                val+=3; count1+=1;
            }else if(sf2.equals("D")){
                val+=2; count1+=1;
            }else if(sf2.equals("E")){
                val+=1; count1+=1;
            };
            if(sf3.equals("A")){
                val+=5; count1+=1;
            }else if(sf3.equals("B")){
                val+=4; count1+=1;
            }else if(sf3.equals("C")){
                val+=3; count1+=1;
            }else if(sf3.equals("D")){
                val+=2; count1+=1;
            }else if(sf3.equals("E")){
                val+=1; count1+=1;
            };
            if(sf4.equals("A")){
                val+=5; count1+=1;
            }else if(sf4.equals("B")){
                val+=4; count1+=1;
            }else if(sf4.equals("C")){
                val+=3; count1+=1;
            }else if(sf4.equals("D")){
                val+=2; count1+=1;
            }else if(sf4.equals("E")){
                val+=1; count1+=1;
            };
            if(sf5.equals("A")){
                val+=5; count1+=1;
            }else if(sf5.equals("B")){
                val+=4; count1+=1;
            }else if(sf5.equals("C")){
                val+=3; count1+=1;
            }else if(sf5.equals("D")){
                val+=2; count1+=1;
            }else if(sf5.equals("E")){
                val+=1; count1+=1;
            };
            if(sf6.equals("A")){
                val+=5; count1+=1;
            }else if(sf6.equals("B")){
                val+=4; count1+=1;
            }else if(sf6.equals("C")){
                val+=3; count1+=1;
            }else if(sf6.equals("D")){
                val+=2; count1+=1;
            }else if(sf6.equals("E")){
                val+=1; count1+=1;
            };
            if(sf7.equals("A")){
                val+=5; count1+=1;
            }else if(sf7.equals("B")){
                val+=4; count1+=1;
            }else if(sf7.equals("C")){
                val+=3; count1+=1;
            }else if(sf7.equals("D")){
                val+=2; count1+=1;
            }else if(sf7.equals("E")){
                val+=1; count1+=1;
            };
            if(sf8.equals("A")){
                val+=5; count1+=1;
            }else if(sf8.equals("B")){
                val+=4; count1+=1;
            }else if(sf8.equals("C")){
                val+=3; count1+=1;
            }else if(sf8.equals("D")){
                val+=2; count1+=1;
            }else if(sf8.equals("E")){
                val+=1; count1+=1;
            };
            if(fpl1.equals("A")){
                val+=5; count1+=1;
            }else if(fpl1.equals("B")){
                val+=4; count1+=1;
            }else if(fpl1.equals("C")){
                val+=3; count1+=1;
            }else if(fpl1.equals("D")){
                val+=2; count1+=1;
            }else if(fpl1.equals("E")){
                val+=1; count1+=1;
            };
            if(fpl2.equals("A")){
                val+=5; count1+=1;
            }else if(fpl2.equals("B")){
                val+=4; count1+=1;
            }else if(fpl2.equals("C")){
                val+=3; count1+=1;
            }else if(fpl2.equals("D")){
                val+=2; count1+=1;
            }else if(fpl2.equals("E")){
                val+=1; count1+=1;
            };
            if(fpl3.equals("A")){
                val+=5; count1+=1;
            }else if(fpl3.equals("B")){
                val+=4; count1+=1;
            }else if(fpl3.equals("C")){
                val+=3; count1+=1;
            }else if(fpl3.equals("D")){
                val+=2; count1+=1;
            }else if(fpl3.equals("E")){
                val+=1; count1+=1;
            };
            // 2-2
            if(ss1.equals("A")){
                val1+=5; count2+=1;
            }else if(ss1.equals("B")){
                val1+=4; count2+=1;
            }else if(ss1.equals("C")){
                val1+=3; count2+=1;
            }else if(ss1.equals("D")){
                val1+=2; count2+=1;
            }else if(ss1.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss2.equals("A")){
                val1+=5; count2+=1;
            }else if(ss2.equals("B")){
                val1+=4; count2+=1;
            }else if(ss2.equals("C")){
                val1+=3; count2+=1;
            }else if(ss2.equals("D")){
                val1+=2; count2+=1;
            }else if(ss2.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss3.equals("A")){
                val1+=5; count2+=1;
            }else if(ss3.equals("B")){
                val1+=4; count2+=1;
            }else if(ss3.equals("C")){
                val1+=3; count2+=1;
            }else if(ss3.equals("D")){
                val1+=2; count2+=1;
            }else if(ss3.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss4.equals("A")){
                val1+=5; count2+=1;
            }else if(ss4.equals("B")){
                val1+=4; count2+=1;
            }else if(ss4.equals("C")){
                val1+=3; count2+=1;
            }else if(ss4.equals("D")){
                val1+=2; count2+=1;
            }else if(ss4.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss5.equals("A")){
                val1+=5; count2+=1;
            }else if(ss5.equals("B")){
                val1+=4; count2+=1;
            }else if(ss5.equals("C")){
                val1+=3; count2+=1;
            }else if(ss5.equals("D")){
                val1+=2; count2+=1;
            }else if(ss5.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss6.equals("A")){
                val1+=5; count2+=1;
            }else if(ss6.equals("B")){
                val1+=4; count2+=1;
            }else if(ss6.equals("C")){
                val1+=3; count2+=1;
            }else if(ss6.equals("D")){
                val1+=2; count2+=1;
            }else if(ss6.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss7.equals("A")){
                val1+=5; count2+=1;
            }else if(ss7.equals("B")){
                val1+=4; count2+=1;
            }else if(ss7.equals("C")){
                val1+=3; count2+=1;
            }else if(ss7.equals("D")){
                val1+=2; count2+=1;
            }else if(ss7.equals("E")){
                val1+=1; count2+=1;
            };
            if(ss8.equals("A")){
                val1+=5; count2+=1;
            }else if(ss8.equals("B")){
                val1+=4; count2+=1;
            }else if(ss8.equals("C")){
                val1+=3; count2+=1;
            }else if(ss8.equals("D")){
                val1+=2; count2+=1;
            }else if(ss8.equals("E")){
                val1+=1; count2+=1;
            };
            if(spl1.equals("A")){
                val1+=5; count2+=1;
            }else if(spl1.equals("B")){
                val1+=4; count2+=1;
            }else if(spl1.equals("C")){
                val1+=3; count2+=1;
            }else if(spl1.equals("D")){
                val1+=2; count2+=1;
            }else if(spl1.equals("E")){
                val1+=1; count2+=1;
            };
            if(spl2.equals("A")){
                val1+=5; count2+=1;
            }else if(spl2.equals("B")){
                val1+=4; count2+=1;
            }else if(spl2.equals("C")){
                val1+=3; count2+=1;
            }else if(spl2.equals("D")){
                val1+=2; count2+=1;
            }else if(spl2.equals("E")){
                val1+=1; count2+=1;
            };
            if(spl3.equals("A")){
                val1+=5; count2+=1;
            }else if(spl3.equals("B")){
                val1+=4; count2+=1;
            }else if(spl3.equals("C")){
                val1+=3; count2+=1;
            }else if(spl3.equals("D")){
                val1+=2; count2+=1;
            }else if(spl3.equals("E")){
                val1+=1; count2+=1;
            };
            // 3-1
            if(tf1.equals("A")){
                val2+=5; count3+=1;
            }else if(tf1.equals("B")){
                val2+=4; count3+=1;
            }else if(tf1.equals("C")){
                val2+=3; count3+=1;
            }else if(tf1.equals("D")){
                val2+=2; count3+=1;
            }else if(tf1.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf2.equals("A")){
                val2+=5; count3+=1;
            }else if(tf2.equals("B")){
                val2+=4; count3+=1;
            }else if(tf2.equals("C")){
                val2+=3; count3+=1;
            }else if(tf2.equals("D")){
                val2+=2; count3+=1;
            }else if(tf2.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf3.equals("A")){
                val2+=5; count3+=1;
            }else if(tf3.equals("B")){
                val2+=4; count3+=1;
            }else if(tf3.equals("C")){
                val2+=3; count3+=1;
            }else if(tf3.equals("D")){
                val2+=2; count3+=1;
            }else if(tf3.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf4.equals("A")){
                val2+=5; count3+=1;
            }else if(tf4.equals("B")){
                val2+=4; count3+=1;
            }else if(tf4.equals("C")){
                val2+=3; count3+=1;
            }else if(tf4.equals("D")){
                val2+=2; count3+=1;
            }else if(tf4.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf5.equals("A")){
                val2+=5; count3+=1;
            }else if(tf5.equals("B")){
                val2+=4; count3+=1;
            }else if(tf5.equals("C")){
                val2+=3; count3+=1;
            }else if(tf5.equals("D")){
                val2+=2; count3+=1;
            }else if(tf5.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf6.equals("A")){
                val2+=5; count3+=1;
            }else if(tf6.equals("B")){
                val2+=4; count3+=1;
            }else if(tf6.equals("C")){
                val2+=3; count3+=1;
            }else if(tf6.equals("D")){
                val2+=2; count3+=1;
            }else if(tf6.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf7.equals("A")){
                val2+=5; count3+=1;
            }else if(tf7.equals("B")){
                val2+=4; count3+=1;
            }else if(tf7.equals("C")){
                val2+=3; count3+=1;
            }else if(tf7.equals("D")){
                val2+=2; count3+=1;
            }else if(tf7.equals("E")){
                val2+=1; count3+=1;
            };
            if(tf8.equals("A")){
                val2+=5; count3+=1;
            }else if(tf8.equals("B")){
                val2+=4; count3+=1;
            }else if(tf8.equals("C")){
                val2+=3; count3+=1;
            }else if(tf8.equals("D")){
                val2+=2; count3+=1;
            }else if(tf8.equals("E")){
                val2+=1; count3+=1;
            };
            if(tpl1.equals("A")){
                val2+=5; count3+=1;
            }else if(tpl1.equals("B")){
                val2+=4; count3+=1;
            }else if(tpl1.equals("C")){
                val2+=3; count3+=1;
            }else if(tpl1.equals("D")){
                val2+=2; count3+=1;
            }else if(tpl1.equals("E")){
                val2+=1; count3+=1;
            };
            if(tpl2.equals("A")){
                val2+=5; count3+=1;
            }else if(tpl2.equals("B")){
                val2+=4; count3+=1;
            }else if(tpl2.equals("C")){
                val2+=3; count3+=1;
            }else if(tpl2.equals("D")){
                val2+=2; count3+=1;
            }else if(tpl2.equals("E")){
                val2+=1; count3+=1;
            };
            if(tpl3.equals("A")){
                val2+=5; count3+=1;
            }else if(tpl3.equals("B")){
                val2+=4; count3+=1;
            }else if(tpl3.equals("C")){
                val2+=3; count3+=1;
            }else if(tpl3.equals("D")){
                val2+=2; count3+=1;
            }else if(tpl3.equals("E")){
                val2+=1; count3+=1;
            };
            // 예체능
            if(sf9.equals("A")){
                val4+=5; count4+=1;
            }else if(sf9.equals("B")){
                val4+=4; count4+=1;
            }else if(sf9.equals("C")){
                val4+=3; count4+=1;
            };
            if(sf10.equals("A")){
                val4+=5; count4+=1;
            }else if(sf10.equals("B")){
                val4+=4; count4+=1;
            }else if(sf10.equals("C")){
                val4+=3; count4+=1;
            };
            if(sf11.equals("A")){
                val4+=5; count4+=1;
            }else if(sf11.equals("B")){
                val4+=4; count4+=1;
            }else if(sf11.equals("C")){
                val4+=3; count4+=1;
            };
            if(ss9.equals("A")){
                val4+=5; count4+=1;
            }else if(ss9.equals("B")){
                val4+=4; count4+=1;
            }else if(ss9.equals("C")){
                val4+=3; count4+=1;
            };
            if(ss10.equals("A")){
                val4+=5; count4+=1;
            }else if(ss10.equals("B")){
                val4+=4; count4+=1;
            }else if(ss10.equals("C")){
                val4+=3; count4+=1;
            };
            if(ss11.equals("A")){
                val4+=5; count4+=1;
            }else if(ss11.equals("B")){
                val4+=4; count4+=1;
            }else if(ss11.equals("C")){
                val4+=3; count4+=1;
            };
            if(tf9.equals("A")){
                val4+=5; count4+=1;
            }else if(tf9.equals("B")){
                val4+=4; count4+=1;
            }else if(tf9.equals("C")){
                val4+=3; count4+=1;
            };
            if(tf10.equals("A")){
                val4+=5; count4+=1;
            }else if(tf10.equals("B")){
                val4+=4; count4+=1;
            }else if(tf10.equals("C")){
                val4+=3; count4+=1;
            };
            if(tf11.equals("A")){
                val4+=5; count4+=1;
            }else if(tf11.equals("B")){
                val4+=4; count4+=1;
            }else if(tf11.equals("C")){
                val4+=3; count4+=1;
            };
            // 출결점수
            int fab = sss.get().getFirstAbsant();
            int fla = sss.get().getFirstLate();
            int fle = sss.get().getFirstLeave();
            int fre = sss.get().getFirstResult();

            int sab = sss.get().getSecondAbsant();
            int sla = sss.get().getSecondLate();
            int sle = sss.get().getSecondLeave();
            int sre = sss.get().getSecondResult();

            int tab = sss.get().getThirdAbsant();
            int tla = sss.get().getThirdLate();
            int tle = sss.get().getThirdLeave();
            int tre = sss.get().getThirdResult();

            double sc1 = 0;
            double notsc1 = 0;
            double scscore1 =0;
            double sc2 = 0;
            double notsc2 = 0;
            double scscore2 =0;
            double sc3 = 0;
            double notsc3 = 0;
            double scscore3 =0;
            if (fla+fle+fre >3){
                notsc1 = Math.floor((fla+fle+fre)/3);
            }
            sc1= fab+notsc1;
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
            if (sla+sle+sre >3){
                notsc2 = Math.floor((sla+sle+sre)/3);
            }
            sc2= sab+notsc2;
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
            if (tla+tle+tre >3){
                notsc3 = Math.floor((tla+tle+tre)/3);
            }
            sc3= tab+notsc3;
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

            double fbd = sss.get().getFirstBehaviorDevelopment();
            double sbd = sss.get().getSecondBehaviorDevelopment();
            double tbd = sss.get().getThirdBehaviorDevelopment();
            double movsocre = (fbd) + (sbd) + (tbd);

            double fea = sss.get().getFirstExpActivities();
            double sea = sss.get().getSecondExpActivities();
            double tea = sss.get().getThirdExpActivities();
            double cresocre = (fea) + (sea) + (tea);

            double fvat = sss.get().getFirstVolunteerActivityTime();
            double svat = sss.get().getSecondVolunteerActivityTime();
            double tvat = sss.get().getThirdVolunteerActivityTime();
            double fvatscore = 0;
            double svatscore = 0;
            double tvatscore = 0;

            if(fvat >= 7){
                fvatscore = 5;
            }else if(fvat >= 6){
                fvatscore = 4.5;
            }else if(fvat >= 5){
                fvatscore = 4;
            }else if(fvat >= 4){
                fvatscore = 3.5;
            }else if(fvat <= 3){
                fvatscore = 3;
            };
            if(svat >= 7){
                svatscore = 5;
            }else if(svat >= 6){
                svatscore = 4.5;
            }else if(svat >= 5){
                svatscore = 4;
            }else if(svat >= 4){
                svatscore = 3.5;
            }else if(svat <= 3){
                svatscore = 3;
            };
            if(tvat >= 7){
                tvatscore = 5;
            }else if(tvat >= 6){
                tvatscore = 4.5;
            }else if(tvat >= 5){
                tvatscore = 4;
            }else if(tvat >= 4){
                tvatscore = 3.5;
            }else if(tvat <= 3){
                tvatscore = 3;
            };
            double vatscore = fvatscore + svatscore + tvatscore;

            t1 = ((180*0.3)*(val/(count1*5)));
            t2 = ((180*0.3)*(val1/(count2*5)));
            t3 = ((180*0.4)*(val2/(count3*5)));
            t4 = 60*(val4/(count4*5));
            t5 = t1+t2+t3+t4;
            t6 = scscore1+scscore2+scscore3;
            t7 = t6 + movsocre + cresocre + vatscore;
            total =  t5 + t7;
            String t1le = Double.toString(t1);
            String t2le = Double.toString(t2);
            String t3le = Double.toString(t3);
            String t4le = Double.toString(t4);
            String t5le = Double.toString(t5);
            String t6le = Double.toString(t6);
            String t7le = Double.toString(t7);
            String movele = Double.toString(movsocre);
            String crele = Double.toString(cresocre);
            String vatle = Double.toString(vatscore);
            String totalle = Double.toString(total);

            String arr [] = {t1le,t2le,t3le,t4le,t6le,t7le,movele,crele,vatle};
            for (int i=0; i< arr.length; i++){
                if (arr[i].length() <3){
                    arr[i] = arr[i] + ".000";
                }else if(arr[i].length() <5){
                    arr[i] = arr[i] + "00";
                }else if(arr[i].length() <7){
                    arr[i] = arr[i] + "0";
                }
            }
            for (int i=0; i< arr.length; i++){
                if (t5le.length() <4){
                    t5le = t5le + ".000";
                }else if(t5le.length() <6){
                    t5le = t5le + "00";
                }else if(t5le.length() <7){
                    t5le = t5le + "0";
                }
            }

            if (totalle.length() <4){
                totalle = totalle + ".000";
            }else if(totalle.length() <6){
                totalle = totalle + "00";
            }else if(totalle.length() <7){
                totalle = totalle + "0";
            }

            model.addAttribute("t1", arr[0].substring(0,6));
            model.addAttribute("t2", arr[1].substring(0,6));
            model.addAttribute("t3", arr[2].substring(0,6));
            model.addAttribute("t4", arr[3].substring(0,6));
            model.addAttribute("t5", t5le.substring(0,7));
            model.addAttribute("t6", arr[4].substring(0,5));
            model.addAttribute("t7", arr[5].substring(0,6));
            model.addAttribute("total",  totalle.substring(0,7));
            model.addAttribute("movsocre", arr[6].substring(0,5));
            model.addAttribute("cresocre", arr[7].substring(0,5));
            model.addAttribute("vatscore", arr[8].substring(0,5));

        } else if(PersonalDataEntityes.get().getAgraduation_type() == 1){
            Optional<GradeType2DataEntity> sss = gradeType2dataRepository.findById(seq);
            if(sss.get().getIsCheck() == 0){
                Optional<GradeType2DataEntity> sss1 = gradeType2dataRepository.findById(seq);
                Optional<StudentfakeseqEntity> s3 = studentfakeseqRepository.findBySseq((Long) session.getAttribute("percode"));
                model.addAttribute("seq",s3.get().getStudentfakeseq());

                String t7le = Double.toString(sss1.get().getNonCurriculumGrades());
                String t6le = Double.toString(sss1.get().getTotalBehaviorDevelopment());
                String movle = Double.toString(sss1.get().getThirdBehaviorDevelopment());
                String crele = Double.toString(sss1.get().getThirdExpActivities());
                String vatle = Double.toString(sss1.get().getTotalVolunteerActivityTime());

                String t5le = Double.toString(sss1.get().getSecondBehaviorDevelopment());
                String totalle = Double.toString(sss1.get().getTotalGrades());


                if (t5le.length() <4){
                    t5le = t5le + ".000";
                }else if(t5le.length() <6){
                    t5le = t5le + "00";
                }else if(t5le.length() <7){
                    t5le = t5le + "0";
                }


                if (totalle.length() <4){
                    totalle = totalle + ".000";
                }else if(totalle.length() <6){
                    totalle = totalle + "00";
                }else if(totalle.length() <7){
                    totalle = totalle + "0";
                }

                String arr [] = {t6le,t7le,movle,crele,vatle};
                for (int i=0; i< arr.length; i++){
                    if (arr[i].length() <3){
                        arr[i] = arr[i] + ".000";
                    }else if(arr[i].length() <5){
                        arr[i] = arr[i] + "00";
                    }else if(arr[i].length() <7){
                        arr[i] = arr[i] + "0";
                    }
                }

                model.addAttribute("t5",t5le.substring(0,7));
                model.addAttribute("total",totalle.substring(0,7));
                model.addAttribute("t6",arr[0].substring(0,5));
                model.addAttribute("movsocre",arr[2].substring(0,5));
                model.addAttribute("cresocre",arr[3].substring(0,5));
                model.addAttribute("vatscore",arr[4].substring(0,5));
                model.addAttribute("t7",arr[1].substring(0,6));
            } else if(sss.get().getIsCheck() == 1){
                model.addAttribute("total", sss.get().getOrderTotal());
            }
        }else if(PersonalDataEntityes.get().getAgraduation_type() == 2){
            Optional<GradeType3DataEntity> sss = gradeType3dataRepository.findById(seq);
            model.addAttribute("total", sss.get().getTotalGrades());
            Optional<StudentfakeseqEntity> s2 = studentfakeseqRepository.findBySseq((Long) session.getAttribute("percode"));
            model.addAttribute("seq",s2.get().getStudentfakeseq());
            System.out.println(sss.get().getASeq());
        }
        return "1.html";
    }

    @GetMapping("/grade")
    public String grade(Model model, HttpSession session, HttpServletRequest request){
        Optional<PersonalDataEntity> PersonalDataEntityes = personalDataRepository.findById((Long) session.getAttribute("percode"));
        Long seq = (Long) session.getAttribute("percode");
        Optional<StudentEntity> main = studentRepository.findById(seq);
        String day = main.get().getStudent_signupdatetime();
        String[] day1 = day.split("-");
        String[] day2 = day1[2].split(" ");
        model.addAttribute("day", day2[0]);
        Optional<GradeType1DataEntity> sss = gradeType1dataRepository.findById(seq);
        if(!sss.isPresent()){
            return "DownloadGradeData.html";
        }
        Optional<StudentfakeseqEntity> s1 = studentfakeseqRepository.findBySseq((Long) session.getAttribute("percode"));
        model.addAttribute("seq",s1.get().getStudentfakeseq());

        String sf1 = sss.get().getSecondFirstType1();
        String sf2 = sss.get().getSecondFirstType2();
        String sf3 = sss.get().getSecondFirstType3();
        String sf4 = sss.get().getSecondFirstType4();
        String sf5 = sss.get().getSecondFirstType5();
        String sf6 = sss.get().getSecondFirstType6();
        String sf7 = sss.get().getSecondFirstType7();
        String sf8 = sss.get().getSecondFirstType8();
        String fpl1 = sss.get().getFirstPlusType1();
        String fpl2 = sss.get().getFirstPlusType2();
        String fpl3 = sss.get().getFirstPlusType3();
        //2-2 일반
        String ss1 = sss.get().getSecondSecondType1();
        String ss2 = sss.get().getSecondSecondType2();
        String ss3 = sss.get().getSecondSecondType3();
        String ss4 = sss.get().getSecondSecondType4();
        String ss5 = sss.get().getSecondSecondType5();
        String ss6 = sss.get().getSecondSecondType6();
        String ss7 = sss.get().getSecondSecondType7();
        String ss8 = sss.get().getSecondSecondType8();
        String spl1 = sss.get().getSecondPlusType1();
        String spl2 = sss.get().getSecondPlusType2();
        String spl3 = sss.get().getSecondPlusType3();
        // 3-1 일반
        String tf1 = sss.get().getThirdFirstType1();
        String tf2 = sss.get().getThirdFirstType2();
        String tf3 = sss.get().getThirdFirstType3();
        String tf4 = sss.get().getThirdFirstType4();
        String tf5 = sss.get().getThirdFirstType5();
        String tf6 = sss.get().getThirdFirstType6();
        String tf7 = sss.get().getThirdFirstType7();
        String tf8 = sss.get().getThirdFirstType8();
        String tpl1 = sss.get().getThirdPlusType1();
        String tpl2 = sss.get().getThirdPlusType2();
        String tpl3 = sss.get().getThirdPlusType3();
        // 예체능
        String sf9 = sss.get().getSecondFirstType9();
        String sf10 = sss.get().getSecondFirstType10();
        String sf11 = sss.get().getSecondFirstType11();
        String ss9 = sss.get().getSecondSecondType9();
        String ss10 = sss.get().getSecondSecondType10();
        String ss11 = sss.get().getSecondSecondType11();
        String tf9 = sss.get().getThirdFirstType9();
        String tf10 = sss.get().getThirdFirstType10();
        String tf11 = sss.get().getThirdFirstType11();

        double val = 0;
        double val1 = 0;
        double val2 = 0;
        double val4 = 0;
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double t1 =0;
        double t2 =0;
        double t3 =0;
        double t4 =0;
        double t5 =0;
        // 2-1
        if(sf1.equals("A")){
            val+=5; count1+=1;
        }else if(sf1.equals("B")){
            val+=4; count1+=1;
        }else if(sf1.equals("C")){
            val+=3; count1+=1;
        }else if(sf1.equals("D")){
            val+=2; count1+=1;
        }else if(sf1.equals("E")){
            val+=1; count1+=1;
        };
        if(sf2.equals("A")){
            val+=5; count1+=1;
        }else if(sf2.equals("B")){
            val+=4; count1+=1;
        }else if(sf2.equals("C")){
            val+=3; count1+=1;
        }else if(sf2.equals("D")){
            val+=2; count1+=1;
        }else if(sf2.equals("E")){
            val+=1; count1+=1;
        };
        if(sf3.equals("A")){
            val+=5; count1+=1;
        }else if(sf3.equals("B")){
            val+=4; count1+=1;
        }else if(sf3.equals("C")){
            val+=3; count1+=1;
        }else if(sf3.equals("D")){
            val+=2; count1+=1;
        }else if(sf3.equals("E")){
            val+=1; count1+=1;
        };
        if(sf4.equals("A")){
            val+=5; count1+=1;
        }else if(sf4.equals("B")){
            val+=4; count1+=1;
        }else if(sf4.equals("C")){
            val+=3; count1+=1;
        }else if(sf4.equals("D")){
            val+=2; count1+=1;
        }else if(sf4.equals("E")){
            val+=1; count1+=1;
        };
        if(sf5.equals("A")){
            val+=5; count1+=1;
        }else if(sf5.equals("B")){
            val+=4; count1+=1;
        }else if(sf5.equals("C")){
            val+=3; count1+=1;
        }else if(sf5.equals("D")){
            val+=2; count1+=1;
        }else if(sf5.equals("E")){
            val+=1; count1+=1;
        };
        if(sf6.equals("A")){
            val+=5; count1+=1;
        }else if(sf6.equals("B")){
            val+=4; count1+=1;
        }else if(sf6.equals("C")){
            val+=3; count1+=1;
        }else if(sf6.equals("D")){
            val+=2; count1+=1;
        }else if(sf6.equals("E")){
            val+=1; count1+=1;
        };
        if(sf7.equals("A")){
            val+=5; count1+=1;
        }else if(sf7.equals("B")){
            val+=4; count1+=1;
        }else if(sf7.equals("C")){
            val+=3; count1+=1;
        }else if(sf7.equals("D")){
            val+=2; count1+=1;
        }else if(sf7.equals("E")){
            val+=1; count1+=1;
        };
        if(sf8.equals("A")){
            val+=5; count1+=1;
        }else if(sf8.equals("B")){
            val+=4; count1+=1;
        }else if(sf8.equals("C")){
            val+=3; count1+=1;
        }else if(sf8.equals("D")){
            val+=2; count1+=1;
        }else if(sf8.equals("E")){
            val+=1; count1+=1;
        };
        if(fpl1.equals("A")){
            val+=5; count1+=1;
        }else if(fpl1.equals("B")){
            val+=4; count1+=1;
        }else if(fpl1.equals("C")){
            val+=3; count1+=1;
        }else if(fpl1.equals("D")){
            val+=2; count1+=1;
        }else if(fpl1.equals("E")){
            val+=1; count1+=1;
        };
        if(fpl2.equals("A")){
            val+=5; count1+=1;
        }else if(fpl2.equals("B")){
            val+=4; count1+=1;
        }else if(fpl2.equals("C")){
            val+=3; count1+=1;
        }else if(fpl2.equals("D")){
            val+=2; count1+=1;
        }else if(fpl2.equals("E")){
            val+=1; count1+=1;
        };
        if(fpl3.equals("A")){
            val+=5; count1+=1;
        }else if(fpl3.equals("B")){
            val+=4; count1+=1;
        }else if(fpl3.equals("C")){
            val+=3; count1+=1;
        }else if(fpl3.equals("D")){
            val+=2; count1+=1;
        }else if(fpl3.equals("E")){
            val+=1; count1+=1;
        };
        // 2-2
        if(ss1.equals("A")){
            val1+=5; count2+=1;
        }else if(ss1.equals("B")){
            val1+=4; count2+=1;
        }else if(ss1.equals("C")){
            val1+=3; count2+=1;
        }else if(ss1.equals("D")){
            val1+=2; count2+=1;
        }else if(ss1.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss2.equals("A")){
            val1+=5; count2+=1;
        }else if(ss2.equals("B")){
            val1+=4; count2+=1;
        }else if(ss2.equals("C")){
            val1+=3; count2+=1;
        }else if(ss2.equals("D")){
            val1+=2; count2+=1;
        }else if(ss2.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss3.equals("A")){
            val1+=5; count2+=1;
        }else if(ss3.equals("B")){
            val1+=4; count2+=1;
        }else if(ss3.equals("C")){
            val1+=3; count2+=1;
        }else if(ss3.equals("D")){
            val1+=2; count2+=1;
        }else if(ss3.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss4.equals("A")){
            val1+=5; count2+=1;
        }else if(ss4.equals("B")){
            val1+=4; count2+=1;
        }else if(ss4.equals("C")){
            val1+=3; count2+=1;
        }else if(ss4.equals("D")){
            val1+=2; count2+=1;
        }else if(ss4.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss5.equals("A")){
            val1+=5; count2+=1;
        }else if(ss5.equals("B")){
            val1+=4; count2+=1;
        }else if(ss5.equals("C")){
            val1+=3; count2+=1;
        }else if(ss5.equals("D")){
            val1+=2; count2+=1;
        }else if(ss5.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss6.equals("A")){
            val1+=5; count2+=1;
        }else if(ss6.equals("B")){
            val1+=4; count2+=1;
        }else if(ss6.equals("C")){
            val1+=3; count2+=1;
        }else if(ss6.equals("D")){
            val1+=2; count2+=1;
        }else if(ss6.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss7.equals("A")){
            val1+=5; count2+=1;
        }else if(ss7.equals("B")){
            val1+=4; count2+=1;
        }else if(ss7.equals("C")){
            val1+=3; count2+=1;
        }else if(ss7.equals("D")){
            val1+=2; count2+=1;
        }else if(ss7.equals("E")){
            val1+=1; count2+=1;
        };
        if(ss8.equals("A")){
            val1+=5; count2+=1;
        }else if(ss8.equals("B")){
            val1+=4; count2+=1;
        }else if(ss8.equals("C")){
            val1+=3; count2+=1;
        }else if(ss8.equals("D")){
            val1+=2; count2+=1;
        }else if(ss8.equals("E")){
            val1+=1; count2+=1;
        };
        if(spl1.equals("A")){
            val1+=5; count2+=1;
        }else if(spl1.equals("B")){
            val1+=4; count2+=1;
        }else if(spl1.equals("C")){
            val1+=3; count2+=1;
        }else if(spl1.equals("D")){
            val1+=2; count2+=1;
        }else if(spl1.equals("E")){
            val1+=1; count2+=1;
        };
        if(spl2.equals("A")){
            val1+=5; count2+=1;
        }else if(spl2.equals("B")){
            val1+=4; count2+=1;
        }else if(spl2.equals("C")){
            val1+=3; count2+=1;
        }else if(spl2.equals("D")){
            val1+=2; count2+=1;
        }else if(spl2.equals("E")){
            val1+=1; count2+=1;
        };
        if(spl3.equals("A")){
            val1+=5; count2+=1;
        }else if(spl3.equals("B")){
            val1+=4; count2+=1;
        }else if(spl3.equals("C")){
            val1+=3; count2+=1;
        }else if(spl3.equals("D")){
            val1+=2; count2+=1;
        }else if(spl3.equals("E")){
            val1+=1; count2+=1;
        };
        // 3-1
        if(tf1.equals("A")){
            val2+=5; count3+=1;
        }else if(tf1.equals("B")){
            val2+=4; count3+=1;
        }else if(tf1.equals("C")){
            val2+=3; count3+=1;
        }else if(tf1.equals("D")){
            val2+=2; count3+=1;
        }else if(tf1.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf2.equals("A")){
            val2+=5; count3+=1;
        }else if(tf2.equals("B")){
            val2+=4; count3+=1;
        }else if(tf2.equals("C")){
            val2+=3; count3+=1;
        }else if(tf2.equals("D")){
            val2+=2; count3+=1;
        }else if(tf2.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf3.equals("A")){
            val2+=5; count3+=1;
        }else if(tf3.equals("B")){
            val2+=4; count3+=1;
        }else if(tf3.equals("C")){
            val2+=3; count3+=1;
        }else if(tf3.equals("D")){
            val2+=2; count3+=1;
        }else if(tf3.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf4.equals("A")){
            val2+=5; count3+=1;
        }else if(tf4.equals("B")){
            val2+=4; count3+=1;
        }else if(tf4.equals("C")){
            val2+=3; count3+=1;
        }else if(tf4.equals("D")){
            val2+=2; count3+=1;
        }else if(tf4.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf5.equals("A")){
            val2+=5; count3+=1;
        }else if(tf5.equals("B")){
            val2+=4; count3+=1;
        }else if(tf5.equals("C")){
            val2+=3; count3+=1;
        }else if(tf5.equals("D")){
            val2+=2; count3+=1;
        }else if(tf5.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf6.equals("A")){
            val2+=5; count3+=1;
        }else if(tf6.equals("B")){
            val2+=4; count3+=1;
        }else if(tf6.equals("C")){
            val2+=3; count3+=1;
        }else if(tf6.equals("D")){
            val2+=2; count3+=1;
        }else if(tf6.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf7.equals("A")){
            val2+=5; count3+=1;
        }else if(tf7.equals("B")){
            val2+=4; count3+=1;
        }else if(tf7.equals("C")){
            val2+=3; count3+=1;
        }else if(tf7.equals("D")){
            val2+=2; count3+=1;
        }else if(tf7.equals("E")){
            val2+=1; count3+=1;
        };
        if(tf8.equals("A")){
            val2+=5; count3+=1;
        }else if(tf8.equals("B")){
            val2+=4; count3+=1;
        }else if(tf8.equals("C")){
            val2+=3; count3+=1;
        }else if(tf8.equals("D")){
            val2+=2; count3+=1;
        }else if(tf8.equals("E")){
            val2+=1; count3+=1;
        };
        if(tpl1.equals("A")){
            val2+=5; count3+=1;
        }else if(tpl1.equals("B")){
            val2+=4; count3+=1;
        }else if(tpl1.equals("C")){
            val2+=3; count3+=1;
        }else if(tpl1.equals("D")){
            val2+=2; count3+=1;
        }else if(tpl1.equals("E")){
            val2+=1; count3+=1;
        };
        if(tpl2.equals("A")){
            val2+=5; count3+=1;
        }else if(tpl2.equals("B")){
            val2+=4; count3+=1;
        }else if(tpl2.equals("C")){
            val2+=3; count3+=1;
        }else if(tpl2.equals("D")){
            val2+=2; count3+=1;
        }else if(tpl2.equals("E")){
            val2+=1; count3+=1;
        };
        if(tpl3.equals("A")){
            val2+=5; count3+=1;
        }else if(tpl3.equals("B")){
            val2+=4; count3+=1;
        }else if(tpl3.equals("C")){
            val2+=3; count3+=1;
        }else if(tpl3.equals("D")){
            val2+=2; count3+=1;
        }else if(tpl3.equals("E")){
            val2+=1; count3+=1;
        };
        // 예체능
        if(sf9.equals("A")){
            val4+=5; count4+=1;
        }else if(sf9.equals("B")){
            val4+=4; count4+=1;
        }else if(sf9.equals("C")){
            val4+=3; count4+=1;
        };
        if(sf10.equals("A")){
            val4+=5; count4+=1;
        }else if(sf10.equals("B")){
            val4+=4; count4+=1;
        }else if(sf10.equals("C")){
            val4+=3; count4+=1;
        };
        if(sf11.equals("A")){
            val4+=5; count4+=1;
        }else if(sf11.equals("B")){
            val4+=4; count4+=1;
        }else if(sf11.equals("C")){
            val4+=3; count4+=1;
        };
        if(ss9.equals("A")){
            val4+=5; count4+=1;
        }else if(ss9.equals("B")){
            val4+=4; count4+=1;
        }else if(ss9.equals("C")){
            val4+=3; count4+=1;
        };
        if(ss10.equals("A")){
            val4+=5; count4+=1;
        }else if(ss10.equals("B")){
            val4+=4; count4+=1;
        }else if(ss10.equals("C")){
            val4+=3; count4+=1;
        };
        if(ss11.equals("A")){
            val4+=5; count4+=1;
        }else if(ss11.equals("B")){
            val4+=4; count4+=1;
        }else if(ss11.equals("C")){
            val4+=3; count4+=1;
        };
        if(tf9.equals("A")){
            val4+=5; count4+=1;
        }else if(tf9.equals("B")){
            val4+=4; count4+=1;
        }else if(tf9.equals("C")){
            val4+=3; count4+=1;
        };
        if(tf10.equals("A")){
            val4+=5; count4+=1;
        }else if(tf10.equals("B")){
            val4+=4; count4+=1;
        }else if(tf10.equals("C")){
            val4+=3; count4+=1;
        };
        if(tf11.equals("A")){
            val4+=5; count4+=1;
        }else if(tf11.equals("B")){
            val4+=4; count4+=1;
        }else if(tf11.equals("C")){
            val4+=3; count4+=1;
        };
        // 출결점수
        int fab = sss.get().getFirstAbsant();
        int fla = sss.get().getFirstLate();
        int fle = sss.get().getFirstLeave();
        int fre = sss.get().getFirstResult();

        int sab = sss.get().getSecondAbsant();
        int sla = sss.get().getSecondLate();
        int sle = sss.get().getSecondLeave();
        int sre = sss.get().getSecondResult();

        int tab = sss.get().getThirdAbsant();
        int tla = sss.get().getThirdLate();
        int tle = sss.get().getThirdLeave();
        int tre = sss.get().getThirdResult();

        model.addAttribute("fab",fab);
        model.addAttribute("fla",fla);
        model.addAttribute("fle",fle);
        model.addAttribute("fre",fre);

        model.addAttribute("sab",sab);
        model.addAttribute("sla",sla);
        model.addAttribute("sle",sle);
        model.addAttribute("sre",sre);

        model.addAttribute("tab",tab);
        model.addAttribute("tla",tla);
        model.addAttribute("tle",tle);
        model.addAttribute("tre",tre);

        double sc1 = 0;
        double notsc1 = 0;
        double scscore1 =0;
        double sc2 = 0;
        double notsc2 = 0;
        double scscore2 =0;
        double sc3 = 0;
        double notsc3 = 0;
        double scscore3 =0;
        if (fla+fle+fre >3){
            notsc1 = Math.floor((fla+fle+fre)/3);
        }
        sc1= fab+notsc1;
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
        if (sla+sle+sre >3){
            notsc2 = Math.floor((sla+sle+sre)/3);
        }
        sc2= sab+notsc2;
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
        if (tla+tle+tre >3){
            notsc3 = Math.floor((tla+tle+tre)/3);
        }
        sc3= tab+notsc3;
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
        double fbd = sss.get().getFirstBehaviorDevelopment()-4.5;
        double sbd = sss.get().getSecondBehaviorDevelopment()-4.5;
        double tbd = sss.get().getThirdBehaviorDevelopment()-4.5;

        model.addAttribute("fbd",fbd);
        model.addAttribute("sbd",sbd);
        model.addAttribute("tbd",tbd);


        double fea = sss.get().getFirstExpActivities()-4.5;
        double sea = sss.get().getSecondExpActivities()-4.5;
        double tea = sss.get().getThirdExpActivities()-4.5;

        model.addAttribute("fea",fea);
        model.addAttribute("sea",sea);
        model.addAttribute("tea",tea);


        double fvat = sss.get().getFirstVolunteerActivityTime();
        double svat = sss.get().getSecondVolunteerActivityTime();
        double tvat = sss.get().getThirdVolunteerActivityTime();
        model.addAttribute("fvat",fvat);
        model.addAttribute("svat",svat);
        model.addAttribute("tvat",tvat);
        double fvatscore = 0;
        double svatscore = 0;
        double tvatscore = 0;

        if(fvat >= 7){
            fvatscore = 5;
        }else if(fvat >= 6){
            fvatscore = 4.5;
        }else if(fvat >= 5){
            fvatscore = 4;
        }else if(fvat >= 4){
            fvatscore = 3.5;
        }else if(fvat <= 3){
            fvatscore = 3;
        };
        if(svat >= 7){
            svatscore = 5;
        }else if(svat >= 6){
            svatscore = 4.5;
        }else if(svat >= 5){
            svatscore = 4;
        }else if(svat >= 4){
            svatscore = 3.5;
        }else if(svat <= 3){
            svatscore = 3;
        };
        if(tvat >= 7){
            tvatscore = 5;
        }else if(tvat >= 6){
            tvatscore = 4.5;
        }else if(tvat >= 5){
            tvatscore = 4;
        }else if(tvat >= 4){
            tvatscore = 3.5;
        }else if(tvat <= 3){
            tvatscore = 3;
        };

        model.addAttribute("scscore1",scscore1);
        model.addAttribute("scscore2",scscore2);
        model.addAttribute("scscore3",scscore3);
        t1 = ((180*0.3)*(val/(count1*5)));
        t2 = ((180*0.3)*(val1/(count2*5)));
        t3 = ((180*0.4)*(val2/(count3*5)));
        t4 = 60*(val4/(count4*5));
        t5 = scscore1+scscore2+scscore3;
        double movsocre = (fbd+4.5) + (sbd+4.5) + (tbd+4.5);
        double cresocre = (fea+4.5) + (sea+4.5) + (tea+4.5);
        double vatscore = fvatscore + svatscore + tvatscore;
        String t1le = Double.toString(t1);
        String t2le = Double.toString(t2);
        String t3le = Double.toString(t3);
        String t4le = Double.toString(t4);
        String t5le = Double.toString(t5);
        String movele = Double.toString(movsocre);
        String crele = Double.toString(cresocre);
        String vatle = Double.toString(vatscore);

        String arr [] = {t1le,t2le,t3le,t4le,movele,crele,vatle};
        for (int i=0; i< arr.length; i++){
            if (arr[i].length() <3){
                arr[i] = arr[i] + ".000";
            }else if(arr[i].length() <5){
                arr[i] = arr[i] + "00";
            }else if(arr[i].length() <7){
                arr[i] = arr[i] + "0";
            }
        }
        for (int i=0; i< arr.length; i++){
            if (t5le.length() <4){
                t5le = t5le + ".000";
            }else if(t5le.length() <6){
                t5le = t5le + "00";
            }else if(t5le.length() <7){
                t5le = t5le + "0";
            }
        }
        model.addAttribute("sfttotal",arr[0].substring(0,6));
        model.addAttribute("ssttotal",arr[1].substring(0,6));
        model.addAttribute("tfttotal",arr[2].substring(0,6));
        model.addAttribute("pistotal",arr[3].substring(0,6));
        model.addAttribute("sctscore",t5le.substring(0,5));
        model.addAttribute("cresocre",arr[4].substring(0,5));
        model.addAttribute("movsocre",arr[5].substring(0,5));
        model.addAttribute("vatscore",arr[6].substring(0,5));


        String sfp = sss.get().getFirstPlusName();
        String ssp = sss.get().getSecondPlusName();
        String stp = sss.get().getThirdPlusName();

        String sf[] = {sf1, sf2, sf3, sf4, sf5, sf6 ,sf7 ,sf8, fpl1, fpl2, fpl3};
        String ss[] = {ss1, ss2, ss3, ss4, ss5, ss6 ,ss7 ,ss8, spl1, spl2, spl3};
        String tf[] = {tf1, tf2, tf3, tf4, tf5, tf6 ,tf7 ,tf8, tpl1, tpl2, tpl3};
        String gn[] = {"국어", "도덕", "사회", "역사", "수학", "과학", "기술가정", "영어",sfp,ssp,stp};

        int a = 0;
        for(int i=0; i<sf.length; i++){
            if(!sf[i].equals("") || !ss[i].equals("") || !tf[i].equals("")){
                a++;
                model.addAttribute("fgn"+a, gn[i]);
                model.addAttribute("sftd"+a, sf[i]);
                model.addAttribute("sstd"+a, ss[i]);
                model.addAttribute("tftd"+a, tf[i]);
            }
        }
        System.out.println(spl2);


        model.addAttribute("sft9", sss.get().getSecondFirstType9());
        model.addAttribute("sst9", sss.get().getSecondSecondType9());
        model.addAttribute("tft9", sss.get().getThirdFirstType9());

        model.addAttribute("sft10", sss.get().getSecondFirstType10());
        model.addAttribute("sst10", sss.get().getSecondSecondType10());
        model.addAttribute("tft10", sss.get().getThirdFirstType10());

        model.addAttribute("sft11", sss.get().getSecondFirstType11());
        model.addAttribute("sst11", sss.get().getSecondSecondType11());
        model.addAttribute("tft11", sss.get().getThirdFirstType11());

        Optional<PersonalDataEntity> sda = personalDataRepository.findById((Long) session.getAttribute("percode"));
        model.addAttribute("middleschool",sda.get().getAmiddle_school());
        return "DownloadGradeData.html";
    }
}
