package com.example.HighSchoolAdminSite.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grade_type2")
public class GradeType2DataEntity {

    @Id
    @Column(name = "seq")
    private Long Seq;

    @Column(name = "ischeck")
    private int IsCheck;

    @Column(name = "order_percentage")
    private double OrderPercentage;

    @Column(name = "order_total")
    private double OrderTotal;

    @Column(name = "second_first_type1")
    private String SecondFirstType1;

    @Column(name = "second_first_type2")
    private String SecondFirstType2;

    @Column(name = "second_first_type3")
    private String SecondFirstType3;

    @Column(name = "second_first_type4")
    private String SecondFirstType4;

    @Column(name = "second_first_type5")
    private String SecondFirstType5;

    @Column(name = "second_first_type6")
    private String SecondFirstType6;

    @Column(name = "second_first_type7")
    private String SecondFirstType7;

    @Column(name = "second_first_type8")
    private String SecondFirstType8;

    @Column(name = "second_first_type9")
    private String SecondFirstType9;

    @Column(name = "second_first_type10")
    private String SecondFirstType10;

    @Column(name = "second_first_type11")
    private String SecondFirstType11;

    @Column(name = "second_second_type1")
    private String SecondSecondType1;

    @Column(name = "second_second_type2")
    private String SecondSecondType2;

    @Column(name = "second_second_type3")
    private String SecondSecondType3;

    @Column(name = "second_second_type4")
    private String SecondSecondType4;

    @Column(name = "second_second_type5")
    private String SecondSecondType5;

    @Column(name = "second_second_type6")
    private String SecondSecondType6;

    @Column(name = "second_second_type7")
    private String SecondSecondType7;

    @Column(name = "second_second_type8")
    private String SecondSecondType8;

    @Column(name = "second_second_type9")
    private String SecondSecondType9;

    @Column(name = "second_second_type10")
    private String SecondSecondType10;

    @Column(name = "second_second_type11")
    private String SecondSecondType11;

    @Column(name = "third_first_type1")
    private String ThirdFirstType1;

    @Column(name = "third_first_type2")
    private String ThirdFirstType2;

    @Column(name = "third_first_type3")
    private String ThirdFirstType3;

    @Column(name = "third_first_type4")
    private String ThirdFirstType4;

    @Column(name = "third_first_type5")
    private String ThirdFirstType5;

    @Column(name = "third_first_type6")
    private String ThirdFirstType6;

    @Column(name = "third_first_type7")
    private String ThirdFirstType7;

    @Column(name = "third_first_type8")
    private String ThirdFirstType8;

    @Column(name = "third_first_type9")
    private String ThirdFirstType9;

    @Column(name = "third_first_type10")
    private String ThirdFirstType10;

    @Column(name = "third_first_type11")
    private String ThirdFirstType11;

    @Column(name = "first_absent")
    private int FirstAbsant;

    @Column(name = "first_late")
    private int FirstLate;

    @Column(name = "first_leave")
    private int FirstLeave;

    @Column(name = "first_result")
    private int FirstResult;

    @Column(name = "first_behavior_development")
    private double FirstBehaviorDevelopment;

    @Column(name = "first_exp_activities")
    private double FirstExpActivities;

    @Column(name = "first_volunteer_activity_time")
    private int FirstVolunteerActivityTime;

    @Column(name = "second_absent")
    private int SecondAbsant;

    @Column(name = "second_late")
    private int SecondLate;

    @Column(name = "second_leave")
    private int SecondLeave;

    @Column(name = "second_result")
    private int SecondResult;

    @Column(name = "second_behavior_development")
    private double SecondBehaviorDevelopment;

    @Column(name = "second_exp_activities")
    private double SecondExpActivities;

    @Column(name = "second_volunteer_activity_time")
    private int SecondVolunteerActivityTime;

    @Column(name = "third_absent")
    private int ThirdAbsant;

    @Column(name = "third_late")
    private int ThirdLate;

    @Column(name = "third_leave")
    private int ThirdLeave;

    @Column(name = "third_result")
    private int ThirdResult;

    @Column(name = "third_behavior_development")
    private double ThirdBehaviorDevelopment;

    @Column(name = "third_exp_activities")
    private double ThirdExpActivities;

    @Column(name = "third_volunteer_activity_time")
    private int ThirdVolunteerActivityTime;

    @Column(name = "curriculum_grades")
    private double CurriculumGrades;

    @Column(name = "non_curriculum_grades")
    private double NonCurriculumGrades;

    @Column(name = "total_grades")
    private double TotalGrades;

    @Builder
    public GradeType2DataEntity(Long mySeq, int myIsCheck, double myOrderPercentage, double myOrderTotal, String mySecondFirstType1, String mySecondFirstType2,
                                String mySecondFirstType3, String mySecondFirstType4,
                                String mySecondFirstType5, String mySecondFirstType6, String mySecondFirstType7, String mySecondFirstType8, String mySecondFirstType9,
                                String mySecondFirstType10, String mySecondFirstType11, String mySecondSecondType1, String mySecondSecondType2, String mySecondSecondType3,
                                String mySecondSecondType4, String mySecondSecondType5, String mySecondSecondType6, String mySecondSecondType7, String mySecondSecondType8,
                                String mySecondSecondType9, String mySecondSecondType10, String mySecondSecondType11, String myThirdFirstType1, String myThirdFirstType2,
                                String myThirdFirstType3, String myThirdFirstType4, String myThirdFirstType5, String myThirdFirstType6, String myThirdFirstType7,
                                String myThirdFirstType8, String myThirdFirstType9, String myThirdFirstType10, String myThirdFirstType11, int myFirstAbsant, int myFirstLate,
                                int myFirstLeave, int myFirstResult, double myFirstBehaviorDevelopment, double myFirstExpActivities, int myFirstVolunteerActivityTime,
                                int mySecondAbsant, int mySecondLate, int mySecondLeave, int mySecondResult, double mySecondBehaviorDevelopment, double mySecondExpActivities,
                                int mySecondVolunteerActivityTime, int myThirdAbsant, int myThirdLate, int myThirdLeave, int myThirdResult, double myThirdBehaviorDevelopment,
                                double myThirdExpActivities, int myThirdVolunteerActivityTime, double myCurriculumGrades, double myNonCurriculumGrades, double myTotalGrades) {
        this.Seq = mySeq;
        this.IsCheck = myIsCheck;
        this.OrderPercentage = myOrderPercentage;
        this.OrderTotal = myOrderTotal;
        this.SecondFirstType1 = mySecondFirstType1;
        this.SecondFirstType2 = mySecondFirstType2;
        this.SecondFirstType3 = mySecondFirstType3;
        this.SecondFirstType4 = mySecondFirstType4;
        this.SecondFirstType5 = mySecondFirstType5;
        this.SecondFirstType6 = mySecondFirstType6;
        this.SecondFirstType7 = mySecondFirstType7;
        this.SecondFirstType8 = mySecondFirstType8;
        this.SecondFirstType9 = mySecondFirstType9;
        this.SecondFirstType10 = mySecondFirstType10;
        this.SecondFirstType11 = mySecondFirstType11;
        this.SecondSecondType1 = mySecondSecondType1;
        this.SecondSecondType2 = mySecondSecondType2;
        this.SecondSecondType3 = mySecondSecondType3;
        this.SecondSecondType4 = mySecondSecondType4;
        this.SecondSecondType5 = mySecondSecondType5;
        this.SecondSecondType6 = mySecondSecondType6;
        this.SecondSecondType7 = mySecondSecondType7;
        this.SecondSecondType8 = mySecondSecondType8;
        this.SecondSecondType9 = mySecondSecondType9;
        this.SecondSecondType10 = mySecondSecondType10;
        this.SecondSecondType11 = mySecondSecondType11;
        this.ThirdFirstType1 = myThirdFirstType1;
        this.ThirdFirstType2 = myThirdFirstType2;
        this.ThirdFirstType3 = myThirdFirstType3;
        this.ThirdFirstType4 = myThirdFirstType4;
        this.ThirdFirstType5 = myThirdFirstType5;
        this.ThirdFirstType6 = myThirdFirstType6;
        this.ThirdFirstType7 = myThirdFirstType7;
        this.ThirdFirstType8 = myThirdFirstType8;
        this.ThirdFirstType9 = myThirdFirstType9;
        this.ThirdFirstType10 = myThirdFirstType10;
        this.ThirdFirstType11 = myThirdFirstType11;
        this.FirstAbsant = myFirstAbsant;
        this.FirstLate = myFirstLate;
        this.FirstLeave = myFirstLeave;
        this.FirstResult = myFirstResult;
        this.FirstBehaviorDevelopment = myFirstBehaviorDevelopment;
        this.FirstExpActivities = myFirstExpActivities;
        this.FirstVolunteerActivityTime = myFirstVolunteerActivityTime;
        this.SecondAbsant = mySecondAbsant;
        this.SecondLate = mySecondLate;
        this.SecondLeave = mySecondLeave;
        this.SecondResult = mySecondResult;
        this.SecondBehaviorDevelopment = mySecondBehaviorDevelopment;
        this.SecondExpActivities = mySecondExpActivities;
        this.SecondVolunteerActivityTime = mySecondVolunteerActivityTime;
        this.ThirdAbsant = myThirdAbsant;
        this.ThirdLate = myThirdLate;
        this.ThirdLeave = myThirdLeave;
        this.ThirdResult = myThirdResult;
        this.ThirdBehaviorDevelopment = myThirdBehaviorDevelopment;
        this.ThirdExpActivities = myThirdExpActivities;
        this.ThirdVolunteerActivityTime = myThirdVolunteerActivityTime;
        this.CurriculumGrades = myCurriculumGrades;
        this.NonCurriculumGrades = myNonCurriculumGrades;
        this.TotalGrades = myTotalGrades;
    }
}
