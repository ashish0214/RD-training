package com.epam.quizApplication.ConsoleUserInterface;

import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuizOperations;

import java.util.HashMap;
import java.util.Map;

public class QuizOperationsFactory {
	Map<Integer, QuizOperations> operator = new HashMap<>();

	public QuizOperationsFactory() {
		operator.put(1, new AddQuiz());
		operator.put(2, new UpdateQuiz());
		operator.put(3, new RemoveQuiz());
		operator.put(4, new DisplayQuiz());
	}

	public QuizOperations getOperation(int input) {
		return operator.get(input);
	}

}
