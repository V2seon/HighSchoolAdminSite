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

    @Column(name = "grade1")
    private int Grade1;

    @Column(name = "grade2")
    private int Grade2;

    @Column(name = "total_grades")
    private int TotalGrades;

    @Builder
    public GradeType3DataEntity(Long mySeq, int myGrade1, int myGrade2, int myTotalGrades) {
        this.Seq = mySeq;
        this.Grade1 = myGrade1;
        this.Grade2 = myGrade2;
        this.TotalGrades = myTotalGrades;
    }
}
