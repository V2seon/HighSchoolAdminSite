package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.StudentEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDto {
    private Long student_seq;
    private String student_phone;
    private String student_password;
    private String student_signupdatetime;

    @Builder
    public StudentDto(Long student_seq, String student_phone, String student_password, String student_signupdatetime) {
        this.student_seq = student_seq;
        this.student_phone = student_phone;
        this.student_password = student_password;
        this.student_signupdatetime = student_signupdatetime;
    }

    public StudentEntity toEntity(){
        StudentEntity entity = StudentEntity.builder()
                .student_seq(student_seq)
                .student_phone(student_phone)
                .student_password(student_password)
                .student_signupdatetime(student_signupdatetime)
                .build();
        return entity;
    }
}
