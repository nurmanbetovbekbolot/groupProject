package kg.company.blogProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    Long id;
    String nickname;
    String email;
    String firstName;
    String lastName;
    String mobilePhone;
    Date registrationDate;
    String intro;
    @JsonIgnore
    String role;

    public UserModel() {

    }

    public UserModel(Long id, String nickname, String email, String firstName, String lastName, String mobilePhone, Date registrationDate, String intro) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.registrationDate = registrationDate;
        this.intro = intro;
    }
}
