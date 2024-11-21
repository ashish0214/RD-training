package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.Operation;
import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class QuestionOperationsMenu implements Operation {
	private static final Logger logger= LogManager.getLogger(QuestionOperationsMenu.class);

	@Override
	public void execute(QuestionService questionServices, QuizService quizServices, Scanner scanner) {
		try {
			int operator;
			do {
				logger.info("\nQuestion operations Menu:");
				logger.info("1. Add Question");
				logger.info("2. Modify Question");
				logger.info("3. Remove Question");
				logger.info("4. Display All Questions");
				logger.info("5. Back to Main Menu");
				logger.info("Enter your choice: ");
				operator = scanner.nextInt();
				QuestionOperationsFactory questionOperationsFactory = new QuestionOperationsFactory();
				QuestionOperations questionOperation = questionOperationsFactory.getOperation(operator);

				if (Objects.nonNull(questionOperation)) {
					questionOperation.execute(questionServices, scanner);
				}

			} while (operator != 5);
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		}
		catch (InputMismatchException e) {
			logger.info("Invalid input");
		}
	}

}
