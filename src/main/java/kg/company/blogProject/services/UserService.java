package kg.company.blogProject.services;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;

import java.util.Date;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    String deleteUserById(Long id);
    List<User> getAllUsersByNickname(String nickname);
    List<User> getAllUsersByFirstName(String firstName);
    List<User> getAllUsersByLastName(String lastName);
    List<User> getAllUsersByFirstNameAndLastName(String firstName, String lastName);
    List<User> getAllUsersByRegistrationDate(Date registrationDate);
    List<User> getAllUsersByRegistrationDateBetween(Date initRegistrationDate, Date finalRegistrationDate);
    List<User> getAllUsersByRegistrationDateGreaterThan(Date initRegistrationDate);
    List<User> getAllUsersByRole(Role role);
}
