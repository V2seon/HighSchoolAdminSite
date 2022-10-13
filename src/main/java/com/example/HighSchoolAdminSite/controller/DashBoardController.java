package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping
public class DashBoardController {
    private StudentService studentService;

    @GetMapping("/dashboard")
    public String moveLogin(Model m, HttpServletRequest request){
        int cnt17th = 0;
        int cnt18th = 0;
        int cnt19th = 0;
        int cnt20th = 0;
        int cntTotal = 0;
        String returnValue = "";
//        if(new SessionCheck().loginSessionCheck(request)){
//            returnValue = "dashboard";
//        }else{
//            returnValue = "login.html";
//        }
        // 17일 가입자수 가져오기
        cnt17th = Math.toIntExact(studentService.get17thUserCount());
        // 18일 가입자수 가져오기
        cnt18th = Math.toIntExact(studentService.get18thUserCount());
        // 19일 가입자수 가져오기
        cnt19th = Math.toIntExact(studentService.get19thUserCount());
        // 20일 가입자수 가져오기
        cnt20th = Math.toIntExact(studentService.get20thUserCount());
        // 전체 가입자수 가져오기
        cntTotal = cnt17th + cnt18th + cnt19th + cnt20th;

        System.out.println("17 : " + cnt17th);
        System.out.println("18 : " + cnt18th);
        System.out.println("19 : " + cnt19th);
        System.out.println("20 : " + cnt20th);
        System.out.println("total : " + cntTotal);

        m.addAttribute("cnt17th", cnt17th);
        m.addAttribute("cnt18th", cnt18th);
        m.addAttribute("cnt19th", cnt19th);
        m.addAttribute("cnt20th", cnt20th);
        m.addAttribute("cntTotal", cntTotal);
        returnValue = "dashboard/DailyStatus.html";
        return returnValue;
    }
}
