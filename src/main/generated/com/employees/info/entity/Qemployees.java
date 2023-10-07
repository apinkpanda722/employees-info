package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qemployees is a Querydsl query type for employees
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qemployees extends EntityPathBase<employees> {

    private static final long serialVersionUID = -629332380L;

    public static final Qemployees employees = new Qemployees("employees");

    public final NumberPath<java.math.BigDecimal> commissionPct = createNumber("commissionPct", java.math.BigDecimal.class);

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final StringPath firstName = createString("firstName");

    public final DateTimePath<java.time.LocalDateTime> hireDate = createDateTime("hireDate", java.time.LocalDateTime.class);

    public final StringPath jobId = createString("jobId");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);

    public Qemployees(String variable) {
        super(employees.class, forVariable(variable));
    }

    public Qemployees(Path<? extends employees> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qemployees(PathMetadata metadata) {
        super(employees.class, metadata);
    }

}

