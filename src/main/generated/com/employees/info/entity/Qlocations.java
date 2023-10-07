package com.employees.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qlocations is a Querydsl query type for locations
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qlocations extends EntityPathBase<locations> {

    private static final long serialVersionUID = -169374147L;

    public static final Qlocations locations = new Qlocations("locations");

    public final StringPath city = createString("city");

    public final StringPath countryId = createString("countryId");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final StringPath postalCode = createString("postalCode");

    public final StringPath stateProvince = createString("stateProvince");

    public final StringPath streetAddress = createString("streetAddress");

    public Qlocations(String variable) {
        super(locations.class, forVariable(variable));
    }

    public Qlocations(Path<? extends locations> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qlocations(PathMetadata metadata) {
        super(locations.class, metadata);
    }

}

