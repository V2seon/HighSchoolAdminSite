package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.GradeType1DataEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GradeType1DataDto implements Serializable {

    private Long MySeq;

    private String MySecondFirstType1;

    private String MySecondFirstType2;

    private String MySecondFirstType3;

    private String MySecondFirstType4;

    private String MySecondFirstType5;

    private String MySecondFirstType6;

    private String MySecondFirstType7;

    private String MySecondFirstType8;

    private String MySecondFirstType9;

    private String MySecondFirstType10;

    private String MySecondFirstType11;

    private String MyFirstPlusType1;

    private String MyFirstPlusType2;

    private String MyFirstPlusType3;

    private String MyFirstPlusName;

    private String MySecondSecondType1;

    private String MySecondSecondType2;

    private String MySecondSecondType3;

    private String MySecondSecondType4;

    private String MySecondSecondType5;

    private String MySecondSecondType6;

    private String MySecondSecondType7;

    private String MySecondSecondType8;

    private String MySecondSecondType9;

    private String MySecondSecondType10;

    private String MySecondSecondType11;

    private String MySecondPlusType1;

    private String MySecondPlusType2;

    private String MySecondPlusType3;

    private String MySecondPlusName;

    private String MyThirdFirstType1;

    private String MyThirdFirstType2;

    private String MyThirdFirstType3;

    private String MyThirdFirstType4;

    private String MyThirdFirstType5;

    private String MyThirdFirstType6;

    private String MyThirdFirstType7;

    private String MyThirdFirstType8;

    private String MyThirdFirstType9;

    private String MyThirdFirstType10;

    private String MyThirdFirstType11;

    private String MyThirdPlusType1;

    private String MyThirdPlusType2;

    private String MyThirdPlusType3;

    private String MyThirdPlusName;

    private int MyFirstAbsant;

    private int MyFirstLate;

    private int MyFirstLeave;

    private int MyFirstResult;

    private double MyFirstBehaviorDevelopment;

    private double MyFirstExpActivities;

    private int MyFirstVolunteerActivityTime;

    private int MySecondAbsant;

    private int MySecondLate;

    private int MySecondLeave;

    private int MySecondResult;

    private double MySecondBehaviorDevelopment;

    private double MySecondExpActivities;

    private int MySecondVolunteerActivityTime;

    private int MyThirdAbsant;

    private int MyThirdLate;

    private int MyThirdLeave;

    private int MyThirdResult;

    private double MyThirdBehaviorDevelopment;

    private double MyThirdExpActivities;

    private int MyThirdVolunteerActivityTime;

    private double MyCurriculumGrades;

    private double MyNonCurriculumGrades;

    private double MyTotalGrades;

    @Builder
    public GradeType1DataDto(Long mySeq, String mySecondFirstType1, String mySecondFirstType2, String mySecondFirstType3, String mySecondFirstType4, String mySecondFirstType5,
                             String mySecondFirstType6, String mySecondFirstType7, String mySecondFirstType8, String mySecondFirstType9, String mySecondFirstType10,
                             String mySecondFirstType11, String myFirstPlusType1, String myFirstPlusType2, String myFirstPlusType3, String myFirstPlusName, String mySecondSecondType1,
                             String mySecondSecondType2, String mySecondSecondType3, String mySecondSecondType4, String mySecondSecondType5, String mySecondSecondType6,
                             String mySecondSecondType7, String mySecondSecondType8, String mySecondSecondType9, String mySecondSecondType10, String mySecondSecondType11,
                             String mySecondPlusType1, String mySecondPlusType2, String mySecondPlusType3, String mySecondPlusName,
                             String myThirdFirstType1, String myThirdFirstType2, String myThirdFirstType3, String myThirdFirstType4, String myThirdFirstType5,
                             String myThirdFirstType6, String myThirdFirstType7, String myThirdFirstType8, String myThirdFirstType9, String myThirdFirstType10,
                             String myThirdFirstType11, String myThirdPlusType1, String myThirdPlusType2, String myThirdPlusType3, String myThirdPlusName,
                             int myFirstAbsant, int myFirstLate, int myFirstLeave, int myFirstResult, double myFirstBehaviorDevelopment,
                             double myFirstExpActivities, int myFirstVolunteerActivityTime, int mySecondAbsant, int mySecondLate, int mySecondLeave, int mySecondResult,
                             double mySecondBehaviorDevelopment, double mySecondExpActivities, int mySecondVolunteerActivityTime, int myThirdAbsant, int myThirdLate,
                             int myThirdLeave, int myThirdResult, double myThirdBehaviorDevelopment, double myThirdExpActivities, int myThirdVolunteerActivityTime,
                             double myCurriculumGrades, double myNonCurriculumGrades, double myTotalGrades) {
        this.MySeq = mySeq;
        this.MySecondFirstType1 = mySecondFirstType1;
        this.MySecondFirstType2 = mySecondFirstType2;
        this.MySecondFirstType3 = mySecondFirstType3;
        this.MySecondFirstType4 = mySecondFirstType4;
        this.MySecondFirstType5 = mySecondFirstType5;
        this.MySecondFirstType6 = mySecondFirstType6;
        this.MySecondFirstType7 = mySecondFirstType7;
        this.MySecondFirstType8 = mySecondFirstType8;
        this.MySecondFirstType9 = mySecondFirstType9;
        this.MySecondFirstType10 = mySecondFirstType10;
        this.MySecondFirstType11 = mySecondFirstType11;
        this.MyFirstPlusType1 = myFirstPlusType1;
        this.MyFirstPlusType2 = myFirstPlusType2;
        this.MyFirstPlusType3 = myFirstPlusType3;
        this.MyFirstPlusName = myFirstPlusName;
        this.MySecondSecondType1 = mySecondSecondType1;
        this.MySecondSecondType2 = mySecondSecondType2;
        this.MySecondSecondType3 = mySecondSecondType3;
        this.MySecondSecondType4 = mySecondSecondType4;
        this.MySecondSecondType5 = mySecondSecondType5;
        this.MySecondSecondType6 = mySecondSecondType6;
        this.MySecondSecondType7 = mySecondSecondType7;
        this.MySecondSecondType8 = mySecondSecondType8;
        this.MySecondSecondType9 = mySecondSecondType9;
        this.MySecondSecondType10 = mySecondSecondType10;
        this.MySecondSecondType11 = mySecondSecondType11;
        this.MySecondPlusType1 = mySecondPlusType1;
        this.MySecondPlusType2 = mySecondPlusType2;
        this.MySecondPlusType3 = mySecondPlusType3;
        this.MySecondPlusName = mySecondPlusName;
        this.MyThirdFirstType1 = myThirdFirstType1;
        this.MyThirdFirstType2 = myThirdFirstType2;
        this.MyThirdFirstType3 = myThirdFirstType3;
        this.MyThirdFirstType4 = myThirdFirstType4;
        this.MyThirdFirstType5 = myThirdFirstType5;
        this.MyThirdFirstType6 = myThirdFirstType6;
        this.MyThirdFirstType7 = myThirdFirstType7;
        this.MyThirdFirstType8 = myThirdFirstType8;
        this.MyThirdFirstType9 = myThirdFirstType9;
        this.MyThirdFirstType10 = myThirdFirstType10;
        this.MyThirdFirstType11 = myThirdFirstType11;
        this.MyThirdPlusType1 = myThirdPlusType1;
        this.MyThirdPlusType2 = myThirdPlusType2;
        this.MyThirdPlusType3 = myThirdPlusType3;
        this.MyThirdPlusName = myThirdPlusName;
        this.MyFirstAbsant = myFirstAbsant;
        this.MyFirstLate = myFirstLate;
        this.MyFirstLeave = myFirstLeave;
        this.MyFirstResult = myFirstResult;
        this.MyFirstBehaviorDevelopment = myFirstBehaviorDevelopment;
        this.MyFirstExpActivities = myFirstExpActivities;
        this.MyFirstVolunteerActivityTime = myFirstVolunteerActivityTime;
        this.MySecondAbsant = mySecondAbsant;
        this.MySecondLate = mySecondLate;
        this.MySecondLeave = mySecondLeave;
        this.MySecondResult = mySecondResult;
        this.MySecondBehaviorDevelopment = mySecondBehaviorDevelopment;
        this.MySecondExpActivities = mySecondExpActivities;
        this.MySecondVolunteerActivityTime = mySecondVolunteerActivityTime;
        this.MyThirdAbsant = myThirdAbsant;
        this.MyThirdLate = myThirdLate;
        this.MyThirdLeave = myThirdLeave;
        this.MyThirdResult = myThirdResult;
        this.MyThirdBehaviorDevelopment = myThirdBehaviorDevelopment;
        this.MyThirdExpActivities = myThirdExpActivities;
        this.MyThirdVolunteerActivityTime = myThirdVolunteerActivityTime;
        this.MyCurriculumGrades = myCurriculumGrades;
        this.MyNonCurriculumGrades = myNonCurriculumGrades;
        this.MyTotalGrades = myTotalGrades;
    }

    public GradeType1DataEntity toEntity(){
        GradeType1DataEntity entity = GradeType1DataEntity.builder()
                .mySeq(MySeq)
                .mySecondFirstType1(MySecondFirstType1)
                .mySecondFirstType2(MySecondFirstType2)
                .mySecondFirstType3(MySecondFirstType3)
                .mySecondFirstType4(MySecondFirstType4)
                .mySecondFirstType5(MySecondFirstType5)
                .mySecondFirstType6(MySecondFirstType6)
                .mySecondFirstType7(MySecondFirstType7)
                .mySecondFirstType8(MySecondFirstType8)
                .mySecondFirstType9(MySecondFirstType9)
                .mySecondFirstType10(MySecondFirstType10)
                .mySecondFirstType11(MySecondFirstType11)
                .myFirstPlusType1(MyFirstPlusType1)
                .myFirstPlusType2(MyFirstPlusType2)
                .myFirstPlusType3(MyFirstPlusType3)
                .myFirstPlusName(MyFirstPlusName)
                .mySecondSecondType1(MySecondSecondType1)
                .mySecondSecondType2(MySecondSecondType2)
                .mySecondSecondType3(MySecondSecondType3)
                .mySecondSecondType4(MySecondSecondType4)
                .mySecondSecondType5(MySecondSecondType5)
                .mySecondSecondType6(MySecondSecondType6)
                .mySecondSecondType7(MySecondSecondType7)
                .mySecondSecondType8(MySecondSecondType8)
                .mySecondSecondType9(MySecondSecondType9)
                .mySecondSecondType10(MySecondSecondType10)
                .mySecondSecondType11(MySecondSecondType11)
                .mySecondPlusType1(MySecondPlusType1)
                .mySecondPlusType2(MySecondPlusType2)
                .mySecondPlusType3(MySecondPlusType3)
                .mySecondPlusName(MySecondPlusName)
                .myThirdFirstType1(MyThirdFirstType1)
                .myThirdFirstType2(MyThirdFirstType2)
                .myThirdFirstType3(MyThirdFirstType3)
                .myThirdFirstType4(MyThirdFirstType4)
                .myThirdFirstType5(MyThirdFirstType5)
                .myThirdFirstType6(MyThirdFirstType6)
                .myThirdFirstType7(MyThirdFirstType7)
                .myThirdFirstType8(MyThirdFirstType8)
                .myThirdFirstType9(MyThirdFirstType9)
                .myThirdFirstType10(MyThirdFirstType10)
                .myThirdFirstType11(MyThirdFirstType11)
                .myThirdPlusType1(MyThirdPlusType1)
                .myThirdPlusType2(MyThirdPlusType2)
                .myThirdPlusType3(MyThirdPlusType3)
                .myThirdPlusName(MyThirdPlusName)
                .myFirstAbsant(MyFirstAbsant)
                .myFirstLate(MyFirstLate)
                .myFirstLeave(MyFirstLeave)
                .myFirstResult(MyFirstResult)
                .myFirstBehaviorDevelopment(MyFirstBehaviorDevelopment)
                .myFirstExpActivities(MyFirstExpActivities)
                .myFirstVolunteerActivityTime(MyFirstVolunteerActivityTime)
                .mySecondAbsant(MySecondAbsant)
                .mySecondLate(MySecondLate)
                .mySecondLeave(MySecondLeave)
                .mySecondResult(MySecondResult)
                .mySecondBehaviorDevelopment(MySecondBehaviorDevelopment)
                .mySecondExpActivities(MySecondExpActivities)
                .mySecondVolunteerActivityTime(MySecondVolunteerActivityTime)
                .myThirdAbsant(MyThirdAbsant)
                .myThirdLate(MyThirdLate)
                .myThirdLeave(MyThirdLeave)
                .myThirdResult(MyThirdResult)
                .myThirdBehaviorDevelopment(MyThirdBehaviorDevelopment)
                .myThirdExpActivities(MyThirdExpActivities)
                .myThirdVolunteerActivityTime(MyThirdVolunteerActivityTime)
                .myCurriculumGrades(MyCurriculumGrades)
                .myNonCurriculumGrades(MyNonCurriculumGrades)
                .myTotalGrades(MyTotalGrades)
                .build();
        return entity;
    }

}
