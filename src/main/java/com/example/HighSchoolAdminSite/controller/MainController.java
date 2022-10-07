package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.service.LoginService;
import lombok.AllArgsConstructor;
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
public class MainController {
    private LoginService loginService;

    @GetMapping("/")
    public String moveLogin(Model m, HttpServletRequest request){
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            returnValue = "dashboard";
        }else{
            returnValue = "login.html";
        }
        return returnValue;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "userlogin")
    public HashMap<String, String> userlogin(@RequestParam(required = false, defaultValue = "", value = "userid") String userid,
                                             @RequestParam(required = false, defaultValue = "", value = "userpw") String userpw,
                                             HttpServletRequest request){
        HttpSession session = request.getSession();
        HashMap<String, String> msg = new HashMap<String, String>();
//        try {
//            userpw = encrypt(userpw);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        int loginResult = loginService.loginAdmin(userid, userpw);
        if(loginResult == 1){
            //로그인성공
            msg.put("loginResult", "1");
            session.setAttribute("user_signature", userid);
        }else{
            //로그인실패
            msg.put("loginResult", "0");
        }
        return msg;
    }

    @GetMapping("/logout")
    public String logout(Model m, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    //암호화
    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        return bytesToHex(md.digest());
    }
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
