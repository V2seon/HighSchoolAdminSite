package com.example.HighSchoolAdminSite.entity;

import com.example.HighSchoolAdminSite.dto.StudentfakeseqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "student_fake_seq")
public class StudentfakeseqEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "sseq", unique = true)
    private Long sseq;

    @Column(name = "studentfakeseq")
    private int studentfakeseq;

    @Column(name = "num")
    private int num;

    @Builder
    public StudentfakeseqEntity(Long a_seq, Long a_sseq, int a_astudentfakeseq, int a_num) {
        this.seq = a_seq;
        this.sseq = a_sseq;
        this.studentfakeseq = a_astudentfakeseq;
        this.num = a_num;
    }

    public static StudentfakeseqEntity toSaveEntity (StudentfakeseqDto studentfakeDto){
        StudentfakeseqEntity mainEntity = new StudentfakeseqEntity();
        mainEntity.setSeq(studentfakeDto.getA_SEQ());
        mainEntity.setSseq(studentfakeDto.getA_SSEQ());
        mainEntity.setStudentfakeseq(studentfakeDto.getA_STUDENTFAKESEQ());
        mainEntity.setNum(studentfakeDto.getA_NUM());
        return mainEntity;
    }

}