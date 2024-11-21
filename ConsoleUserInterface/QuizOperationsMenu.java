package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.Operation;
import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class QuizOperationsMenu implements Operation {
	private static final Logger logger= LogManager.getLogger(QuizOperationsMenu.class);

	public void execute(QuestionService questionServices, QuizService quizServices, Scanner scanner) {
		try {
			int operator;
			do {
				logger.info("\nQuiz operations Menu:");
				logger.info("1. Add Quiz");
				logger.info("2. Modify Quiz");
				logger.info("3. Remove Quiz");
				logger.info("4. Display All Quizzes");
				logger.info("5. Back to Main Menu");
				logger.info("Enter your choice: ");
				operator = scanner.nextInt();
				QuizOperationsFactory quizOperationsFactory = new QuizOperationsFactory();
				QuizOperations quizOperation = quizOperationsFactory.getOperation(operator);
				if (Objects.nonNull(quizOperation)) {
					quizOperation.execute(quizServices, questionServices, scanner);
				}

			} while (operator != 5);
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		} catch (InputMismatchException e) {
			logger.info("Invalid input");
		}
	}

}
