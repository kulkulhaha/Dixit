package dixit.demo.dto;

import dixit.demo.domain.MemberEditor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UpdateMemberDto {
    private String nickName;
    private String name;
    private LocalDateTime birthday;
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
