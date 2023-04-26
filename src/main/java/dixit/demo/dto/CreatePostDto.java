package dixit.demo.dto;

import dixit.demo.domain.Member;
import dixit.demo.domain.Post;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
public class CreatePostDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private Member member;

    @Builder
    public CreatePostDto(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
