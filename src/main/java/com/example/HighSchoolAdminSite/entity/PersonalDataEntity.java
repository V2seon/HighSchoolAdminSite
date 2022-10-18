package com.example.HighSchoolAdminSite.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "information")
public class PersonalDataEntity {

    @Id
    @Column(name = "seq")
    private Long aseq;

    @Column(name = "studentfakeseq")
    private int astudentfakeseq;

    @Column(name = "name")
    private String aname;

    @Column(name = "birthday")
    private String abirthday;

    @Column(name = "phone")
    private String aphone;

    @Column(name = "sex")
    private int asex;

    @Column(name = "postal_code")
    private String apostal_code;

    @Column(name = "address")
    private String aaddress;

    @Column(name = "detailed_address")
    private String adetailed_address;

    @Column(name = "guardian")
    private String aguardian;

    @Column(name = "parental")
    private String aparental;

    @Column(name = "home_phone")
    private String ahome_phone;

    @Column(name = "parental_phone")
    private String aparental_phone;

    @Column(name = "application_incharge_name")
    private String aapplication_incharge_name;

    @Column(name = "application_incharge_phone")
    private String aapplication_incharge_phone;

    @Column(name = "id_picture")
    private String aid_picture;

    @Column(name = "middle_school")
    private String amiddle_school;

    @Column(name = "middle_school_unique_number")
    private int amiddle_school_unique_number;

    @Column(name = "middle_school_phone")
    private String amiddle_school_phone;

    @Column(name = "area_name")
    private String aarea_name;

    @Column(name = "area2_name")
    private String aarea2_name;

    @Column(name = "graduation_year")
    private int agraduation_year;

    @Column(name = "graduation_month")
    private int agraduation_month;

    @Column(name = "graduation_type")
    private int agraduation_type;

    @Column(name = "classification_type")
    private int aclassification_type;

    @Builder
    public PersonalDataEntity(Long a_seq,int a_studentfakeseq, String a_name, String a_birthday, int a_sex, String a_phone, String a_postal_code, String a_address,
                              String a_detailed_address, String a_guardian, String a_parental, String a_home_phone, String a_parental_phone,
                              String a_application_incharge_name, String a_application_incharge_phone, String a_id_picture, String a_middle_school,
                              int a_middle_school_unique_number, String a_middle_school_phone, String a_area_name, String a_area2_name,
                              int a_graduation_year, int a_graduation_month, int a_graduation_type, int a_classification_type) {
        this.aseq = a_seq;
        this.astudentfakeseq = a_studentfakeseq;
        this.aname = a_name;
        this.abirthday = a_birthday;
        this.aphone = a_phone;
        this.asex = a_sex;
        this.apostal_code = a_postal_code;
        this.aaddress = a_address;
        this.adetailed_address = a_detailed_address;
        this.aguardian = a_guardian;
        this.aparental = a_parental;
        this.ahome_phone = a_home_phone;
        this.aparental_phone = a_parental_phone;
        this.aapplication_incharge_name = a_application_incharge_name;
        this.aapplication_incharge_phone = a_application_incharge_phone;
        this.aid_picture = a_id_picture;
        this.amiddle_school = a_middle_school;
        this.amiddle_school_unique_number = a_middle_school_unique_number;
        this.amiddle_school_phone = a_middle_school_phone;
        this.aarea_name = a_area_name;
        this.aarea2_name = a_area2_name;
        this.agraduation_year = a_graduation_year;
        this.agraduation_month = a_graduation_month;
        this.agraduation_type = a_graduation_type;
        this.aclassification_type = a_classification_type;
    }

}
