package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qregions is a Querydsl query type for regions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qregions extends EntityPathBase<regions> {

    private static final long serialVersionUID = 1020140190L;

    public static final Qregions regions = new Qregions("regions");

    public final NumberPath<Long> regionId = createNumber("regionId", Long.class);

    public final StringPath regionName = createString("regionName");

    public Qregions(String variable) {
        super(regions.class, forVariable(variable));
    }

    public Qregions(Path<? extends regions> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qregions(PathMetadata metadata) {
        super(regions.class, metadata);
    }

}

