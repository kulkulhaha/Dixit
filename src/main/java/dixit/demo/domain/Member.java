package dixit.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{
    @Id @GeneratedValue
    private Long id;
    private String loginId;
    private String password;
    private String nickName;

    private String name;
    private String gender;
    private LocalDateTime birthday;

    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private ApplyRoute applyRoute;
    @Lob
    private String motive;

    @OneToMany(mappedBy = "member")
    private final List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private final List<Comment> comments = new ArrayList<>();

    @Builder
    public Member(Long id, String loginId, String password, String nickName, String name, String gender, LocalDateTime birthday, String email, String phoneNumber, ApplyRoute applyRoute, String motive) {
        this.id = id;
        this.loginId = loginId;
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






    public MemberEditor.MemberEditorBuilder toEditor(){
        return MemberEditor.builder()
                .nickName(nickName)
                .password(password)
                .name(name)
                .gender(gender)
                .birthday(birthday)
                .email(email)
                .phoneNumber(phoneNumber)
                .applyRoute(applyRoute)
                .motive(motive);
    }

    public void edit(MemberEditor memberEditor){
        nickName = memberEditor.getNickName();
        password = memberEditor.getPassword();
        name = memberEditor.getName();
        gender = memberEditor.getGender();
        birthday = memberEditor.getBirthday();
        email = memberEditor.getEmail();
        phoneNumber = memberEditor.getPhoneNumber();
        applyRoute = memberEditor.getApplyRoute();
        motive = memberEditor.getMotive();
    }
}
