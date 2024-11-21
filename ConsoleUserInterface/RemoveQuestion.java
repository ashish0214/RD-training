package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RemoveQuestion implements QuestionOperations {
	private static final Logger logger= LogManager.getLogger(RemoveQuestion.class);
	@Override
	public void execute(QuestionService questionServices, Scanner scanner) {
		logger.info("Enter question id to be removed");
		int questionToBeRemoved = scanner.nextInt();
		scanner.nextLine();
		try {
			questionServices.deleteQuestion(questionToBeRemoved);
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		}
		logger.info("Question deleted");
	}

}
