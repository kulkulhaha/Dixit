package dixit.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;


@Entity
@Getter
public class Header {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @OneToMany(mappedBy = "header")
    private List<Post> posts = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private Header parent;
    @OneToMany(mappedBy = "parent")
    private List<Header> child;
}
