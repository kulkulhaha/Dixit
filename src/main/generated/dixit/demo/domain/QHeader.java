package dixit.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHeader is a Querydsl query type for Header
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHeader extends EntityPathBase<Header> {

    private static final long serialVersionUID = 547403068L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHeader header = new QHeader("header");

    public final ListPath<Header, QHeader> child = this.<Header, QHeader>createList("child", Header.class, QHeader.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QHeader parent;

    public final ListPath<Post, QPost> posts = this.<Post, QPost>createList("posts", Post.class, QPost.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QHeader(String variable) {
        this(Header.class, forVariable(variable), INITS);
    }

    public QHeader(Path<? extends Header> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHeader(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHeader(PathMetadata metadata, PathInits inits) {
        this(Header.class, metadata, inits);
    }

    public QHeader(Class<? extends Header> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QHeader(forProperty("parent"), inits.get("parent")) : null;
    }

}

