package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGradeType3DataEntity is a Querydsl query type for GradeType3DataEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGradeType3DataEntity extends EntityPathBase<GradeType3DataEntity> {

    private static final long serialVersionUID = -1195956517L;

    public static final QGradeType3DataEntity gradeType3DataEntity = new QGradeType3DataEntity("gradeType3DataEntity");

    public final NumberPath<Long> aSeq = createNumber("aSeq", Long.class);

    public final NumberPath<Double> Grade1 = createNumber("Grade1", Double.class);

    public final NumberPath<Double> Grade2 = createNumber("Grade2", Double.class);

    public final StringPath Name = createString("Name");

    public final NumberPath<Integer> Studentfakeseq = createNumber("Studentfakeseq", Integer.class);

    public final NumberPath<Double> TotalGrades = createNumber("TotalGrades", Double.class);

    public QGradeType3DataEntity(String variable) {
        super(GradeType3DataEntity.class, forVariable(variable));
    }

    public QGradeType3DataEntity(Path<? extends GradeType3DataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGradeType3DataEntity(PathMetadata metadata) {
        super(GradeType3DataEntity.class, metadata);
    }

}

