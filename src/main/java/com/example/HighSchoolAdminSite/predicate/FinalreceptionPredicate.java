package com.example.HighSchoolAdminSite.predicate;

import com.example.HighSchoolAdminSite.entity.QFinalreceptionEntity;
import com.example.HighSchoolAdminSite.entity.QPersonalDataEntity;
import com.querydsl.core.BooleanBuilder;


public class FinalreceptionPredicate {

    public static BooleanBuilder search(String selectKey, String titleText){
        QFinalreceptionEntity qFinalreceptionEntity = QFinalreceptionEntity.finalreceptionEntity;

        BooleanBuilder builder = new BooleanBuilder();
        System.out.println(titleText);

        if(!selectKey.equals("전체")){
            if(selectKey.equals("접수번호")){
                try{
                    builder.and(qFinalreceptionEntity.seq.eq(Long.valueOf(titleText)));
                }
                catch (Exception e){
                    builder.and(qFinalreceptionEntity.name.contains(titleText));
                    System.out.println("접수번호로 조회할 경우 String 타입으로 검색하셔야 합니다.");
                }
            }
            else if(selectKey.equals("이름")){
                builder.and(qFinalreceptionEntity.name.contains(titleText));
            }
            else if(selectKey.equals("생년월일")){
                builder.and(qFinalreceptionEntity.birthday.contains(titleText));
            }
        }
        else if(selectKey.equals("전체")){
            try{
                builder.and(qFinalreceptionEntity.seq.eq(Long.valueOf(titleText)));
            }
            catch (Exception e){
                builder.and(
                        (qFinalreceptionEntity.name.contains(titleText)).or
                        (qFinalreceptionEntity.birthday.contains(titleText)));
            }

        }

//        builder.and(qPersonalDataEntity.aname.eq(titleText));

        return builder;
    }

}
