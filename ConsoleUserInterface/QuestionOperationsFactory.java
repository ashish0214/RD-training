package com.epam.quizApplication.ConsoleUserInterface;

import com.epam.quizApplication.ConsoleUserInterface.userInterface.QuestionOperations;

import java.util.HashMap;
import java.util.Map;

public class QuestionOperationsFactory {
	Map<Integer, QuestionOperations> operator = new HashMap<>();

	public QuestionOperationsFactory() {
		operator.put(1, new AddQuestion());
		operator.put(2, new UpdateQuestion());
		operator.put(3, new RemoveQuestion());
		operator.put(4, new DisplayQuestion());
	}

	public QuestionOperations getOperation(int input) {
		return operator.get(input);
	}

}
