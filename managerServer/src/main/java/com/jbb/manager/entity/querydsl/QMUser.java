package com.jbb.manager.entity.querydsl;

import com.jbb.manager.entity.MUser;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMUser is a Querydsl query type for MUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMUser extends EntityPathBase<MUser> {

    private static final long serialVersionUID = 738722207L;

    public static final QMUser mUser = new QMUser("mUser");

    public final StringPath address = createString("address");

    public final StringPath headImg = createString("headImg");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.sql.Timestamp> loginTime = createDateTime("loginTime", java.sql.Timestamp.class);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath realName = createString("realName");

    public final StringPath username = createString("username");

    public final NumberPath<Integer> userStatus = createNumber("userStatus", Integer.class);

    public QMUser(String variable) {
        super(MUser.class, forVariable(variable));
    }

    public QMUser(Path<? extends MUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMUser(PathMetadata metadata) {
        super(MUser.class, metadata);
    }

}

