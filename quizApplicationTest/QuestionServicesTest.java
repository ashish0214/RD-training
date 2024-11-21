import com.epam.quizApplication.ConsoleUserInterface.QuizManagement;
import com.epam.quizApplication.model.Question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizApplication.service.QuestionServicesImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class QuestionServicesTest {
    private QuestionServicesImple questionService;
    CategoryServiceImple categoryServiceImple;


    @BeforeEach
    public void setUp() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(QuizManagement.class);
        questionService = applicationContext.getBean(QuestionServicesImple.class);
        categoryServiceImple = applicationContext.getBean(CategoryServiceImple.class);

        questionService.createQuestion(1,
                new Question(1, "What is the Largest land Animal ?", Set.of("Tiger", "Elephant", "Lion", "Dog"),
                        "Easy", "Java", Set.of("Elephant"), 1));
        questionService.createQuestion(2,
                new Question(2, "A package is a collection of ?", Set.of("Classes", "none", "Interface", "Record"),
                        "Easy", "JavaCore", Set.of("Classes", "Interface", "Record"), 1));

    }


    //Test cases for createQuestion
    @Test
    void testCreateQuestion() {
        int id = 11;
        Question question = new Question(id, "what does API stands for in java ?",
                Set.of("Application programming interface", "App program intterface", "App programming idea", "Application Processing Interpreter"),
                "Easy", "Java", Set.of("Application programming interface"), 1);
        assertEquals("Successfully Question created", questionService.createQuestion(id, question));

    }

    @Test
    void testCreateQuestionWithExistingId() {
        int id = 1;
        Question question = new Question(id, "what does API stands for in java ?",
                Set.of("Application programming interface", "App program interface", "App programming idea", "Application Processing Interpreter"),
                "Easy", "Java", Set.of("Application programming interface"), 1);
        QuestionIdPresentException questionIdAlreadyPresent = assertThrows(QuestionIdPresentException.class, () -> questionService.createQuestion(id, question));
        assertTrue(questionIdAlreadyPresent.getMessage().contains("Question id already present"));

    }

    //minimum option violation
    @Test
    void testCreateQuestionIsValid() {
        int id = 15;
        Question question = new Question(id, "what does API stands for in java ?",
                Set.of("Application programming interface", "App programming idea", "Application Processing Interpreter"),
                "Easy", "Java", Set.of("Application programming interface"), 1);

        assertEquals("Question invalid", questionService.createQuestion(id, question));
    }

    //Test cases for updating the Question
    @Test
    void testUpdateQuestionByIdPresent() {
        int id = 1;
        Question newQuestion = new Question(id, "what does API stands for in java ?",
                Set.of("Application programming interface", "App program interface", "App programming idea", "Application Processing Interpreter"),
                "Easy", "Java", Set.of("Application programming interface"), 1);
        assertEquals("Successfully modified the question", questionService.updateQuestion(id, newQuestion));
    }

    @Test
    void testUpdateQuestionWithNonExistingId() {
        int id = 7;
        Question newQuestion = new Question(id, "what does API stands for in java ?",
                Set.of("Application programming interface", "App program interface", "App programming idea", "Application Processing Interpreter"),
                "Easy", "Java", Set.of("Application programming interface"), 1);

        QuestionIdNotPresentException questionIdNotPresentException = assertThrows
                (QuestionIdNotPresentException.class, () -> questionService.updateQuestion(id, newQuestion));

        assertTrue(questionIdNotPresentException.getMessage().contains("Id not present to modify"));

    }

    //Test cases for Deleting the question

    @Test
    void testDeleteQuestionIdPresent() {
        int id = 2;
        assertEquals("Successfully deleted question", questionService.deleteQuestion(id));
    }

    @Test
    void testDeleteQuestionIdNotPresent() {
        int id = 9;
        QuestionIdNotPresentException questionIdNotPresentException = assertThrows
                (QuestionIdNotPresentException.class, () -> questionService.deleteQuestion(id));

        assertTrue(questionIdNotPresentException.getMessage().contains("id not present to remove"));
    }

    //Test case for fetchingQuestion
    @Test
    void testGetQuestionWhenPresent() {
        assertNotNull(questionService.questionList());
    }

    @Test
    void testGetQuestionWhenNotPresent() {
        questionService.deleteQuestion(1);
        questionService.deleteQuestion(2);
        QuestionNotPresentException questionNotPresentException = assertThrows(QuestionNotPresentException.class, () -> questionService.questionList());
        assertTrue(questionNotPresentException.getMessage().contains("No Question Present"));
    }


    @Test
    void getQuestionBasedOnCategory() {
        assertNotNull(categoryServiceImple.findBasedOnCategories("Java"));
    }


}
