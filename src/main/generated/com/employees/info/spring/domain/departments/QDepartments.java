package com.employees.info.spring.domain.departments;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDepartments is a Querydsl query type for Departments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartments extends EntityPathBase<Departments> {

    private static final long serialVersionUID = 1567019041L;

    public static final QDepartments departments = new QDepartments("departments");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath departmentName = createString("departmentName");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public QDepartments(String variable) {
        super(Departments.class, forVariable(variable));
    }

    public QDepartments(Path<? extends Departments> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartments(PathMetadata metadata) {
        super(Departments.class, metadata);
    }

}

