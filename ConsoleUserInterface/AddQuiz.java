package com.epam.quizApplication.ConsoleUserInterface;

import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.models.Question;
import com.epam.quizApplication.models.Quiz;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class AddQuiz implements QuizOperations {
private static  final Logger logger= LogManager.getLogger(AddQuiz.class);
        @Override
        public void execute(QuizService quizServices, QuestionService questionServices, Scanner scanner) {

            scanner.nextLine();
            logger.info("Enter quiz title: ");
            String quizTitle = scanner.nextLine();
            logger.info("Enter quiz description: ");
            String description = scanner.nextLine();

            logger.info("Enter number of questions to add to quiz: ");
            int numberOfQuestions = scanner.nextInt();
            List<Question> questionIds = new ArrayList<>();
            while (numberOfQuestions > 0) {

                logger.info("1. Add already available question");
                logger.info("2. Add new Question");
                logger.info("Choose questionsSystem.out.println");
                int questionChoice = scanner.nextInt();
                switch (questionChoice) {
                    case 1:

                        try {
                            logger.info("Enter question id: ");
                            int questionId = scanner.nextInt();
                            scanner.nextLine();
                            if (questionServices.questionList().contains(questionId)) {
                                questionIds.add(questionServices.findQuestionById(questionId).get());
                            } else {
                                throw new QuizNamePresentException("Question id does not exists");
                            }
                        } catch (QuizNamePresentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        logger.info("Enter the question :");
                        String questionTitle = scanner.nextLine();
                        logger.info("Enter the options(comma separated) :");
                        Set<String> options = new HashSet<>(List.of(scanner.nextLine().split(",")));
                        logger.info("Enter the right answer (comma separated) :");
                        Set<String> answer = new HashSet<>(List.of(scanner.nextLine().split(",")));
                        logger.info("Enter the Category :");
                        String category = scanner.nextLine();
                        logger.info("Enter the difficulty :");
                        String difficultyLevel = scanner.nextLine();
                        logger.info("Enter the Marks :");
                        Integer marks = scanner.nextInt();

                        int id= questionServices.getNumberOfQuestionPresent()+1;
                        Question question = new Question(id,questionTitle, options, difficultyLevel,category,marks,answer);
                        questionServices.createQuestion(id, question);
                        questionIds.add(question);
                        break;
                    default:
                        logger.warn("Invalid choice. Please try again");
                }
                numberOfQuestions--;
            }
            Quiz quiz = new Quiz(quizTitle,description,questionIds);
            quizServices.createQuiz(quizTitle, quiz);



}
}
