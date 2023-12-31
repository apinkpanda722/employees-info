package com.employees.info.spring.domain.employees;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployees is a Querydsl query type for Employees
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployees extends EntityPathBase<Employees> {

    private static final long serialVersionUID = 506043049L;

    public static final QEmployees employees = new QEmployees("employees");

    public final NumberPath<java.math.BigDecimal> commissionPct = createNumber("commissionPct", java.math.BigDecimal.class);

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath hireDate = createString("hireDate");

    public final StringPath jobId = createString("jobId");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);

    public QEmployees(String variable) {
        super(Employees.class, forVariable(variable));
    }

    public QEmployees(Path<? extends Employees> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployees(PathMetadata metadata) {
        super(Employees.class, metadata);
    }

}

