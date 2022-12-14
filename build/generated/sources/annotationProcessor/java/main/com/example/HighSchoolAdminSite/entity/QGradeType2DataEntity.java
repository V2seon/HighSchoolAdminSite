package com.example.HighSchoolAdminSite.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGradeType2DataEntity is a Querydsl query type for GradeType2DataEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGradeType2DataEntity extends EntityPathBase<GradeType2DataEntity> {

    private static final long serialVersionUID = 600994842L;

    public static final QGradeType2DataEntity gradeType2DataEntity = new QGradeType2DataEntity("gradeType2DataEntity");

    public final NumberPath<Long> aSeq = createNumber("aSeq", Long.class);

    public final NumberPath<Double> CurriculumGrades = createNumber("CurriculumGrades", Double.class);

    public final NumberPath<Integer> FirstAbsant = createNumber("FirstAbsant", Integer.class);

    public final NumberPath<Double> FirstBehaviorDevelopment = createNumber("FirstBehaviorDevelopment", Double.class);

    public final NumberPath<Double> FirstExpActivities = createNumber("FirstExpActivities", Double.class);

    public final NumberPath<Integer> FirstLate = createNumber("FirstLate", Integer.class);

    public final NumberPath<Integer> FirstLeave = createNumber("FirstLeave", Integer.class);

    public final NumberPath<Integer> FirstResult = createNumber("FirstResult", Integer.class);

    public final NumberPath<Integer> FirstVolunteerActivityTime = createNumber("FirstVolunteerActivityTime", Integer.class);

    public final NumberPath<Integer> IsCheck = createNumber("IsCheck", Integer.class);

    public final StringPath Name = createString("Name");

    public final NumberPath<Double> NonCurriculumGrades = createNumber("NonCurriculumGrades", Double.class);

    public final NumberPath<Double> OrderPercentage = createNumber("OrderPercentage", Double.class);

    public final NumberPath<Double> OrderTotal = createNumber("OrderTotal", Double.class);

    public final NumberPath<Integer> SecondAbsant = createNumber("SecondAbsant", Integer.class);

    public final NumberPath<Double> SecondBehaviorDevelopment = createNumber("SecondBehaviorDevelopment", Double.class);

    public final NumberPath<Double> SecondExpActivities = createNumber("SecondExpActivities", Double.class);

    public final StringPath SecondFirstType1 = createString("SecondFirstType1");

    public final StringPath SecondFirstType10 = createString("SecondFirstType10");

    public final StringPath SecondFirstType11 = createString("SecondFirstType11");

    public final StringPath SecondFirstType2 = createString("SecondFirstType2");

    public final StringPath SecondFirstType3 = createString("SecondFirstType3");

    public final StringPath SecondFirstType4 = createString("SecondFirstType4");

    public final StringPath SecondFirstType5 = createString("SecondFirstType5");

    public final StringPath SecondFirstType6 = createString("SecondFirstType6");

    public final StringPath SecondFirstType7 = createString("SecondFirstType7");

    public final StringPath SecondFirstType8 = createString("SecondFirstType8");

    public final StringPath SecondFirstType9 = createString("SecondFirstType9");

    public final NumberPath<Integer> SecondLate = createNumber("SecondLate", Integer.class);

    public final NumberPath<Integer> SecondLeave = createNumber("SecondLeave", Integer.class);

    public final NumberPath<Integer> SecondResult = createNumber("SecondResult", Integer.class);

    public final StringPath SecondSecondType1 = createString("SecondSecondType1");

    public final StringPath SecondSecondType10 = createString("SecondSecondType10");

    public final StringPath SecondSecondType11 = createString("SecondSecondType11");

    public final StringPath SecondSecondType2 = createString("SecondSecondType2");

    public final StringPath SecondSecondType3 = createString("SecondSecondType3");

    public final StringPath SecondSecondType4 = createString("SecondSecondType4");

    public final StringPath SecondSecondType5 = createString("SecondSecondType5");

    public final StringPath SecondSecondType6 = createString("SecondSecondType6");

    public final StringPath SecondSecondType7 = createString("SecondSecondType7");

    public final StringPath SecondSecondType8 = createString("SecondSecondType8");

    public final StringPath SecondSecondType9 = createString("SecondSecondType9");

    public final NumberPath<Integer> SecondVolunteerActivityTime = createNumber("SecondVolunteerActivityTime", Integer.class);

    public final NumberPath<Integer> Studentfakeseq = createNumber("Studentfakeseq", Integer.class);

    public final NumberPath<Integer> ThirdAbsant = createNumber("ThirdAbsant", Integer.class);

    public final NumberPath<Double> ThirdBehaviorDevelopment = createNumber("ThirdBehaviorDevelopment", Double.class);

    public final NumberPath<Double> ThirdExpActivities = createNumber("ThirdExpActivities", Double.class);

    public final StringPath ThirdFirstType1 = createString("ThirdFirstType1");

    public final StringPath ThirdFirstType10 = createString("ThirdFirstType10");

    public final StringPath ThirdFirstType11 = createString("ThirdFirstType11");

    public final StringPath ThirdFirstType2 = createString("ThirdFirstType2");

    public final StringPath ThirdFirstType3 = createString("ThirdFirstType3");

    public final StringPath ThirdFirstType4 = createString("ThirdFirstType4");

    public final StringPath ThirdFirstType5 = createString("ThirdFirstType5");

    public final StringPath ThirdFirstType6 = createString("ThirdFirstType6");

    public final StringPath ThirdFirstType7 = createString("ThirdFirstType7");

    public final StringPath ThirdFirstType8 = createString("ThirdFirstType8");

    public final StringPath ThirdFirstType9 = createString("ThirdFirstType9");

    public final NumberPath<Integer> ThirdLate = createNumber("ThirdLate", Integer.class);

    public final NumberPath<Integer> ThirdLeave = createNumber("ThirdLeave", Integer.class);

    public final NumberPath<Integer> ThirdResult = createNumber("ThirdResult", Integer.class);

    public final NumberPath<Integer> ThirdVolunteerActivityTime = createNumber("ThirdVolunteerActivityTime", Integer.class);

    public final NumberPath<Double> TotalBehaviorDevelopment = createNumber("TotalBehaviorDevelopment", Double.class);

    public final NumberPath<Double> TotalGrades = createNumber("TotalGrades", Double.class);

    public final NumberPath<Double> TotalVolunteerActivityTime = createNumber("TotalVolunteerActivityTime", Double.class);

    public QGradeType2DataEntity(String variable) {
        super(GradeType2DataEntity.class, forVariable(variable));
    }

    public QGradeType2DataEntity(Path<? extends GradeType2DataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGradeType2DataEntity(PathMetadata metadata) {
        super(GradeType2DataEntity.class, metadata);
    }

}

