package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.models.Quiz;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Scanner;

public class UpdateQuiz implements QuizOperations {
    private static final Logger logger= LogManager.getLogger(UpdateQuiz.class);
    @Override
    public void execute(QuizService quizServices, QuestionService questionServices, Scanner scanner) {

        logger.info("Enter the Quiz Name of quiz to be modified");
        String quizNameToBeModified = scanner.nextLine();

        try {
            Optional<Quiz> quiz = quizServices.findQuiz(quizNameToBeModified);
            if (quiz.isPresent()) {
                logger.info("Enter description to change");
                String modifiedQuizdescription = scanner.nextLine();
                quiz.get().setDescription(modifiedQuizdescription);
                quizServices.updateQuiz(quizNameToBeModified, quiz.get());
            }
        } catch (QuizNamePresentException e) {
            logger.error(e.getMessage());
        }
        logger.info("Quiz modified");
    }

}
