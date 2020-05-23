package kg.company.blogProject.repos;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;
import kg.company.blogProject.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> getAllByNickname(String nickname);
    @Query(value = "select new kg.company.blogProject.models.UserModel(u.id, u.nickname, u.email, u.firstName, u.lastName, u.mobilePhone, u.registrationDate, u.intro)" +
            "from User u where u.nickname = :nickname")
    List<UserModel> getByNickname(String nickname);

    List<User> getAllByFirstName(String firstName);
    @Query(value = "select new kg.company.blogProject.models.UserModel(u.id, u.nickname, u.email, u.firstName, u.lastName, u.mobilePhone, u.registrationDate, u.intro)" +
            "from User u where u.firstName = :firstName")
    List<UserModel> getByFirstName(String firstName);

    List<User> getAllByLastName(String lastName);
    @Query(value = "select new kg.company.blogProject.models.UserModel(u.id, u.nickname, u.email, u.firstName, u.lastName, u.mobilePhone, u.registrationDate, u.intro)" +
            "from User u where u.lastName = :lastName")
    List<UserModel> getByLastName(String lastName);

    List<User> getAllByFirstNameAndLastName(String firstName, String lastName);
    @Query(value = "select new kg.company.blogProject.models.UserModel(u.id, u.nickname, u.email, u.firstName, u.lastName, u.mobilePhone, u.registrationDate, u.intro)" +
            "from User u where u.firstName = :firstName and u.lastName = :lastName")
    List<UserModel> getByFirstNameAndLastName(String firstName, String lastName);

    List<User> getAllByRole(Role role);
    @Query(value = "select new kg.company.blogProject.models.UserModel(u.id, u.nickname, u.email, u.firstName, u.lastName, u.mobilePhone, u.registrationDate, u.intro)" +
            "from User u where u.role = :role")
    List<UserModel> getByRole(Role role);
}
