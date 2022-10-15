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
@Table(name = "grade_type3")
public class GradeType3DataEntity {

    @Id
    @Column(name = "seq")
    private Long Seq;

    @Column(name = "name")
    private String Name;

    @Column(name = "grade1")
    private double Grade1;

    @Column(name = "grade2")
    private double Grade2;

    @Column(name = "total_grades")
    private double TotalGrades;

    @Builder
    public GradeType3DataEntity(Long mySeq,String myName ,double myGrade1, double myGrade2, double myTotalGrades) {
        this.Seq = mySeq;
        this.Name = myName;
        this.Grade1 = myGrade1;
        this.Grade2 = myGrade2;
        this.TotalGrades = myTotalGrades;
    }
}
