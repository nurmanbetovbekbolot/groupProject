package kg.company.blogProject.entities;

import kg.company.blogProject.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "b_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "nickname", unique = true)
    String nickname;

    @Column(name = "password")
    String password;

    @Email
    @Column(name = "email")
    String email;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "mobile_phone")
    String mobilePhone;

    @CreatedDate
    @Column(name = "registration_date")
    Date registrationDate = new Date();

    @Column(name = "intro")
    String intro;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    Role role;
}
