package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentEntity is a Querydsl query type for StudentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentEntity extends EntityPathBase<StudentEntity> {

    private static final long serialVersionUID = 810859794L;

    public static final QStudentEntity studentEntity = new QStudentEntity("studentEntity");

    public final StringPath student_password = createString("student_password");

    public final StringPath student_phone = createString("student_phone");

    public final NumberPath<Long> student_seq = createNumber("student_seq", Long.class);

    public final StringPath student_signupdatetime = createString("student_signupdatetime");

    public QStudentEntity(String variable) {
        super(StudentEntity.class, forVariable(variable));
    }

    public QStudentEntity(Path<? extends StudentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentEntity(PathMetadata metadata) {
        super(StudentEntity.class, metadata);
    }

}

