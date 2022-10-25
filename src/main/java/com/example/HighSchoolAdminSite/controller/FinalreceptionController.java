package com.example.HighSchoolAdminSite.controller;

import com.example.HighSchoolAdminSite.common.Pagination;
import com.example.HighSchoolAdminSite.common.SessionCheck;
import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import com.example.HighSchoolAdminSite.repository.FinalreceptionRepository;
import com.example.HighSchoolAdminSite.service.FinalreceptionService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
@RequestMapping
public class FinalreceptionController {

    private FinalreceptionService finalreceptionService;
    private FinalreceptionRepository finalreceptionRepository;

    @GetMapping("/finalreception")
    public String main(Model model, HttpServletRequest session, Pageable pageable,
                       @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        if (new SessionCheck().loginSessionCheck(session)){
            pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
            Page<FinalreceptionEntity> memberEntities = finalreceptionService.findAll(pageable);
            Pagination pagination = new Pagination(memberEntities.getTotalPages(), page);
            model.addAttribute("nowurl0", "/Finalreception");
            model.addAttribute("userlist", memberEntities);
            model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            return "Finalreception";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/finalreception_search", method = RequestMethod.POST)
    public String main_search(Model model,
                              @RequestParam(required = false ,defaultValue = "0" , value="page") int page,
                              @RequestParam(required = false ,defaultValue = "" , value="selectKey") String selectKey,
                              @RequestParam(required = false ,defaultValue = "" , value="titleText") String titleText){
        Pageable pageable = PageRequest.of(page, 15, Sort.by("seq").descending());
        int totalPages = finalreceptionService.findAll2(selectKey, titleText, pageable).getTotalPages();
        Pagination pagination = new Pagination(totalPages, page);

        model.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
        model.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
        model.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
        model.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
        model.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
        model.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함

        //서비스 엔티티 추가후 주석 풀고 사용
        Page<FinalreceptionEntity> pageList = finalreceptionService.findAll2(selectKey, titleText, pageable);

        model.addAttribute("userlist", pageList); //페이지 객체 리스트

        return "Finalreception :: #example3";
    }

    @GetMapping("/excel/download")
    public void excelDownload(HttpServletResponse response) throws IOException {
        File excelFile = new File("/home/AdminHighschoolAddmission/test.xlsx"); //해당경로에 있는 엑셀 파일을 읽는다.

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelFile));

        List<FinalreceptionEntity> list = finalreceptionRepository.findAll();

        XSSFCellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);
        cellstyle.setBorderTop(BorderStyle.THIN);
        cellstyle.setBorderLeft(BorderStyle.THIN);

        XSSFSheet sheet1 = workbook.getSheetAt(0);
        int a = 1;
        int b = 1;
        for (int i=0; i<list.size(); i++){
            String gradetype = "";
            String classtype = "";
            String ck = "";
            String sex = "";
            if(list.get(i).getSex() == 0){
                sex = "남";
            }else if(list.get(i).getSex() == 1){
                sex = "여";
            }
            if(list.get(i).getGraduation_type() ==0){
                gradetype = "졸업예정자";
            }else if(list.get(i).getGraduation_type() ==1){
                gradetype = "졸업자";
            }else if(list.get(i).getGraduation_type() ==2){
                gradetype = "검정고시";
            }

            if (list.get(i).getClassification_type() == 0 || list.get(i).getClassification_type() == 1 || list.get(i).getClassification_type() == 2){
                classtype = "일반전형";
            }else if(list.get(i).getClassification_type() == 3 || list.get(i).getClassification_type() == 4 || list.get(i).getClassification_type() == 5 || list.get(i).getClassification_type() == 6
                    || list.get(i).getClassification_type() == 7 || list.get(i).getClassification_type() == 8 || list.get(i).getClassification_type() == 9){
                classtype = "사회통합전형 - 기회균등전형";
            }else if(list.get(i).getClassification_type() == 10 || list.get(i).getClassification_type() == 11 || list.get(i).getClassification_type() == 12){
                classtype = "사회통합전형 - 사회다양성 전형";
            }else if(list.get(i).getClassification_type() == 13 || list.get(i).getClassification_type() == 14){
                classtype = "특별전형(정원외)";
            }
            if(list.get(i).getCk_reception() == 1){
                ck = "제출완료";
            }

            sheet1.getRow(a+1).createCell(b+1).setCellValue(list.get(i).getReceptionnum());
            sheet1.getRow(a+1).getCell(b+1).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+2).setCellValue(list.get(i).getName());
            sheet1.getRow(a+1).getCell(b+2).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+3).setCellValue(sex);
            sheet1.getRow(a+1).getCell(b+3).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+4).setCellValue(list.get(i).getBirthday());
            sheet1.getRow(a+1).getCell(b+4).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+5).setCellValue(list.get(i).getAddress());
            sheet1.getRow(a+1).getCell(b+5).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+6).setCellValue(list.get(i).getMiddle_school());
            sheet1.getRow(a+1).getCell(b+6).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+7).setCellValue(list.get(i).getNeis());
            sheet1.getRow(a+1).getCell(b+7).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+8).setCellValue(gradetype);
            sheet1.getRow(a+1).getCell(b+8).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+9).setCellValue(classtype);
            sheet1.getRow(a+1).getCell(b+9).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+10).setCellValue(list.get(i).getCurriculum_grades());
            sheet1.getRow(a+1).getCell(b+10).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+11).setCellValue(list.get(i).getFinal_receptioncol());
            sheet1.getRow(a+1).getCell(b+11).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+12).setCellValue(list.get(i).getBehavior_development());
            sheet1.getRow(a+1).getCell(b+12).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+13).setCellValue(list.get(i).getExp_activities());
            sheet1.getRow(a+1).getCell(b+13).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+14).setCellValue(list.get(i).getVolunteer_activity_time());
            sheet1.getRow(a+1).getCell(b+14).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+15).setCellValue(list.get(i).getTotal_grades());
            sheet1.getRow(a+1).getCell(b+15).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+16).setCellValue(list.get(i).getOrder_percentage());
            sheet1.getRow(a+1).getCell(b+16).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+17).setCellValue(ck);
            sheet1.getRow(a+1).getCell(b+17).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+18).setCellValue(list.get(i).getPhone());
            sheet1.getRow(a+1).getCell(b+18).setCellStyle(cellstyle);
            sheet1.getRow(a+1).createCell(b+19).setCellValue(list.get(i).getParental_phone());
            sheet1.getRow(a+1).getCell(b+19).setCellStyle(cellstyle);
            a = a+1;
        }


        FileOutputStream outStream = null;

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");
//        response.setHeader("Content-Disposition", "attachment;filename=example.xls");
        response.setHeader("Content-Disposition", "attachment;filename=최종접수자현황.xlsx");

        // Excel File Output
        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
