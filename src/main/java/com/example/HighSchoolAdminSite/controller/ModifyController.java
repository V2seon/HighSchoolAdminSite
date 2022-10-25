package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.dto.*;
import com.example.HighSchoolAdminSite.entity.*;
import com.example.HighSchoolAdminSite.repository.*;
import com.example.HighSchoolAdminSite.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping
public class ModifyController {

    private PersonalDataRepository personalDataRepository;
    private GradeType1DataRepository gradeType1DataRepository;
    private GradeType2DataRepository gradeType2DataRepository;
    private GradeType3DataRepository gradeType3DataRepository;
    private StudentfakeseqRepository studentfakeseqRepository;
    private StudentfakeseqService studentfakeseqService;
    private PersonalDataService informationService;
    private Gradetype1DataService gradetype1DataService;
    private Gradetype2DataService gradetype2DataService;
    private Gradetype3DataService gradetype3DataService;

    @GetMapping("/getcode0")
    public String getcode0(Model model, HttpSession session, HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        System.out.println(percode);
        return "Persondatalist0 :: Success" ;
    }

    @GetMapping("/getcode1")
    public String getcode1(Model model, HttpSession session, HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "",value = "percode")Long percode){
        session.setAttribute("percode", percode);
        Optional<PersonalDataEntity> personalDataEntity = personalDataRepository.findById((Long) session.getAttribute("percode"));
        if (personalDataEntity.get().getAgraduation_type() == 0){
            session.setAttribute("grade",0);
        }else if(personalDataEntity.get().getAgraduation_type() == 1){
            session.setAttribute("grade",1);
        }else if(personalDataEntity.get().getAgraduation_type() == 2){
            session.setAttribute("grade",2);
        }
        return "Persondatalist0 :: Success" ;
    }

    @PostMapping("/modify")
    public String modify(HttpServletRequest request,Model model,
                         @RequestParam(required = false, defaultValue = "", value = "userName")String userName,
                         @RequestParam(required = false, defaultValue = "", value = "userBirthday")String userBirthday,
                         @RequestParam(required = false, defaultValue = "", value = "sexchoice")Integer sexchoice,
                         @RequestParam(required = false, defaultValue = "", value = "userPhone")String userPhone,
                         @RequestParam(required = false, defaultValue = "", value = "postalCode")String postalCode,
                         @RequestParam(required = false, defaultValue = "", value = "Address")String Address,
                         @RequestParam(required = false, defaultValue = "", value = "detailAdd")String detailAdd,
                         @RequestParam(required = false, defaultValue = "", value = "guardian")String guardian,
                         @RequestParam(required = false, defaultValue = "", value = "homephone")String homephone,
                         @RequestParam(required = false, defaultValue = "", value = "parental")String parental,
                         @RequestParam(required = false, defaultValue = "", value = "parentalphone")String parentalphone,
                         @RequestParam(required = false, defaultValue = "", value = "adminparental")String adminparental,
                         @RequestParam(required = false, defaultValue = "", value = "adminphone")String adminphone,
                         @RequestParam(required = false, defaultValue = "", value = "upload")String upload,
                         @RequestParam(required = false, defaultValue = "", value = "scName")String scName,
                         @RequestParam(required = false, defaultValue = "", value = "scphone")String scphone,
                         @RequestParam(required = false, defaultValue = "", value = "sido")String sido,
                         @RequestParam(required = false, defaultValue = "", value = "sigungu")String sigungu,
                         @RequestParam(required = false, defaultValue = "", value = "year")Integer year,
                         @RequestParam(required = false, defaultValue = "", value = "month")Integer month,
                         @RequestParam(required = false, defaultValue = "", value = "graduation")Integer graduation,
                         @RequestParam(required = false, defaultValue = "", value = "classifcation")Integer classifcation){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<PersonalDataEntity> sss = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> sfq = studentfakeseqRepository.findBySseq(sss.get().getAseq());

        if(graduation != sss.get().getAgraduation_type() ||graduation != sfq.get().getNum() ){
            Optional<GradeType1DataEntity> g1 = gradeType1DataRepository.findById(seq);
            Optional<GradeType2DataEntity> g2 = gradeType2DataRepository.findById(seq);
            Optional<GradeType3DataEntity> g3 = gradeType3DataRepository.findById(seq);
            if(g1.isPresent()){
                gradeType1DataRepository.deleteById(sss.get().getAseq());
            }else if(g2.isPresent()){
                gradeType2DataRepository.deleteById(sss.get().getAseq());
            }else if(g3.isPresent()){
                gradeType3DataRepository.deleteById(sss.get().getAseq());
            }

            studentfakeseqRepository.deleteById(sfq.get().getSeq());
            if (graduation == 0){
                Optional<StudentfakeseqEntity> s0 = studentfakeseqRepository.findBynum(graduation);
                if (!s0.isPresent()){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 1000001, 0,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if (s0.get().getNum() != 0){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 1000001, 0,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if(s0.get().getNum() == 0){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), s0.get().getStudentfakeseq()+1, 0,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }
            }else if(graduation == 1){
                Optional<StudentfakeseqEntity> s0 = studentfakeseqRepository.findBynum(graduation);
                if (!s0.isPresent()){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 2000001, 1,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if (s0.get().getNum() != 1){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 2000001, 1,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if(s0.get().getNum() == 1){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), s0.get().getStudentfakeseq()+1, 1,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }
            }else if(graduation == 2){
                Optional<StudentfakeseqEntity> s0 = studentfakeseqRepository.findBynum(graduation);
                if (!s0.isPresent()){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 3000001, 2,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if (s0.get().getNum() != 2){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), 3000001, 2,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }else if(s0.get().getNum() == 2){
                    StudentfakeseqDto studentfakeseqDto = new StudentfakeseqDto(null,(Long) session.getAttribute("percode"), s0.get().getStudentfakeseq()+1, 2,0);
                    studentfakeseqService.save(studentfakeseqDto);
                }
            }
        }
        Optional<StudentfakeseqEntity> sss00 = studentfakeseqRepository.findBySseq((Long) session.getAttribute("percode"));
        System.out.println(sss00.get().getStudentfakeseq());
        System.out.println(upload);
        if (!sss.isPresent()){
            String imgtype = "";
            if(upload.equals("png") || upload.equals("PNG")){
                imgtype = ".png";
            }else if(upload.equals("jpeg") || upload.equals("JPEG")){
                imgtype = ".jpeg";
            }else{
                imgtype = ".jpg";
            }
            String id = UUID.randomUUID().toString().replace("-","");
            upload = id+imgtype;
            session.setAttribute("upload",upload);
        }else{
            String imgtype = "";
            if(upload.equals("png") || upload.equals("PNG")){
                imgtype = ".png";
            }else if(upload.equals("jpeg") || upload.equals("JPEG")){
                imgtype = ".jpeg";
            }else{
                imgtype = ".jpg";
            }
            upload=sss.get().getAid_picture();
            String [] token = upload.split("\\.");
            upload = token[0]+imgtype;
            session.setAttribute("upload",upload);
        }if(sexchoice == null || year == null || month == null || graduation == null || classifcation == null ){
            PersonalDataDto informationDto = new PersonalDataDto(seq,sss00.get().getStudentfakeseq(), userName, userBirthday, 99, userPhone, postalCode,
                    Address, detailAdd, guardian, parental,homephone , parentalphone, adminparental, adminphone, upload,
                    scName, 0, scphone, sido, sigungu, 0, 0, 99, 99);
            informationService.save(informationDto);
        }else{
            PersonalDataDto informationDto = new PersonalDataDto(seq,sss00.get().getStudentfakeseq(), userName, userBirthday, sexchoice, userPhone, postalCode,
                    Address, detailAdd, guardian, parental,homephone , parentalphone, adminparental, adminphone, upload,
                    scName, 0, scphone, sido, sigungu, year, month, graduation, classifcation);
            informationService.save(informationDto);
        }
        return "Modify/Modify1 :: Success";
    }

    @GetMapping("/modify1")
    public String Modify1(Model model, HttpSession session, HttpServletRequest request) {
        String returnValue = "";
            Optional<PersonalDataEntity> PersonalDataEntityes = personalDataRepository.findById((Long) session.getAttribute("percode"));
                session.setAttribute("myseq", PersonalDataEntityes.get().getAseq());
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
                returnValue = "Modify/Modify1.html";
        return returnValue;
    }

    @GetMapping("/modify2")
    public String Modify2(Model model, HttpSession session, HttpServletRequest request) {
        int type = (int) session.getAttribute("grade");
        if(type == 0){
            return "redirect:/modifygt1";
        }else if (type == 1){
            return "redirect:/modifygt2";
        }else{
            return "redirect:/modifygt3";
        }
    }

    @GetMapping("/modifygt1")
    public String modifygt1(HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<GradeType1DataEntity> sss = gradeType1DataRepository.findById(seq);
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);
        if(sss.isPresent()==false){
            GradeType1DataDto gradeType1TableDto = new GradeType1DataDto(seq,s10.get().getStudentfakeseq(),"","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택",0,0,0,0,4.5,4.5,0,0,0,0,0,4.5,4.5,0,0,0,0,0,4.5,4.5,0,0,0,0,0,0);
            gradetype1DataService.insertData1(gradeType1TableDto);
            sss = gradeType1DataRepository.findById(seq);
        }
        model.addAttribute("sss", sss);
        model.addAttribute("s1class",s1.get().getAclassification_type());
        model.addAttribute("fbd", sss.get().getFirstBehaviorDevelopment() - 4.5);
        model.addAttribute("sbd", sss.get().getSecondBehaviorDevelopment() - 4.5);
        model.addAttribute("tbd", sss.get().getThirdBehaviorDevelopment() - 4.5);
        model.addAttribute("fea", sss.get().getFirstExpActivities() - 4.5);
        model.addAttribute("sea", sss.get().getSecondExpActivities() - 4.5);
        model.addAttribute("tea", sss.get().getThirdExpActivities() - 4.5);
        return "Modify/gradeType1Modify.html";
    }

    @GetMapping("/modifygt2")
    public String modifygt2(HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<GradeType2DataEntity> sss = gradeType2DataRepository.findById(seq);
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);

        if(sss.isPresent()==false){
            GradeType2DataDto gradeType2TableDto = new GradeType2DataDto(seq,s10.get().getStudentfakeseq(),"",0,0,0,"선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택","선택",0,0,0,0,4.5,4.5,0,0,0,0,0,4.5,4.5,0,0,0,0,0,4.5,4.5,0,0,0,0,0,0);
            gradetype2DataService.insertData2(gradeType2TableDto);
            sss = gradeType2DataRepository.findById(seq);
        }
        model.addAttribute("sss", sss);
        model.addAttribute("s1class",s1.get().getAclassification_type());
        model.addAttribute("fbd", sss.get().getFirstBehaviorDevelopment() - 4.5);
        model.addAttribute("sbd", sss.get().getSecondBehaviorDevelopment() - 4.5);
        model.addAttribute("tbd", sss.get().getThirdBehaviorDevelopment() - 4.5);
        model.addAttribute("fea", sss.get().getFirstExpActivities() - 4.5);
        model.addAttribute("sea", sss.get().getSecondExpActivities() - 4.5);
        model.addAttribute("tea", sss.get().getThirdExpActivities() - 4.5);
        return "Modify/gradeType2Modify.html";
    }

    @GetMapping("/modifygt3")
    public String Modifygt3(HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Long seq = (Long) session.getAttribute("percode");
        Optional<GradeType3DataEntity> sss = gradeType3DataRepository.findById(seq);
        Optional<PersonalDataEntity> s1 = personalDataRepository.findById(seq);
        Optional<StudentfakeseqEntity> s10 = studentfakeseqRepository.findBySseq(seq);

        if(sss.isPresent()==false){
            GradeType3DataDto gradeType3TableDto = new GradeType3DataDto(seq,s10.get().getStudentfakeseq(),"",0,0,0);
            gradetype3DataService.insertData3(gradeType3TableDto);
            sss = gradeType3DataRepository.findById(seq);
        }
        model.addAttribute("sss", sss);
        model.addAttribute("s1class",s1.get().getAclassification_type());
        return "Modify/gradeType3Modify.html";
    }



}
