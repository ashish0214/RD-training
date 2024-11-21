//import com.epam.quizApplication.ConsoleUserInterface.QuizManagement;
//import com.epam.quizApplication.model.Question;
//import com.epam.quizApplication.model.Quiz;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import com.epam.quizApplication.service.QuestionServicesImple;
//import com.epam.quizApplication.service.QuizServicesImple;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class QuizServicesTest {
//
//    private QuizServicesImple quizServices;
//    private QuestionService questionService;
//
//
//    @BeforeEach
//    public void setUp() {
//
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(QuizManagement.class);
//        quizServices = applicationContext.getBean(QuizServicesImple.class);
//        questionService=applicationContext.getBean(QuestionServicesImple.class);
//
//
//        // Clear existing quizzes to avoid conflicts
//        quizServices.findAllQuiz().forEach(quiz -> {
//            try {
//                quizServices.removeQuiz(quiz.getQuizTitle());
//            } catch (QuizNameNotPresentException e) {
//
//            }
//        });
//
//        questionService.createQuestion(1,
//                new Question(1, "What is Java?", Set.of("Programming", "Language", "Java", "None"), "Easy", "JavaCore", Set.of("Programming", "Language", "Java"), 1));
//
//        questionService.createQuestion(2,
//                new Question(2, "A package is a collection of ?", Set.of("Classes", "none", "all", "Interfaces", "Records"),
//                        "Easy", "JavaCore", Set.of("all"), 1));
//
//        questionService.createQuestion(3,
//                new Question(3, "What is SQL?", Set.of("Database", "Query", "SQL", "Relational"), "Easy", "DBMS", Set.of("Database", "Query", "SQL"), 1));
//
//        questionService.createQuestion(4,
//                new Question(4, "What is a class?", Set.of("Programming", "OOP", "Java", "Entity"), "Easy", "JavaCore", Set.of("Programming", "OOP", "Java"), 1));
//
//        questionService.createQuestion(5,
//                new Question(5, "What is inheritance?", Set.of("Programming", "Java", "OOP", "Hierarchy"), "Hard", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(6,
//                new Question(6, "What is polymorphism?", Set.of("Programming", "Java", "OOP", "Overloading"), "Hard", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(7,
//                new Question(7, "What is encapsulation?", Set.of("Programming", "Java", "OOP", "Protection"), "Medium", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(8,
//                new Question(8, "What is abstraction?", Set.of("Programming", "Java", "OOP", "Generalization"), "Medium", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(9,
//                new Question(9, "What is a method?", Set.of("Programming", "Java", "OOP", "Function"), "Easy", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(10,
//                new Question(10, "What is a variable?", Set.of("Programming", "Java", "OOP", "Data"), "Easy", "JavaCore", Set.of("Programming", "Java", "OOP"), 1));
//
//        questionService.createQuestion(11,
//                new Question(11, "What is the Largest land Animal ?", Set.of("Tiger", "Elephant", "Lion", "Dog"),
//                        "Easy", "Java", Set.of("Elephant"), 1));
//        questionService.createQuestion(12,
//                new Question(12, "A package is a collection of ?", Set.of("Classes", "none", "Interface", "Record"),
//                        "Easy", "JavaCore", Set.of("Classes", "Interface", "Record"), 1));
//
//        quizServices.createQuiz("Software Developer Test",
//                new Quiz("Software Developer Test", "Testing the Knowledge on java", List.of(1, 2, 3, 4, 5, 6, 7, 9, 10, 11)));
//    }
////to be tested
//    @Test
//    void testCreateQuiz() {
//        String quizTitle="General Knowledge Quiz";
//               Quiz newQuiz= new Quiz(quizTitle, "Testing users general knowledge ", List.of(1, 2, 3, 4,12,5, 6,7, 9, 10, 11));
//
//        assertEquals("Successfully quiz added",quizServices.createQuiz(quizTitle,newQuiz));
//    }
//
//    @Test
//    void testCreateQuizWithExistingQuizName(){
//
//        String quizTitle="Software Developer Test";
//        Quiz quiz= new Quiz(quizTitle, "Testing users general knowledge ", List.of(1, 2, 3, 4,12,5, 6,7, 9, 10, 11));
//        QuizNamePresentException quizNamePresentException=Assertions.assertThrows(QuizNamePresentException.class,()->quizServices.createQuiz(quizTitle,quiz));
//        assertTrue(quizNamePresentException.getMessage().contains("QuizName present"));
//    }
//
//    @Test
//    public void testUpdateQuiz_Success() {
//        String quizName = "MathQuiz";
//        Quiz quiz= new Quiz(quizName, "Testing users general knowledge ", List.of(1, 2, 3, 4,12,5, 6,7, 9, 10, 11));
//        quizServices.createQuiz(quizName, quiz);
//        Quiz newQuiz= new Quiz(quizName, "Testing users general knowledge ", List.of(1, 2, 3, 4,12,5, 6,7, 9, 10, 11));
//        String result = quizServices.updateQuiz(quizName, newQuiz);
//        assertEquals("Successfully Quiz modifed", result);
//    }
//
//    @Test
//    public void testUpdateQuiz_QuizNameNotPresentException() {
//            String quizName = "MathQuiz";
//            Quiz newQuiz= new Quiz(quizName, "Testing users general knowledge ", List.of(1, 2, 3, 4,12,5, 6,7, 9, 10, 11));
//
//        Assertions.assertThrows(QuizNameNotPresentException.class, () -> {
//            quizServices.updateQuiz(quizName, newQuiz);
//        });
//}
//
//    @Test
//    public void testRemoveQuiz_Success() throws QuizNameNotPresentException {
//        String quizName = "MathQuiz";
//        Quiz quiz = new Quiz();
//        quizServices.createQuiz(quizName, quiz);
//        String result = quizServices.removeQuiz(quizName);
//        assertEquals("Successfully quiz removal", result);
//    }
//
//    @Test
//    public void testRemoveQuiz_QuizNameNotPresentException() {
//        String quizName = "ScienceQuiz"; // Assuming ScienceQuiz doesn't exist
//        Assertions.assertThrows(QuizNameNotPresentException.class, () -> {
//            quizServices.removeQuiz(quizName);
//        });
//    }
//
//    @Test
//    public void testFindQuiz_ExistingQuiz() {
//        String quizName = "MathQuiz";
//        Quiz quiz = new Quiz();
//        quizServices.createQuiz(quizName, quiz);
//        Optional<Quiz> result = quizServices.findQuiz(quizName);
//        assertTrue(result.isPresent());
//        assertEquals(quiz, result.get());
//    }
//
//    @Test
//    public void testFindQuiz_NonExistingQuiz() {
//        String quizName = "ScienceQuiz";
//        Optional<Quiz> result = quizServices.findQuiz(quizName);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testFindQuiz_IgnoreCase() {
//        String quizName = "MATHQUIZ";
//        Quiz quiz = new Quiz();
//        quizServices.createQuiz("MathQuiz", quiz);
//        Optional<Quiz> result = quizServices.findQuiz(quizName);
//        assertTrue(result.isPresent());
//        assertEquals(quiz, result.get());
//    }
//
//    @Test
//    public void testFindAllQuiz_EmptyLibrary() {
//        quizServices.removeQuiz("Software Developer Test");
//        List<Quiz> result = quizServices.findAllQuiz();
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testFindAllQuiz_NonEmptyLibrary() {
//        Quiz quiz1 = new Quiz();
//        Quiz quiz2 = new Quiz();
//        quizServices.createQuiz("MathQuiz", quiz1);
//        quizServices.createQuiz("ScienceQuiz", quiz2);
//        List<Quiz> result = quizServices.findAllQuiz();
//        assertEquals(3, result.size());
//        assertTrue(result.contains(quiz1));
//        assertTrue(result.contains(quiz2));
//    }
//
//    @Test
//    public void testIsQuizNamePresent_ExistingName() {
//        // Arrange
//        String quizName = "MathQuiz";
//        Quiz quiz = new Quiz();
//        quizServices.createQuiz(quizName, quiz);
//        boolean result = quizServices.isQuizNamePresent(quizName);
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsQuizNamePresent_NonExistingName() {
//        String quizName = "ScienceQuiz";
//        boolean result = quizServices.isQuizNamePresent(quizName);
//        Assertions.assertFalse(result);
//    }
//
//
//}