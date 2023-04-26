package dixit.demo.dto;

import dixit.demo.domain.Comment;
import dixit.demo.domain.Header;
import dixit.demo.domain.Member;
import dixit.demo.domain.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
public class FindPostDto {
    private Long id;
    private String title;

    private String content;

    private Member member;
    private List<Comment> comments = new ArrayList<>();
    private Header header;


    @Builder
    public FindPostDto(Long id, String title, String content, Member member, List<Comment> comments, Header header) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
        this.comments = comments;
        this.header = header;

    }

    public FindPostDto(Post  post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.member = post.getMember();
        this.comments = post.getComments();
        this.header = post.getHeader();
    }
}
