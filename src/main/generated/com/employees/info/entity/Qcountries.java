package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCountries is a Querydsl query type for Countries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCountries extends EntityPathBase<Countries> {

    private static final long serialVersionUID = 89452915L;

    public static final QCountries countries = new QCountries("countries");

    public final StringPath countryId = createString("countryId");

    public final StringPath countryName = createString("countryName");

    public final NumberPath<Long> regionId = createNumber("regionId", Long.class);

    public QCountries(String variable) {
        super(Countries.class, forVariable(variable));
    }

    public QCountries(Path<? extends Countries> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountries(PathMetadata metadata) {
        super(Countries.class, metadata);
    }

}

