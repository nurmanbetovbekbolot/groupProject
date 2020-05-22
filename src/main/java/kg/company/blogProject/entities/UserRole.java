//package kg.company.blogProject.entities;
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table(name = "sec_user_role")
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    @Column(name = "role_name", unique = true)
//    String roleName;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User user;
//}
