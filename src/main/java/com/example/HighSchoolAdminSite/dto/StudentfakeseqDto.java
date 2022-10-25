package com.example.HighSchoolAdminSite.dto;

import com.example.HighSchoolAdminSite.entity.StudentfakeseqEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentfakeseqDto {
    private Long A_SEQ;
    private Long A_SSEQ;
    private int A_STUDENTFAKESEQ;
    private int A_NUM;
    private int A_PASSNUM;

    @Builder
    public StudentfakeseqDto(Long a_SEQ, Long a_SSEQ, int a_STUDENTFAKESEQ, int a_NUM, int a_PASSNUM) {
        this.A_SEQ = a_SEQ;
        this.A_SSEQ = a_SSEQ;
        this.A_STUDENTFAKESEQ = a_STUDENTFAKESEQ;
        this.A_NUM = a_NUM;
        this.A_PASSNUM = a_PASSNUM;
    }

    public StudentfakeseqEntity toEntity(){
        StudentfakeseqEntity entity = StudentfakeseqEntity.builder()
                .a_seq(A_SEQ)
                .a_sseq(A_SSEQ)
                .a_astudentfakeseq(A_STUDENTFAKESEQ)
                .a_num(A_NUM)
                .a_passnum(A_PASSNUM)
                .build();
        return entity;
    }
}
