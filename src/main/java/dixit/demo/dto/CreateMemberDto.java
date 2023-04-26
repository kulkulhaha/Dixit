package dixit.demo.dto;


import dixit.demo.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateMemberDto {

    @Size(min = 2, max = 15)
    @NotBlank
    private String nickName;
    @NotBlank
    @Size(min = 2, max = 15)
    private String name;
    @Size(min = 5, max = 20)
    @NotBlank
    private String loginId;
    @Size(min = 8, max = 16)
    @NotBlank
    private String password;
    private String gender;
    private LocalDateTime birthday;
    @Email
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
