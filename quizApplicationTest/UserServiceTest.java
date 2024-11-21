//import com.epam.quizApplication.ConsoleUserInterface.QuizManagement;
//import com.epam.quizApplication.constant.Role;
//import com.epam.quizApplication.model.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import com.epam.quizApplication.service.UserServicesImple;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserServiceTest {
//
//    private UserServicesImple userServicesImple;
//
//    @BeforeEach
//    void setUp() {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(QuizManagement.class);
//        userServicesImple = applicationContext.getBean(UserServicesImple.class);
//        User newUser = new User("Rahul@gmail.com", "password", Role.USER);
//        userServicesImple.creatUser(newUser);
//    }
//
//    @Test
//    void testCreateUser_UserNotPresent() throws UserNamePresentException {
//        User newUserAddition=new User("Rohith@123","user@123",Role.USER);
//       userServicesImple.creatUser(newUserAddition);
//
//        assertTrue(userServicesImple.getUsers().contains(newUserAddition));
//    }
//
//    @Test
//    void testCreateUser_UserPresent() {
//        User newUserAddition=new User("Rohith@123","user@123",Role.USER);
//        userServicesImple.creatUser(newUserAddition);
//
//        UserNamePresentException exception = assertThrows(UserNamePresentException.class, () -> {
//            userServicesImple.creatUser(newUserAddition);
//        });
//        assertEquals("Enter Different username", exception.getMessage());
//    }
////
//    @Test
//    void testDeleteUser_UserPresent(){
//        User existingUser = new User("existingUser", "password",Role.ADMIN);
//        userServicesImple.creatUser(existingUser);
//
//        userServicesImple.deleteUser(existingUser);
//        assertFalse(userServicesImple.getUsers().contains(existingUser));
//    }
//
//    @Test
//    void testDeleteUser_UserNotPresent() {
//        User nonExistingUser = new User("Manish@123", "admin@123",Role.USER);
//
//        UserNameNotPresentException exception = assertThrows(UserNameNotPresentException.class, () -> {
//            userServicesImple.deleteUser(nonExistingUser);
//        });
//        assertEquals("No User Present to remove", exception.getMessage());
//    }
//
//    @Test
//    void testValidate_ValidUser() {
//        User existingUser = new User("ashish@gmail.com", "user@123",Role.USER);
//        userServicesImple.creatUser(existingUser);
//
//        assertTrue(userServicesImple.validate("ashish@gmail.com", "user@123"));
//    }
//
//    @Test
//    void testValidate_InvalidUser() {
//        User existingUser = new User("ashish@gmail.com", "user@123",Role.USER);
//        userServicesImple.creatUser(existingUser);
//
//        assertFalse(userServicesImple.validate("ashish@gmail.com", "user@"));
//    }
//}
