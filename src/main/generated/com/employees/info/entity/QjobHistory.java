package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QjobHistory is a Querydsl query type for jobHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QjobHistory extends EntityPathBase<jobHistory> {

    private static final long serialVersionUID = 971261720L;

    public static final QjobHistory jobHistory = new QjobHistory("jobHistory");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final StringPath jobId = createString("jobId");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QjobHistory(String variable) {
        super(jobHistory.class, forVariable(variable));
    }

    public QjobHistory(Path<? extends jobHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QjobHistory(PathMetadata metadata) {
        super(jobHistory.class, metadata);
    }

}

