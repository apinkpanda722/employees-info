package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qcountries is a Querydsl query type for countries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qcountries extends EntityPathBase<countries> {

    private static final long serialVersionUID = -1914515053L;

    public static final Qcountries countries = new Qcountries("countries");

    public final StringPath countryId = createString("countryId");

    public final StringPath countryName = createString("countryName");

    public final NumberPath<Long> regionId = createNumber("regionId", Long.class);

    public Qcountries(String variable) {
        super(countries.class, forVariable(variable));
    }

    public Qcountries(Path<? extends countries> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qcountries(PathMetadata metadata) {
        super(countries.class, metadata);
    }

}

