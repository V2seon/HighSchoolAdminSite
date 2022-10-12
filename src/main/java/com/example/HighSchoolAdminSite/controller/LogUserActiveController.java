package com.example.HighSchoolAdminSite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class LogUserActiveController {
//
//    @GetMapping("/main_day")
//    public String moveMain(Model model, HttpServletRequest request,
//                           @RequestParam(required = false, defaultValue = "", value = "local_year") String local_year,
//                           @RequestParam(required = false, defaultValue = "", value = "local_month") String local_month,
//                           @RequestParam(required = false, defaultValue = "", value = "local_day") String local_day) {
//
//        String returnValue = "";
//        int year = 0;
//        int month = 0;
//        int day = 0;
//        int localweekNum = 0;
//        int localdayNum = 0;
//        String local_my_day = null;
//        String finaldyaname = null;
//        String dayname = "";
//        Date now = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String now_dt = null;
//        if (new SessionCheck().loginSessionCheck(request)) {
//            if (local_year.equals("") && local_month.equals("") && local_day.equals("")) {
//                LocalDateTime nowtime = LocalDateTime.now();
//                year = Integer.parseInt(String.valueOf(nowtime.getYear()));
//                month = Integer.parseInt(String.valueOf(nowtime.getMonthValue()));
//                day = Integer.parseInt(String.valueOf(nowtime.getDayOfMonth()));
//
//                dayname = null;
//                System.out.println("로컬 현재 년 : " + year);
//                System.out.println("로컬 현재 달 : " + month);
////            System.out.println("로컬 현재 요일 : " + dayOfWeek);
//
//                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//                String localstrDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(nowtime);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                String formatedNow = nowtime.format(formatter);
//                Date Localdate = null;
//                try {
//                    Localdate = formatter2.parse(localstrDate);
//                } catch (ParseException e) {
//                }
//                Localdate = new Date(Localdate.getTime() + (1000 * 60 * 60 * 24 - 1));
//                Calendar cal2 = Calendar.getInstance();
//                cal2.setFirstDayOfWeek(Calendar.MONDAY);
//                cal2.get(Calendar.WEEK_OF_YEAR);
//                cal2.setTime(Localdate);
//                localweekNum = cal2.get(Calendar.WEEK_OF_MONTH);
//                localdayNum = cal2.get(Calendar.DAY_OF_WEEK);
//
//                System.out.println("로컬 몇주차 : " + localweekNum);
//                System.out.println("로컬 몇요일 : " + localdayNum);
//                if (localdayNum == 1) {
//                    dayname = "일";
//                } else if (localdayNum == 2) {
//                    dayname = "월";
//                } else if (localdayNum == 3) {
//                    dayname = "화";
//                } else if (localdayNum == 4) {
//                    dayname = "수";
//                } else if (localdayNum == 5) {
//                    dayname = "목";
//                } else if (localdayNum == 6) {
//                    dayname = "금";
//                } else if (localdayNum == 7) {
//                    dayname = "토";
//                }
//                finaldyaname = formatedNow + "(" + dayname + ")";
//                now_dt = format.format(now);
//            } else {
//                year = Integer.parseInt(local_year);
//                month = Integer.parseInt(local_month);
//                day = Integer.parseInt(local_day);
//
//                now_dt = local_year + "-" + local_month + "-" + local_day;
//
//                LocalDate date = LocalDate.of(year, month, day);
//                DayOfWeek dayOfWeek = date.getDayOfWeek();
//                localdayNum = dayOfWeek.getValue();
//
//                if (localdayNum == 1) {
//                    dayname = "월";
//                } else if (localdayNum == 2) {
//                    dayname = "화";
//                } else if (localdayNum == 3) {
//                    dayname = "수";
//                } else if (localdayNum == 4) {
//                    dayname = "목";
//                } else if (localdayNum == 5) {
//                    dayname = "금";
//                } else if (localdayNum == 6) {
//                    dayname = "토";
//                } else if (localdayNum == 7) {
//                    dayname = "일";
//                }
//                finaldyaname = now_dt + "(" + dayname + ")";
//            }
//
//
//            System.out.println("오늘 며칠? : " + finaldyaname);
//            System.out.println("현재 년 : " + year);
//            System.out.println("현재 달 : " + month);
//            List<LogUserActiveEntity> logUserActiveEntities = logUserActiveService.list(String.valueOf(year), String.valueOf(month));
//            System.out.println(logUserActiveEntities.size());
//
//            int new_users_count_today = 0;
//            int app_run_count_today = 0;
//            int treasurehunt_count_today = 0;
//            int detecting_count_today = 0;
//
//            int hakeijung_panel = 0;
//            int mangwoljung_panel = 0;
//            int boojo5 = 0;
//            int hongsalmoon = 0;
//            int sungcheon = 0;
//            int cheonjamoon = 0;
//            int boojo1 = 0;
//            int susinjeong = 0;
//            int choizimongbi = 0;
//            int jeonghwabee = 0;
//            int noraebee = 0;
//            int mangwujeong = 0;
//            int moonsanjae = 0;
//            int moonsanjae_panel = 0;
//            int baekjemoon = 0;
//            int bongseondae = 0;
//            int boojo2 = 0;
//            int boojo3 = 0;
//            int boojo4 = 0;
//            int boojo6 = 0;
//            int sangdaepo = 0;
//            int sojeongsuseokjeonsigwan_panel = 0;
//            int sinseontaeguek = 0;
//            int aehyangsuseok = 0;
//            int yangsajae = 0;
//            int yeongwolgwan = 0;
//            int yeongwolbee = 0;
//            int wanginrock = 0;
//            int wanginsadang = 0;
//            int wanginmyobi = 0;
//            int wanginstatue = 0;
//            int wangin_stonestatue_real = 0;
//            int wanginhakdang = 0;
//            int wolakru = 0;
//            int yuheobi = 0;
//            int jaemyeongdang = 0;
//            int jaemyeongdangpanel = 0;
//            int junhongsuseokjeonsigwan_panel = 0;
//            int cheonjamoon_step = 0;
//            int hakeijung = 0;
//            int hakeimoon = 0;
//
//            //전시물 내부 변수
//            int wangin_drawing8 = 0;
//            int wangin_drawing3 = 0;
//            int wangin_smallstatue2 = 0;
//            int gusegwaneum = 0;
//            int wangin_kwanumsang = 0;
//            int wangin_threebuddha = 0;
//            int danji = 0;
//            int geumdongjegwanmo = 0;
//            int wangin_goldcrown = 0;
//            int wangin_stonestatue1 = 0;
//            int wangin_drawing2 = 0;
//            int wangin_baekjemodel = 0;
//
//            //AR 애니메이션 사용 변수
//            int one = 0; //왕인탄생
//            int two = 0; //학문수학
//            int three = 0; //초빙의례
//            int four = 0; //도일행차
//            int five = 0; //도일출항
//
//
////            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////            Date now = new Date();
////            String now_dt = format.format(now);
//
//            for (int i = 0; i < logUserActiveEntities.size(); i++) {
//
//                if (logUserActiveEntities.get(i).getLuaType() == 0 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    new_users_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 1 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    app_run_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 2 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    treasurehunt_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 3 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    detecting_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 0 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    new_users_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 1 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    app_run_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 2 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    treasurehunt_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 3 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    detecting_count_today++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32001 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    hakeijung_panel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32002 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    mangwoljung_panel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32003 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo5++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32004 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    hongsalmoon++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32005 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    sungcheon++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32006 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    cheonjamoon++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32007 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo1++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32008 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    susinjeong++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32009 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    choizimongbi++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32010 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    jeonghwabee++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32011 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    noraebee++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32012 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    mangwujeong++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32013 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    moonsanjae++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32014 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    moonsanjae_panel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32015 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    baekjemoon++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32016 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    bongseondae++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32017 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo2++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32018 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo3++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32019 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo4++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32020 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    boojo6++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32021 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    sangdaepo++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32022 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    sojeongsuseokjeonsigwan_panel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32023 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    sinseontaeguek++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32024 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    aehyangsuseok++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32025 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    yangsajae++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32026 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    yeongwolgwan++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32027 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    yeongwolbee++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32028 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wanginrock++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32029 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wanginsadang++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32030 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wanginmyobi++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32031 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wanginstatue++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32032 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_stonestatue_real++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32033 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wanginhakdang++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32034 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wolakru++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32035 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    yuheobi++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32036 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    jaemyeongdang++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32037 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    jaemyeongdangpanel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32038 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    junhongsuseokjeonsigwan_panel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32039 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    cheonjamoon_step++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32040 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    hakeijung++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 32041 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    hakeimoon++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31001 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_drawing8++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31002 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_drawing3++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31003 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_smallstatue2++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31004 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    gusegwaneum++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31005 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_kwanumsang++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31006 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_threebuddha++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31007 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    danji++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31008 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    geumdongjegwanmo++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31009 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_goldcrown++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31010 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_stonestatue1++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31011 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_drawing2++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 31012 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    wangin_baekjemodel++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 5001 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    one++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 5002 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    two++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 5003 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    three++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 5004 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    four++;
//                } else if (logUserActiveEntities.get(i).getLuaType() == 5005 && DateTimeFormatter.ofPattern("yyyy-MM-dd").format(logUserActiveEntities.get(i).getLuaDatetime()).equals(now_dt)) {
//                    five++;
//                }
//            }
//            model.addAttribute("new_users_count_today", new_users_count_today);
//            model.addAttribute("app_run_count_today", app_run_count_today);
//            model.addAttribute("treasurehunt_count_today", treasurehunt_count_today);
//            model.addAttribute("detecting_count_today", detecting_count_today);
//
//            model.addAttribute("one", one);
//            model.addAttribute("two", two);
//            model.addAttribute("three", three);
//            model.addAttribute("four", four);
//            model.addAttribute("five", five);
//
//            model.addAttribute("hakeijung_panel", hakeijung_panel);
//            model.addAttribute("mangwoljung_panel", mangwoljung_panel);
//            model.addAttribute("boojo5", boojo5);
//            model.addAttribute("hongsalmoon", hongsalmoon);
//            model.addAttribute("sungcheon", sungcheon);
//            model.addAttribute("cheonjamoon", cheonjamoon);
//            model.addAttribute("boojo1", boojo1);
//            model.addAttribute("susinjeong", susinjeong);
//            model.addAttribute("choizimongbi", choizimongbi);
//            model.addAttribute("jeonghwabee", jeonghwabee);
//            model.addAttribute("noraebee", noraebee);
//            model.addAttribute("mangwujeong", mangwujeong);
//            model.addAttribute("moonsanjae", moonsanjae);
//            model.addAttribute("moonsanjae_panel", moonsanjae_panel);
//            model.addAttribute("baekjemoon", baekjemoon);
//            model.addAttribute("bongseondae", bongseondae);
//            model.addAttribute("boojo2", boojo2);
//            model.addAttribute("boojo3", boojo3);
//            model.addAttribute("boojo4", boojo4);
//            model.addAttribute("boojo6", boojo6);
//            model.addAttribute("sangdaepo", sangdaepo);
//            model.addAttribute("sojeongsuseokjeonsigwan_panel", sojeongsuseokjeonsigwan_panel);
//            model.addAttribute("sinseontaeguek", sinseontaeguek);
//            model.addAttribute("aehyangsuseok", aehyangsuseok);
//            model.addAttribute("yangsajae", yangsajae);
//            model.addAttribute("yeongwolgwan", yeongwolgwan);
//            model.addAttribute("yeongwolbee", yeongwolbee);
//            model.addAttribute("wanginrock", wanginrock);
//            model.addAttribute("wanginsadang", wanginsadang);
//            model.addAttribute("wanginmyobi", wanginmyobi);
//            model.addAttribute("wanginstatue", wanginstatue);
//            model.addAttribute("wangin_stonestatue_real", wangin_stonestatue_real);
//            model.addAttribute("wanginhakdang", wanginhakdang);
//            model.addAttribute("wolakru", wolakru);
//            model.addAttribute("yuheobi", yuheobi);
//            model.addAttribute("jaemyeongdang", jaemyeongdang);
//            model.addAttribute("jaemyeongdangpanel", jaemyeongdangpanel);
//            model.addAttribute("junhongsuseokjeonsigwan_panel", junhongsuseokjeonsigwan_panel);
//            model.addAttribute("cheonjamoon_step", cheonjamoon_step);
//            model.addAttribute("hakeijung", hakeijung);
//            model.addAttribute("hakeimoon", hakeimoon);
//
//            model.addAttribute("wangin_drawing8", wangin_drawing8);
//            model.addAttribute("wangin_drawing3", wangin_drawing3);
//            model.addAttribute("wangin_smallstatue2", wangin_smallstatue2);
//            model.addAttribute("gusegwaneum", gusegwaneum);
//            model.addAttribute("wangin_kwanumsang", wangin_kwanumsang);
//            model.addAttribute("wangin_threebuddha", wangin_threebuddha);
//            model.addAttribute("danji", danji);
//            model.addAttribute("geumdongjegwanmo", geumdongjegwanmo);
//            model.addAttribute("wangin_goldcrown", wangin_goldcrown);
//            model.addAttribute("wangin_stonestatue1", wangin_stonestatue1);
//            model.addAttribute("wangin_drawing2", wangin_drawing2);
//            model.addAttribute("wangin_baekjemodel", wangin_baekjemodel);
//
//            model.addAttribute("finaldyaname", finaldyaname);
//            model.addAttribute("mydays",year+"/"+month+"/"+day);
//            model.addAttribute("month", month);
//            model.addAttribute("nowurl0", "/log");
//            model.addAttribute("nowurl1", "/main_day");
//            returnValue = "dashboard";
//        } else {
//            returnValue = "redirect:/";
//        }
//        return returnValue;
//    }
//
//    @GetMapping("/main_week")
//    public String moveMain_week(Model model, HttpServletRequest request,
//                                @RequestParam(required = false, defaultValue = "", value = "local_year") String local_year,
//                                @RequestParam(required = false, defaultValue = "", value = "local_month") String local_month,
//                                @RequestParam(required = false, defaultValue = "", value = "local_week") String local_week) {
//        String returnValue = "";
//        int year = 0;
//        int month = 0;
//        int localweekNum = 0;
//        int localdayNum = 0;
//
//        if (new SessionCheck().loginSessionCheck(request)) {
//
//            if (local_year.equals("") && local_month.equals("") && local_week.equals("")) {
//                LocalDateTime nowtime = LocalDateTime.now();
//                year = Integer.parseInt(String.valueOf(nowtime.getYear()));
//                month = Integer.parseInt(String.valueOf(nowtime.getMonthValue()));
////                int dayOfWeek = nowtime.getDayOfWeek().getValue();
//                System.out.println("로컬 현재 년 : " + year);
//                System.out.println("로컬 현재 달 : " + month);
////            System.out.println("로컬 현재 요일 : " + dayOfWeek);
//
//                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//                String localstrDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(nowtime);
//                Date Localdate = null;
//                try {
//                    Localdate = formatter2.parse(localstrDate);
//                } catch (ParseException e) {
//                }
//                Localdate = new Date(Localdate.getTime() + (1000 * 60 * 60 * 24 - 1));
//                Calendar cal2 = Calendar.getInstance();
//                cal2.setFirstDayOfWeek(Calendar.MONDAY);
//                cal2.get(Calendar.WEEK_OF_YEAR);
//                cal2.setTime(Localdate);
//                localweekNum = cal2.get(Calendar.WEEK_OF_MONTH);
//                localdayNum = cal2.get(Calendar.DAY_OF_WEEK);
//
//                System.out.println("로컬 몇주차 : " + localweekNum);
//                System.out.println("로컬 몇요일 : " + localdayNum);
//            } else {
//                year = Integer.parseInt(local_year);
//                month = Integer.parseInt(local_month);
//                localweekNum = Integer.parseInt(local_week);
//            }
//
//////////////////////////////////외부시설물 전역변수////////////////////////////////
//
//            Map<String, Integer> hakeijung_panel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                hakeijung_panel.put("hakeijung_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> mangwoljung_panel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                mangwoljung_panel.put("mangwoljung_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo5 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo5.put("boojo5" + (i + 1), 0);
//            }
//            Map<String, Integer> hongsalmoon = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                hongsalmoon.put("hongsalmoon" + (i + 1), 0);
//            }
//            Map<String, Integer> sungcheon = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                sungcheon.put("sungcheon" + (i + 1), 0);
//            }
//            Map<String, Integer> cheonjamoon = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                cheonjamoon.put("cheonjamoon" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo1 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo1.put("boojo1" + (i + 1), 0);
//            }
//            Map<String, Integer> susinjeong = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                susinjeong.put("susinjeong" + (i + 1), 0);
//            }
//            Map<String, Integer> choizimongbi = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                choizimongbi.put("choizimongbi" + (i + 1), 0);
//            }
//            Map<String, Integer> jeonghwabee = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                jeonghwabee.put("jeonghwabee" + (i + 1), 0);
//            }
//            Map<String, Integer> noraebee = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                noraebee.put("noraebee" + (i + 1), 0);
//            }
//            Map<String, Integer> mangwujeong = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                mangwujeong.put("mangwujeong" + (i + 1), 0);
//            }
//            Map<String, Integer> moonsanjae = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                moonsanjae.put("moonsanjae" + (i + 1), 0);
//            }
//            Map<String, Integer> moonsanjae_panel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                moonsanjae_panel.put("moonsanjae_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> baekjemoon = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                baekjemoon.put("baekjemoon" + (i + 1), 0);
//            }
//            Map<String, Integer> bongseondae = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                bongseondae.put("bongseondae" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo2 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo2.put("boojo2" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo3 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo3.put("boojo3" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo4 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo4.put("boojo4" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo6 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                boojo6.put("boojo6" + (i + 1), 0);
//            }
//            Map<String, Integer> sangdaepo = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                sangdaepo.put("sangdaepo" + (i + 1), 0);
//            }
//            Map<String, Integer> sojeongsuseokjeonsigwan_panel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> sinseontaeguek = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                sinseontaeguek.put("sinseontaeguek" + (i + 1), 0);
//            }
//            Map<String, Integer> aehyangsuseok = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                aehyangsuseok.put("aehyangsuseok" + (i + 1), 0);
//            }
//            Map<String, Integer> yangsajae = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                yangsajae.put("yangsajae" + (i + 1), 0);
//            }
//            Map<String, Integer> yeongwolgwan = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                yeongwolgwan.put("yeongwolgwan" + (i + 1), 0);
//            }
//            Map<String, Integer> yeongwolbee = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                yeongwolbee.put("yeongwolbee" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginrock = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wanginrock.put("wanginrock" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginsadang = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wanginsadang.put("wanginsadang" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginmyobi = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wanginmyobi.put("wanginmyobi" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginstatue = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wanginstatue.put("wanginstatue" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_stonestatue_real = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_stonestatue_real.put("wangin_stonestatue_real" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginhakdang = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wanginhakdang.put("wanginhakdang" + (i + 1), 0);
//            }
//            Map<String, Integer> wolakru = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wolakru.put("wolakru" + (i + 1), 0);
//            }
//            Map<String, Integer> yuheobi = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                yuheobi.put("yuheobi" + (i + 1), 0);
//            }
//            Map<String, Integer> jaemyeongdang = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                jaemyeongdang.put("jaemyeongdang" + (i + 1), 0);
//            }
//            Map<String, Integer> jaemyeongdangpanel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                jaemyeongdangpanel.put("jaemyeongdangpanel" + (i + 1), 0);
//            }
//            Map<String, Integer> junhongsuseokjeonsigwan_panel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> cheonjamoon_step = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                cheonjamoon_step.put("cheonjamoon_step" + (i + 1), 0);
//            }
//            Map<String, Integer> hakeijung = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                hakeijung.put("hakeijung" + (i + 1), 0);
//            }
//            Map<String, Integer> hakeimoon = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                hakeimoon.put("hakeimoon" + (i + 1), 0);
//            }
//            ////////////////////////////////외부시설물 전역변수////////////////////////////////
//
//            // 차트 전용 전역 변수
//
//            Map<String, Integer> new_ = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                new_.put("new_" + (i + 1), 0);
//            }
//            Map<String, Integer> user_ = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                user_.put("user_" + (i + 1), 0);
//            }
//            Map<String, Integer> tresurehunt_ = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                tresurehunt_.put("tresurehunt_" + (i + 1), 0);
//            }
//            int[] newcharts = new int[7];
//            int[] usercharts = new int[7];
//            int[] treasurehuntcharts = new int[7];
//
//            ////////////////////////////////내부시설물 전역변수////////////////////////////////
//
//            Map<String, Integer> wangin_drawing8 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_drawing8.put("wangin_drawing8" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_drawing3 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_drawing3.put("wangin_drawing3" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_smallstatue2 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_smallstatue2.put("wangin_smallstatue2" + (i + 1), 0);
//            }
//            Map<String, Integer> gusegwaneum = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                gusegwaneum.put("gusegwaneum" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_kwanumsang = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_kwanumsang.put("wangin_kwanumsang" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_threebuddha = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_threebuddha.put("wangin_threebuddha" + (i + 1), 0);
//            }
//            Map<String, Integer> danji = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                danji.put("danji" + (i + 1), 0);
//            }
//            Map<String, Integer> geumdongjegwanmo = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                geumdongjegwanmo.put("geumdongjegwanmo" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_goldcrown = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_goldcrown.put("wangin_goldcrown" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_stonestatue1 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_stonestatue1.put("wangin_stonestatue1" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_drawing2 = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_drawing2.put("wangin_drawing2" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_baekjemodel = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                wangin_baekjemodel.put("wangin_baekjemodel" + (i + 1), 0);
//            }
//
//            ////////////////////////////////내부시설물 전역변수////////////////////////////////
//
//            ////////////////////////////////애니메이션 전역변수////////////////////////////////
//
//            Map<String, Integer> one = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                one.put("one" + (i + 1), 0);
//            }
//            Map<String, Integer> two = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                two.put("two" + (i + 1), 0);
//            }
//            Map<String, Integer> three = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                three.put("three" + (i + 1), 0);
//            }
//            Map<String, Integer> four = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                four.put("four" + (i + 1), 0);
//            }
//            Map<String, Integer> five = new HashMap<>();
//            for (int i = 0; i < 7; i++) {
//                five.put("five" + (i + 1), 0);
//            }
//            ////////////////////////////////애니메이션 전역변수////////////////////////////////
//
//            List<LogUserActiveEntity> weekseries = logUserActiveService.list(String.valueOf(year), String.valueOf(month));
//            System.out.println("날짜 사이즈 : " + weekseries.size());
//
//            for (int i = 0; i < weekseries.size(); i++) {
//
//                //--------------특정일의 요일을 돌려주는 함수 ----------
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = null;
//
//                // 특정 날짜 입력하는곳 . 함수로 사용시 인자로 받으면 됨.
//                String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(weekseries.get(i).getLuaDatetime());
//                System.out.println("일단 데이터 다 가져오기 " + strDate);
//
//                try {
//                    date = formatter.parse(strDate);
//                } catch (ParseException e) {
//                }
//                date = new Date(date.getTime() + (1000 * 60 * 60 * 24 - 1));
//
//                Calendar cal = Calendar.getInstance();
//                cal.setFirstDayOfWeek(Calendar.MONDAY);
//                cal.get(Calendar.WEEK_OF_YEAR);
//                cal.setTime(date);
//
//                //각각의 원하는 데이터를 얻어 온다.
////                int custom_year = Calendar.getInstance().get(Calendar.YEAR);
////                int month_name = Calendar.getInstance().get(month);
////                int my_month_name = cal.get(Calendar.MONTH)+1;
//                int weekNum = cal.get(Calendar.WEEK_OF_MONTH); // 해당달의 주차가 몇 주차인지 구한다.
//                int dayNum = cal.get(Calendar.DAY_OF_WEEK); // 요일을 구한다.
//                Long users_type = weekseries.get(i).getLuaType();
//
//                //출력해서 결과를 알아 본다.
////                System.out.println("DB해당 년도 : " + custom_year);
////                System.out.println("DB몇월 : " + month_name);
////                System.out.println("DB해당 월의 주차 : " + weekNum);
////                System.out.println("DB요일 : " + dayNum);
////                System.out.println("DB로그 타입 : " + weekseries.get(i).getLuaType());
//
////////////////////////////////////////////////   여기서 부터는 차트 전용   //////////////////////////////////////////////
//                if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("0")) {
//                    new_.put("new_1", new_.get("new_1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("0")) {
//                    new_.put("new_2", new_.get("new_2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("0")) {
//                    new_.put("new_3", new_.get("new_3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("0")) {
//                    new_.put("new_4", new_.get("new_4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("0")) {
//                    new_.put("new_5", new_.get("new_5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("0")) {
//                    new_.put("new_6", new_.get("new_6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("0")) {
//                    new_.put("new_7", new_.get("new_7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("1")) {
//                    user_.put("user_1", user_.get("user_1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("1")) {
//                    user_.put("user_2", user_.get("user_2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("1")) {
//                    user_.put("user_3", user_.get("user_3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("1")) {
//                    user_.put("user_4", user_.get("user_4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("1")) {
//                    user_.put("user_5", user_.get("user_5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("1")) {
//                    user_.put("user_6", user_.get("user_6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("1")) {
//                    user_.put("user_7", user_.get("user_7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_1", tresurehunt_.get("tresurehunt_1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_2", tresurehunt_.get("tresurehunt_2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_3", tresurehunt_.get("tresurehunt_3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_4", tresurehunt_.get("tresurehunt_4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_5", tresurehunt_.get("tresurehunt_5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_6", tresurehunt_.get("tresurehunt_6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_7", tresurehunt_.get("tresurehunt_7") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 외부 전시물   //////////////////////////////////////////////
//                else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel1", hakeijung_panel.get("hakeijung_panel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel2", hakeijung_panel.get("hakeijung_panel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel3", hakeijung_panel.get("hakeijung_panel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel4", hakeijung_panel.get("hakeijung_panel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel5", hakeijung_panel.get("hakeijung_panel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel6", hakeijung_panel.get("hakeijung_panel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel7", hakeijung_panel.get("hakeijung_panel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel1", mangwoljung_panel.get("mangwoljung_panel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel2", mangwoljung_panel.get("mangwoljung_panel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel3", mangwoljung_panel.get("mangwoljung_panel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel4", mangwoljung_panel.get("mangwoljung_panel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel5", mangwoljung_panel.get("mangwoljung_panel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel6", mangwoljung_panel.get("mangwoljung_panel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel7", mangwoljung_panel.get("mangwoljung_panel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo51", boojo5.get("boojo51") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo52", boojo5.get("boojo52") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo53", boojo5.get("boojo53") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo54", boojo5.get("boojo54") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo55", boojo5.get("boojo55") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo56", boojo5.get("boojo56") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo57", boojo5.get("boojo57") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon1", hongsalmoon.get("hongsalmoon1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon2", hongsalmoon.get("hongsalmoon2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon3", hongsalmoon.get("hongsalmoon3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon4", hongsalmoon.get("hongsalmoon4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon5", hongsalmoon.get("hongsalmoon5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon6", hongsalmoon.get("hongsalmoon6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon7", hongsalmoon.get("hongsalmoon7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon1", sungcheon.get("sungcheon1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon2", sungcheon.get("sungcheon2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon3", sungcheon.get("sungcheon3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon4", sungcheon.get("sungcheon4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon5", sungcheon.get("sungcheon5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon6", sungcheon.get("sungcheon6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon7", sungcheon.get("sungcheon7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon1", cheonjamoon.get("cheonjamoon1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon2", cheonjamoon.get("cheonjamoon2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon3", cheonjamoon.get("cheonjamoon3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon4", cheonjamoon.get("cheonjamoon4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon5", cheonjamoon.get("cheonjamoon5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon6", cheonjamoon.get("cheonjamoon6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon7", cheonjamoon.get("cheonjamoon7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo11", boojo1.get("boojo11") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo12", boojo1.get("boojo12") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo13", boojo1.get("boojo13") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo14", boojo1.get("boojo14") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo15", boojo1.get("boojo15") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo16", boojo1.get("boojo16") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo17", boojo1.get("boojo17") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong1", susinjeong.get("susinjeong1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong2", susinjeong.get("susinjeong2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong3", susinjeong.get("susinjeong3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong4", susinjeong.get("susinjeong4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong5", susinjeong.get("susinjeong5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong6", susinjeong.get("susinjeong6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong7", susinjeong.get("susinjeong7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi1", choizimongbi.get("choizimongbi1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi2", choizimongbi.get("choizimongbi2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi3", choizimongbi.get("choizimongbi3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi4", choizimongbi.get("choizimongbi4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi5", choizimongbi.get("choizimongbi5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi6", choizimongbi.get("choizimongbi6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi7", choizimongbi.get("choizimongbi7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee1", jeonghwabee.get("jeonghwabee1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee2", jeonghwabee.get("jeonghwabee2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee3", jeonghwabee.get("jeonghwabee3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee4", jeonghwabee.get("jeonghwabee4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee5", jeonghwabee.get("jeonghwabee5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee6", jeonghwabee.get("jeonghwabee6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee7", jeonghwabee.get("jeonghwabee7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee1", noraebee.get("noraebee1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee2", noraebee.get("noraebee2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee3", noraebee.get("noraebee3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee4", noraebee.get("noraebee4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee5", noraebee.get("noraebee5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee6", noraebee.get("noraebee6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee7", noraebee.get("noraebee7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong1", mangwujeong.get("mangwujeong1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong2", mangwujeong.get("mangwujeong2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong3", mangwujeong.get("mangwujeong3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong4", mangwujeong.get("mangwujeong4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong5", mangwujeong.get("mangwujeong5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong6", mangwujeong.get("mangwujeong6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong7", mangwujeong.get("mangwujeong7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae1", moonsanjae.get("moonsanjae1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae2", moonsanjae.get("moonsanjae2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae3", moonsanjae.get("moonsanjae3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae4", moonsanjae.get("moonsanjae4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae5", moonsanjae.get("moonsanjae5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae6", moonsanjae.get("moonsanjae6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae7", moonsanjae.get("moonsanjae7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel1", moonsanjae_panel.get("moonsanjae_panel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel2", moonsanjae_panel.get("moonsanjae_panel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel3", moonsanjae_panel.get("moonsanjae_panel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel4", moonsanjae_panel.get("moonsanjae_panel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel5", moonsanjae_panel.get("moonsanjae_panel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel6", moonsanjae_panel.get("moonsanjae_panel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel7", moonsanjae_panel.get("moonsanjae_panel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon1", baekjemoon.get("baekjemoon1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon2", baekjemoon.get("baekjemoon2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon3", baekjemoon.get("baekjemoon3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon4", baekjemoon.get("baekjemoon4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon5", baekjemoon.get("baekjemoon5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon6", baekjemoon.get("baekjemoon6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon7", baekjemoon.get("baekjemoon7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae1", bongseondae.get("bongseondae1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae2", bongseondae.get("2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae3", bongseondae.get("bongseondae3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae4", bongseondae.get("bongseondae4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae5", bongseondae.get("bongseondae5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae6", bongseondae.get("bongseondae6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae7", bongseondae.get("bongseondae7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo21", boojo2.get("boojo21") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo22", boojo2.get("boojo22") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo23", boojo2.get("boojo23") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo24", boojo2.get("boojo24") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo25", boojo2.get("boojo25") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo26", boojo2.get("boojo26") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo27", boojo2.get("boojo27") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo31", boojo3.get("boojo31") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo32", boojo3.get("boojo32") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo33", boojo3.get("boojo33") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo34", boojo3.get("boojo34") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo35", boojo3.get("boojo35") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo36", boojo3.get("boojo36") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo37", boojo3.get("boojo37") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo41", boojo4.get("boojo41") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo42", boojo4.get("boojo42") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo43", boojo4.get("boojo43") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo44", boojo4.get("boojo44") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo45", boojo4.get("boojo45") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo46", boojo4.get("boojo46") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo47", boojo4.get("boojo47") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo61", boojo6.get("boojo61") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo62", boojo6.get("boojo62") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo63", boojo6.get("boojo63") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo64", boojo6.get("boojo64") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo65", boojo6.get("boojo65") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo66", boojo6.get("boojo66") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo67", boojo6.get("boojo67") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo1", sangdaepo.get("sangdaepo1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo2", sangdaepo.get("sangdaepo2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo3", sangdaepo.get("sangdaepo3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo4", sangdaepo.get("sangdaepo4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo5", sangdaepo.get("sangdaepo5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo6", sangdaepo.get("sangdaepo6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo7", sangdaepo.get("sangdaepo7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel1", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel2", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel3", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel4", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel5", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel6", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel7", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek1", sinseontaeguek.get("sinseontaeguek1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek2", sinseontaeguek.get("sinseontaeguek2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek3", sinseontaeguek.get("sinseontaeguek3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek4", sinseontaeguek.get("sinseontaeguek4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek5", sinseontaeguek.get("sinseontaeguek5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek6", sinseontaeguek.get("sinseontaeguek6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek7", sinseontaeguek.get("sinseontaeguek7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok1", aehyangsuseok.get("aehyangsuseok1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok2", aehyangsuseok.get("aehyangsuseok2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok3", aehyangsuseok.get("aehyangsuseok3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok4", aehyangsuseok.get("aehyangsuseok4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok5", aehyangsuseok.get("aehyangsuseok5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok6", aehyangsuseok.get("aehyangsuseok6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok7", aehyangsuseok.get("aehyangsuseok7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae1", yangsajae.get("yangsajae1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae2", yangsajae.get("yangsajae2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae3", yangsajae.get("yangsajae3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae4", yangsajae.get("yangsajae4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae5", yangsajae.get("yangsajae5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae6", yangsajae.get("yangsajae6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae7", yangsajae.get("yangsajae7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan1", yeongwolgwan.get("yeongwolgwan1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan2", yeongwolgwan.get("yeongwolgwan2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan3", yeongwolgwan.get("yeongwolgwan3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan4", yeongwolgwan.get("yeongwolgwan4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan5", yeongwolgwan.get("yeongwolgwan5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan6", yeongwolgwan.get("yeongwolgwan6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan7", yeongwolgwan.get("yeongwolgwan7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee1", yeongwolbee.get("yeongwolbee1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee2", yeongwolbee.get("yeongwolbee2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee3", yeongwolbee.get("yeongwolbee3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee4", yeongwolbee.get("yeongwolbee4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee5", yeongwolbee.get("yeongwolbee5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee6", yeongwolbee.get("yeongwolbee6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee7", yeongwolbee.get("yeongwolbee7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock1", wanginrock.get("wanginrock1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock2", wanginrock.get("wanginrock2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock3", wanginrock.get("wanginrock3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock4", wanginrock.get("wanginrock4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock5", wanginrock.get("wanginrock5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock6", wanginrock.get("wanginrock6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock7", wanginrock.get("wanginrock7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang1", wanginsadang.get("wanginsadang1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang2", wanginsadang.get("wanginsadang2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang3", wanginsadang.get("wanginsadang3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang4", wanginsadang.get("wanginsadang4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang5", wanginsadang.get("wanginsadang5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang6", wanginsadang.get("wanginsadang6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang7", wanginsadang.get("wanginsadang7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi1", wanginmyobi.get("wanginmyobi1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi2", wanginmyobi.get("wanginmyobi2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi3", wanginmyobi.get("wanginmyobi3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi4", wanginmyobi.get("wanginmyobi4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi5", wanginmyobi.get("wanginmyobi5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi6", wanginmyobi.get("wanginmyobi6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi7", wanginmyobi.get("wanginmyobi7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue1", wanginstatue.get("wanginstatue1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue2", wanginstatue.get("wanginstatue2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue3", wanginstatue.get("wanginstatue3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue4", wanginstatue.get("wanginstatue4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue5", wanginstatue.get("wanginstatue5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue6", wanginstatue.get("wanginstatue6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue7", wanginstatue.get("wanginstatue7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real1", wangin_stonestatue_real.get("wangin_stonestatue_real1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real2", wangin_stonestatue_real.get("wangin_stonestatue_real2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real3", wangin_stonestatue_real.get("wangin_stonestatue_real3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real4", wangin_stonestatue_real.get("wangin_stonestatue_real4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real5", wangin_stonestatue_real.get("wangin_stonestatue_real5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real6", wangin_stonestatue_real.get("wangin_stonestatue_real6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real7", wangin_stonestatue_real.get("wangin_stonestatue_real7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang1", wanginhakdang.get("wanginhakdang1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang2", wanginhakdang.get("wanginhakdang2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang3", wanginhakdang.get("wanginhakdang3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang4", wanginhakdang.get("wanginhakdang4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang5", wanginhakdang.get("wanginhakdang5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang6", wanginhakdang.get("wanginhakdang6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang7", wanginhakdang.get("wanginhakdang7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru1", wolakru.get("wolakru1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru2", wolakru.get("wolakru2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru3", wolakru.get("wolakru3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru4", wolakru.get("wolakru4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru5", wolakru.get("wolakru5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru6", wolakru.get("wolakru6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru7", wolakru.get("wolakru7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi1", yuheobi.get("yuheobi1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi2", yuheobi.get("yuheobi2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi3", yuheobi.get("yuheobi3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi4", yuheobi.get("yuheobi4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi5", yuheobi.get("yuheobi5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi6", yuheobi.get("yuheobi6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi7", yuheobi.get("yuheobi7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang1", jaemyeongdang.get("jaemyeongdang1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang2", jaemyeongdang.get("jaemyeongdang2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang3", jaemyeongdang.get("jaemyeongdang3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang4", jaemyeongdang.get("jaemyeongdang4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang5", jaemyeongdang.get("jaemyeongdang5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang6", jaemyeongdang.get("jaemyeongdang6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang7", jaemyeongdang.get("jaemyeongdang7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel1", jaemyeongdangpanel.get("jaemyeongdangpanel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel2", jaemyeongdangpanel.get("jaemyeongdangpanel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel3", jaemyeongdangpanel.get("jaemyeongdangpanel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel4", jaemyeongdangpanel.get("jaemyeongdangpanel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel5", jaemyeongdangpanel.get("jaemyeongdangpanel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel6", jaemyeongdangpanel.get("jaemyeongdangpanel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel7", jaemyeongdangpanel.get("jaemyeongdangpanel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel1", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel2", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel3", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel4", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel5", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel6", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel7", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step1", cheonjamoon_step.get("cheonjamoon_step1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step2", cheonjamoon_step.get("cheonjamoon_step2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step3", cheonjamoon_step.get("cheonjamoon_step3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step4", cheonjamoon_step.get("cheonjamoon_step4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step5", cheonjamoon_step.get("cheonjamoon_step5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step6", cheonjamoon_step.get("cheonjamoon_step6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step7", cheonjamoon_step.get("cheonjamoon_step7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung1", hakeijung.get("hakeijung1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung2", hakeijung.get("hakeijung2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung3", hakeijung.get("hakeijung3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung4", hakeijung.get("hakeijung4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung5", hakeijung.get("hakeijung5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung6", hakeijung.get("hakeijung6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung7", hakeijung.get("hakeijung7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon1", hakeimoon.get("hakeimoon1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon2", hakeimoon.get("hakeimoon2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon3", hakeimoon.get("hakeimoon3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon4", hakeimoon.get("hakeimoon4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon5", hakeimoon.get("hakeimoon5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon6", hakeimoon.get("hakeimoon6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon7", hakeimoon.get("hakeimoon7") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 내부 전시물   //////////////////////////////////////////////
//                else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing81", wangin_drawing8.get("wangin_drawing81") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing82", wangin_drawing8.get("wangin_drawing82") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing83", wangin_drawing8.get("wangin_drawing83") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing84", wangin_drawing8.get("wangin_drawing84") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing85", wangin_drawing8.get("wangin_drawing85") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing86", wangin_drawing8.get("wangin_drawing86") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing87", wangin_drawing8.get("wangin_drawing87") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing31", wangin_drawing3.get("wangin_drawing31") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing32", wangin_drawing3.get("wangin_drawing32") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing33", wangin_drawing3.get("wangin_drawing33") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing34", wangin_drawing3.get("wangin_drawing34") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing35", wangin_drawing3.get("wangin_drawing35") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing36", wangin_drawing3.get("wangin_drawing36") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing37", wangin_drawing3.get("wangin_drawing37") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue21", wangin_smallstatue2.get("wangin_smallstatue21") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue22", wangin_smallstatue2.get("wangin_smallstatue22") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue23", wangin_smallstatue2.get("wangin_smallstatue23") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue24", wangin_smallstatue2.get("wangin_smallstatue24") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue25", wangin_smallstatue2.get("wangin_smallstatue25") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue26", wangin_smallstatue2.get("wangin_smallstatue26") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue27", wangin_smallstatue2.get("wangin_smallstatue27") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum1", gusegwaneum.get("gusegwaneum1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum2", gusegwaneum.get("gusegwaneum2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum3", gusegwaneum.get("gusegwaneum3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum4", gusegwaneum.get("gusegwaneum4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum5", gusegwaneum.get("gusegwaneum5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum6", gusegwaneum.get("gusegwaneum6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum7", gusegwaneum.get("gusegwaneum7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang1", wangin_kwanumsang.get("wangin_kwanumsang1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang2", wangin_kwanumsang.get("wangin_kwanumsang2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang3", wangin_kwanumsang.get("wangin_kwanumsang3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang4", wangin_kwanumsang.get("wangin_kwanumsang4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang5", wangin_kwanumsang.get("wangin_kwanumsang5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang6", wangin_kwanumsang.get("wangin_kwanumsang6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang7", wangin_kwanumsang.get("wangin_kwanumsang7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha1", wangin_threebuddha.get("wangin_threebuddha1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha2", wangin_threebuddha.get("wangin_threebuddha2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha3", wangin_threebuddha.get("wangin_threebuddha3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha4", wangin_threebuddha.get("wangin_threebuddha4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha5", wangin_threebuddha.get("wangin_threebuddha5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha6", wangin_threebuddha.get("wangin_threebuddha6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha7", wangin_threebuddha.get("wangin_threebuddha7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31007")) {
//                    danji.put("danji1", danji.get("danji1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31007")) {
//                    danji.put("danji2", danji.get("danji2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31007")) {
//                    danji.put("danji3", danji.get("danji3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31007")) {
//                    danji.put("danji4", danji.get("danji4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31007")) {
//                    danji.put("danji5", danji.get("danji5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31007")) {
//                    danji.put("danji6", danji.get("danji6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31007")) {
//                    danji.put("danji7", danji.get("danji7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo1", geumdongjegwanmo.get("geumdongjegwanmo1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo2", geumdongjegwanmo.get("geumdongjegwanmo2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo3", geumdongjegwanmo.get("geumdongjegwanmo3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo4", geumdongjegwanmo.get("geumdongjegwanmo4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo5", geumdongjegwanmo.get("geumdongjegwanmo5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo6", geumdongjegwanmo.get("geumdongjegwanmo6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo7", geumdongjegwanmo.get("geumdongjegwanmo7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown1", wangin_goldcrown.get("wangin_goldcrown1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown2", wangin_goldcrown.get("wangin_goldcrown2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown3", wangin_goldcrown.get("wangin_goldcrown3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown4", wangin_goldcrown.get("wangin_goldcrown4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown5", wangin_goldcrown.get("wangin_goldcrown5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown6", wangin_goldcrown.get("wangin_goldcrown6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown7", wangin_goldcrown.get("wangin_goldcrown7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue11", wangin_stonestatue1.get("wangin_stonestatue11") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue12", wangin_stonestatue1.get("wangin_stonestatue12") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue13", wangin_stonestatue1.get("wangin_stonestatue13") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue14", wangin_stonestatue1.get("wangin_stonestatue14") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue15", wangin_stonestatue1.get("wangin_stonestatue15") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue16", wangin_stonestatue1.get("wangin_stonestatue16") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue17", wangin_stonestatue1.get("wangin_stonestatue17") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing21", wangin_drawing2.get("wangin_drawing21") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing22", wangin_drawing2.get("wangin_drawing22") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing23", wangin_drawing2.get("wangin_drawing23") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing24", wangin_drawing2.get("wangin_drawing24") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing25", wangin_drawing2.get("wangin_drawing25") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing26", wangin_drawing2.get("wangin_drawing26") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing27", wangin_drawing2.get("wangin_drawing27") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel1", wangin_baekjemodel.get("wangin_baekjemodel1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel2", wangin_baekjemodel.get("wangin_baekjemodel2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel3", wangin_baekjemodel.get("wangin_baekjemodel3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel4", wangin_baekjemodel.get("wangin_baekjemodel4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel5", wangin_baekjemodel.get("wangin_baekjemodel5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel6", wangin_baekjemodel.get("wangin_baekjemodel6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel7", wangin_baekjemodel.get("wangin_baekjemodel7") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 애니메이션   //////////////////////////////////////////////
//                else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("5001")) {
//                    one.put("one1", one.get("one1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("5001")) {
//                    one.put("one2", one.get("one2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("5001")) {
//                    one.put("one3", one.get("one3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("5001")) {
//                    one.put("one4", one.get("one4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("5001")) {
//                    one.put("one5", one.get("one5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("5001")) {
//                    one.put("one6", one.get("one6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("5001")) {
//                    one.put("one7", one.get("one7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("5002")) {
//                    two.put("two1", two.get("two1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("5002")) {
//                    two.put("two2", two.get("two2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("5002")) {
//                    two.put("two3", two.get("two3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("5002")) {
//                    two.put("two4", two.get("two4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("5002")) {
//                    two.put("two5", two.get("two5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("5002")) {
//                    two.put("two6", two.get("two6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("5002")) {
//                    two.put("two7", two.get("two7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("5003")) {
//                    three.put("three1", three.get("three1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("5003")) {
//                    three.put("three2", three.get("three2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("5003")) {
//                    three.put("three3", three.get("three3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("5003")) {
//                    three.put("three4", three.get("three4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("5003")) {
//                    three.put("three5", three.get("three5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("5003")) {
//                    three.put("three6", three.get("three6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("5003")) {
//                    three.put("three7", three.get("three7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("5004")) {
//                    four.put("four1", four.get("four1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("5004")) {
//                    four.put("four2", four.get("four2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("5004")) {
//                    four.put("four3", four.get("four3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("5004")) {
//                    four.put("four4", four.get("four4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("5004")) {
//                    four.put("four5", four.get("four5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("5004")) {
//                    four.put("four6", four.get("four6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("5004")) {
//                    four.put("four7", four.get("four7") + 1);
//                } else if (localweekNum == weekNum && dayNum == 1 && users_type.toString().equals("5005")) {
//                    five.put("five1", five.get("five1") + 1);
//                } else if (localweekNum == weekNum && dayNum == 2 && users_type.toString().equals("5005")) {
//                    five.put("five2", five.get("five2") + 1);
//                } else if (localweekNum == weekNum && dayNum == 3 && users_type.toString().equals("5005")) {
//                    five.put("five3", five.get("five3") + 1);
//                } else if (localweekNum == weekNum && dayNum == 4 && users_type.toString().equals("5005")) {
//                    five.put("five4", five.get("five4") + 1);
//                } else if (localweekNum == weekNum && dayNum == 5 && users_type.toString().equals("5005")) {
//                    five.put("five5", five.get("five5") + 1);
//                } else if (localweekNum == weekNum && dayNum == 6 && users_type.toString().equals("5005")) {
//                    five.put("five6", five.get("five6") + 1);
//                } else if (localweekNum == weekNum && dayNum == 7 && users_type.toString().equals("5005")) {
//                    five.put("five7", five.get("five7") + 1);
//                }
//            }
//
//            newcharts[0] = new_.get("new_2");
//            newcharts[1] = new_.get("new_3");
//            newcharts[2] = new_.get("new_4");
//            newcharts[3] = new_.get("new_5");
//            newcharts[4] = new_.get("new_6");
//            newcharts[5] = new_.get("new_7");
//            newcharts[6] = new_.get("new_1");
//
//            usercharts[0] = user_.get("user_2");
//            usercharts[1] = user_.get("user_3");
//            usercharts[2] = user_.get("user_4");
//            usercharts[3] = user_.get("user_5");
//            usercharts[4] = user_.get("user_6");
//            usercharts[5] = user_.get("user_7");
//            usercharts[6] = user_.get("user_1");
//
//            treasurehuntcharts[0] = tresurehunt_.get("tresurehunt_2");
//            treasurehuntcharts[1] = tresurehunt_.get("tresurehunt_3");
//            treasurehuntcharts[2] = tresurehunt_.get("tresurehunt_4");
//            treasurehuntcharts[3] = tresurehunt_.get("tresurehunt_5");
//            treasurehuntcharts[4] = tresurehunt_.get("tresurehunt_6");
//            treasurehuntcharts[5] = tresurehunt_.get("tresurehunt_7");
//            treasurehuntcharts[6] = tresurehunt_.get("tresurehunt_1");
//
//            model.addAttribute("newcharts", newcharts);
//            model.addAttribute("usercharts", usercharts);
//            model.addAttribute("treasurehuntcharts", treasurehuntcharts);
//
//            for (int i = 0; i < 7; i++) {
//                //////////////////////////////////////////////   여기서 부터는 외부 전시물   //////////////////////////////////////////////
//                model.addAttribute("hakeijung_panel" + (i + 1), hakeijung_panel.get("hakeijung_panel" + (i + 1)));
//                model.addAttribute("mangwoljung_panel" + (i + 1), mangwoljung_panel.get("mangwoljung_panel" + (i + 1)));
//                model.addAttribute("boojo5" + (i + 1), boojo5.get("boojo5" + (i + 1)));
//                model.addAttribute("hongsalmoon" + (i + 1), hongsalmoon.get("hongsalmoon" + (i + 1)));
//                model.addAttribute("sungcheon" + (i + 1), sungcheon.get("sungcheon" + (i + 1)));
//                model.addAttribute("cheonjamoon" + (i + 1), cheonjamoon.get("cheonjamoon" + (i + 1)));
//                model.addAttribute("boojo1" + (i + 1), boojo1.get("boojo1" + (i + 1)));
//                model.addAttribute("susinjeong" + (i + 1), susinjeong.get("susinjeong" + (i + 1)));
//                model.addAttribute("choizimongbi" + (i + 1), choizimongbi.get("choizimongbi" + (i + 1)));
//                model.addAttribute("jeonghwabee" + (i + 1), jeonghwabee.get("jeonghwabee" + (i + 1)));
//                model.addAttribute("noraebee" + (i + 1), noraebee.get("noraebee" + (i + 1)));
//                model.addAttribute("mangwujeong" + (i + 1), mangwujeong.get("mangwujeong" + (i + 1)));
//                model.addAttribute("moonsanjae" + (i + 1), moonsanjae.get("moonsanjae" + (i + 1)));
//                model.addAttribute("moonsanjae_panel" + (i + 1), moonsanjae_panel.get("moonsanjae_panel" + (i + 1)));
//                model.addAttribute("baekjemoon" + (i + 1), baekjemoon.get("baekjemoon" + (i + 1)));
//                model.addAttribute("bongseondae" + (i + 1), bongseondae.get("bongseondae" + (i + 1)));
//                model.addAttribute("boojo2" + (i + 1), boojo2.get("boojo2" + (i + 1)));
//                model.addAttribute("boojo3" + (i + 1), boojo3.get("boojo3" + (i + 1)));
//                model.addAttribute("boojo4" + (i + 1), boojo4.get("boojo4" + (i + 1)));
//                model.addAttribute("boojo6" + (i + 1), boojo6.get("boojo6" + (i + 1)));
//                model.addAttribute("sangdaepo" + (i + 1), sangdaepo.get("sangdaepo" + (i + 1)));
//                model.addAttribute("sojeongsuseokjeonsigwan_panel" + (i + 1), sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel" + (i + 1)));
//                model.addAttribute("sinseontaeguek" + (i + 1), sinseontaeguek.get("sinseontaeguek" + (i + 1)));
//                model.addAttribute("aehyangsuseok" + (i + 1), aehyangsuseok.get("aehyangsuseok" + (i + 1)));
//                model.addAttribute("yangsajae" + (i + 1), yangsajae.get("yangsajae" + (i + 1)));
//                model.addAttribute("yeongwolgwan" + (i + 1), yeongwolgwan.get("yeongwolgwan" + (i + 1)));
//                model.addAttribute("yeongwolbee" + (i + 1), yeongwolbee.get("yeongwolbee" + (i + 1)));
//                model.addAttribute("wanginrock" + (i + 1), wanginrock.get("wanginrock" + (i + 1)));
//                model.addAttribute("wanginsadang" + (i + 1), wanginsadang.get("wanginsadang" + (i + 1)));
//                model.addAttribute("wanginmyobi" + (i + 1), wanginmyobi.get("wanginmyobi" + (i + 1)));
//                model.addAttribute("wanginstatue" + (i + 1), wanginstatue.get("wanginstatue" + (i + 1)));
//                model.addAttribute("wangin_stonestatue_real" + (i + 1), wangin_stonestatue_real.get("wangin_stonestatue_real" + (i + 1)));
//                model.addAttribute("wanginhakdang" + (i + 1), wanginhakdang.get("wanginhakdang" + (i + 1)));
//                model.addAttribute("wolakru" + (i + 1), wolakru.get("wolakru" + (i + 1)));
//                model.addAttribute("yuheobi" + (i + 1), yuheobi.get("yuheobi" + (i + 1)));
//                model.addAttribute("jaemyeongdang" + (i + 1), jaemyeongdang.get("jaemyeongdang" + (i + 1)));
//                model.addAttribute("jaemyeongdangpanel" + (i + 1), jaemyeongdangpanel.get("jaemyeongdangpanel" + (i + 1)));
//                model.addAttribute("junhongsuseokjeonsigwan_panel" + (i + 1), junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel" + (i + 1)));
//                model.addAttribute("cheonjamoon_step" + (i + 1), cheonjamoon_step.get("cheonjamoon_step" + (i + 1)));
//                model.addAttribute("hakeijung" + (i + 1), hakeijung.get("hakeijung" + (i + 1)));
//                model.addAttribute("hakeimoon" + (i + 1), hakeimoon.get("hakeimoon" + (i + 1)));
//                //////////////////////////////////////////////   여기서 부터는 내부 전시물   //////////////////////////////////////////////
//                model.addAttribute("wangin_drawing8" + (i + 1), wangin_drawing8.get("wangin_drawing8" + (i + 1)));
//                model.addAttribute("wangin_drawing3" + (i + 1), wangin_drawing3.get("wangin_drawing3" + (i + 1)));
//                model.addAttribute("wangin_smallstatue2" + (i + 1), wangin_smallstatue2.get("wangin_smallstatue2" + (i + 1)));
//                model.addAttribute("gusegwaneum" + (i + 1), gusegwaneum.get("gusegwaneum" + (i + 1)));
//                model.addAttribute("wangin_kwanumsang" + (i + 1), wangin_kwanumsang.get("wangin_kwanumsang" + (i + 1)));
//                model.addAttribute("wangin_threebuddha" + (i + 1), wangin_threebuddha.get("wangin_threebuddha" + (i + 1)));
//                model.addAttribute("danji" + (i + 1), danji.get("danji" + (i + 1)));
//                model.addAttribute("geumdongjegwanmo" + (i + 1), geumdongjegwanmo.get("geumdongjegwanmo" + (i + 1)));
//                model.addAttribute("wangin_goldcrown" + (i + 1), wangin_goldcrown.get("wangin_goldcrown" + (i + 1)));
//                model.addAttribute("wangin_stonestatue1" + (i + 1), wangin_stonestatue1.get("wangin_stonestatue1" + (i + 1)));
//                model.addAttribute("wangin_drawing2" + (i + 1), wangin_drawing2.get("wangin_drawing2" + (i + 1)));
//                model.addAttribute("wangin_baekjemodel" + (i + 1), wangin_baekjemodel.get("wangin_baekjemodel" + (i + 1)));
//                //////////////////////////////////////////////   여기서 부터는 애니메이션   //////////////////////////////////////////////
//                model.addAttribute("one" + (i + 1), one.get("one" + (i + 1)));
//                model.addAttribute("two" + (i + 1), two.get("two" + (i + 1)));
//                model.addAttribute("three" + (i + 1), three.get("three" + (i + 1)));
//                model.addAttribute("four" + (i + 1), four.get("four" + (i + 1)));
//                model.addAttribute("five" + (i + 1), five.get("five" + (i + 1)));
//            }
//
////////////////////////////////////////////////   끝   //////////////////////////////////////////////
//            model.addAttribute("weekname", year + "년 " + month + "월 " + localweekNum + "주차");
//            model.addAttribute("weekname2", year + "/" + month);
//            model.addAttribute("weeknumber", localweekNum);
//            model.addAttribute("nowurl0", "/log");
//            model.addAttribute("nowurl1", "/main_week");
//            returnValue = "dashboard2";
//        } else {
//            returnValue = "redirect:/";
//        }
//        return returnValue;
//    }
//
//    @GetMapping("/main_month")
//    public String moveMain_month(Model model, HttpServletRequest request,
//                                 @RequestParam(required = false, defaultValue = "", value = "local_year") String local_year,
//                                 @RequestParam(required = false, defaultValue = "", value = "local_year2") String local_year2) {
//        String returnValue = "";
//        int year = 0;
//        int year2 = 0;
//        System.out.println("year2 " + year2);
//
//        if (new SessionCheck().loginSessionCheck(request)) {
//
//            if (local_year.equals("") && local_year2.equals("")) {
//                LocalDateTime nowtime = LocalDateTime.now();
//                year = Integer.parseInt(String.valueOf(nowtime.getYear()));
//            } else {
//                year = Integer.parseInt(local_year);
//                year2 = Integer.parseInt(local_year2);
//            }
//
//////////////////////////////////외부시설물 전역변수//////////////////////////////// 주 단위 계산 전용 변수
//
//            Map<String, Integer> hakeijung_panel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                hakeijung_panel.put("hakeijung_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> mangwoljung_panel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                mangwoljung_panel.put("mangwoljung_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo5 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo5.put("boojo5" + (i + 1), 0);
//            }
//            Map<String, Integer> hongsalmoon = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                hongsalmoon.put("hongsalmoon" + (i + 1), 0);
//            }
//            Map<String, Integer> sungcheon = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                sungcheon.put("sungcheon" + (i + 1), 0);
//            }
//            Map<String, Integer> cheonjamoon = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                cheonjamoon.put("cheonjamoon" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo1 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo1.put("boojo1" + (i + 1), 0);
//            }
//            Map<String, Integer> susinjeong = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                susinjeong.put("susinjeong" + (i + 1), 0);
//            }
//            Map<String, Integer> choizimongbi = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                choizimongbi.put("choizimongbi" + (i + 1), 0);
//            }
//            Map<String, Integer> jeonghwabee = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                jeonghwabee.put("jeonghwabee" + (i + 1), 0);
//            }
//            Map<String, Integer> noraebee = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                noraebee.put("noraebee" + (i + 1), 0);
//            }
//            Map<String, Integer> mangwujeong = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                mangwujeong.put("mangwujeong" + (i + 1), 0);
//            }
//            Map<String, Integer> moonsanjae = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                moonsanjae.put("moonsanjae" + (i + 1), 0);
//            }
//            Map<String, Integer> moonsanjae_panel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                moonsanjae_panel.put("moonsanjae_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> baekjemoon = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                baekjemoon.put("baekjemoon" + (i + 1), 0);
//            }
//            Map<String, Integer> bongseondae = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                bongseondae.put("bongseondae" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo2 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo2.put("boojo2" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo3 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo3.put("boojo3" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo4 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo4.put("boojo4" + (i + 1), 0);
//            }
//            Map<String, Integer> boojo6 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                boojo6.put("boojo6" + (i + 1), 0);
//            }
//            Map<String, Integer> sangdaepo = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                sangdaepo.put("sangdaepo" + (i + 1), 0);
//            }
//            Map<String, Integer> sojeongsuseokjeonsigwan_panel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> sinseontaeguek = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                sinseontaeguek.put("sinseontaeguek" + (i + 1), 0);
//            }
//            Map<String, Integer> aehyangsuseok = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                aehyangsuseok.put("aehyangsuseok" + (i + 1), 0);
//            }
//            Map<String, Integer> yangsajae = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                yangsajae.put("yangsajae" + (i + 1), 0);
//            }
//            Map<String, Integer> yeongwolgwan = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                yeongwolgwan.put("yeongwolgwan" + (i + 1), 0);
//            }
//            Map<String, Integer> yeongwolbee = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                yeongwolbee.put("yeongwolbee" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginrock = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wanginrock.put("wanginrock" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginsadang = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wanginsadang.put("wanginsadang" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginmyobi = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wanginmyobi.put("wanginmyobi" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginstatue = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wanginstatue.put("wanginstatue" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_stonestatue_real = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_stonestatue_real.put("wangin_stonestatue_real" + (i + 1), 0);
//            }
//            Map<String, Integer> wanginhakdang = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wanginhakdang.put("wanginhakdang" + (i + 1), 0);
//            }
//            Map<String, Integer> wolakru = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wolakru.put("wolakru" + (i + 1), 0);
//            }
//            Map<String, Integer> yuheobi = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                yuheobi.put("yuheobi" + (i + 1), 0);
//            }
//            Map<String, Integer> jaemyeongdang = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                jaemyeongdang.put("jaemyeongdang" + (i + 1), 0);
//            }
//            Map<String, Integer> jaemyeongdangpanel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                jaemyeongdangpanel.put("jaemyeongdangpanel" + (i + 1), 0);
//            }
//            Map<String, Integer> junhongsuseokjeonsigwan_panel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel" + (i + 1), 0);
//            }
//            Map<String, Integer> cheonjamoon_step = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                cheonjamoon_step.put("cheonjamoon_step" + (i + 1), 0);
//            }
//            Map<String, Integer> hakeijung = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                hakeijung.put("hakeijung" + (i + 1), 0);
//            }
//            Map<String, Integer> hakeimoon = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                hakeimoon.put("hakeimoon" + (i + 1), 0);
//            }
//
//            // 차트 전용 전역 변수
//
//            Map<String, Integer> new_ = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                new_.put("new_" + (i + 1), 0);
//            }
//            Map<String, Integer> user_ = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                user_.put("user_" + (i + 1), 0);
//            }
//            Map<String, Integer> tresurehunt_ = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                tresurehunt_.put("tresurehunt_" + (i + 1), 0);
//            }
//            int[] newcharts = new int[12];
//            int[] usercharts = new int[12];
//            int[] treasurehuntcharts = new int[12];
//
//            ////////////////////////////////내부시설물 전역변수////////////////////////////////
//
//            Map<String, Integer> wangin_drawing8 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_drawing8.put("wangin_drawing8" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_drawing3 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_drawing3.put("wangin_drawing3" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_smallstatue2 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_smallstatue2.put("wangin_smallstatue2" + (i + 1), 0);
//            }
//            Map<String, Integer> gusegwaneum = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                gusegwaneum.put("gusegwaneum" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_kwanumsang = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_kwanumsang.put("wangin_kwanumsang" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_threebuddha = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_threebuddha.put("wangin_threebuddha" + (i + 1), 0);
//            }
//            Map<String, Integer> danji = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                danji.put("danji" + (i + 1), 0);
//            }
//            Map<String, Integer> geumdongjegwanmo = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                geumdongjegwanmo.put("geumdongjegwanmo" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_goldcrown = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_goldcrown.put("wangin_goldcrown" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_stonestatue1 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_stonestatue1.put("wangin_stonestatue1" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_drawing2 = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_drawing2.put("wangin_drawing2" + (i + 1), 0);
//            }
//            Map<String, Integer> wangin_baekjemodel = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                wangin_baekjemodel.put("wangin_baekjemodel" + (i + 1), 0);
//            }
//
//            ////////////////////////////////애니메이션 전역변수////////////////////////////////
//
//            Map<String, Integer> one = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                one.put("one" + (i + 1), 0);
//            }
//            Map<String, Integer> two = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                two.put("two" + (i + 1), 0);
//            }
//            Map<String, Integer> three = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                three.put("three" + (i + 1), 0);
//            }
//            Map<String, Integer> four = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                four.put("four" + (i + 1), 0);
//            }
//            Map<String, Integer> five = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                five.put("five" + (i + 1), 0);
//            }
//            ////////////////////////////////애니메이션 전역변수////////////////////////////////
//
//            List<LogUserActiveEntity> weekseries = logUserActiveService.list_only_year(String.valueOf(year), String.valueOf(year2));
//            System.out.println("날짜 사이즈 : " + weekseries.size());
//            String length = String.valueOf(weekseries.size());
//
//            // 차트 계산 반복문
//            for (int i = 0; i < weekseries.size(); i++) {
//
//
//                //--------------특정일의 요일을 돌려주는 함수 ----------
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = null;
//
//                // 특정 날짜 입력하는곳 . 함수로 사용시 인자로 받으면 됨.
//                String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(weekseries.get(i).getLuaDatetime());
//                System.out.println("일단 데이터 다 가져오기 " + strDate);
//
//                try {
//                    date = formatter.parse(strDate);
//                } catch (ParseException e) {
//                }
//                date = new Date(date.getTime() + (1000 * 60 * 60 * 24 - 1));
//                Calendar cal = Calendar.getInstance();
////                cal.setFirstDayOfWeek(Calendar.MONDAY);
////                cal.get(Calendar.WEEK_OF_YEAR);
//                cal.setTime(date);
//
//                //각각의 원하는 데이터를 얻어 온다.
////                int custom_year = Calendar.getInstance().get(Calendar.YEAR);
//                int my_month_name = cal.get(Calendar.MONTH) + 1;
//                Long users_type = weekseries.get(i).getLuaType();
//
//                //출력해서 결과를 알아 본다.
////                System.out.println("DB해당 년도 : " + custom_year);
//                System.out.println("DB몇월 : " + my_month_name);
//                System.out.println("DB로그 타입 : " + weekseries.get(i).getLuaType());
//
//                //////////////////////////////////////////////   여기서 부터는 차트 전용   //////////////////////////////////////////////
//                if (my_month_name == 1 && users_type.toString().equals("0")) {
//                    new_.put("new_1", new_.get("new_1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("0")) {
//                    new_.put("new_2", new_.get("new_2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("0")) {
//                    new_.put("new_3", new_.get("new_3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("0")) {
//                    new_.put("new_4", new_.get("new_4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("0")) {
//                    new_.put("new_5", new_.get("new_5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("0")) {
//                    new_.put("new_6", new_.get("new_6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("0")) {
//                    new_.put("new_7", new_.get("new_7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("0")) {
//                    new_.put("new_8", new_.get("new_8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("0")) {
//                    new_.put("new_9", new_.get("new_9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("0")) {
//                    new_.put("new_10", new_.get("new_10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("0")) {
//                    new_.put("new_11", new_.get("new_11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("0")) {
//                    new_.put("new_12", new_.get("new_12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("1")) {
//                    user_.put("user_1", user_.get("user_1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("1")) {
//                    user_.put("user_2", user_.get("user_2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("1")) {
//                    user_.put("user_3", user_.get("user_3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("1")) {
//                    user_.put("user_4", user_.get("user_4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("1")) {
//                    user_.put("user_5", user_.get("user_5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("1")) {
//                    user_.put("user_6", user_.get("user_6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("1")) {
//                    user_.put("user_7", user_.get("user_7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("1")) {
//                    user_.put("user_8", user_.get("user_8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("1")) {
//                    user_.put("user_9", user_.get("user_9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("1")) {
//                    user_.put("user_10", user_.get("user_10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("1")) {
//                    user_.put("user_11", user_.get("user_11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("1")) {
//                    user_.put("user_12", user_.get("user_12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_1", tresurehunt_.get("tresurehunt_1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_2", tresurehunt_.get("tresurehunt_2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_3", tresurehunt_.get("tresurehunt_3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_4", tresurehunt_.get("tresurehunt_4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_5", tresurehunt_.get("tresurehunt_5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_6", tresurehunt_.get("tresurehunt_6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_7", tresurehunt_.get("tresurehunt_7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_8", tresurehunt_.get("tresurehunt_8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_9", tresurehunt_.get("tresurehunt_9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_10", tresurehunt_.get("tresurehunt_10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_11", tresurehunt_.get("tresurehunt_11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("2")) {
//                    tresurehunt_.put("tresurehunt_12", tresurehunt_.get("tresurehunt_12") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 외부 전시물   //////////////////////////////////////////////
//                else if (my_month_name == 1 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel1", hakeijung_panel.get("hakeijung_panel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel2", hakeijung_panel.get("hakeijung_panel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel3", hakeijung_panel.get("hakeijung_panel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel4", hakeijung_panel.get("hakeijung_panel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel5", hakeijung_panel.get("hakeijung_panel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel6", hakeijung_panel.get("hakeijung_panel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel7", hakeijung_panel.get("hakeijung_panel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel8", hakeijung_panel.get("hakeijung_panel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel9", hakeijung_panel.get("hakeijung_panel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel10", hakeijung_panel.get("hakeijung_panel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel11", hakeijung_panel.get("hakeijung_panel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32001")) {
//                    hakeijung_panel.put("hakeijung_panel12", hakeijung_panel.get("hakeijung_panel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel1", mangwoljung_panel.get("mangwoljung_panel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel2", mangwoljung_panel.get("mangwoljung_panel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel3", mangwoljung_panel.get("mangwoljung_panel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel4", mangwoljung_panel.get("mangwoljung_panel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel5", mangwoljung_panel.get("mangwoljung_panel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel6", mangwoljung_panel.get("mangwoljung_panel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel7", mangwoljung_panel.get("mangwoljung_panel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel8", mangwoljung_panel.get("mangwoljung_panel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel9", mangwoljung_panel.get("mangwoljung_panel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel10", mangwoljung_panel.get("mangwoljung_panel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel11", mangwoljung_panel.get("mangwoljung_panel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32002")) {
//                    mangwoljung_panel.put("mangwoljung_panel12", mangwoljung_panel.get("mangwoljung_panel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo51", boojo5.get("boojo51") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo52", boojo5.get("boojo52") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo53", boojo5.get("boojo53") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo54", boojo5.get("boojo54") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo55", boojo5.get("boojo55") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo56", boojo5.get("boojo56") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo57", boojo5.get("boojo57") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo58", boojo5.get("boojo58") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo59", boojo5.get("boojo59") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo510", boojo5.get("boojo510") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo511", boojo5.get("boojo511") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32003")) {
//                    boojo5.put("boojo512", boojo5.get("boojo512") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon1", hongsalmoon.get("hongsalmoon1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon2", hongsalmoon.get("hongsalmoon2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon3", hongsalmoon.get("hongsalmoon3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon4", hongsalmoon.get("hongsalmoon4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon5", hongsalmoon.get("hongsalmoon5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon6", hongsalmoon.get("hongsalmoon6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon7", hongsalmoon.get("hongsalmoon7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon8", hongsalmoon.get("hongsalmoon8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon9", hongsalmoon.get("hongsalmoon9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon10", hongsalmoon.get("hongsalmoon10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon11", hongsalmoon.get("hongsalmoon11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32004")) {
//                    hongsalmoon.put("hongsalmoon12", hongsalmoon.get("hongsalmoon12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon1", sungcheon.get("sungcheon1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon2", sungcheon.get("sungcheon2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon3", sungcheon.get("sungcheon3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon4", sungcheon.get("sungcheon4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon5", sungcheon.get("sungcheon5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon6", sungcheon.get("sungcheon6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon7", sungcheon.get("sungcheon7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon8", sungcheon.get("sungcheon8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon9", sungcheon.get("sungcheon9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon10", sungcheon.get("sungcheon10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon11", sungcheon.get("sungcheon11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32005")) {
//                    sungcheon.put("sungcheon12", sungcheon.get("sungcheon12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon1", cheonjamoon.get("cheonjamoon1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon2", cheonjamoon.get("cheonjamoon2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon3", cheonjamoon.get("cheonjamoon3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon4", cheonjamoon.get("cheonjamoon4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon5", cheonjamoon.get("cheonjamoon5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon6", cheonjamoon.get("cheonjamoon6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon7", cheonjamoon.get("cheonjamoon7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon8", cheonjamoon.get("cheonjamoon8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon9", cheonjamoon.get("cheonjamoon9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon10", cheonjamoon.get("cheonjamoon10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon11", cheonjamoon.get("cheonjamoon11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32006")) {
//                    cheonjamoon.put("cheonjamoon12", cheonjamoon.get("cheonjamoon12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo11", boojo1.get("boojo11") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo12", boojo1.get("boojo12") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo13", boojo1.get("boojo13") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo14", boojo1.get("boojo14") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo15", boojo1.get("boojo15") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo16", boojo1.get("boojo16") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo17", boojo1.get("boojo17") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo18", boojo1.get("boojo18") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo19", boojo1.get("boojo19") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo110", boojo1.get("boojo110") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo111", boojo1.get("boojo111") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32007")) {
//                    boojo1.put("boojo112", boojo1.get("boojo112") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong1", susinjeong.get("susinjeong1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong2", susinjeong.get("susinjeong2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong3", susinjeong.get("susinjeong3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong4", susinjeong.get("susinjeong4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong5", susinjeong.get("susinjeong5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong6", susinjeong.get("susinjeong6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong7", susinjeong.get("susinjeong7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong8", susinjeong.get("susinjeong8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong9", susinjeong.get("susinjeong9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong10", susinjeong.get("susinjeong10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong11", susinjeong.get("susinjeong11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32008")) {
//                    susinjeong.put("susinjeong12", susinjeong.get("susinjeong12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi1", choizimongbi.get("choizimongbi1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi2", choizimongbi.get("choizimongbi2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi3", choizimongbi.get("choizimongbi3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi4", choizimongbi.get("choizimongbi4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi5", choizimongbi.get("choizimongbi5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi6", choizimongbi.get("choizimongbi6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi7", choizimongbi.get("choizimongbi7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi8", choizimongbi.get("choizimongbi8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi9", choizimongbi.get("choizimongbi9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi10", choizimongbi.get("choizimongbi10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi11", choizimongbi.get("choizimongbi11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32009")) {
//                    choizimongbi.put("choizimongbi12", choizimongbi.get("choizimongbi12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee1", jeonghwabee.get("jeonghwabee1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee2", jeonghwabee.get("jeonghwabee2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee3", jeonghwabee.get("jeonghwabee3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee4", jeonghwabee.get("jeonghwabee4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee5", jeonghwabee.get("jeonghwabee5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee6", jeonghwabee.get("jeonghwabee6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee7", jeonghwabee.get("jeonghwabee7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee8", jeonghwabee.get("jeonghwabee8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee9", jeonghwabee.get("jeonghwabee9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee10", jeonghwabee.get("jeonghwabee10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee11", jeonghwabee.get("jeonghwabee11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32010")) {
//                    jeonghwabee.put("jeonghwabee12", jeonghwabee.get("jeonghwabee12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee1", noraebee.get("noraebee1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee2", noraebee.get("noraebee2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee3", noraebee.get("noraebee3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee4", noraebee.get("noraebee4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee5", noraebee.get("noraebee5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee6", noraebee.get("noraebee6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee7", noraebee.get("noraebee7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee8", noraebee.get("noraebee8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee9", noraebee.get("noraebee9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee10", noraebee.get("noraebee10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee11", noraebee.get("noraebee11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32011")) {
//                    noraebee.put("noraebee12", noraebee.get("noraebee12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong1", mangwujeong.get("mangwujeong1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong2", mangwujeong.get("mangwujeong2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong3", mangwujeong.get("mangwujeong3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong4", mangwujeong.get("mangwujeong4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong5", mangwujeong.get("mangwujeong5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong6", mangwujeong.get("mangwujeong6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong7", mangwujeong.get("mangwujeong7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong8", mangwujeong.get("mangwujeong8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong9", mangwujeong.get("mangwujeong9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong10", mangwujeong.get("mangwujeong10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong11", mangwujeong.get("mangwujeong11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32012")) {
//                    mangwujeong.put("mangwujeong12", mangwujeong.get("mangwujeong12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae1", moonsanjae.get("moonsanjae1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae2", moonsanjae.get("moonsanjae2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae3", moonsanjae.get("moonsanjae3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae4", moonsanjae.get("moonsanjae4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae5", moonsanjae.get("moonsanjae5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae6", moonsanjae.get("moonsanjae6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae7", moonsanjae.get("moonsanjae7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae8", moonsanjae.get("moonsanjae8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae9", moonsanjae.get("moonsanjae9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae10", moonsanjae.get("moonsanjae10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae11", moonsanjae.get("moonsanjae11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32013")) {
//                    moonsanjae.put("moonsanjae12", moonsanjae.get("moonsanjae12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel1", moonsanjae_panel.get("moonsanjae_panel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel2", moonsanjae_panel.get("moonsanjae_panel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel3", moonsanjae_panel.get("moonsanjae_panel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel4", moonsanjae_panel.get("moonsanjae_panel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel5", moonsanjae_panel.get("moonsanjae_panel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel6", moonsanjae_panel.get("moonsanjae_panel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel7", moonsanjae_panel.get("moonsanjae_panel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel8", moonsanjae_panel.get("moonsanjae_panel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel9", moonsanjae_panel.get("moonsanjae_panel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel10", moonsanjae_panel.get("moonsanjae_panel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel11", moonsanjae_panel.get("moonsanjae_panel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32014")) {
//                    moonsanjae_panel.put("moonsanjae_panel12", moonsanjae_panel.get("moonsanjae_panel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon1", baekjemoon.get("baekjemoon1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon2", baekjemoon.get("baekjemoon2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon3", baekjemoon.get("baekjemoon3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon4", baekjemoon.get("baekjemoon4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon5", baekjemoon.get("baekjemoon5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon6", baekjemoon.get("baekjemoon6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon7", baekjemoon.get("baekjemoon7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon8", baekjemoon.get("baekjemoon8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon9", baekjemoon.get("baekjemoon9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon10", baekjemoon.get("baekjemoon10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon11", baekjemoon.get("baekjemoon11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32015")) {
//                    baekjemoon.put("baekjemoon12", baekjemoon.get("baekjemoon12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae1", bongseondae.get("bongseondae1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae2", bongseondae.get("2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae3", bongseondae.get("bongseondae3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae4", bongseondae.get("bongseondae4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae5", bongseondae.get("bongseondae5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae6", bongseondae.get("bongseondae6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae7", bongseondae.get("bongseondae7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae8", bongseondae.get("bongseondae8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae9", bongseondae.get("bongseondae9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae10", bongseondae.get("bongseondae10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae11", bongseondae.get("bongseondae11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32016")) {
//                    bongseondae.put("bongseondae12", bongseondae.get("bongseondae12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo21", boojo2.get("boojo21") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo22", boojo2.get("boojo22") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo23", boojo2.get("boojo23") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo24", boojo2.get("boojo24") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo25", boojo2.get("boojo25") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo26", boojo2.get("boojo26") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo27", boojo2.get("boojo27") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo28", boojo2.get("boojo28") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo29", boojo2.get("boojo29") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo210", boojo2.get("boojo210") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo211", boojo2.get("boojo211") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32017")) {
//                    boojo2.put("boojo212", boojo2.get("boojo212") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo31", boojo3.get("boojo31") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo32", boojo3.get("boojo32") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo33", boojo3.get("boojo33") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo34", boojo3.get("boojo34") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo35", boojo3.get("boojo35") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo36", boojo3.get("boojo36") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo37", boojo3.get("boojo37") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo38", boojo3.get("boojo38") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo39", boojo3.get("boojo39") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo310", boojo3.get("boojo310") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo311", boojo3.get("boojo311") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32018")) {
//                    boojo3.put("boojo312", boojo3.get("boojo312") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo41", boojo4.get("boojo41") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo42", boojo4.get("boojo42") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo43", boojo4.get("boojo43") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo44", boojo4.get("boojo44") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo45", boojo4.get("boojo45") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo46", boojo4.get("boojo46") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo47", boojo4.get("boojo47") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo48", boojo4.get("boojo48") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo49", boojo4.get("boojo49") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo410", boojo4.get("boojo410") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo411", boojo4.get("boojo411") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32019")) {
//                    boojo4.put("boojo412", boojo4.get("boojo412") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo61", boojo6.get("boojo61") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo62", boojo6.get("boojo62") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo63", boojo6.get("boojo63") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo64", boojo6.get("boojo64") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo65", boojo6.get("boojo65") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo66", boojo6.get("boojo66") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo67", boojo6.get("boojo67") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo68", boojo6.get("boojo68") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo69", boojo6.get("boojo69") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo610", boojo6.get("boojo610") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo611", boojo6.get("boojo611") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32020")) {
//                    boojo6.put("boojo612", boojo6.get("boojo612") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo1", sangdaepo.get("sangdaepo1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo2", sangdaepo.get("sangdaepo2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo3", sangdaepo.get("sangdaepo3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo4", sangdaepo.get("sangdaepo4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo5", sangdaepo.get("sangdaepo5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo6", sangdaepo.get("sangdaepo6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo7", sangdaepo.get("sangdaepo7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo8", sangdaepo.get("sangdaepo8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo9", sangdaepo.get("sangdaepo9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo10", sangdaepo.get("sangdaepo10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo11", sangdaepo.get("sangdaepo11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32021")) {
//                    sangdaepo.put("sangdaepo12", sangdaepo.get("sangdaepo12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel1", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel2", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel3", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel4", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel5", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel6", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel7", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel8", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel9", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel10", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel11", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32022")) {
//                    sojeongsuseokjeonsigwan_panel.put("sojeongsuseokjeonsigwan_panel12", sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek1", sinseontaeguek.get("sinseontaeguek1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek2", sinseontaeguek.get("sinseontaeguek2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek3", sinseontaeguek.get("sinseontaeguek3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek4", sinseontaeguek.get("sinseontaeguek4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek5", sinseontaeguek.get("sinseontaeguek5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek6", sinseontaeguek.get("sinseontaeguek6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek7", sinseontaeguek.get("sinseontaeguek7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek8", sinseontaeguek.get("sinseontaeguek8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek9", sinseontaeguek.get("sinseontaeguek9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek10", sinseontaeguek.get("sinseontaeguek10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek11", sinseontaeguek.get("sinseontaeguek11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32023")) {
//                    sinseontaeguek.put("sinseontaeguek12", sinseontaeguek.get("sinseontaeguek12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok1", aehyangsuseok.get("aehyangsuseok1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok2", aehyangsuseok.get("aehyangsuseok2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok3", aehyangsuseok.get("aehyangsuseok3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok4", aehyangsuseok.get("aehyangsuseok4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok5", aehyangsuseok.get("aehyangsuseok5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok6", aehyangsuseok.get("aehyangsuseok6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok7", aehyangsuseok.get("aehyangsuseok7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok8", aehyangsuseok.get("aehyangsuseok8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok9", aehyangsuseok.get("aehyangsuseok9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok10", aehyangsuseok.get("aehyangsuseok10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok11", aehyangsuseok.get("aehyangsuseok11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32024")) {
//                    aehyangsuseok.put("aehyangsuseok12", aehyangsuseok.get("aehyangsuseok12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae1", yangsajae.get("yangsajae1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae2", yangsajae.get("yangsajae2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae3", yangsajae.get("yangsajae3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae4", yangsajae.get("yangsajae4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae5", yangsajae.get("yangsajae5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae6", yangsajae.get("yangsajae6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae7", yangsajae.get("yangsajae7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae8", yangsajae.get("yangsajae8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae9", yangsajae.get("yangsajae9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae10", yangsajae.get("yangsajae10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae11", yangsajae.get("yangsajae11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32025")) {
//                    yangsajae.put("yangsajae12", yangsajae.get("yangsajae12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan1", yeongwolgwan.get("yeongwolgwan1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan2", yeongwolgwan.get("yeongwolgwan2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan3", yeongwolgwan.get("yeongwolgwan3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan4", yeongwolgwan.get("yeongwolgwan4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan5", yeongwolgwan.get("yeongwolgwan5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan6", yeongwolgwan.get("yeongwolgwan6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan7", yeongwolgwan.get("yeongwolgwan7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan8", yeongwolgwan.get("yeongwolgwan8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan9", yeongwolgwan.get("yeongwolgwan9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan10", yeongwolgwan.get("yeongwolgwan10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan11", yeongwolgwan.get("yeongwolgwan11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32026")) {
//                    yeongwolgwan.put("yeongwolgwan12", yeongwolgwan.get("yeongwolgwan12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee1", yeongwolbee.get("yeongwolbee1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee2", yeongwolbee.get("yeongwolbee2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee3", yeongwolbee.get("yeongwolbee3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee4", yeongwolbee.get("yeongwolbee4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee5", yeongwolbee.get("yeongwolbee5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee6", yeongwolbee.get("yeongwolbee6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee7", yeongwolbee.get("yeongwolbee7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee8", yeongwolbee.get("yeongwolbee8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee9", yeongwolbee.get("yeongwolbee9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee10", yeongwolbee.get("yeongwolbee10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee11", yeongwolbee.get("yeongwolbee11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32027")) {
//                    yeongwolbee.put("yeongwolbee12", yeongwolbee.get("yeongwolbee12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock1", wanginrock.get("wanginrock1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock2", wanginrock.get("wanginrock2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock3", wanginrock.get("wanginrock3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock4", wanginrock.get("wanginrock4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock5", wanginrock.get("wanginrock5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock6", wanginrock.get("wanginrock6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock7", wanginrock.get("wanginrock7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock8", wanginrock.get("wanginrock8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock9", wanginrock.get("wanginrock9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock10", wanginrock.get("wanginrock10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock11", wanginrock.get("wanginrock11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32028")) {
//                    wanginrock.put("wanginrock12", wanginrock.get("wanginrock12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang1", wanginsadang.get("wanginsadang1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang2", wanginsadang.get("wanginsadang2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang3", wanginsadang.get("wanginsadang3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang4", wanginsadang.get("wanginsadang4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang5", wanginsadang.get("wanginsadang5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang6", wanginsadang.get("wanginsadang6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang7", wanginsadang.get("wanginsadang7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang8", wanginsadang.get("wanginsadang8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang9", wanginsadang.get("wanginsadang9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang10", wanginsadang.get("wanginsadang10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang11", wanginsadang.get("wanginsadang11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32029")) {
//                    wanginsadang.put("wanginsadang12", wanginsadang.get("wanginsadang12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi1", wanginmyobi.get("wanginmyobi1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi2", wanginmyobi.get("wanginmyobi2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi3", wanginmyobi.get("wanginmyobi3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi4", wanginmyobi.get("wanginmyobi4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi5", wanginmyobi.get("wanginmyobi5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi6", wanginmyobi.get("wanginmyobi6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi7", wanginmyobi.get("wanginmyobi7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi8", wanginmyobi.get("wanginmyobi8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi9", wanginmyobi.get("wanginmyobi9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi10", wanginmyobi.get("wanginmyobi10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi11", wanginmyobi.get("wanginmyobi11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32030")) {
//                    wanginmyobi.put("wanginmyobi12", wanginmyobi.get("wanginmyobi12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue1", wanginstatue.get("wanginstatue1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue2", wanginstatue.get("wanginstatue2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue3", wanginstatue.get("wanginstatue3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue4", wanginstatue.get("wanginstatue4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue5", wanginstatue.get("wanginstatue5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue6", wanginstatue.get("wanginstatue6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue7", wanginstatue.get("wanginstatue7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue8", wanginstatue.get("wanginstatue8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue9", wanginstatue.get("wanginstatue9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue10", wanginstatue.get("wanginstatue10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue11", wanginstatue.get("wanginstatue11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32031")) {
//                    wanginstatue.put("wanginstatue12", wanginstatue.get("wanginstatue12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real1", wangin_stonestatue_real.get("wangin_stonestatue_real1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real2", wangin_stonestatue_real.get("wangin_stonestatue_real2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real3", wangin_stonestatue_real.get("wangin_stonestatue_real3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real4", wangin_stonestatue_real.get("wangin_stonestatue_real4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real5", wangin_stonestatue_real.get("wangin_stonestatue_real5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real6", wangin_stonestatue_real.get("wangin_stonestatue_real6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real7", wangin_stonestatue_real.get("wangin_stonestatue_real7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real8", wangin_stonestatue_real.get("wangin_stonestatue_real8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real9", wangin_stonestatue_real.get("wangin_stonestatue_real9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real10", wangin_stonestatue_real.get("wangin_stonestatue_real10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real11", wangin_stonestatue_real.get("wangin_stonestatue_real11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32032")) {
//                    wangin_stonestatue_real.put("wangin_stonestatue_real12", wangin_stonestatue_real.get("wangin_stonestatue_real12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang1", wanginhakdang.get("wanginhakdang1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang2", wanginhakdang.get("wanginhakdang2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang3", wanginhakdang.get("wanginhakdang3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang4", wanginhakdang.get("wanginhakdang4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang5", wanginhakdang.get("wanginhakdang5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang6", wanginhakdang.get("wanginhakdang6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang7", wanginhakdang.get("wanginhakdang7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang8", wanginhakdang.get("wanginhakdang8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang9", wanginhakdang.get("wanginhakdang9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang10", wanginhakdang.get("wanginhakdang10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang11", wanginhakdang.get("wanginhakdang11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32033")) {
//                    wanginhakdang.put("wanginhakdang12", wanginhakdang.get("wanginhakdang12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru1", wolakru.get("wolakru1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru2", wolakru.get("wolakru2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru3", wolakru.get("wolakru3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru4", wolakru.get("wolakru4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru5", wolakru.get("wolakru5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru6", wolakru.get("wolakru6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru7", wolakru.get("wolakru7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru8", wolakru.get("wolakru8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru9", wolakru.get("wolakru9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru10", wolakru.get("wolakru10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru11", wolakru.get("wolakru11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32034")) {
//                    wolakru.put("wolakru12", wolakru.get("wolakru12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi1", yuheobi.get("yuheobi1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi2", yuheobi.get("yuheobi2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi3", yuheobi.get("yuheobi3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi4", yuheobi.get("yuheobi4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi5", yuheobi.get("yuheobi5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi6", yuheobi.get("yuheobi6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi7", yuheobi.get("yuheobi7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi8", yuheobi.get("yuheobi8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi9", yuheobi.get("yuheobi9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi10", yuheobi.get("yuheobi10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi11", yuheobi.get("yuheobi11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32035")) {
//                    yuheobi.put("yuheobi12", yuheobi.get("yuheobi12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang1", jaemyeongdang.get("jaemyeongdang1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang2", jaemyeongdang.get("jaemyeongdang2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang3", jaemyeongdang.get("jaemyeongdang3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang4", jaemyeongdang.get("jaemyeongdang4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang5", jaemyeongdang.get("jaemyeongdang5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang6", jaemyeongdang.get("jaemyeongdang6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang7", jaemyeongdang.get("jaemyeongdang7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang8", jaemyeongdang.get("jaemyeongdang8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang9", jaemyeongdang.get("jaemyeongdang9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang10", jaemyeongdang.get("jaemyeongdang10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang11", jaemyeongdang.get("jaemyeongdang11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32036")) {
//                    jaemyeongdang.put("jaemyeongdang12", jaemyeongdang.get("jaemyeongdang12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel1", jaemyeongdangpanel.get("jaemyeongdangpanel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel2", jaemyeongdangpanel.get("jaemyeongdangpanel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel3", jaemyeongdangpanel.get("jaemyeongdangpanel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel4", jaemyeongdangpanel.get("jaemyeongdangpanel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel5", jaemyeongdangpanel.get("jaemyeongdangpanel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel6", jaemyeongdangpanel.get("jaemyeongdangpanel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel7", jaemyeongdangpanel.get("jaemyeongdangpanel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel8", jaemyeongdangpanel.get("jaemyeongdangpanel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel9", jaemyeongdangpanel.get("jaemyeongdangpanel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel10", jaemyeongdangpanel.get("jaemyeongdangpanel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel11", jaemyeongdangpanel.get("jaemyeongdangpanel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32037")) {
//                    jaemyeongdangpanel.put("jaemyeongdangpanel12", jaemyeongdangpanel.get("jaemyeongdangpanel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel1", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel2", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel3", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel4", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel5", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel6", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel7", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel8", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel9", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32039")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel10", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel11", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32038")) {
//                    junhongsuseokjeonsigwan_panel.put("junhongsuseokjeonsigwan_panel12", junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step1", cheonjamoon_step.get("cheonjamoon_step1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step2", cheonjamoon_step.get("cheonjamoon_step2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step3", cheonjamoon_step.get("cheonjamoon_step3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step4", cheonjamoon_step.get("cheonjamoon_step4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step5", cheonjamoon_step.get("cheonjamoon_step5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step6", cheonjamoon_step.get("cheonjamoon_step6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step7", cheonjamoon_step.get("cheonjamoon_step7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step8", cheonjamoon_step.get("cheonjamoon_step8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step9", cheonjamoon_step.get("cheonjamoon_step9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step10", cheonjamoon_step.get("cheonjamoon_step10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step11", cheonjamoon_step.get("cheonjamoon_step11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32039")) {
//                    cheonjamoon_step.put("cheonjamoon_step12", cheonjamoon_step.get("cheonjamoon_step12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung1", hakeijung.get("hakeijung1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung2", hakeijung.get("hakeijung2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung3", hakeijung.get("hakeijung3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung4", hakeijung.get("hakeijung4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung5", hakeijung.get("hakeijung5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung6", hakeijung.get("hakeijung6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung7", hakeijung.get("hakeijung7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung8", hakeijung.get("hakeijung8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung9", hakeijung.get("hakeijung9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung10", hakeijung.get("hakeijung10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung11", hakeijung.get("hakeijung11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32040")) {
//                    hakeijung.put("hakeijung12", hakeijung.get("hakeijung12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon1", hakeimoon.get("hakeimoon1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon2", hakeimoon.get("hakeimoon2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon3", hakeimoon.get("hakeimoon3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon4", hakeimoon.get("hakeimoon4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon5", hakeimoon.get("hakeimoon5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon6", hakeimoon.get("hakeimoon6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon7", hakeimoon.get("hakeimoon7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon8", hakeimoon.get("hakeimoon8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon9", hakeimoon.get("hakeimoon9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon10", hakeimoon.get("hakeimoon10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon11", hakeimoon.get("hakeimoon11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("32041")) {
//                    hakeimoon.put("hakeimoon12", hakeimoon.get("hakeimoon12") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 내부 전시물   //////////////////////////////////////////////
//                else if (my_month_name == 1 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing81", wangin_drawing8.get("wangin_drawing81") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing82", wangin_drawing8.get("wangin_drawing82") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing83", wangin_drawing8.get("wangin_drawing83") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing84", wangin_drawing8.get("wangin_drawing84") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing85", wangin_drawing8.get("wangin_drawing85") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing86", wangin_drawing8.get("wangin_drawing86") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing87", wangin_drawing8.get("wangin_drawing87") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing88", wangin_drawing8.get("wangin_drawing88") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing89", wangin_drawing8.get("wangin_drawing89") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing810", wangin_drawing8.get("wangin_drawing810") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing811", wangin_drawing8.get("wangin_drawing811") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31001")) {
//                    wangin_drawing8.put("wangin_drawing812", wangin_drawing8.get("wangin_drawing812") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing31", wangin_drawing3.get("wangin_drawing31") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing32", wangin_drawing3.get("wangin_drawing32") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing33", wangin_drawing3.get("wangin_drawing33") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing34", wangin_drawing3.get("wangin_drawing34") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing35", wangin_drawing3.get("wangin_drawing35") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing36", wangin_drawing3.get("wangin_drawing36") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing37", wangin_drawing3.get("wangin_drawing37") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing38", wangin_drawing3.get("wangin_drawing38") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing39", wangin_drawing3.get("wangin_drawing39") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing310", wangin_drawing3.get("wangin_drawing310") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing311", wangin_drawing3.get("wangin_drawing311") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31002")) {
//                    wangin_drawing3.put("wangin_drawing312", wangin_drawing3.get("wangin_drawing312") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue21", wangin_smallstatue2.get("wangin_smallstatue21") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue22", wangin_smallstatue2.get("wangin_smallstatue22") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue23", wangin_smallstatue2.get("wangin_smallstatue23") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue24", wangin_smallstatue2.get("wangin_smallstatue24") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue25", wangin_smallstatue2.get("wangin_smallstatue25") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue26", wangin_smallstatue2.get("wangin_smallstatue26") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue27", wangin_smallstatue2.get("wangin_smallstatue27") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue28", wangin_smallstatue2.get("wangin_smallstatue28") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue29", wangin_smallstatue2.get("wangin_smallstatue29") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue210", wangin_smallstatue2.get("wangin_smallstatue210") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue211", wangin_smallstatue2.get("wangin_smallstatue211") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31003")) {
//                    wangin_smallstatue2.put("wangin_smallstatue212", wangin_smallstatue2.get("wangin_smallstatue212") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum1", gusegwaneum.get("gusegwaneum1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum2", gusegwaneum.get("gusegwaneum2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum3", gusegwaneum.get("gusegwaneum3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum4", gusegwaneum.get("gusegwaneum4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum5", gusegwaneum.get("gusegwaneum5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum6", gusegwaneum.get("gusegwaneum6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum7", gusegwaneum.get("gusegwaneum7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum8", gusegwaneum.get("gusegwaneum8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum9", gusegwaneum.get("gusegwaneum9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum10", gusegwaneum.get("gusegwaneum10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum11", gusegwaneum.get("gusegwaneum11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31004")) {
//                    gusegwaneum.put("gusegwaneum12", gusegwaneum.get("gusegwaneum12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang1", wangin_kwanumsang.get("wangin_kwanumsang1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang2", wangin_kwanumsang.get("wangin_kwanumsang2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang3", wangin_kwanumsang.get("wangin_kwanumsang3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang4", wangin_kwanumsang.get("wangin_kwanumsang4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang5", wangin_kwanumsang.get("wangin_kwanumsang5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang6", wangin_kwanumsang.get("wangin_kwanumsang6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang7", wangin_kwanumsang.get("wangin_kwanumsang7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang8", wangin_kwanumsang.get("wangin_kwanumsang8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang9", wangin_kwanumsang.get("wangin_kwanumsang9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang10", wangin_kwanumsang.get("wangin_kwanumsang10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang11", wangin_kwanumsang.get("wangin_kwanumsang11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31005")) {
//                    wangin_kwanumsang.put("wangin_kwanumsang12", wangin_kwanumsang.get("wangin_kwanumsang12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha1", wangin_threebuddha.get("wangin_threebuddha1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha2", wangin_threebuddha.get("wangin_threebuddha2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha3", wangin_threebuddha.get("wangin_threebuddha3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha4", wangin_threebuddha.get("wangin_threebuddha4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha5", wangin_threebuddha.get("wangin_threebuddha5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha6", wangin_threebuddha.get("wangin_threebuddha6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha7", wangin_threebuddha.get("wangin_threebuddha7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha8", wangin_threebuddha.get("wangin_threebuddha8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha9", wangin_threebuddha.get("wangin_threebuddha9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha10", wangin_threebuddha.get("wangin_threebuddha10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha11", wangin_threebuddha.get("wangin_threebuddha11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31006")) {
//                    wangin_threebuddha.put("wangin_threebuddha12", wangin_threebuddha.get("wangin_threebuddha12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31007")) {
//                    danji.put("danji1", danji.get("danji1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31007")) {
//                    danji.put("danji2", danji.get("danji2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31007")) {
//                    danji.put("danji3", danji.get("danji3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31007")) {
//                    danji.put("danji4", danji.get("danji4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31007")) {
//                    danji.put("danji5", danji.get("danji5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31007")) {
//                    danji.put("danji6", danji.get("danji6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31007")) {
//                    danji.put("danji7", danji.get("danji7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31007")) {
//                    danji.put("danji8", danji.get("danji8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31007")) {
//                    danji.put("danji9", danji.get("danji9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31007")) {
//                    danji.put("danji10", danji.get("danji10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31007")) {
//                    danji.put("danji11", danji.get("danji11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31007")) {
//                    danji.put("danji12", danji.get("danji12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo1", geumdongjegwanmo.get("geumdongjegwanmo1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo2", geumdongjegwanmo.get("geumdongjegwanmo2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo3", geumdongjegwanmo.get("geumdongjegwanmo3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo4", geumdongjegwanmo.get("geumdongjegwanmo4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo5", geumdongjegwanmo.get("geumdongjegwanmo5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo6", geumdongjegwanmo.get("geumdongjegwanmo6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo7", geumdongjegwanmo.get("geumdongjegwanmo7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo8", geumdongjegwanmo.get("geumdongjegwanmo8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo9", geumdongjegwanmo.get("geumdongjegwanmo9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo10", geumdongjegwanmo.get("geumdongjegwanmo10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo11", geumdongjegwanmo.get("geumdongjegwanmo11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31008")) {
//                    geumdongjegwanmo.put("geumdongjegwanmo12", geumdongjegwanmo.get("geumdongjegwanmo12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown1", wangin_goldcrown.get("wangin_goldcrown1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown2", wangin_goldcrown.get("wangin_goldcrown2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown3", wangin_goldcrown.get("wangin_goldcrown3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown4", wangin_goldcrown.get("wangin_goldcrown4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown5", wangin_goldcrown.get("wangin_goldcrown5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown6", wangin_goldcrown.get("wangin_goldcrown6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown7", wangin_goldcrown.get("wangin_goldcrown7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown8", wangin_goldcrown.get("wangin_goldcrown8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown9", wangin_goldcrown.get("wangin_goldcrown9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown10", wangin_goldcrown.get("wangin_goldcrown10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown11", wangin_goldcrown.get("wangin_goldcrown11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31009")) {
//                    wangin_goldcrown.put("wangin_goldcrown12", wangin_goldcrown.get("wangin_goldcrown12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue11", wangin_stonestatue1.get("wangin_stonestatue11") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue12", wangin_stonestatue1.get("wangin_stonestatue12") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue13", wangin_stonestatue1.get("wangin_stonestatue13") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue14", wangin_stonestatue1.get("wangin_stonestatue14") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue15", wangin_stonestatue1.get("wangin_stonestatue15") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue16", wangin_stonestatue1.get("wangin_stonestatue16") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue17", wangin_stonestatue1.get("wangin_stonestatue17") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue18", wangin_stonestatue1.get("wangin_stonestatue18") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue19", wangin_stonestatue1.get("wangin_stonestatue19") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue110", wangin_stonestatue1.get("wangin_stonestatue110") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue111", wangin_stonestatue1.get("wangin_stonestatue111") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31010")) {
//                    wangin_stonestatue1.put("wangin_stonestatue112", wangin_stonestatue1.get("wangin_stonestatue112") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing21", wangin_drawing2.get("wangin_drawing21") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing22", wangin_drawing2.get("wangin_drawing22") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing23", wangin_drawing2.get("wangin_drawing23") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing24", wangin_drawing2.get("wangin_drawing24") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing25", wangin_drawing2.get("wangin_drawing25") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing26", wangin_drawing2.get("wangin_drawing26") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing27", wangin_drawing2.get("wangin_drawing27") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing28", wangin_drawing2.get("wangin_drawing28") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing29", wangin_drawing2.get("wangin_drawing29") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing210", wangin_drawing2.get("wangin_drawing210") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing211", wangin_drawing2.get("wangin_drawing211") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31011")) {
//                    wangin_drawing2.put("wangin_drawing212", wangin_drawing2.get("wangin_drawing212") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel1", wangin_baekjemodel.get("wangin_baekjemodel1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel2", wangin_baekjemodel.get("wangin_baekjemodel2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel3", wangin_baekjemodel.get("wangin_baekjemodel3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel4", wangin_baekjemodel.get("wangin_baekjemodel4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel5", wangin_baekjemodel.get("wangin_baekjemodel5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel6", wangin_baekjemodel.get("wangin_baekjemodel6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel7", wangin_baekjemodel.get("wangin_baekjemodel7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel8", wangin_baekjemodel.get("wangin_baekjemodel8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel9", wangin_baekjemodel.get("wangin_baekjemodel9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel10", wangin_baekjemodel.get("wangin_baekjemodel10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel11", wangin_baekjemodel.get("wangin_baekjemodel11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("31012")) {
//                    wangin_baekjemodel.put("wangin_baekjemodel12", wangin_baekjemodel.get("wangin_baekjemodel12") + 1);
//                }
////////////////////////////////////////////////   여기서 부터는 애니메이션   //////////////////////////////////////////////
//                else if (my_month_name == 1 && users_type.toString().equals("5001")) {
//                    one.put("one1", one.get("one1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("5001")) {
//                    one.put("one2", one.get("one2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("5001")) {
//                    one.put("one3", one.get("one3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("5001")) {
//                    one.put("one4", one.get("one4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("5001")) {
//                    one.put("one5", one.get("one5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("5001")) {
//                    one.put("one6", one.get("one6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("5001")) {
//                    one.put("one7", one.get("one7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("5001")) {
//                    one.put("one8", one.get("one8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("5001")) {
//                    one.put("one9", one.get("one9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("5001")) {
//                    one.put("one10", one.get("one10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("5001")) {
//                    one.put("one11", one.get("one11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("5001")) {
//                    one.put("one12", one.get("one12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("5002")) {
//                    two.put("two1", two.get("two1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("5002")) {
//                    two.put("two2", two.get("two2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("5002")) {
//                    two.put("two3", two.get("two3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("5002")) {
//                    two.put("two4", two.get("two4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("5002")) {
//                    two.put("two5", two.get("two5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("5002")) {
//                    two.put("two6", two.get("two6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("5002")) {
//                    two.put("two7", two.get("two7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("5002")) {
//                    two.put("two8", two.get("two8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("5002")) {
//                    two.put("two9", two.get("two9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("5002")) {
//                    two.put("two10", two.get("two10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("5002")) {
//                    two.put("two11", two.get("two11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("5002")) {
//                    two.put("two12", two.get("two12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("5003")) {
//                    three.put("three1", three.get("three1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("5003")) {
//                    three.put("three2", three.get("three2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("5003")) {
//                    three.put("three3", three.get("three3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("5003")) {
//                    three.put("three4", three.get("three4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("5003")) {
//                    three.put("three5", three.get("three5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("5003")) {
//                    three.put("three6", three.get("three6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("5003")) {
//                    three.put("three7", three.get("three7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("5003")) {
//                    three.put("three8", three.get("three8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("5003")) {
//                    three.put("three9", three.get("three9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("5003")) {
//                    three.put("three10", three.get("three10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("5003")) {
//                    three.put("three11", three.get("three11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("5003")) {
//                    three.put("three12", three.get("three12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("5004")) {
//                    four.put("four1", four.get("four1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("5004")) {
//                    four.put("four2", four.get("four2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("5004")) {
//                    four.put("four3", four.get("four3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("5004")) {
//                    four.put("four4", four.get("four4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("5004")) {
//                    four.put("four5", four.get("four5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("5004")) {
//                    four.put("four6", four.get("four6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("5004")) {
//                    four.put("four7", four.get("four7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("5004")) {
//                    four.put("four8", four.get("four8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("5004")) {
//                    four.put("four9", four.get("four9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("5004")) {
//                    four.put("four10", four.get("four10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("5004")) {
//                    four.put("four11", four.get("four11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("5004")) {
//                    four.put("four12", four.get("four12") + 1);
//                } else if (my_month_name == 1 && users_type.toString().equals("5005")) {
//                    five.put("five1", five.get("five1") + 1);
//                } else if (my_month_name == 2 && users_type.toString().equals("5005")) {
//                    five.put("five2", five.get("five2") + 1);
//                } else if (my_month_name == 3 && users_type.toString().equals("5005")) {
//                    five.put("five3", five.get("five3") + 1);
//                } else if (my_month_name == 4 && users_type.toString().equals("5005")) {
//                    five.put("five4", five.get("five4") + 1);
//                } else if (my_month_name == 5 && users_type.toString().equals("5005")) {
//                    five.put("five5", five.get("five5") + 1);
//                } else if (my_month_name == 6 && users_type.toString().equals("5005")) {
//                    five.put("five6", five.get("five6") + 1);
//                } else if (my_month_name == 7 && users_type.toString().equals("5005")) {
//                    five.put("five7", five.get("five7") + 1);
//                } else if (my_month_name == 8 && users_type.toString().equals("5005")) {
//                    five.put("five8", five.get("five8") + 1);
//                } else if (my_month_name == 9 && users_type.toString().equals("5005")) {
//                    five.put("five9", five.get("five9") + 1);
//                } else if (my_month_name == 10 && users_type.toString().equals("5005")) {
//                    five.put("five10", five.get("five10") + 1);
//                } else if (my_month_name == 11 && users_type.toString().equals("5005")) {
//                    five.put("five11", five.get("five11") + 1);
//                } else if (my_month_name == 12 && users_type.toString().equals("5005")) {
//                    five.put("five12", five.get("five12") + 1);
//                }
//            }
//
////////////////////////////////////////////////   여기서 부터는 차트 표시   //////////////////////////////////////////////
//            for (int i = 0; i < 12; i++) {
//                newcharts[i] = new_.get("new_" + (i + 1));
//                usercharts[i] = user_.get("user_" + (i + 1));
//                treasurehuntcharts[i] = tresurehunt_.get("tresurehunt_" + (i + 1));
//            }
//            model.addAttribute("newcharts", newcharts);
//            model.addAttribute("usercharts", usercharts);
//            model.addAttribute("treasurehuntcharts", treasurehuntcharts);
//
//
//            for (int i = 0; i < 12; i++) {
//                //////////////////////////////////////////////   여기서 부터는 외부 전시물   //////////////////////////////////////////////
//                model.addAttribute("hakeijung_panel" + (i + 1), hakeijung_panel.get("hakeijung_panel" + (i + 1)));
//                model.addAttribute("mangwoljung_panel" + (i + 1), mangwoljung_panel.get("mangwoljung_panel" + (i + 1)));
//                model.addAttribute("boojo5" + (i + 1), boojo5.get("boojo5" + (i + 1)));
//                model.addAttribute("hongsalmoon" + (i + 1), hongsalmoon.get("hongsalmoon" + (i + 1)));
//                model.addAttribute("sungcheon" + (i + 1), sungcheon.get("sungcheon" + (i + 1)));
//                model.addAttribute("cheonjamoon" + (i + 1), cheonjamoon.get("cheonjamoon" + (i + 1)));
//                model.addAttribute("boojo1" + (i + 1), boojo1.get("boojo1" + (i + 1)));
//                model.addAttribute("susinjeong" + (i + 1), susinjeong.get("susinjeong" + (i + 1)));
//                model.addAttribute("choizimongbi" + (i + 1), choizimongbi.get("choizimongbi" + (i + 1)));
//                model.addAttribute("jeonghwabee" + (i + 1), jeonghwabee.get("jeonghwabee" + (i + 1)));
//                model.addAttribute("noraebee" + (i + 1), noraebee.get("noraebee" + (i + 1)));
//                model.addAttribute("mangwujeong" + (i + 1), mangwujeong.get("mangwujeong" + (i + 1)));
//                model.addAttribute("moonsanjae" + (i + 1), moonsanjae.get("moonsanjae" + (i + 1)));
//                model.addAttribute("moonsanjae_panel" + (i + 1), moonsanjae_panel.get("moonsanjae_panel" + (i + 1)));
//                model.addAttribute("baekjemoon" + (i + 1), baekjemoon.get("baekjemoon" + (i + 1)));
//                model.addAttribute("bongseondae" + (i + 1), bongseondae.get("bongseondae" + (i + 1)));
//                model.addAttribute("boojo2" + (i + 1), boojo2.get("boojo2" + (i + 1)));
//                model.addAttribute("boojo3" + (i + 1), boojo3.get("boojo3" + (i + 1)));
//                model.addAttribute("boojo4" + (i + 1), boojo4.get("boojo4" + (i + 1)));
//                model.addAttribute("boojo6" + (i + 1), boojo6.get("boojo6" + (i + 1)));
//                model.addAttribute("sangdaepo" + (i + 1), sangdaepo.get("sangdaepo" + (i + 1)));
//                model.addAttribute("sojeongsuseokjeonsigwan_panel" + (i + 1), sojeongsuseokjeonsigwan_panel.get("sojeongsuseokjeonsigwan_panel" + (i + 1)));
//                model.addAttribute("sinseontaeguek" + (i + 1), sinseontaeguek.get("sinseontaeguek" + (i + 1)));
//                model.addAttribute("aehyangsuseok" + (i + 1), aehyangsuseok.get("aehyangsuseok" + (i + 1)));
//                model.addAttribute("yangsajae" + (i + 1), yangsajae.get("yangsajae" + (i + 1)));
//                model.addAttribute("yeongwolgwan" + (i + 1), yeongwolgwan.get("yeongwolgwan" + (i + 1)));
//                model.addAttribute("yeongwolbee" + (i + 1), yeongwolbee.get("yeongwolbee" + (i + 1)));
//                model.addAttribute("wanginrock" + (i + 1), wanginrock.get("wanginrock" + (i + 1)));
//                model.addAttribute("wanginsadang" + (i + 1), wanginsadang.get("wanginsadang" + (i + 1)));
//                model.addAttribute("wanginmyobi" + (i + 1), wanginmyobi.get("wanginmyobi" + (i + 1)));
//                model.addAttribute("wanginstatue" + (i + 1), wanginstatue.get("wanginstatue" + (i + 1)));
//                model.addAttribute("wangin_stonestatue_real" + (i + 1), wangin_stonestatue_real.get("wangin_stonestatue_real" + (i + 1)));
//                model.addAttribute("wanginhakdang" + (i + 1), wanginhakdang.get("wanginhakdang" + (i + 1)));
//                model.addAttribute("wolakru" + (i + 1), wolakru.get("wolakru" + (i + 1)));
//                model.addAttribute("yuheobi" + (i + 1), yuheobi.get("yuheobi" + (i + 1)));
//                model.addAttribute("jaemyeongdang" + (i + 1), jaemyeongdang.get("jaemyeongdang" + (i + 1)));
//                model.addAttribute("jaemyeongdangpanel" + (i + 1), jaemyeongdangpanel.get("jaemyeongdangpanel" + (i + 1)));
//                model.addAttribute("junhongsuseokjeonsigwan_panel" + (i + 1), junhongsuseokjeonsigwan_panel.get("junhongsuseokjeonsigwan_panel" + (i + 1)));
//                model.addAttribute("cheonjamoon_step" + (i + 1), cheonjamoon_step.get("cheonjamoon_step" + (i + 1)));
//                model.addAttribute("hakeijung" + (i + 1), hakeijung.get("hakeijung" + (i + 1)));
//                model.addAttribute("hakeimoon" + (i + 1), hakeimoon.get("hakeimoon" + (i + 1)));
//                //////////////////////////////////////////////   여기서 부터는 내부 전시물   //////////////////////////////////////////////
//                model.addAttribute("wangin_drawing8" + (i + 1), wangin_drawing8.get("wangin_drawing8" + (i + 1)));
//                model.addAttribute("wangin_drawing3" + (i + 1), wangin_drawing3.get("wangin_drawing3" + (i + 1)));
//                model.addAttribute("wangin_smallstatue2" + (i + 1), wangin_smallstatue2.get("wangin_smallstatue2" + (i + 1)));
//                model.addAttribute("gusegwaneum" + (i + 1), gusegwaneum.get("gusegwaneum" + (i + 1)));
//                model.addAttribute("wangin_kwanumsang" + (i + 1), wangin_kwanumsang.get("wangin_kwanumsang" + (i + 1)));
//                model.addAttribute("wangin_threebuddha" + (i + 1), wangin_threebuddha.get("wangin_threebuddha" + (i + 1)));
//                model.addAttribute("danji" + (i + 1), danji.get("danji" + (i + 1)));
//                model.addAttribute("geumdongjegwanmo" + (i + 1), geumdongjegwanmo.get("geumdongjegwanmo" + (i + 1)));
//                model.addAttribute("wangin_goldcrown" + (i + 1), wangin_goldcrown.get("wangin_goldcrown" + (i + 1)));
//                model.addAttribute("wangin_stonestatue1" + (i + 1), wangin_stonestatue1.get("wangin_stonestatue1" + (i + 1)));
//                model.addAttribute("wangin_drawing2" + (i + 1), wangin_drawing2.get("wangin_drawing2" + (i + 1)));
//                model.addAttribute("wangin_baekjemodel" + (i + 1), wangin_baekjemodel.get("wangin_baekjemodel" + (i + 1)));
//                //////////////////////////////////////////////   여기서 부터는 애니메이션   //////////////////////////////////////////////
//                model.addAttribute("one" + (i + 1), one.get("one" + (i + 1)));
//                model.addAttribute("two" + (i + 1), two.get("two" + (i + 1)));
//                model.addAttribute("three" + (i + 1), three.get("three" + (i + 1)));
//                model.addAttribute("four" + (i + 1), four.get("four" + (i + 1)));
//                model.addAttribute("five" + (i + 1), five.get("five" + (i + 1)));
//            }
//
////////////////////////////////////////////////   끝   //////////////////////////////////////////////
//            if (year2 == 0) {
//                year2 = year;
//            }
//            model.addAttribute("yearname", year + "년 ~ " + year2 + "년 월간 이용현황");
//            model.addAttribute("firstyear", year);
//            model.addAttribute("secondyear", year2);
//            model.addAttribute("nowurl0", "/log");
//            model.addAttribute("nowurl1", "/main_month");
//            returnValue = "dashboard3";
//        } else {
//            returnValue = "redirect:/";
//        }
//        return returnValue;
//    }
}
