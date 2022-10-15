package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.PersonalDataEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonalDataDto {
    private Long A_SEQ;
    private int A_STUDENTFAKESEQ;
    private String A_NAME;
    private String A_BIRTHDAY;
    private String A_PHONE;
    private int A_SEX;
    private int A_POSTAL_CODE;
    private String A_ADDRESS;
    private String A_DETAILED_ADDRESS;
    private String A_GUARDIAN;
    private String A_PARENTAL;
    private String A_HOME_PHONE;
    private String A_PARENTAL_PHONE;
    private String A_APPLICATION_INCHARGE_NAME;
    private String A_APPLICATION_INCHARGE_PHONE;
    private String A_ID_PICTURE;
    private String A_MIDDLE_SCHOOL;
    private int A_MIDDLE_SCHOOL_UNIQUE_NUMBER;
    private String A_MIDDLE_SCHOOL_PHONE;
    private String A_AREA_NAME;
    private String A_AREA2_NAME;
    private int A_GRADUATION_YEAR;
    private int A_GRADUATION_MONTH;
    private int A_GRADUATION_TYPE;
    private int A_CLASSIFICATION_TYPE;

    @Builder
    public PersonalDataDto(Long a_SEQ,int a_STUDENTFAKESEQ, String a_NAME, String a_BIRTHDAY, int a_SEX, String a_PHONE, int a_POSTAL_CODE
            , String a_ADDRESS, String a_DETAILED_ADDRESS, String a_GUARDIAN, String a_PARENTAL, String a_HOME_PHONE, String a_PARENTAL_PHONE
            , String a_APPLICATION_INCHARGE_NAME, String a_APPLICATION_INCHARGE_PHONE, String a_ID_PICTURE, String a_MIDDLE_SCHOOL
            , int a_MIDDLE_SCHOOL_UNIQUE_NUMBER, String a_MIDDLE_SCHOOL_PHONE, String a_AREA_NAME, String a_AREA2_NAME
            , int a_GRADUATION_YEAR, int a_GRADUATION_MONTH, int a_GRADUATION_TYPE, int a_CLASSIFICATION_TYPE) {
        A_SEQ = a_SEQ;
        A_STUDENTFAKESEQ = a_STUDENTFAKESEQ;
        A_NAME = a_NAME;
        A_BIRTHDAY = a_BIRTHDAY;
        A_PHONE = a_PHONE;
        A_SEX = a_SEX;
        A_POSTAL_CODE = a_POSTAL_CODE;
        A_ADDRESS = a_ADDRESS;
        A_DETAILED_ADDRESS = a_DETAILED_ADDRESS;
        A_GUARDIAN = a_GUARDIAN;
        A_PARENTAL = a_PARENTAL;
        A_HOME_PHONE = a_HOME_PHONE;
        A_PARENTAL_PHONE = a_PARENTAL_PHONE;
        A_APPLICATION_INCHARGE_NAME = a_APPLICATION_INCHARGE_NAME;
        A_APPLICATION_INCHARGE_PHONE = a_APPLICATION_INCHARGE_PHONE;
        A_ID_PICTURE = a_ID_PICTURE;
        A_MIDDLE_SCHOOL = a_MIDDLE_SCHOOL;
        A_MIDDLE_SCHOOL_UNIQUE_NUMBER = a_MIDDLE_SCHOOL_UNIQUE_NUMBER;
        A_MIDDLE_SCHOOL_PHONE = a_MIDDLE_SCHOOL_PHONE;
        A_AREA_NAME = a_AREA_NAME;
        A_AREA2_NAME = a_AREA2_NAME;
        A_GRADUATION_YEAR = a_GRADUATION_YEAR;
        A_GRADUATION_MONTH = a_GRADUATION_MONTH;
        A_GRADUATION_TYPE = a_GRADUATION_TYPE;
        A_CLASSIFICATION_TYPE = a_CLASSIFICATION_TYPE;
    }
    public PersonalDataEntity toEntity(){
        PersonalDataEntity entity = PersonalDataEntity.builder()
                .a_seq(A_SEQ)
                .a_studentfakeseq(A_STUDENTFAKESEQ)
                .a_name(A_NAME)
                .a_birthday(A_BIRTHDAY)
                .a_phone(A_PHONE)
                .a_sex(A_SEX)
                .a_postal_code(A_POSTAL_CODE)
                .a_address(A_ADDRESS)
                .a_detailed_address(A_DETAILED_ADDRESS)
                .a_guardian(A_GUARDIAN)
                .a_parental(A_PARENTAL)
                .a_home_phone(A_HOME_PHONE)
                .a_parental_phone(A_PARENTAL_PHONE)
                .a_application_incharge_name(A_APPLICATION_INCHARGE_NAME)
                .a_application_incharge_phone(A_APPLICATION_INCHARGE_PHONE)
                .a_id_picture(A_ID_PICTURE)
                .a_middle_school(A_MIDDLE_SCHOOL)
                .a_middle_school_unique_number(A_MIDDLE_SCHOOL_UNIQUE_NUMBER)
                .a_middle_school_phone(A_MIDDLE_SCHOOL_PHONE)
                .a_area_name(A_AREA_NAME)
                .a_area2_name(A_AREA2_NAME)
                .a_graduation_year(A_GRADUATION_YEAR)
                .a_graduation_month(A_GRADUATION_MONTH)
                .a_graduation_type(A_GRADUATION_TYPE)
                .a_classification_type(A_CLASSIFICATION_TYPE)
                .build();
        return entity;
    }
    @Builder
    public PersonalDataDto(int A_STUDENTFAKESEQ,String A_NAME, String A_BIRTHDAY, int A_SEX, String A_PHONE, int A_POSTAL_CODE, String A_ADDRESS
            , String A_DETAILED_ADDRESS, String A_GUARDIAN, String A_PARENTAL, String A_HOME_PHONE, String A_PARENTAL_PHONE
            , String A_APPLICATION_INCHARGE_NAME, String A_APPLICATION_INCHARGE_PHONE, String A_ID_PICTURE, String A_MIDDLE_SCHOOL
            , int A_MIDDLE_SCHOOL_UNIQUE_NUMBER, String A_MIDDLE_SCHOOL_PHONE, String A_AREA_NAME, String A_AREA2_NAME
            , int A_GRADUATION_YEAR, int A_GRADUATION_MONTH, int A_GRADUATION_TYPE, int A_CLASSIFICATION_TYPE) {
        this.A_STUDENTFAKESEQ = A_STUDENTFAKESEQ;
        this.A_NAME = A_NAME;
        this.A_BIRTHDAY = A_BIRTHDAY;
        this.A_PHONE = A_PHONE;
        this.A_SEX = A_SEX;
        this.A_POSTAL_CODE = A_POSTAL_CODE;
        this.A_ADDRESS = A_ADDRESS;
        this.A_DETAILED_ADDRESS = A_DETAILED_ADDRESS;
        this.A_GUARDIAN = A_GUARDIAN;
        this.A_PARENTAL = A_PARENTAL;
        this.A_HOME_PHONE = A_HOME_PHONE;
        this.A_PARENTAL_PHONE = A_PARENTAL_PHONE;
        this.A_APPLICATION_INCHARGE_NAME = A_APPLICATION_INCHARGE_NAME;
        this.A_APPLICATION_INCHARGE_PHONE = A_APPLICATION_INCHARGE_PHONE;
        this.A_ID_PICTURE = A_ID_PICTURE;
        this.A_MIDDLE_SCHOOL = A_MIDDLE_SCHOOL;
        this.A_MIDDLE_SCHOOL_UNIQUE_NUMBER = A_MIDDLE_SCHOOL_UNIQUE_NUMBER;
        this.A_MIDDLE_SCHOOL_PHONE = A_MIDDLE_SCHOOL_PHONE;
        this.A_AREA_NAME = A_AREA_NAME;
        this.A_AREA2_NAME = A_AREA2_NAME;
        this.A_GRADUATION_YEAR = A_GRADUATION_YEAR;
        this.A_GRADUATION_MONTH = A_GRADUATION_MONTH;
        this.A_GRADUATION_TYPE = A_GRADUATION_TYPE;
        this.A_CLASSIFICATION_TYPE = A_CLASSIFICATION_TYPE;
    }
}
