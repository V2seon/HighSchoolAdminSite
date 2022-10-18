package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonalDataEntity is a Querydsl query type for PersonalDataEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPersonalDataEntity extends EntityPathBase<PersonalDataEntity> {

    private static final long serialVersionUID = 798790649L;

    public static final QPersonalDataEntity personalDataEntity = new QPersonalDataEntity("personalDataEntity");

    public final StringPath aaddress = createString("aaddress");

    public final StringPath aapplication_incharge_name = createString("aapplication_incharge_name");

    public final StringPath aapplication_incharge_phone = createString("aapplication_incharge_phone");

    public final StringPath aarea2_name = createString("aarea2_name");

    public final StringPath aarea_name = createString("aarea_name");

    public final StringPath abirthday = createString("abirthday");

    public final NumberPath<Integer> aclassification_type = createNumber("aclassification_type", Integer.class);

    public final StringPath adetailed_address = createString("adetailed_address");

    public final NumberPath<Integer> agraduation_month = createNumber("agraduation_month", Integer.class);

    public final NumberPath<Integer> agraduation_type = createNumber("agraduation_type", Integer.class);

    public final NumberPath<Integer> agraduation_year = createNumber("agraduation_year", Integer.class);

    public final StringPath aguardian = createString("aguardian");

    public final StringPath ahome_phone = createString("ahome_phone");

    public final StringPath aid_picture = createString("aid_picture");

    public final StringPath amiddle_school = createString("amiddle_school");

    public final StringPath amiddle_school_phone = createString("amiddle_school_phone");

    public final NumberPath<Integer> amiddle_school_unique_number = createNumber("amiddle_school_unique_number", Integer.class);

    public final StringPath aname = createString("aname");

    public final StringPath aparental = createString("aparental");

    public final StringPath aparental_phone = createString("aparental_phone");

    public final StringPath aphone = createString("aphone");

    public final StringPath apostal_code = createString("apostal_code");

    public final NumberPath<Long> aseq = createNumber("aseq", Long.class);

    public final NumberPath<Integer> asex = createNumber("asex", Integer.class);

    public final NumberPath<Integer> astudentfakeseq = createNumber("astudentfakeseq", Integer.class);

    public QPersonalDataEntity(String variable) {
        super(PersonalDataEntity.class, forVariable(variable));
    }

    public QPersonalDataEntity(Path<? extends PersonalDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonalDataEntity(PathMetadata metadata) {
        super(PersonalDataEntity.class, metadata);
    }

}

