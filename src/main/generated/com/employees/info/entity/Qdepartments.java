package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qdepartments is a Querydsl query type for departments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qdepartments extends EntityPathBase<departments> {

    private static final long serialVersionUID = 411771520L;

    public static final Qdepartments departments = new Qdepartments("departments");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath departmentName = createString("departmentName");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public Qdepartments(String variable) {
        super(departments.class, forVariable(variable));
    }

    public Qdepartments(Path<? extends departments> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qdepartments(PathMetadata metadata) {
        super(departments.class, metadata);
    }

}

