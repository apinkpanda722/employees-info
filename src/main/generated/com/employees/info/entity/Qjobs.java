package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qjobs is a Querydsl query type for jobs
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qjobs extends EntityPathBase<jobs> {

    private static final long serialVersionUID = 1680971287L;

    public static final Qjobs jobs = new Qjobs("jobs");

    public final StringPath jobId = createString("jobId");

    public final StringPath jobTitle = createString("jobTitle");

    public final NumberPath<java.math.BigDecimal> maxSalary = createNumber("maxSalary", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> minSalary = createNumber("minSalary", java.math.BigDecimal.class);

    public Qjobs(String variable) {
        super(jobs.class, forVariable(variable));
    }

    public Qjobs(Path<? extends jobs> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qjobs(PathMetadata metadata) {
        super(jobs.class, metadata);
    }

}

