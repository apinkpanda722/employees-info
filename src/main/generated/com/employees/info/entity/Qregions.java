package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.employees.info.spring.domain.regions.Regions;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegions is a Querydsl query type for Regions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegions extends EntityPathBase<Regions> {

    private static final long serialVersionUID = -1610173826L;

    public static final QRegions regions = new QRegions("regions");

    public final NumberPath<Long> regionId = createNumber("regionId", Long.class);

    public final StringPath regionName = createString("regionName");

    public QRegions(String variable) {
        super(Regions.class, forVariable(variable));
    }

    public QRegions(Path<? extends Regions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegions(PathMetadata metadata) {
        super(Regions.class, metadata);
    }

}

