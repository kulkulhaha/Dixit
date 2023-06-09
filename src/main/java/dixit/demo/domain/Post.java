package dixit.demo.domain;

import dixit.demo.dto.PostEditor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Post extends BaseEntity{
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String content;
    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private Member member;
    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private Header header;

    @Builder
    public Post(String title, String content, Member member, List<Comment> comments, Header header) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.comments = comments != null?comments:new ArrayList<>();
        this.header = header;
    }

    public PostEditor.PostEditorBuilder toEditor(){
        return PostEditor.builder()
                .title(title)
                .content(content);
    }

    public void edit(PostEditor editor){
        title = editor.getTitle();
        content = editor.getContent();
    }
}
