package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFinalreceptionEntity is a Querydsl query type for FinalreceptionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFinalreceptionEntity extends EntityPathBase<FinalreceptionEntity> {

    private static final long serialVersionUID = 585996744L;

    public static final QFinalreceptionEntity finalreceptionEntity = new QFinalreceptionEntity("finalreceptionEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Double> behavior_development = createNumber("behavior_development", Double.class);

    public final StringPath birthday = createString("birthday");

    public final NumberPath<Integer> ck_reception = createNumber("ck_reception", Integer.class);

    public final NumberPath<Integer> classification_type = createNumber("classification_type", Integer.class);

    public final NumberPath<Double> curriculum_grades = createNumber("curriculum_grades", Double.class);

    public final NumberPath<Double> exp_activities = createNumber("exp_activities", Double.class);

    public final NumberPath<Double> final_receptioncol = createNumber("final_receptioncol", Double.class);

    public final NumberPath<Integer> graduation_type = createNumber("graduation_type", Integer.class);

    public final StringPath middle_school = createString("middle_school");

    public final StringPath name = createString("name");

    public final StringPath neis = createString("neis");

    public final NumberPath<Double> order_percentage = createNumber("order_percentage", Double.class);

    public final StringPath parental_phone = createString("parental_phone");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> receptionnum = createNumber("receptionnum", Long.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final NumberPath<Integer> sex = createNumber("sex", Integer.class);

    public final NumberPath<Double> total_grades = createNumber("total_grades", Double.class);

    public final NumberPath<Double> volunteer_activity_time = createNumber("volunteer_activity_time", Double.class);

    public QFinalreceptionEntity(String variable) {
        super(FinalreceptionEntity.class, forVariable(variable));
    }

    public QFinalreceptionEntity(Path<? extends FinalreceptionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFinalreceptionEntity(PathMetadata metadata) {
        super(FinalreceptionEntity.class, metadata);
    }

}

