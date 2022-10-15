package com.example.HighSchoolAdminSite.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "final_reception")
public class FinalreceptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "receptionnum")
    private int receptionnum;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private int sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "middle_school")
    private String middle_school;

    @Column(name = "neis")
    private String neis;

    @Column(name = "graduation_type")
    private int graduation_type;

    @Column(name = "classification_type")
    private int classification_type;

    @Column(name = "curriculum_grades")
    private double curriculum_grades;

    @Column(name = "final_receptioncol")
    private double final_receptioncol;

    @Column(name = "behavior_development")
    private double behavior_development;

    @Column(name = "exp_activities")
    private double exp_activities;

    @Column(name = "volunteer_activity_time")
    private double volunteer_activity_time;

    @Column(name = "total_grades")
    private double total_grades;

    @Column(name = "order_percentage")
    private double order_percentage;

    @Column(name = "ck_reception")
    private int ck_reception;

    @Column(name = "phone")
    private String phone;

    @Column(name = "parental_phone")
    private String parental_phone;



    @Builder
    public FinalreceptionEntity(Long myseq, int myreceptionnum, String myname, int mysex, String mybirthday, String myaddress, String mymiddle_school, String myneis, int mygraduation_type,
                                int myclassification_type, double mycurriculum_grades, double myfinal_receptioncol, double mybehavior_development, double myexp_activities, double myvolunteer_activity_time,
                                double mytotal_grades, double myorder_percentage, int myck_reception, String myphone, String myparental_phone) {
        this.seq = myseq;
        this.receptionnum = myreceptionnum;
        this.name = myname;
        this.sex = mysex;
        this.birthday = mybirthday;
        this.address = myaddress;
        this.middle_school = mymiddle_school;
        this.neis = myneis;
        this.graduation_type = mygraduation_type;
        this.classification_type = myclassification_type;
        this.curriculum_grades = mycurriculum_grades;
        this.final_receptioncol = myfinal_receptioncol;
        this.behavior_development = mybehavior_development;
        this.exp_activities = myexp_activities;
        this.volunteer_activity_time = myvolunteer_activity_time;
        this.total_grades = mytotal_grades;
        this.order_percentage = myorder_percentage;
        this.ck_reception = myck_reception;
        this.phone = myphone;
        this.parental_phone = myparental_phone;
    }
}
