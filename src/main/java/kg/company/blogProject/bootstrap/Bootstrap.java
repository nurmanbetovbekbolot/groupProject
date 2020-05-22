//package kg.company.blogProject.bootstrap;
//
//import kg.company.blogProject.entities.UserRole;
//import kg.company.blogProject.repos.UserRepo;
//import kg.company.blogProject.repos.UserRoleRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import kg.company.blogProject.entities.User;
//
//@Component
//public class Bootstrap implements CommandLineRunner {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private UserRoleRepo userRoleRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        User admin = User.builder()
//                .nickname("admin")
//                .password(passwordEncoder.encode("passwordforadmin2020"))
//                .email("admin@gmail.com")
//                .build();
//        UserRole adminRole = UserRole.builder()
//                .roleName("ROLE_ADMIN")
//                .user(admin)
//                .build();
//
//        userRepo.save(admin);
//        userRoleRepo.save(adminRole);
//    }
//}
