package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.models.Question;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class AddQuestion implements QuestionOperations {
private static final Logger logger= LogManager.getLogger(AddQuestion.class);

	@Override
	public void execute(QuestionService questionServices, Scanner scanner) {
		logger.info("Enter the question :");
		scanner.nextLine();
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
		Question question = new Question(questionTitle, options, difficultyLevel,category,marks,answer);



		try {
			logger.info(questionServices.createQuestion(id, question));
		} catch (QuizNamePresentException e) {
			logger.error(e.getMessage());
		}

	}

}
