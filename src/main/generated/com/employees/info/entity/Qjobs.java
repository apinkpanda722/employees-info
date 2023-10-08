package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobs is a Querydsl query type for Jobs
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJobs extends EntityPathBase<Jobs> {

    private static final long serialVersionUID = 1680017975L;

    public static final QJobs jobs = new QJobs("jobs");

    public final StringPath jobId = createString("jobId");

    public final StringPath jobTitle = createString("jobTitle");

    public final NumberPath<java.math.BigDecimal> maxSalary = createNumber("maxSalary", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> minSalary = createNumber("minSalary", java.math.BigDecimal.class);

    public QJobs(String variable) {
        super(Jobs.class, forVariable(variable));
    }

    public QJobs(Path<? extends Jobs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobs(PathMetadata metadata) {
        super(Jobs.class, metadata);
    }

}

