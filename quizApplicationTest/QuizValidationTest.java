//import com.epam.quizApplication.model.Quiz;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import com.epam.quizApplication.service.QuestionServicesImple;
//import com.epam.quizApplication.service.QuizServicesImple;
//import com.epam.quizApplication.service.QuizValidateImple;
//import com.epam.quizApplication.service.serviceInterface.QuizService;
//import com.epam.quizApplication.service.serviceInterface.QuizValidate;
//
//import java.util.List;
//
//public class QuizValidationTest {
//    QuizValidate quizValidateImple;
//    QuestionService questionService;
//    QuizService quizService;
//
//    @BeforeEach
//    void setUp() {
//        questionService = new QuestionServicesImple();
//        quizValidateImple = new QuizValidateImple();
//        quizService = new QuizServicesImple();
//
//
//    }
//    @Test
//    void testValidateQuiz_InvalidNumberOfQuestions() {
//
//        assertTrue(quizValidateImple.validateNumberOfQuestionInAQuiz( new Quiz("Programming Quiz","This Quiz is to Test the Knowledge of the user.",List.of(1,2,3,4,5,6,7,8,9,10))));
//    }
//
//    @Test
//    void testValidateQuiz_InvalidDescription() {
//        String quizName = "Don";
//        Quiz quiz = new Quiz(quizName, "Short description", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        assertFalse(quizValidateImple.validateDescription(quiz));
//    }
//
//
//}
//
