package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RemoveQuiz implements QuizOperations {

	private static final Logger logger= LogManager.getLogger(RemoveQuiz.class);
	@Override
	public void execute(QuizService quizServices, QuestionService questionServices, Scanner scanner) {
		logger.info("Enter the QuizName of quiz that needs to be removed");
		String quizNameToBeRemoved = scanner.nextLine();
		try {
			quizServices.removeQuiz(quizNameToBeRemoved);
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		}
		logger.info("Quiz removed");
	}

}
