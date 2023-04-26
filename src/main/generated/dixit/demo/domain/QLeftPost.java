package dixit.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeftPost is a Querydsl query type for LeftPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLeftPost extends EntityPathBase<LeftPost> {

    private static final long serialVersionUID = 606942262L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLeftPost leftPost = new QLeftPost("leftPost");

    public final QPost _super;

    //inherited
    public final ListPath<Post, QPost> child;

    //inherited
    public final ListPath<Comment, QComment> comments;

    //inherited
    public final StringPath content;

    //inherited
    public final StringPath createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate;

    // inherited
    public final QMember member;

    // inherited
    public final QPost parent;

    //inherited
    public final StringPath title;

    public QLeftPost(String variable) {
        this(LeftPost.class, forVariable(variable), INITS);
    }

    public QLeftPost(Path<? extends LeftPost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLeftPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLeftPost(PathMetadata metadata, PathInits inits) {
        this(LeftPost.class, metadata, inits);
    }

    public QLeftPost(Class<? extends LeftPost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QPost(type, metadata, inits);
        this.child = _super.child;
        this.comments = _super.comments;
        this.content = _super.content;
        this.createdBy = _super.createdBy;
        this.createdDate = _super.createdDate;
        this.id = _super.id;
        this.lastModifiedBy = _super.lastModifiedBy;
        this.lastModifiedDate = _super.lastModifiedDate;
        this.member = _super.member;
        this.parent = _super.parent;
        this.title = _super.title;
    }

}

