package com.employees.info.spring.domain.locations;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocations is a Querydsl query type for Locations
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocations extends EntityPathBase<Locations> {

    private static final long serialVersionUID = -767217893L;

    public static final QLocations locations = new QLocations("locations");

    public final StringPath city = createString("city");

    public final StringPath countryId = createString("countryId");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final StringPath postalCode = createString("postalCode");

    public final StringPath stateProvince = createString("stateProvince");

    public final StringPath streetAddress = createString("streetAddress");

    public QLocations(String variable) {
        super(Locations.class, forVariable(variable));
    }

    public QLocations(Path<? extends Locations> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocations(PathMetadata metadata) {
        super(Locations.class, metadata);
    }

}

