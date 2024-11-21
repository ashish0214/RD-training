package com.epam.quizApplication.ConsoleUserInterface;

import com.epam.quizApplication.ConsoleUserInterface.userInterface.Operation;

import java.util.HashMap;
import java.util.Map;

public class OperationsFactory {
	Map<Integer, Operation> operator = new HashMap<>();
//	QuestionService questionServicesImple=new QuestionServicesImple();

	public OperationsFactory() {
		operator.put(1, new QuestionOperationsMenu());
		operator.put(2, new QuizOperationsMenu());
	}

	public Operation getOperation(int input) {
		return operator.get(input);
	}
}
