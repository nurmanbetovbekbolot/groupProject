package kg.company.blogProject.repos;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> getAllByNickname(String nickname);
    List<User> getAllByFirstName(String firstName);
    List<User> getAllByLastName(String lastName);
    List<User> getAllByFirstNameAndLastName(String firstName, String lastName);
    List<User> getAllByRegistrationDate(Date registrationDate);
    List<User> getAllByRegistrationDateBetween(Date initRegistrationDate, Date finalRegistrationDate);
    List<User> getAllByRegistrationDateGreaterThan(Date initRegistrationDate);
    List<User> getAllByRole(Role role);
}
