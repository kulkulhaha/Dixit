package dixit.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Header {
    @Id @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "header")
    private List<Post> posts = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private Header parent;
    @BatchSize(size = 120)
    @OneToMany(mappedBy = "parent")
    private List<Header> child = new ArrayList<>();

    @Builder
    public Header(String name, List<Post> posts, Header parent) {
        this.name = name;
        this.posts = posts;
        this.parent = parent;

    }

    public void addParent(Header parent){
        this.parent =parent;
        parent.child.add(this);
    }

}
