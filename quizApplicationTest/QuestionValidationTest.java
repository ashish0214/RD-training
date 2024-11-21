//import org.junit.jupiter.api.Test;
//import com.epam.quizApplication.model.Question;
//import com.epam.quizApplication.service.QuestionValidateImple;
//
//import java.util.Set;
//
//public class QuestionValidationTest {
//
//    QuestionValidateImple questionValidateImple=new QuestionValidateImple();
//
//    @Test
//    void testValidateQuestion() {
//        Question question = new Question(1, "What is the Largest land Animal ?", Set.of("Tiger", "Elephant", "Lion", "Rat"), "Easy", "JavaCore", Set.of("Elephant"), 1);
//
//        assertTrue(questionValidateImple.validateQuestion(question));
//    }
//    @Test
//    void testValidateQuestionNotValidQuestion() {
//        Question question = new Question(1, " Java?", Set.of("A", "B", "C", "D"), "Easy", "JavaCore", Set.of("A"), 1);
//
//        assertFalse(questionValidateImple.validateQuestion(question));
//    }
//
//    @Test
//    void testValidateQuestionInvalidQuestionStatement() {
//        Question question = new Question(2, "Short?", Set.of("A", "B", "C", "D"), "Easy", "JavaCore", Set.of("A"), 1);
//
//        assertFalse(questionValidateImple.validateQuestion(question));
//    }
//
//    @Test
//    void testValidateQuestionInvalidOptions() {
//        Question question = new Question(3, "What is Java?", Set.of("A", "B", "C"), "Easy", "JavaCore", Set.of("A"), 1);
//
//        assertFalse(questionValidateImple.validateQuestion(question));
//    }
//
//    @Test
//    void testValidateQuestionNoCorrectOption() {
//        Question question = new Question(4, "What is Java?", Set.of("A", "B", "C", "D"), "Easy", "JavaCore", Set.of(), 1);
//        assertFalse(questionValidateImple.validateQuestion(question));
//    }
//}
