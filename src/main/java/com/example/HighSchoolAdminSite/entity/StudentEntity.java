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
@Entity
@Setter
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "seq")
    private Long student_seq;

    @Column(name = "phone")
    private String student_phone;

    @Column(name = "password")
    private String student_password;

    @Column(name = "signupdatetime")
    private String student_signupdatetime;


    @Builder
    public StudentEntity(Long student_seq, String student_phone, String student_password, String student_signupdatetime) {
        this.student_seq = student_seq;
        this.student_phone = student_phone;
        this.student_password = student_password;
        this.student_signupdatetime = student_signupdatetime;
    }
}
