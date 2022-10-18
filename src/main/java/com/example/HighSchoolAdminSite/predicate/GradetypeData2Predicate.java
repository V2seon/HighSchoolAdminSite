package com.example.HighSchoolAdminSite.predicate;

import com.example.HighSchoolAdminSite.entity.QGradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.QGradeType2DataEntity;
import com.querydsl.core.BooleanBuilder;

public class GradetypeData2Predicate {
    public static BooleanBuilder search(String selectKey, String titleText){
        QGradeType2DataEntity qGradeType2DataEntity = QGradeType2DataEntity.gradeType2DataEntity;

        BooleanBuilder builder = new BooleanBuilder();
        System.out.println(titleText);

        if(!selectKey.equals("전체")){
            if(selectKey.equals("접수번호")){
                try{
                    builder.and(qGradeType2DataEntity.Studentfakeseq.eq(Integer.valueOf(titleText)));
                }
                catch (Exception e){
                    builder.and(qGradeType2DataEntity.Name.contains(titleText));
                    System.out.println("접수번호로 조회할 경우 String 타입으로 검색하셔야 합니다.");
                }
            }
            else if(selectKey.equals("이름")){
                builder.and(qGradeType2DataEntity.Name.contains(titleText));
            }
        }
        else if(selectKey.equals("전체")){
            try{
                builder.and(qGradeType2DataEntity.Studentfakeseq.eq(Integer.valueOf(titleText)));
            }
            catch (Exception e){
                builder.and(
                        (qGradeType2DataEntity.Name.contains(titleText)));
            }

        }

//        builder.and(qPersonalDataEntity.aname.eq(titleText));

        return builder;
    }
}
