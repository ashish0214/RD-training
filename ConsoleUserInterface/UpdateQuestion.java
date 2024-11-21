package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.models.Question;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UpdateQuestion implements QuestionOperations {
	private static final Logger logger= LogManager.getLogger(UpdateQuestion.class);

	@Override
	public void execute(QuestionService questionServices, Scanner scanner) {
		logger.info("Enter the Id :");
		Integer id = scanner.nextInt();
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

		Question newQuestion = new Question(id,questionTitle, options, difficultyLevel,category,marks,answer);
		try {
			questionServices.updateQuestion(id, newQuestion);
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		}
		logger.info("Question updated successfully");
	}

}
