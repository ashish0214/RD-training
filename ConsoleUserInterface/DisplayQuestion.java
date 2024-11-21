package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;
import com.epam.quizApplication.exceptions.DisplayException;
import com.epam.quizApplication.models.Question;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DisplayQuestion implements QuestionOperations {
private static final Logger logger= LogManager.getLogger(DisplayQuestion.class);
	@Override
	public void execute(QuestionService questionServices, Scanner scanner)throws DisplayException {
		try {
			List< Question> questions = questionServices.questionList();
			questions.stream().forEach(entry -> {
				logger.info("Question id :"+entry.getId());
				Question question1 = entry;
				logger.info(question1.getQuestionTitle());
				question1.getOptions().forEach(logger::info);
			});
		} catch (DisplayException e) {
			logger.error(e.getMessage());
		}
	}

}
