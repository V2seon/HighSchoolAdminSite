package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.FinalreceptionEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FinalreceptionDto implements Serializable {

    private Long Myseq;

    private int Myreceptionnum;

    private String Myname;

    private int Mysex;

    private String Mybirthday;

    private String Myaddress;

    private String Mymiddle_school;

    private String Myneis;

    private int Mygraduation_type;

    private int Myclassification_type;

    private double Mycurriculum_grades;

    private double Myfinal_receptioncol;

    private double Mybehavior_development;

    private double Myexp_activities;

    private double Myvolunteer_activity_time;

    private double Mytotal_grades;

    private double Myorder_percentage;

    private int Myck_reception;

    private String Myphone;

    private String Myparental_phone;

    @Builder
    public FinalreceptionDto(Long myseq, int myreceptionnum, String myname, int mysex, String mybirthday, String myaddress, String mymiddle_school, String myneis, int mygraduation_type,
                                 int myclassification_type, double mycurriculum_grades, double myfinal_receptioncol, double mybehavior_development, double myexp_activities,double myvolunteer_activity_time,
                             double mytotal_grades, double myorder_percentage, int myck_reception, String myphone, String myparental_phone) {
        this.Myseq = myseq;
        this.Myreceptionnum = myreceptionnum;
        this.Myname = myname;
        this.Mysex = mysex;
        this.Mybirthday = mybirthday;
        this.Myaddress = myaddress;
        this.Mymiddle_school = mymiddle_school;
        this.Myneis = myneis;
        this.Mygraduation_type = mygraduation_type;
        this.Myclassification_type = myclassification_type;
        this.Mycurriculum_grades = mycurriculum_grades;
        this.Myfinal_receptioncol = myfinal_receptioncol;
        this.Mybehavior_development = mybehavior_development;
        this.Myexp_activities = myexp_activities;
        this.Myvolunteer_activity_time = myvolunteer_activity_time;
        this.Mytotal_grades = mytotal_grades;
        this.Myorder_percentage = myorder_percentage;
        this.Myck_reception = myck_reception;
        this.Myphone = myphone;
        this.Myparental_phone = myparental_phone;
    }

    public FinalreceptionEntity toEntity(){
        FinalreceptionEntity entity = FinalreceptionEntity.builder()
                .myseq(Myseq)
                .myreceptionnum(Myreceptionnum)
                .myname(Myname)
                .mysex(Mysex)
                .mybirthday(Mybirthday)
                .myaddress(Myaddress)
                .mymiddle_school(Mymiddle_school)
                .myneis(Myneis)
                .mygraduation_type(Mygraduation_type)
                .myclassification_type(Myclassification_type)
                .mycurriculum_grades(Mycurriculum_grades)
                .myfinal_receptioncol(Myfinal_receptioncol)
                .mybehavior_development(Mybehavior_development)
                .myexp_activities(Myexp_activities)
                .myvolunteer_activity_time(Myvolunteer_activity_time)
                .mytotal_grades(Mytotal_grades)
                .myorder_percentage(Myorder_percentage)
                .myck_reception(Myck_reception)
                .myphone(Myphone)
                .myparental_phone(Myparental_phone)
                .build();
        return entity;
    }
}
