package com.example.HighSchoolAdminSite.predicate;

import com.example.HighSchoolAdminSite.entity.QPersonalDataEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


public class PersonalDataPredicate {

    public static BooleanBuilder search(String aname, String titleText){
        QPersonalDataEntity qPersonalDataEntity = QPersonalDataEntity.personalDataEntity;

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(qPersonalDataEntity.aname.contains(aname));

        return builder;
    }

}
