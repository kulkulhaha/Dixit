package dixit.demo.dto;


import dixit.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateMemberDto {

    private String nickName;
    private String name;
    private String loginId;
    private String password;
    private String gender;
    private LocalDateTime birthday;
    private String email;

    @Builder
    public CreateMemberDto(String nickName, String name, String loginId, String password, String gender, LocalDateTime birthday, String email) {
        this.nickName = nickName;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
    }



    public Member toEntity() {
        return Member.builder()
                .nickName(nickName)
                .name(name)
                .loginId(loginId)
                .password(password)
                .gender(gender)
                .birthday(birthday)
                .email(email)
                .build();
    }
}
