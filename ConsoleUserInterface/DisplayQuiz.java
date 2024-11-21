package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;
import com.epam.quizApplication.exceptions.DisplayException;
import com.epam.quizApplication.models.Question;
import com.epam.quizApplication.models.Quiz;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DisplayQuiz implements QuizOperations {

    private static final Logger logger= LogManager.getLogger(DisplayQuiz.class);
    @Override
    public void execute(QuizService quizServices, QuestionService questionServices, Scanner scanner) throws DisplayException {
        try {
            List< Quiz> quizzes = quizServices.findAllQuiz();
            int totalMarks=0;
            quizzes.stream().forEach(entry -> {
                logger.info("Quiz ID: {}"+entry.getQuizTitle());
                logger.info("Quiz Name: {}"+ entry.getQuizTitle());
                logger.info("Quiz Description:"+entry.getDescription());
                entry.getQuestionsList().forEach(questionNumber -> {
                    Optional<Question> question1=questionServices.findQuestionById(questionNumber.getId());
                    logger.info("Question: {}"+ question1.get().getQuestionTitle());
                    question1.get().getOptions().forEach(logger::info);
                });
                logger.info("Total Marks: {}"+ quizzes.size());

            });
        } catch (DisplayException e) {
            logger.error(e.getMessage());
        }
    }

}
