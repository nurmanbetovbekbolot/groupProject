package kg.company.blogProject.services;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;
import kg.company.blogProject.models.UserModel;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    Boolean deleteUserById(Long id);
    List<UserModel> getAllUsersByNickname(String nickname);
    List<UserModel> getAllUsersByFirstName(String firstName);
    List<UserModel> getAllUsersByLastName(String lastName);
    List<UserModel> getAllUsersByFirstNameAndLastName(String firstName, String lastName);
    List<UserModel> getAllUsersByRole(Role role);
}
