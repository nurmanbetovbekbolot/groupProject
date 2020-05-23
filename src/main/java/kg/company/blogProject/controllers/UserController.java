package kg.company.blogProject.controllers;

import kg.company.blogProject.enums.Role;
import kg.company.blogProject.models.UserModel;
import kg.company.blogProject.services.UserService;
import kg.company.blogProject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") Long id,@RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        if(userService.deleteUserById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byNickname/{nickname}")
    public List<UserModel> getByNickname(@PathVariable("nickname") String nickname) {
        return userService.getAllUsersByNickname(nickname);
    }

    @GetMapping("/byFirstName")
    public List<UserModel> getByFirstName(@RequestParam(value = "first_name") String firstName) {
            return userService.getAllUsersByFirstName(firstName);
    }

    @GetMapping("/byLastName")
    public List<UserModel> getByLastName(@RequestParam(value = "last_name") String lastName) {
        return userService.getAllUsersByLastName(lastName);
    }

    @GetMapping("/byFullName")
    public List<UserModel> getByFullName(@RequestParam(value = "first_name") String firstName, @RequestParam(value = "last_name") String lastName) {
        return userService.getAllUsersByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/byRole")
    public List<UserModel> getByRole(@RequestParam(value = "role") Role role) {
        return userService.getAllUsersByRole(role);
    }
}
