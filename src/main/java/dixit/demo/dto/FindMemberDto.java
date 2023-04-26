package dixit.demo.dto;

import dixit.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class FindMemberDto {
    private Long id;
    private String nickName;
    private String name;
    private String loginId;
    private LocalDateTime birthday;
    private String email;

    @Builder
    public FindMemberDto(Long id,String nickName, String name, String loginId, LocalDateTime birthday, String email) {
        this.id = id;
        this.nickName = nickName;
        this.name = name;
        this.loginId = loginId;
        this.birthday = birthday;
        this.email = email;
    }

    public FindMemberDto(Member member){
        this.id = member.getId();
        this.nickName = member.getNickName();
        this.name = member.getName();
        this.loginId = member.getLoginId();
        this.birthday = member.getBirthday();
        this.email = member.getEmail();
    }
}

