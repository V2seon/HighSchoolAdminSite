package com.example.HighSchoolAdminSite.predicate;

import com.example.HighSchoolAdminSite.entity.QPersonalDataEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


public class PersonalDataPredicate {

    public static BooleanBuilder search(String selectKey, String titleText, int agraduation_type){
        QPersonalDataEntity qPersonalDataEntity = QPersonalDataEntity.personalDataEntity;

        BooleanBuilder builder = new BooleanBuilder();
        System.out.println(titleText);

        if(!selectKey.equals("전체")){
            if(selectKey.equals("접수번호")){
                builder.and(qPersonalDataEntity.aseq.eq(Long.valueOf(titleText)).and
                        (qPersonalDataEntity.agraduation_type.eq(Math.toIntExact(agraduation_type))));
            }
            else if(selectKey.equals("이름")){
                builder.and(qPersonalDataEntity.aname.contains(titleText)).and
                        (qPersonalDataEntity.agraduation_type.eq(Math.toIntExact(agraduation_type)));
            }
            else if(selectKey.equals("생년월일")){
                builder.and(qPersonalDataEntity.abirthday.contains(titleText)).and
                        (qPersonalDataEntity.agraduation_type.eq(Math.toIntExact(agraduation_type)));
            }
        }
        else if(selectKey.equals("전체")){
            builder.and((qPersonalDataEntity.aseq.eq(Long.valueOf(titleText)).or
                    (qPersonalDataEntity.aname.contains(titleText)).or
                    (qPersonalDataEntity.abirthday.contains(titleText))).and
                    (qPersonalDataEntity.agraduation_type.eq(Math.toIntExact(agraduation_type))));
        }

//        builder.and(qPersonalDataEntity.aname.eq(titleText));

        return builder;
    }

}
