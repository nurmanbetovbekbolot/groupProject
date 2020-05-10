package kg.company.blogProject.controllers;

import kg.company.blogProject.enums.Role;
import kg.company.blogProject.services.UserService;
import kg.company.blogProject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        userService.deleteUserById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{nickname}")
    public List<User> getByNickname(@PathVariable("name") String nickname) {
        return userService.getAllUsersByNickname(nickname);
    }

    @GetMapping("/byFirstName/{first_name}")
    public List<User> getByFirstName(@PathVariable("first_name") String firstName) {
        return userService.getAllUsersByFirstName(firstName);
    }

    @GetMapping("/byLastName/{last_name}")
    public List<User> getByLastName(@PathVariable("last_name") String lastName) {
        return userService.getAllUsersByLastName(lastName);
    }

    @GetMapping(params = {"first_name", "last_name"})
    public List<User> getByNickname(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
        return userService.getAllUsersByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/{date}")
    public List<User> getByDate(@PathVariable("date") Date regDate) {
        return userService.getAllUsersByRegistrationDate(regDate);
    }

    @GetMapping(params = {"init", "final"})
    public List<User> getByDateBetween(@RequestParam("init") Date initDate, @RequestParam("final") Date finalDate) {
        return userService.getAllUsersByRegistrationDateBetween(initDate, finalDate);
    }

    @GetMapping("/byDateGreaterThan/{date}")
    public List<User> getByDateGreater(@PathVariable("date") Date date) {
        return userService.getAllUsersByRegistrationDateGreaterThan(date);
    }

    @GetMapping("/byRole/{role}")
    public List<User> getByRole(@PathVariable("role") Role role) {
        return userService.getAllUsersByRole(role);
    }
}
