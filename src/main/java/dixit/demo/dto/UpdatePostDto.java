package dixit.demo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UpdatePostDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    @Builder
    public UpdatePostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
