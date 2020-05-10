package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;
import kg.company.blogProject.repos.UserRepo;
import kg.company.blogProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        if(userRepo.findById(id).isPresent()) {
            User existingUser = userRepo.findById(id).get();
            existingUser.setNickname(user.getNickname());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setMobilePhone(user.getMobilePhone());
            existingUser.setPasswordHash(user.getPasswordHash());
            existingUser.setRegistrationDate(user.getRegistrationDate());
            existingUser.setIntro(user.getIntro());
            existingUser.setRole(user.getRole());
            User updatedUser = userRepo.save(existingUser);
            return updatedUser;
        }
        else return null;
    }

    @Override
    public String deleteUserById(Long id) {
        String result = "deleted " + userRepo.findById(id);
        userRepo.deleteById(id);
        return result;
    }

    @Override
    public List<User> getAllUsersByNickname(String nickname) {
        return userRepo.getAllByNickname(nickname);
    }

    @Override
    public List<User> getAllUsersByFirstName(String firstName) {
        return userRepo.getAllByFirstName(firstName);
    }

    @Override
    public List<User> getAllUsersByLastName(String lastName) {
        return userRepo.getAllByLastName(lastName);
    }

    @Override
    public List<User> getAllUsersByFirstNameAndLastName(String firstName, String lastName) {
        return userRepo.getAllByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<User> getAllUsersByRegistrationDate(Date registrationDate) {
        return userRepo.getAllByRegistrationDate(registrationDate);
    }

    @Override
    public List<User> getAllUsersByRegistrationDateBetween(Date initRegistrationDate, Date finalRegistrationDate) {
        return userRepo.getAllByRegistrationDateBetween(initRegistrationDate, finalRegistrationDate);
    }

    @Override
    public List<User> getAllUsersByRegistrationDateGreaterThan(Date initRegistrationDate) {
        return userRepo.getAllByRegistrationDateGreaterThan(initRegistrationDate);
    }

    @Override
    public List<User> getAllUsersByRole(Role role) {
        return userRepo.getAllByRole(role);
    }
}
