package com.employees.info.spring.domain.jobHistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobHistory is a Querydsl query type for JobHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJobHistory extends EntityPathBase<JobHistory> {

    private static final long serialVersionUID = 218421659L;

    public static final QJobHistory jobHistory = new QJobHistory("jobHistory");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final StringPath jobId = createString("jobId");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QJobHistory(String variable) {
        super(JobHistory.class, forVariable(variable));
    }

    public QJobHistory(Path<? extends JobHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobHistory(PathMetadata metadata) {
        super(JobHistory.class, metadata);
    }

}

