package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.GradeType3DataEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GradeType3DataDto {

    private Long MySeq;

    private int MyStudentfakeseq;

    private String MyName;

    private double MyGrade1;

    private double MyGrade2;

    private double MyTotalGrads;

    @Builder
    public GradeType3DataDto(Long mySeq,int myStudentfakeseq, String myName ,double myGrade1, double myGrade2, double myTotalGrads) {
        this.MySeq = mySeq;
        this.MyStudentfakeseq = myStudentfakeseq;
        this.MyName = myName;
        this.MyGrade1 = myGrade1;
        this.MyGrade2 = myGrade2;
        this.MyTotalGrads = myTotalGrads;
    }

    public GradeType3DataEntity toEntity(){
        GradeType3DataEntity entity = GradeType3DataEntity.builder()
                .mySeq(MySeq)
                .myStudentfakeseq(MyStudentfakeseq)
                .myName(MyName)
                .myGrade1(MyGrade1)
                .myGrade2(MyGrade2)
                .myTotalGrades(MyTotalGrads)
                .build();
        return entity;
    }

}
