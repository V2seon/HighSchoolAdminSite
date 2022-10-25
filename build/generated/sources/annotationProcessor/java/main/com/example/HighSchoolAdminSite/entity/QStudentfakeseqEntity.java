package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentfakeseqEntity is a Querydsl query type for StudentfakeseqEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentfakeseqEntity extends EntityPathBase<StudentfakeseqEntity> {

    private static final long serialVersionUID = -2036910722L;

    public static final QStudentfakeseqEntity studentfakeseqEntity = new QStudentfakeseqEntity("studentfakeseqEntity");

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final NumberPath<Integer> passnum = createNumber("passnum", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final NumberPath<Long> sseq = createNumber("sseq", Long.class);

    public final NumberPath<Integer> studentfakeseq = createNumber("studentfakeseq", Integer.class);

    public QStudentfakeseqEntity(String variable) {
        super(StudentfakeseqEntity.class, forVariable(variable));
    }

    public QStudentfakeseqEntity(Path<? extends StudentfakeseqEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentfakeseqEntity(PathMetadata metadata) {
        super(StudentfakeseqEntity.class, metadata);
    }

}

