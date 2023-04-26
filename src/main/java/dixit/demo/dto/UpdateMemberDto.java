package dixit.demo.dto;

import dixit.demo.domain.MemberEditor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UpdateMemberDto {
    @Size(min = 2, max = 15)
    @NotBlank
    private String nickName;
    @Size(min = 2, max = 15)
    @NotBlank
    private String name;
    private LocalDateTime birthday;
    @Email
    private String email;

    @Builder
    public UpdateMemberDto(String nickName, String name, LocalDateTime birthday, String email) {
        this.nickName = nickName;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }

    public MemberEditor updateEdit(MemberEditor.MemberEditorBuilder builder){
        return builder.nickName(nickName)
                .name(name)
                .birthday(birthday)
                .email(email)
                .build();
    }


}
