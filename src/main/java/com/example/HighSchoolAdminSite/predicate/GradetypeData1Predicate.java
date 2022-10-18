package com.example.HighSchoolAdminSite.predicate;

import com.example.HighSchoolAdminSite.entity.QGradeType1DataEntity;
import com.example.HighSchoolAdminSite.entity.QPersonalDataEntity;
import com.querydsl.core.BooleanBuilder;

public class GradetypeData1Predicate {
    public static BooleanBuilder search(String selectKey, String titleText){
        QGradeType1DataEntity qGradeType1DataEntity = QGradeType1DataEntity.gradeType1DataEntity;

        BooleanBuilder builder = new BooleanBuilder();
        System.out.println(titleText);

        if(!selectKey.equals("전체")){
            if(selectKey.equals("접수번호")){
                try{
                    builder.and(qGradeType1DataEntity.Studentfakeseq.eq(Integer.valueOf(titleText)));
                }
                catch (Exception e){
                    builder.and(qGradeType1DataEntity.Name.contains(titleText));
                    System.out.println("접수번호로 조회할 경우 String 타입으로 검색하셔야 합니다.");
                }
            }
            else if(selectKey.equals("이름")){
                builder.and(qGradeType1DataEntity.Name.contains(titleText));
            }
        }
        else if(selectKey.equals("전체")){
            try{
                builder.and(qGradeType1DataEntity.Studentfakeseq.eq(Integer.valueOf(titleText)));
            }
            catch (Exception e){
                builder.and(
                        (qGradeType1DataEntity.Name.contains(titleText)));
            }

        }

//        builder.and(qPersonalDataEntity.aname.eq(titleText));

        return builder;
    }
}
