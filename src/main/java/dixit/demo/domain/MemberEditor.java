package dixit.demo.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberEditor extends BaseEntity{

    private String password;
    private String nickName;
    private String name;
    private String gender;
    private LocalDateTime birthday;
    private String email;
    private String phoneNumber;
    private ApplyRoute applyRoute;
    private String motive;

    @Builder
    public MemberEditor(String password, String nickName, String name, String gender, LocalDateTime birthday, String email, String phoneNumber, ApplyRoute applyRoute, String motive) {
        this.password = password;
        this.nickName = nickName;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.applyRoute = applyRoute;
        this.motive = motive;
    }
}
