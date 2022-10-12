package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminEntity is a Querydsl query type for AdminEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminEntity extends EntityPathBase<AdminEntity> {

    private static final long serialVersionUID = -1051601882L;

    public static final QAdminEntity adminEntity = new QAdminEntity("adminEntity");

    public final StringPath aid = createString("aid");

    public final StringPath alogindatetime = createString("alogindatetime");

    public final NumberPath<Long> apk = createNumber("apk", Long.class);

    public final StringPath apw = createString("apw");

    public final StringPath asignupdatetime = createString("asignupdatetime");

    public QAdminEntity(String variable) {
        super(AdminEntity.class, forVariable(variable));
    }

    public QAdminEntity(Path<? extends AdminEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminEntity(PathMetadata metadata) {
        super(AdminEntity.class, metadata);
    }

}

