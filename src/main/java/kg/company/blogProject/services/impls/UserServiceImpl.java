package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;
import kg.company.blogProject.models.UserModel;
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
            existingUser.setPassword(user.getPassword());
            existingUser.setRegistrationDate(user.getRegistrationDate());
            existingUser.setIntro(user.getIntro());
            existingUser.setRole(user.getRole());
            User updatedUser = userRepo.save(existingUser);
            return updatedUser;
        }
        else return null;
    }

    @Override
    public Boolean deleteUserById(Long id) {
        userRepo.deleteById(id);
        if(userRepo.findById(id).isPresent()) {
            return false;
        } else return true;
    }

    @Override
    public List<UserModel> getAllUsersByNickname(String nickname) {
        List<UserModel> userModels = userRepo.getByNickname(nickname);
        for(int i = 0; i < userModels.size(); i++) {
            Optional<User> user = userRepo.findById(userModels.get(i).getId());
            User temp = user.get();
            userModels.get(i).setRole(temp.getRole().name());
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByFirstName(String firstName) {
        List<UserModel> userModels = userRepo.getByFirstName(firstName);
        for(int i = 0; i < userModels.size(); i++) {
            Optional<User> user = userRepo.findById(userModels.get(i).getId());
            User temp = user.get();
            userModels.get(i).setRole(temp.getRole().name());
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByLastName(String lastName) {
        List<UserModel> userModels = userRepo.getByLastName(lastName);
        for(int i = 0; i < userModels.size(); i++) {
            Optional<User> user = userRepo.findById(userModels.get(i).getId());
            User temp = user.get();
            userModels.get(i).setRole(temp.getRole().name());
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByFirstNameAndLastName(String firstName, String lastName) {
        List<UserModel> userModels = userRepo.getByFirstNameAndLastName(firstName, lastName);
        for(int i = 0; i < userModels.size(); i++) {
            Optional<User> user = userRepo.findById(userModels.get(i).getId());
            User temp = user.get();
            userModels.get(i).setRole(temp.getRole().name());
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByRole(Role role) {
        List<UserModel> userModels = userRepo.getByRole(role);
        for(int i = 0; i < userModels.size(); i++) {
            Optional<User> user = userRepo.findById(userModels.get(i).getId());
            User temp = user.get();
            userModels.get(i).setRole(temp.getRole().name());
        }
        return userModels;
    }
}
